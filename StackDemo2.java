class Stack
{
	int maxSize;
	int stackArray[];
	int top;
	
	Stack(int size)
	{
		maxSize=size;
		stackArray=new int[maxSize];
		top=-1;
	}
	
	public void push(int value)
	{
		if(isFull())
			System.out.println();
		else
		{
			stackArray[++top]=value;
			System.out.println(value+" is pushed");			
		}
	}
	
	public int pop()
	{
		if(isEmpty())
		{
				System.out.println();
				return -1;		
		}
		else
		{
			System.out.println(stackArray[top]+" is popped");
			return stackArray[top--];
		}	
	}
	
	public void display()
	{
	
		if(top==-1)
			System.out.println("stack is empty");
		else
		{
			System.out.println("Stack elements are :");
			for(int i=0;i<=top;i++)
			{
				System.out.print(stackArray[i]+"\t");
			}
		}
		System.out.println();
	}
	
	public boolean isFull()
	{
		if(top==maxSize-1)
		{
			System.out.println("stack is overflow");
			return true;
		}
		else
		{
			return false;
		}	
		
	}	
	
	public boolean isEmpty()
	{
		if(top==-1)
		{
			System.out.println("Stack is underflow");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void minValue()
	{
		int min=stackArray[0];
		for(int i=0;i<=top;i++)
		{
			if(stackArray[i]<=min)
			{
				min=stackArray[i];
			}
		}
		
		System.out.println(min+" is minimum value in stack");
	}	
	
	public void maxValue()
	{
		int max=stackArray[0];
		for(int i=1;i<=top;i++)
		{
			if(stackArray[i]>=max)
				max=stackArray[i];
		}
		
		System.out.println(max+" is maximum value in stack");
	}
}

class StackDemo2
{
	public static void main(String s[])
	{
		Stack s1=new Stack(5);
		s1.isEmpty();
		s1.push(25);
		s1.push(52);
		s1.push(85);
		s1.isEmpty();
		s1.push(65);
		s1.push(1);
		s1.display();
		s1.isFull();
		s1.minValue();
	}
}	
			
		
		
