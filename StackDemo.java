class Stack
{
    int maxSize;
    int StackArray[];
    int top;


    Stack(int size)
    {
        maxSize=size;
        StackArray=new int[maxSize];
        top = -1;
    }

    public void display()
    {
        System.out.println("stack elements are");
        for(int i=0;i<=top;i++)
        {
            System.out.print(StackArray[i]+"\t");
        }
        System.out.println("\t");
    }

    public void push(int value)
    {
        if(top==maxSize-1)
            System.out.println("stack overflow");
        else
        {
            StackArray[++top]=value;

        }
    }

    public int pop()
    {
        if(top==-1)
        {
            System.out.println("stack underflow");
            return -1;   
        }
        else{
            System.out.println(StackArray[top]+" is popped.\t");
            return StackArray[top--];
        }
    }
}

class StackDemo
{
    public static void main(String s[])
    {
        Stack s1=new Stack(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);

        s1.display();
        s1.pop();
        s1.display();
    }
}

