class Stack{
    int stackArray[];
    int maxSize;
    int top;

    Stack(int size){
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
    }

    public void push(int x){
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
       System.out.println(java.util.Arrays.toString(stackArray));
    }
}



public class StackPr {
    public static void main(String s[]){
        Stack stack1=new Stack(5);
        stack1.push(100);
        stack1.push(45);
        stack1.push(46);
        stack1.push(47);
        stack1.push(48);
        stack1.push(49);
        stack1.display();
    }
}
