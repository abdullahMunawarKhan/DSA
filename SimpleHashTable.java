public class SimpleHashTable {
    private final int SIZE = 10;
    private int[] keys = new int[SIZE];
    private String[] values = new String[SIZE];

    public SimpleHashTable() {
        // Use -1 to mark empty slots
        for (int i = 0; i < SIZE; i++) {
            keys[i] = -1;
        }
    }

    // Hash function: key % SIZE
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert key-value pair
    public void insert(int key, String value) {
        int index = hash(key);

        // Linear probing to find empty slot or update existing key
        while (keys[index] != -1 && keys[index] != key) {
            index = (index + 1) % SIZE;
        }
        keys[index] = key;
        values[index] = value;
    }

    // Search by key
    public String search(int key) {
        int index = hash(key);
        int startIndex = index;

        while (keys[index] != -1) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % SIZE;
            if (index == startIndex)
                break; // searched full table
        }
        return null; // not found
    }

    // Delete key-value pair
    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;

        while (keys[index] != -1) {
            if (keys[index] == key) {
                // Mark slot empty
                keys[index] = -1;
                values[index] = null;
                return;
            }
            index = (index + 1) % SIZE;
            if (index == startIndex)
                break; // full loop
        }
        System.out.println("Key not found: " + key);
    }

    // Display table
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] != -1) {
                System.out.println("Index " + i + ": Key = " + keys[i] + ", Value = " + values[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable();

        ht.insert(10, "Ten");
        ht.insert(20, "Twenty");
        ht.insert(30, "Thirty");

        ht.display();

        System.out.println("Search key 20: " + ht.search(20)); // Twenty

    }
}
