class Stack{
    int stackArray[];
    int maxSize;
    int top;
    
    Stack(int size){
        maxSize=size;
        top=-1;
        stackArray=new int[maxSize];
    }
    
    public void push(int x){
        if(top==maxSize-1){
            System.out.println("stack overflow.");
        }else{
            stackArray[++top]=x;
            System.out.println(x+" is pushed in stack.");
        }
    }

    public int pop(){
        if(top==-1){
            System.out.println("stack underflow.");
            return -1;
        }else{
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

public class Stackpr2{

    public static void main(String[] args) {
    
        Stack stack1=new Stack(5);
        stack1.push(25);
        stack1.push(45);
        stack1.push(65);
        stack1.push(78);
        stack1.push(99);
        stack1.display();
        stack1.pop();
        stack1.display();

    }
}