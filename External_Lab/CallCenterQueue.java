import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing a call
class Call {
    int customerID;
    int callTime; // in minutes

    public Call(int customerID, int callTime) {
        this.customerID = customerID;
        this.callTime = callTime;
    }

    @Override
    public String toString() {
        return "CustomerID: " + customerID + ", Call Time: " + callTime + " min";
    }
}

// Main class for the Call Center Queue System
public class CallCenterQueue {
    private Queue<Call> callQueue = new LinkedList<>();

    // Add a call to the queue
    public void addCall(int customerID, int callTime) {
        Call newCall = new Call(customerID, callTime);
        callQueue.add(newCall);
        System.out.println("📞 Call from Customer " + customerID + " added to the queue.");
    }

    // Answer (and remove) the next call in the queue
    public void answerCall() {
        if (!callQueue.isEmpty()) {
            Call answered = callQueue.poll();
            System.out.println("✅ Answering call from Customer " + answered.customerID +
                    " (" + answered.callTime + " min).");
        } else {
            System.out.println("⚠️ No calls to answer. Queue is empty!");
        }
    }

    // View all calls currently waiting in the queue
    public void viewQueue() {
        if (callQueue.isEmpty()) {
            System.out.println("📭 No pending calls in the queue.");
        } else {
            System.out.println("📋 Pending Calls:");
            for (Call call : callQueue) {
                System.out.println(" - " + call);
            }
        }
    }

    // Check if queue is empty
    public boolean isQueueEmpty() {
        return callQueue.isEmpty();
    }

    // --------------------------
    // Main method (Menu-driven)
    // --------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CallCenterQueue center = new CallCenterQueue();
        int choice;

        do {
            System.out.println("\n====== Call Center Queue System ======");
            System.out.println("1. Add a Call");
            System.out.println("2. Answer Next Call");
            System.out.println("3. View Call Queue");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Call Time (in minutes): ");
                    int time = sc.nextInt();
                    center.addCall(id, time);
                    break;

                case 2:
                    center.answerCall();
                    break;

                case 3:
                    center.viewQueue();
                    break;

                case 4:
                    if (center.isQueueEmpty())
                        System.out.println("✅ Queue is empty.");
                    else
                        System.out.println("📞 Queue is not empty. Calls are pending.");
                    break;

                case 5:
                    System.out.println("👋 Exiting Call Center System. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
