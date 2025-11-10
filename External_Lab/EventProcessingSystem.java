import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EventProcessingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> eventQueue = new LinkedList<>();

        int choice;
        do {
            System.out.println("\n====== Real-Time Event Processing System ======");
            System.out.println("1. Add an Event");
            System.out.println("2. Process Next Event");
            System.out.println("3. Display Pending Events");
            System.out.println("4. Cancel an Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Event
                    System.out.print("Enter event name to add: ");
                    String newEvent = sc.nextLine();
                    eventQueue.add(newEvent);
                    System.out.println("✅ Event \"" + newEvent + "\" added to the queue.");
                    break;

                case 2:
                    // Process Next Event (FIFO)
                    if (!eventQueue.isEmpty()) {
                        String processedEvent = eventQueue.poll();
                        System.out.println("⚙️ Processing event: " + processedEvent);
                    } else {
                        System.out.println("⚠️ No events to process.");
                    }
                    break;

                case 3:
                    // Display Pending Events
                    if (eventQueue.isEmpty()) {
                        System.out.println("📭 No pending events in the queue.");
                    } else {
                        System.out.println("📋 Pending Events:");
                        for (String event : eventQueue) {
                            System.out.println(" - " + event);
                        }
                    }
                    break;

                case 4:
                    // Cancel an Event
                    if (eventQueue.isEmpty()) {
                        System.out.println("⚠️ No events to cancel.");
                    } else {
                        System.out.print("Enter event name to cancel: ");
                        String cancelEvent = sc.nextLine();
                        if (eventQueue.remove(cancelEvent)) {
                            System.out.println("❌ Event \"" + cancelEvent + "\" has been canceled.");
                        } else {
                            System.out.println("⚠️ Event \"" + cancelEvent + "\" not found in queue.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("🚪 Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
