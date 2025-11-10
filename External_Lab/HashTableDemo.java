import java.util.LinkedList;
import java.util.Scanner;

// Class to represent a key-value pair
class HashNode {
    int key;
    String value;

    public HashNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// Hash Table class
class HashTable {
    private final int SIZE = 10;
    private LinkedList<HashNode>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function (Division Method)
    private int hashFunction(int key) {
        return key % SIZE;
    }

    // 1️⃣ Insert key-value pair
    public void insert(int key, String value) {
        int index = hashFunction(key);
        for (HashNode node : table[index]) {
            if (node.key == key) {
                node.value = value; // Update existing value
                System.out.println("✏️ Key " + key + " updated with new value: " + value);
                return;
            }
        }
        table[index].add(new HashNode(key, value));
        System.out.println("✅ Inserted (" + key + ", " + value + ") at index " + index);
    }

    // 2️⃣ Search for a key
    public void search(int key) {
        int index = hashFunction(key);
        for (HashNode node : table[index]) {
            if (node.key == key) {
                System.out.println("🔍 Found: Key = " + key + ", Value = " + node.value);
                return;
            }
        }
        System.out.println("❌ Key " + key + " not found.");
    }

    // 3️⃣ Delete a key-value pair
    public void delete(int key) {
        int index = hashFunction(key);
        for (HashNode node : table[index]) {
            if (node.key == key) {
                table[index].remove(node);
                System.out.println("🗑️ Key " + key + " deleted successfully.");
                return;
            }
        }
        System.out.println("⚠️ Key " + key + " not found. Cannot delete.");
    }

    // 4️⃣ Display entire hash table
    public void display() {
        System.out.println("\n📦 Hash Table Contents:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                for (HashNode node : table[i]) {
                    System.out.print(node + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}

public class HashTableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable hashTable = new HashTable();
        int choice;

        do {
            System.out.println("\n====== Hash Table Operations ======");
            System.out.println("1. Insert Key-Value Pair");
            System.out.println("2. Search Key");
            System.out.println("3. Delete Key");
            System.out.println("4. Display Hash Table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Key (integer): ");
                    int key = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Value (string): ");
                    String value = sc.nextLine();
                    hashTable.insert(key, value);
                    break;

                case 2:
                    System.out.print("Enter Key to search: ");
                    hashTable.search(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Key to delete: ");
                    hashTable.delete(sc.nextInt());
                    break;

                case 4:
                    hashTable.display();
                    break;

                case 5:
                    System.out.println("👋 Exiting Hash Table Program. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
