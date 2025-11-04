import java.util.*;
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


public class ReverseString{

    public static void main(String s[]){
        Scanner sc=new Scanner(System.in);
        String trial=sc.next();
        char[] sample= trial.toCharArray();

        Stack stack1=new Stack(sample.length);

        for(int i=0;i<=sample.length-1;i++){
            stack1.push(sample[i]);
        }

        char[] reverseString = new char[sample.length];
        for(int i=0;i<=sample.length-1;i++){
            reverseString[i]=sample[stack1.top];
            stack1.pop();
        }

        System.out.println("reverse string is :");
        System.out.println(reverseString);
    }
}