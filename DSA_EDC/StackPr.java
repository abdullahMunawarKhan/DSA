

/*class Stack{
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
*/


class Stack{
    int arraylist[];
    int maxSize;
    int top;
    
    Stack(int size){
        maxSize=size;
        arraylist =new int[size];
        top=-1;
    }

    public void push(int value){
        if(top==maxSize-1){
            System.out.println("stack overflow.");
            return;
        }
        arraylist[++top]=value;
        System.out.println(value+" is pushed.");

    }

    public int pop(){
        if(top==-1){
            System.out.println("stack underflow.");
            return -1;
        }else{
            System.out.println(arraylist[top]+" is poped.");
            return arraylist[--top];
        }
    }

    public void display(){
        if(top==-1){
            System.out.println("Stack underflow");
            return;
        }
        for(int i=0;i<=top;i++){
            System.err.print(arraylist[i]+"\t");
        }
        System.out.println("");
    }
}

public class StackPr{

    public static void main(String s[]){
        Stack s1=new Stack(5);
        s1.push(25);
        s1.push(85);
        s1.push(28);
        s1.push(27);
        s1.push(65);
        s1.push(55);
        s1.push(44);
        s1.display();
        s1.pop();
        s1.pop();
        s1.display();
    }

}