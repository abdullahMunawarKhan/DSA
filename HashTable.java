import java.util.LinkedList;

class KeyValuePair {
    int key;
    String value;
    
    public KeyValuePair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable {
    private static final int TABLE_SIZE = 10;
    private LinkedList<KeyValuePair>[] table;
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    // Division method hash function
    private int hashFunction(int key) {
        return key % TABLE_SIZE;
    }
    
    // Insert operation
    public void insert(int key, String value) {
        int index = hashFunction(key);
        LinkedList<KeyValuePair> chain = table[index];
        
        // Check if key already exists and update value
        for (KeyValuePair pair : chain) {
            if (pair.key == key) {
                pair.value = value;
                System.out.println("Updated key " + key + " with value: " + value);
                return;
            }
        }
        
        // Add new key-value pair
        chain.add(new KeyValuePair(key, value));
        System.out.println("Inserted key " + key + " with value: " + value + " at index " + index);
    }
    
    // Search operation
    public String search(int key) {
        int index = hashFunction(key);
        LinkedList<KeyValuePair> chain = table[index];
        
        for (KeyValuePair pair : chain) {
            if (pair.key == key) {
                System.out.println("Found key " + key + " with value: " + pair.value);
                return pair.value;
            }
        }
        
        System.out.println("Key " + key + " not found");
        return null;
    }
    
    // Delete operation
    public boolean delete(int key) {
        int index = hashFunction(key);
        LinkedList<KeyValuePair> chain = table[index];
        
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).key == key) {
                KeyValuePair removed = chain.remove(i);
                System.out.println("Deleted key " + key + " with value: " + removed.value);
                return true;
            }
        }
        
        System.out.println("Key " + key + " not found for deletion");
        return false;
    }
    
    // Display the hash table
    public void display() {
        System.out.println("\nHash Table Contents:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                for (KeyValuePair pair : table[i]) {
                    System.out.print("[" + pair.key + ":" + pair.value + "] ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        
        // Test Insert operations
        System.out.println("=== INSERT OPERATIONS ===");
        hashTable.insert(15, "Value15");
        hashTable.insert(25, "Value25");  // Will collide with 15 (both hash to index 5)
        hashTable.insert(35, "Value35");  // Will also hash to index 5
        hashTable.insert(12, "Value12");
        hashTable.insert(22, "Value22");  // Will collide with 12 (both hash to index 2)
        
        hashTable.display();
        
        // Test Search operations
        System.out.println("=== SEARCH OPERATIONS ===");
        hashTable.search(15);
        hashTable.search(25);
        hashTable.search(99);  // Key not found
        
        // Test Delete operations
        System.out.println("\n=== DELETE OPERATIONS ===");
        hashTable.delete(25);
        hashTable.delete(99);  // Key not found
        
        hashTable.display();
        
        // Test updating existing key
        System.out.println("=== UPDATE OPERATION ===");
        hashTable.insert(15, "UpdatedValue15");
        
        hashTable.display();
    }
}
