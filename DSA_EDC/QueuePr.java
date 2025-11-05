class Queue{
    int queueArray[];
    int front;
    int rear;
    int maxSize;
    int count;

    Queue(int size){
        queueArray=new int[size];
        maxSize=size;
        front=0;
        rear=-1;
        count=0;
    }

    public void enQueue(int value){
        if(count==maxSize){
            System.out.println("queue is full.");
            return;
        }
    
        rear=(rear+1)%maxSize;
        queueArray[rear]=value;
        count++;
        System.out.println(value+" is added to queue.");
    }

    public void deQueue(){
        if(count==0){
            System.out.println("queue is empty.");
            return;
        }
        System.out.println(queueArray[front]+" is removed.");
        front=(front+1)%maxSize;
        count--;
    }

    public void display(){
        if(count==0){
            System.out.println("queue is empty.");
            return;
        }
        for(int i=0;i<count;i++){
            int index=(front+i)%maxSize;
            System.out.print(queueArray[index]+"\t");
        }
        System.out.println();
    }
}

class QueuePr{

    public static void main(String[] args) {
        
        Queue q1=new Queue(5);
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.display();
        q1.deQueue();
        q1.display();

    }
}
