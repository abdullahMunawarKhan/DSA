
public class EmployeeSalarySorter {
    
    // Selection Sort implementation for floating-point numbers
    public static void selectionSort(double[] salaries) {
        int n = salaries.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (salaries[j] < salaries[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            double temp = salaries[minIndex];
            salaries[minIndex] = salaries[i];
            salaries[i] = temp;
        }
    }
    
    // Bubble Sort implementation for floating-point numbers
    public static void bubbleSort(double[] salaries) {
        int n = salaries.length;
        
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparison in each pass
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (salaries[j] > salaries[j + 1]) {
                    // Swap if they are in wrong order
                    double temp = salaries[j];
                    salaries[j] = salaries[j + 1];
                    salaries[j + 1] = temp;
                }
            }
        }
    }
    
    // Method to display array
    public static void printArray(double[] salaries) {
        for (double salary : salaries) {
            System.out.printf("%.2f ", salary);
        }
        System.out.println();
    }
    
    // Method to get top 5 highest salaries
    public static void displayTopFive(double[] sortedSalaries) {
        System.out.println("\nTop 5 Highest Salaries:");
        int count = Math.min(5, sortedSalaries.length);
        
        // Display from the end of sorted array (highest values)
        for (int i = sortedSalaries.length - 1; i >= sortedSalaries.length - count; i--) {
            System.out.printf("%.2f\n", sortedSalaries[i]);
        }
    }
    
    public static void main(String[] args) {
        // Sample employee salaries
        double[] originalSalaries = {45000.50, 78000.75, 52000.25, 95000.00, 
                                   38000.80, 67000.30, 89000.60, 41000.90, 
                                   72000.45, 56000.70};
        
        System.out.println("Original Employee Salaries:");
        printArray(originalSalaries);
        
        // Create copies for both sorting algorithms
        double[] salariesForSelection = originalSalaries.clone();
        double[] salariesForBubble = originalSalaries.clone();
        
        // Sort using Selection Sort
        System.out.println("\n--- Selection Sort ---");
        selectionSort(salariesForSelection);
        System.out.println("Salaries sorted using Selection Sort:");
        printArray(salariesForSelection);
        displayTopFive(salariesForSelection);
        
        // Sort using Bubble Sort
        System.out.println("\n--- Bubble Sort ---");
        bubbleSort(salariesForBubble);
        System.out.println("Salaries sorted using Bubble Sort:");
        printArray(salariesForBubble);
        displayTopFive(salariesForBubble);
    }
}
