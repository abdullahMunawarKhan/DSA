import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double marks;
    Student next;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head = null;

    // 1️⃣ Add Student
    public void addStudent(int rollNo, String name, double marks) {
        Student newStudent = new Student(rollNo, name, marks);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newStudent;
        }
        System.out.println("✅ Student added successfully!");
    }

    // 2️⃣ Delete Student
    public void deleteStudent(int rollNo) {
        if (head == null) {
            System.out.println("⚠️ List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("🗑️ Student deleted successfully!");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("❌ Student not found.");
        else {
            temp.next = temp.next.next;
            System.out.println("🗑️ Student deleted successfully!");
        }
    }

    // 3️⃣ Update Student
    public void updateStudent(int rollNo, String newName, double newMarks) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.name = newName;
                temp.marks = newMarks;
                System.out.println("✏️ Student record updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Student not found.");
    }

    // 4️⃣ Search Student
    public void searchStudent(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("🎓 Student Found:");
                System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Marks: " + temp.marks);
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Student not found.");
    }

    // 5️⃣ Sort Students
    public void sortRecords(String field, boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("⚠️ Not enough records to sort.");
            return;
        }
        for (Student i = head; i != null; i = i.next) {
            for (Student j = i.next; j != null; j = j.next) {
                boolean swap = false;
                if (field.equalsIgnoreCase("roll")) {
                    swap = ascending ? i.rollNo > j.rollNo : i.rollNo < j.rollNo;
                } else if (field.equalsIgnoreCase("marks")) {
                    swap = ascending ? i.marks > j.marks : i.marks < j.marks;
                }
                if (swap) {
                    // Swap data (not nodes)
                    int tempRoll = i.rollNo;
                    String tempName = i.name;
                    double tempMarks = i.marks;

                    i.rollNo = j.rollNo;
                    i.name = j.name;
                    i.marks = j.marks;

                    j.rollNo = tempRoll;
                    j.name = tempName;
                    j.marks = tempMarks;
                }
            }
        }
        System.out.println("✅ Records sorted successfully by " + field + " (" + (ascending ? "Ascending" : "Descending") + ")");
    }

    // 6️⃣ Display All Students
    public void displayStudents() {
        if (head == null) {
            System.out.println("📭 No student records found.");
            return;
        }
        System.out.println("\n📋 Student Records:");
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Marks: " + temp.marks);
            temp = temp.next;
        }
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n====== Student Record Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Records");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    list.addStudent(roll, name, marks);
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteStudent(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();
                    list.updateStudent(r, newName, newMarks);
                    break;

                case 4:
                    System.out.print("Enter Roll No to search: ");
                    list.searchStudent(sc.nextInt());
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Sort by (roll/marks): ");
                    String field = sc.nextLine();
                    System.out.print("Order (asc/desc): ");
                    String order = sc.nextLine();
                    boolean ascending = order.equalsIgnoreCase("asc");
                    list.sortRecords(field, ascending);
                    break;

                case 6:
                    list.displayStudents();
                    break;

                case 7:
                    System.out.println("👋 Exiting Student Record System. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}

