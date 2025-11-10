/*
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
*/

class Queue{
    int queueArray[];
    int front;
    int rear;
    int count;
    int maxSize;

    Queue(int size){
        maxSize=size;
        queueArray=new int[maxSize];
        front=0;
        rear=-1;
        count=0;
    }

    public void enQueue(int value){
        if(count==maxSize){
            System.out.println("Queue is full. can not add new element.");
        }else{
            System.out.println(value+" is added to queue.");
            rear=(rear+1)%maxSize;
            queueArray[rear]=value;
            count++;
        }

    }

    public void deQueue(){
        if(count==0){
            System.out.println("no element in queue.");
        }else{
            System.out.println(queueArray[front]+" is removed.");
            front=(front+1)%maxSize;
            count--;
        }
    }
    
    public void display(){
        if(count==0){
            System.out.println("no elements to display.");
        }else{
            System.out.println("queue elements are :");
            for(int i=0;i<count;i++){
                int index = (front + i) % maxSize;
                if(i==0)
                    System.out.print(queueArray[index]);
                else{
                    System.out.print(" -> "+queueArray[index]);
                }
            }
            System.out.println();
        }
        
    }
}



public class QueuePr{
    public static void main(String s[]){
        Queue q1=new Queue(5);
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.display();
        q1.deQueue();
        q1.deQueue();
        q1.deQueue();
        q1.display();
    }

}

