import java.util.*;

// Student class to represent individual student records
class Student {
    int rollNo;
    String name;
    int marks;
    Student next;

    // Constructor
    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.next = null;
    }

    // Display student information
    public void display() {
        System.out.printf("%-10d %-20s %-10d%n", rollNo, name, marks);
    }
}

// StudentManagement class using singly linked list
class StudentManagement {
    private Student head;

    public StudentManagement() {
        this.head = null;
    }

    // 1. Add a new student record
    public void addStudent(int rollNo, String name, int marks) {
        // Check if student with same roll number already exists
        if (searchStudent(rollNo) != null) {
            System.out.println("Student with Roll No " + rollNo + " already exists!");
            return;
        }

        Student newStudent = new Student(rollNo, name, marks);

        // If list is empty, make new student the head
        if (head == null) {
            head = newStudent;
        } else {
            // Add at the beginning for simplicity
            newStudent.next = head;
            head = newStudent;
        }
        System.out.println("Student added successfully!");
    }

    // 2. Delete a student record by roll number
    public boolean deleteStudent(int rollNo) {
        if (head == null) {
            System.out.println("No records found!");
            return false;
        }

        // If head node is to be deleted
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student with Roll No " + rollNo + " deleted successfully!");
            return true;
        }

        // Search for the student to delete
        Student current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with Roll No " + rollNo + " not found!");
            return false;
        }

        current.next = current.next.next;
        System.out.println("Student with Roll No " + rollNo + " deleted successfully!");
        return true;
    }

    // 3. Update student record
    public boolean updateStudent(int rollNo, String newName, int newMarks) {
        Student student = searchStudent(rollNo);
        if (student != null) {
            student.name = newName;
            student.marks = newMarks;
            System.out.println("Student record updated successfully!");
            return true;
        } else {
            System.out.println("Student with Roll No " + rollNo + " not found!");
            return false;
        }
    }

    // 4. Search for a student by roll number
    public Student searchStudent(int rollNo) {
        Student current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display search result
    public void displaySearchResult(int rollNo) {
        Student student = searchStudent(rollNo);
        if (student != null) {
            System.out.println("Student found:");
            System.out.printf("%-10s %-20s %-10s%n", "Roll No", "Name", "Marks");
            System.out.println("--------------------------------------------");
            student.display();
        } else {
            System.out.println("Student with Roll No " + rollNo + " not found!");
        }
    }

    // 5. Sort students by roll number (ascending)
    public void sortByRollNoAsc() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Student current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.rollNo > current.next.rollNo) {
                    // Swap data
                    swapStudentData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Records sorted by Roll Number (Ascending)");
    }

    // Sort students by roll number (descending)
    public void sortByRollNoDesc() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Student current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.rollNo < current.next.rollNo) {
                    // Swap data
                    swapStudentData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Records sorted by Roll Number (Descending)");
    }

    // Sort students by marks (ascending)
    public void sortByMarksAsc() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Student current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.marks > current.next.marks) {
                    // Swap data
                    swapStudentData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Records sorted by Marks (Ascending)");
    }

    // Sort students by marks (descending)
    public void sortByMarksDesc() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Student current;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.marks < current.next.marks) {
                    // Swap data
                    swapStudentData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Records sorted by Marks (Descending)");
    }

    // Helper method to swap student data
    private void swapStudentData(Student a, Student b) {
        // Swap roll numbers
        int tempRoll = a.rollNo;
        a.rollNo = b.rollNo;
        b.rollNo = tempRoll;

        // Swap names
        String tempName = a.name;
        a.name = b.name;
        b.name = tempName;

        // Swap marks
        int tempMarks = a.marks;
        a.marks = b.marks;
        b.marks = tempMarks;
    }

    // Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records found!");
            return;
        }

        System.out.printf("%-10s %-20s %-10s%n", "Roll No", "Name", "Marks");
        System.out.println("--------------------------------------------");

        Student current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    // Count total number of students
    public int getStudentCount() {
        int count = 0;
        Student current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Main class with menu-driven interface - uses nextLine()+parse to avoid Scanner buffer issues
public class StudentRecordSystem {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort by Roll Number (Ascending)");
            System.out.println("7. Sort by Roll Number (Descending)");
            System.out.println("8. Sort by Marks (Ascending)");
            System.out.println("9. Sort by Marks (Descending)");
            System.out.println("10. Show Student Count");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine()); // read line and parse to avoid newline issues [web:22][web:24]

                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int rollNo = Integer.parseInt(scanner.nextLine()); // parse from full line [web:23]
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        int marks = Integer.parseInt(scanner.nextLine());
                        sm.addStudent(rollNo, name, marks);
                        break;

                    case 2:
                        System.out.print("Enter Roll Number to delete: ");
                        int delRollNo = Integer.parseInt(scanner.nextLine());
                        sm.deleteStudent(delRollNo);
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to update: ");
                        int updateRollNo = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new Marks: ");
                        int newMarks = Integer.parseInt(scanner.nextLine());
                        sm.updateStudent(updateRollNo, newName, newMarks);
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to search: ");
                        int searchRollNo = Integer.parseInt(scanner.nextLine());
                        sm.displaySearchResult(searchRollNo);
                        break;

                    case 5:
                        sm.displayAllStudents();
                        break;

                    case 6:
                        sm.sortByRollNoAsc();
                        sm.displayAllStudents();
                        break;

                    case 7:
                        sm.sortByRollNoDesc();
                        sm.displayAllStudents();
                        break;

                    case 8:
                        sm.sortByMarksAsc();
                        sm.displayAllStudents();
                        break;

                    case 9:
                        sm.sortByMarksDesc();
                        sm.displayAllStudents();
                        break;

                    case 10:
                        System.out.println("Total number of students: " + sm.getStudentCount());
                        break;

                    case 0:
                        System.out.println("Thank you for using Student Record Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                choice = -1; // Continue loop
            }
        } while (choice != 0);

        scanner.close();
    }
}
