/*

PR_1
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head; // first node of the list

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();

        list.delete(20);
        list.display();

        list.delete(10);
        list.display();
    }
}

PR_2

class Node {
    int value;
    Node next;

    Node(int value){
        this.value=value;
        this.next=null;
    }
}

public class LinkedList{

    Node head;
    
    public void insert(int value){
        Node newNode=new Node(value);
        if(head == null ){
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
        if(head==null)
            System.out.println("linked list is empty");
        else{
            Node temp=head;
            System.out.println("the elements of linked list are : ");
            while(temp.next!=null){
                System.out.print(temp.value+" -> ");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

    public void delete(int key){
        if(head==null)
            System.out.println("linked list is empty");
        else{
            if(head.value==key){
                head=head.next;
                return;
            }

            Node temp=head;
            while (temp.next != null && temp.next.value != key) {
                temp = temp.next;         
            }
            if (temp.next == null) {    
                System.out.println("Element not found");
            } else {
                temp.next = temp.next.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.insert(40);

        l1.display();
        l1.delete(20);
        l1.display();

    }
}

PR_3

class Node{
    int value;
    Node next;

    Node(int value){
        this.value=value;
        this.next=null;
    }
} 

public class LinkedList{
    Node head;

    public void insert(int value){
        Node newNode=new Node(value);
        if(head==null){
            newNode=head;
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
        }else{
            Node temp=head;
            System.out.println("Elements of linked list are:");
            while(temp.next != null){
                System.out.print(temp.value+" ->");
                temp=temp.next;
            }
            System.out.println("null");
        }
    }

    public void delete(int key){
        if(head==null){
            System.out.println("linked list is empty.");
            return;
        }
        if(head.value==key){
            head=head.next;
            return;
        }  
        
        Node temp=head;
        while(temp.next!=null && temp.next.value!=key){
            temp=temp.next;
        }

        if(temp.next ==null)
            System.out.println("element not found.");
        else
            temp.next=temp.next.next;
    }
}

PR_4

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
            System.out.println("head added");
            return;
        }
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        System.out.println("new Node added.");
        temp.next=newNode;
    }

    public void display(){
        if(head==null){
            System.out.println("linked list is empty.");
            return;
        }
        
        Node temp=head;
        System.out.println("the linked list is:");
        while(temp != null){
            System.out.print(temp.value+" ->");
            temp=temp.next;
        }

        System.out.println("null");
    }

    public void delete(int key){
        if(head.value==key){
            head=head.next;
            return;
        }

        Node temp=head;
        while(temp.next !=null && temp.next.value !=key){
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("element not found.");
            return;
        }else{
            temp.next=temp.next.next;
            System.out.println("element deleted.");
        }
    }

    public static void main(String s[]){
        LinkedList l1=new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.display();


    }
}

PR_5

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
        while(temp.next != null){
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
            System.out.println(temp.value+" ->");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public void delete(int key){
        if(head==null){
            System.out.println("linkedlist is empty.");
            return;
        }

        if(head.value==key){
            head=head.next;
            return;
        }

        Node temp=head;
        while(temp.next!=null && temp.next.value!=key){
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("not found.");
        }else{
            temp.next=temp.next.next;
        }
    }

     public static void main(String s[]){
        LinkedList l1=new LinkedList();
        l1.insert(10);
        l1.insert(20);
        l1.insert(30);
        l1.display();


    }
}*/

// PR_6

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

