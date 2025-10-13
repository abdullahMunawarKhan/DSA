class Call
{

	int maxSize;
	int callListID[];
	float callListTime[];
	int front;
	int rear;
	int count;
	
	Call(int size)
	{
		maxSize=size;
		callListID= new int[size];
		callListTime=new float[size];
		front=0;
		rear=-1;
		count=0;
	}
	
	public void addCall(int customerID, float callTime)
	{
		if(count==maxSize)
		{
			System.out.println("call log is full");
		}
		else
		{
			rear=(rear+1)%maxSize;
			callListID[rear]=customerID;
			callListTime[rear]=callTime;
			System.out.println(callListID[rear]+" is added ");
			count++;
		}
	}
	
	public void answerCall()
	{
		if(count==0)
			System.out.println("no call in call log");
		else
		{
			System.out.println(callListID[front]+" is answered.");
			front=(front+1)%maxSize;
			count--;
		}
		
	}
	
	public void viewQueue()
	{
		if(count==0)
		{
			System.out.println("there is no call in call log");
		}
		else
		{
			System.out.println("sr\t"+"CustomerID\t"+"call duration\t");		
			for(int i=0;i<count;i++)
			{
				int index=(front+i)%maxSize;
				System.out.print((i+1)+"\t"+callListID[index]+"         \t  "+callListTime[index]); 
				System.out.println();
			}
		}
		System.out.println();
	}
}

class CallCentreQueue
{
	public static void main(String s[])
	{
		Call calls=new Call(5);
		calls.addCall(4875,2);
		calls.addCall(4887,5);
		calls.addCall(4898,8);
		calls.viewQueue();
	}
}
