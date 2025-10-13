import java.util.Arrays;

public class LinearProbingHashTable {
    private static final int TABLE_SIZE = 11; // Prime number for better distribution
    private static final int EMPTY = -1;
    private static final int DELETED = -2;
    
    private int[] table;
    
    public LinearProbingHashTable() {
        table = new int[TABLE_SIZE];
        Arrays.fill(table, EMPTY);
    }
    
    // Division method hash function
    private int hashFunction(int key) {
        return key % TABLE_SIZE;
    }
    
    // Insert operation with linear probing
    public boolean insert(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        
        // Linear probing to find empty slot or deleted slot
        while (table[index] != EMPTY && table[index] != DELETED) {
            // Key already exists
            if (table[index] == key) {
                System.out.println("Key " + key + " already exists at index " + index);
                return false;
            }
            
            // Move to next index (linear probing)
            index = (index + 1) % TABLE_SIZE;
            
            // Table is full if we've checked all positions
            if (index == originalIndex) {
                System.out.println("Hash table is full! Cannot insert key " + key);
                return false;
            }
        }
        
        // Insert the key
        table[index] = key;
        System.out.println("Inserted key " + key + " at index " + index);
        return true;
    }
    
    // Search operation with linear probing
    public boolean search(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        
        while (table[index] != EMPTY) {
            // Key found
            if (table[index] == key) {
                System.out.println("Key " + key + " found at index " + index);
                return true;
            }
            
            // Move to next index
            index = (index + 1) % TABLE_SIZE;
            
            // Searched entire table
            if (index == originalIndex) {
                break;
            }
        }
        
        System.out.println("Key " + key + " not found");
        return false;
    }
    
    // Delete operation with linear probing
    public boolean delete(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        
        while (table[index] != EMPTY) {
            // Key found, mark as deleted
            if (table[index] == key) {
                table[index] = DELETED;
                System.out.println("Deleted key " + key + " from index " + index);
                return true;
            }
            
            // Move to next index
            index = (index + 1) % TABLE_SIZE;
            
            // Searched entire table
            if (index == originalIndex) {
                break;
            }
        }
        
        System.out.println("Key " + key + " not found for deletion");
        return false;
    }
    
    // Display the hash table
    public void display() {
        System.out.println("\nHash Table Contents:");
        System.out.println("Index\tValue\tStatus");
        System.out.println("-----\t-----\t------");
        
        for (int i = 0; i < TABLE_SIZE; i++) {
            String status;
            String value;
            
            if (table[i] == EMPTY) {
                status = "Empty";
                value = "-";
            } else if (table[i] == DELETED) {
                status = "Deleted";
                value = "-";
            } else {
                status = "Occupied";
                value = String.valueOf(table[i]);
            }
            
            System.out.println(i + "\t" + value + "\t" + status);
        }
        System.out.println();
    }
    
    // Calculate load factor
    public double getLoadFactor() {
        int occupied = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i] != EMPTY && table[i] != DELETED) {
                occupied++;
            }
        }
        return (double) occupied / TABLE_SIZE;
    }
    
    public static void main(String[] args) {
        LinearProbingHashTable hashTable = new LinearProbingHashTable();
        
        System.out.println("=== LINEAR PROBING HASH TABLE DEMO ===");
        System.out.println("Table Size: " + TABLE_SIZE);
        
        // Initial display
        hashTable.display();
        
        // Test Insert operations
        System.out.println("=== INSERT OPERATIONS ===");
        hashTable.insert(22);  // Hash to index 0 (22 % 11 = 0)
        hashTable.insert(33);  // Hash to index 0, probe to index 1
        hashTable.insert(44);  // Hash to index 0, probe to index 2
        hashTable.insert(15);  // Hash to index 4 (15 % 11 = 4)
        hashTable.insert(26);  // Hash to index 4, probe to index 5
        hashTable.insert(37);  // Hash to index 4, probe to index 6
        hashTable.insert(48);  // Hash to index 4, probe to index 7
        
        hashTable.display();
        System.out.println("Load Factor: " + String.format("%.2f", hashTable.getLoadFactor()));
        
        // Test Search operations
        System.out.println("=== SEARCH OPERATIONS ===");
        hashTable.search(33);
        hashTable.search(26);
        hashTable.search(99);  // Not in table
        
        // Test Delete operations
        System.out.println("=== DELETE OPERATIONS ===");
        hashTable.delete(33);
        hashTable.delete(99);  // Not in table
        
        hashTable.display();
        
        // Test insertion after deletion
        System.out.println("=== INSERT AFTER DELETION ===");
        hashTable.insert(55);  // Should use deleted slot
        
        hashTable.display();
        
        // Test duplicate insertion
        System.out.println("=== DUPLICATE INSERTION TEST ===");
        hashTable.insert(22);  // Already exists
        
        hashTable.display();
        System.out.println("Final Load Factor: " + String.format("%.2f", hashTable.getLoadFactor()));
    }
}
