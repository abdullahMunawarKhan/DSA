class Stack {
    char stackArray[];
    int maxSize;
    int top;

    Stack(int size) {
        maxSize = size;
        top = -1;
        stackArray = new char[maxSize];
    }

    public void push(char x) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow.");
        } else {
            stackArray[++top] = x;
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack underflow.");
            return '\0';
        } else {
            return stackArray[top--];
        }
    }

    public char peek() {
        if (top == -1)
            return '\0';
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class PostFix {
    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        String exp = "(A*B/C+D)";
        char[] input = exp.toCharArray();
        Stack stack = new Stack(input.length);
        String outputExp = "";

        for (char ch : input) {
            if (Character.isLetterOrDigit(ch)) {
                outputExp += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    outputExp += stack.pop();
                }
                stack.pop(); // remove '('
            } else { // operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    outputExp += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            outputExp += stack.pop();
        }

        System.out.println("The postfix expression is: " + outputExp);
    }
}
