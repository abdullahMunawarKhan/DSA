import java.util.Arrays;
import java.util.Scanner;

public class CustomerSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample customer account IDs
        int[] customerIDs = {101, 205, 150, 178, 230, 99, 310};

        System.out.println("Enter Customer Account ID to search:");
        int target = sc.nextInt();

        // 1️⃣ Linear Search
        boolean linearResult = linearSearch(customerIDs, target);
        if (linearResult)
            System.out.println("✅ Linear Search: Customer ID " + target + " found.");
        else
            System.out.println("❌ Linear Search: Customer ID " + target + " not found.");

        // 2️⃣ Binary Search (requires sorted array)
        Arrays.sort(customerIDs); // sorting for binary search
        boolean binaryResult = binarySearch(customerIDs, target);
        if (binaryResult)
            System.out.println("✅ Binary Search: Customer ID " + target + " found.");
        else
            System.out.println("❌ Binary Search: Customer ID " + target + " not found.");

        sc.close();
    }

    // ---------- Linear Search ----------
    public static boolean linearSearch(int[] arr, int target) {
        for (int id : arr) {
            if (id == target)
                return true;
        }
        return false;
    }

    // ---------- Binary Search ----------
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}



