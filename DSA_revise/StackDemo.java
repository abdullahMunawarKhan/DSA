class Stack{
    int stackArray[];
    int maxSize;
    int top;
 
    Stack(int size){
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
    }

     public void push(int value){
        if(top==maxSize-1){
            System.out.println("Stack overflow.");
            return;
        }
        stackArray[++top]=value;
        System.out.println(value+" is pushed.");   
    }

    public int pop(){
        if(top==-1){
            System.out.println("stack underflow.");
            return -1;
        }
            
        System.out.println(stackArray[top]+" is poped.");
        return stackArray[--top];
    }

    public void display(){
        if(top==-1){
            System.out.println("stack underflow.");
            return;
        }
        System.out.println("elements of stack are: ");
        for(int i=0;i<=top;i++){
            System.out.print(stackArray[i]+"\t");
        }
        System.out.println("");
        
    }
}

class StackDemo{
    
    public static void main(String s[]){

        Stack s1=new Stack(5);
        
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.display();
        s1.pop();
        s1.display();
        s1.push(50);
        s1.display();

        }
}