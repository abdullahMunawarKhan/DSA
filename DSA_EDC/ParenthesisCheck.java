
class Stack{
    char stackArray[];
    int maxSize;
    int top;

    Stack(int size){
        maxSize=size;
        stackArray=new char[maxSize];
        top=-1;
    }

    public void push(char x){
        if(top == maxSize-1)
            System.out.println("stack overflow");
        else
        {
            stackArray[++top]=x;
            System.out.println(x+" is pushed in stack");
        }
    }

    public int pop(){
        if(top==-1){
            System.out.println("stack underflow");
            return -1;
        }
        else{
            System.out.println(stackArray[top]+" is poped.");
            return stackArray[top--];
        }
    }

    public void display(){
        if(top==-1){
            System.out.println("stack is empty");
        }else{

            System.out.println("stack elements are :\t");
            for(int i=0;i<=top;i++){
                System.out.print(stackArray[i]+"\t");
            }
            System.out.println("\t");
        }
    }
}
public class ParenthesisCheck {

    public static void main(String[] args) {
        System.out.println("checker");
        String exp="(a+b*c(d+e)))";
        char[] sample= exp.toCharArray();
        Stack stack1=new Stack(sample.length);
        for(int i=0;i<=sample.length-1;i++){
            if(sample[i]=='('){
                stack1.push(sample[i]);
            }else if(sample[i]==')'){
                if(stack1.top==-1)
                    System.out.println("unbalanced parenthesis");
                else{
                    stack1.pop();
                }
            }
        }
        if(stack1.top==-1){
            System.out.println("balanced parenthesis");
        }else{
            System.out.println("unbalanced parenthesis");
        }


    }

}