import java.util.Arrays;
import java.util.Scanner;

public class CustomerAccountSearchSystem {
    
    // Linear Search method based on your LinearSearch.java
    public static int linearSearch(String[] accountIds, String targetId) {
        for(int i = 0; i < accountIds.length; i++) {
            if(accountIds[i].equals(targetId)) {
                return i;
            }
        }
        return -1;
    }
    
    // Bubble Sort method from your BinarySearch.java adapted for strings
    static void bubbleSort(String[] accountIds) {
        for(int i = 0; i < accountIds.length; i++) {
            for(int j = i + 1; j < accountIds.length; j++) {
                if(accountIds[i].compareTo(accountIds[j]) > 0) {
                    String temp = accountIds[i];
                    accountIds[i] = accountIds[j];
                    accountIds[j] = temp;
                }
            }
        }
    }
    
    // Binary Search method based on your BinarySearch.java
    static int binarySearch(String[] accountIds, int right, int left, String targetId) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(accountIds[mid].equals(targetId)) {
                return mid;
            }
            
            if(accountIds[mid].compareTo(targetId) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]) {
        // E-commerce customer account IDs
        String[] accountIds = {"ACC085", "ACC025", "ACC014", "ACC032", "ACC012", 
                              "ACC002", "ACC065", "ACC004", "ACC006", "ACC098"};
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== E-commerce Customer Account Search System ===");
        System.out.println("Available Customer Account IDs:");
        System.out.println(Arrays.toString(accountIds));
        
        while(true) {
            System.out.println("\nChoose search method:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            if(choice == 3) {
                System.out.println("Exiting system...");
                break;
            }
            
            System.out.print("Enter customer account ID to search: ");
            String targetId = sc.nextLine();
            
            switch(choice) {
                case 1:
                    System.out.println("\n--- Linear Search ---");
                    long startTime = System.nanoTime();
                    int linearResult = linearSearch(accountIds, targetId);
                    long linearTime = System.nanoTime() - startTime;
                    
                    if(linearResult == -1) {
                        System.out.println("Customer account ID " + targetId + " is not found.");
                    } else {
                        System.out.println("Customer account ID " + targetId + " is found at position " + linearResult + ".");
                    }
                    System.out.println("Time taken: " + linearTime + " nanoseconds");
                    break;
                    
                case 2:
                    System.out.println("\n--- Binary Search ---");
                    // Create a copy for sorting (to preserve original array)
                    String[] sortedIds = accountIds.clone();
                    
                    
                    bubbleSort(sortedIds);
                    
                    
                    startTime = System.nanoTime();
                    int binaryResult = binarySearch(sortedIds, sortedIds.length - 1, 0, targetId);
                    long binaryTime = System.nanoTime() - startTime;
                    
                    if(binaryResult == -1) {
                        System.out.println("Customer account ID " + targetId + " is not found.");
                    } else {
                        System.out.println("Customer account ID " + targetId + " is found at position " + binaryResult + " in sorted array.");
                    }
                    System.out.println("Time taken: " + binaryTime + " nanoseconds");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        sc.close();
    }
}
