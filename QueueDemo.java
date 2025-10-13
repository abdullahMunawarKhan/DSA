class Queue
{
	int maxSize;
	int queueArray[];
	int front;
	int rear;
	int count;
	
	Queue(int size)
	{
		maxSize=size;
		queueArray=new int[maxSize];
		front=0;
		rear=-1;
		count=0;
	}
	
	public void enQueue(int value)
	{
//		if(count==maxSize )
		if(front==maxSize-1)
		{
			System.out.println("Queue is full");
		}
		else
		{
			rear=(rear+1)%maxSize;
			queueArray[rear]=value;
			System.out.println(value+" is added");
			count++;
		}
	}
	
	public void deQueue()
	{
//			if(count==0)
			if(rear==-1)
			{ 
				System.out.println("queue is Empty");
			}
			else
			{
				System.out.println(queueArray[front]+" is served");
				front=(front+1)%maxSize;
				count--;
			}
	}
	
	public void display()
	{
		for(int i=0;i<count;i++)
		{
			int index=(front+i)%maxSize;
			System.out.print(queueArray[index]+"\t");
		}
		System.out.println();
	}
	
}

class QueueDemo
{
	public static void main(String s[])
	{
		Queue queue1=new Queue(5);
		queue1.enQueue(12);
		queue1.enQueue(7);
		queue1.enQueue(52);
		queue1.enQueue(20);
		queue1.enQueue(18);
		queue1.display();
		queue1.deQueue();
		queue1.deQueue();
		
		queue1.display();
		queue1.enQueue(85);
		queue1.display();
		queue1.enQueue(50);
		queue1.display();
		
	}
}