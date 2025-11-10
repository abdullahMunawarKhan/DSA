import java.util.Arrays;
import java.util.Scanner;

public class EmployeeSalarySort {

    // 1️⃣ Selection Sort (Ascending)
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 2️⃣ Bubble Sort (Ascending)
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 3️⃣ Display Top 5 Highest Salaries
    public static void displayTopFive(double[] arr) {
        System.out.println("\nTop 5 Highest Salaries:");
        int count = Math.min(5, arr.length); // in case fewer than 5 salaries
        for (int i = arr.length - 1, rank = 1; i >= arr.length - count; i--, rank++) {
            System.out.printf("%d. ₹%.2f%n", rank, arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get salary input
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double[] salaries = new double[n];
        System.out.println("Enter salaries of employees:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextDouble();
        }

        // Copy arrays for separate sorting
        double[] selectionSorted = Arrays.copyOf(salaries, n);
        double[] bubbleSorted = Arrays.copyOf(salaries, n);

        // Perform Selection Sort
        selectionSort(selectionSorted);
        System.out.println("\nSalaries sorted using Selection Sort (Ascending):");
        System.out.println(Arrays.toString(selectionSorted));

        // Perform Bubble Sort
        bubbleSort(bubbleSorted);
        System.out.println("\nSalaries sorted using Bubble Sort (Ascending):");
        System.out.println(Arrays.toString(bubbleSorted));

        // Display top 5 highest salaries (from sorted array)
        displayTopFive(selectionSorted);

        sc.close();
    }
}


