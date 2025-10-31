import java.util.Scanner;

// Student Class
class Student {
    String id;
    String name;
    String course;
    float grade;
    Student next; // For chaining

    public Student(String id, String name, String course, float grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
        this.next = null;
    }
}

// Hash Table for Student Database
class StudentHashTable {
    private int SIZE = 11; // Prime number for hash table size
    private Student[] table;

    public StudentHashTable() {
        table = new Student[SIZE];
    }

    // Hash Function: sum of ASCII values of chars in ID, modulo SIZE
    private int hash(String id) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            sum += (int) id.charAt(i);
        }
        return sum % SIZE;
    }

    // Insert student
    public void insert(String id, String name, String course, float grade) {
        int index = hash(id);
        Student newStudent = new Student(id, name, course, grade);

        newStudent.next = table[index];
        table[index] = newStudent;
        System.out.println("Student inserted!");
    }

    // Search for student by ID
    public Student search(String id) {
        int index = hash(id);
        Student curr = table[index];
        while (curr != null) {
            if (curr.id.equals(id)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // Delete student by ID
    public boolean delete(String id) {
        int index = hash(id);
        Student curr = table[index];
        Student prev = null;
        while (curr != null) {
            if (curr.id.equals(id)) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    // Display all students
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Student curr = table[i];
            if (curr != null) {
                System.out.print("Bucket " + i + ": ");
                while (curr != null) {
                    System.out.print("[" + curr.id + ", " + curr.name + ", " + curr.course + ", " + curr.grade + "] -> ");
                    curr = curr.next;
                }
                System.out.println("null");
            }
        }
    }
}

// Driver Class
public class StudentDBMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentHashTable db = new StudentHashTable();
        int choice;

        while (true) {
            System.out.println("Student Database Management System [Hashing]");
            System.out.println("1. Insert Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    float grade = Float.parseFloat(scanner.nextLine());
                    db.insert(id, name, course, grade);
                    break;
                case 2:
                    System.out.print("Enter Student ID to search: ");
                    id = scanner.nextLine();
                    Student s = db.search(id);
                    if (s != null) {
                        System.out.println("Found: ID=" + s.id + ", Name=" + s.name + ", Course=" + s.course + ", Grade=" + s.grade);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    id = scanner.nextLine();
                    if (db.delete(id)) {
                        System.out.println("Deleted successfully.");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    db.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}