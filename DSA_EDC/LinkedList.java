/*
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
    Node head;

    public void insert(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void display(){
        if(head==null){
            System.out.println("linked list is empty.");
            return;
        }

        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void delete(int key){
        if(head.data==key){
            head=head.next;
            return;
        }

        Node temp=head;
        while(temp.next!=null && temp.next.data!=key){
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("element not found.");
        }else{
            temp.next=temp.next.next;
        }
    }

    public static void main(String[] args) {
        
        LinkedList l1=new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.insert(40);
        l1.insert(50);
        l1.display();
        l1.delete(30);
        l1.display();

    }
}

*/

class Node{
    int value;
    Node next;

    Node(int value){
        this.value=value;
        this.next=null;
    }

}



class LinkedList{

    Node head;

    public void insert(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    public void delete(int value){
        if(head.value==value){
            System.out.println(value+" is deleted");
            head=head.next;
            return;
        }

        Node temp=head;
        while(temp.next!=null && temp.next.value!=value){
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("not found.");
        }else{
            temp.next=temp.next.next;
        }

    }

    public void display(){
        if(head==null){
            System.out.println("linked list is empty.");
            return;
        }

        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    
        LinkedList l1=new LinkedList();
        l1.insert(12);
        l1.insert(54);
        l1.display();
    }
}

