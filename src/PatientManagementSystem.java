
import java.util.Scanner;

public class PatientManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientWaitingQueue waitingQueue = new PatientWaitingQueue();
        PatientHistoryList historyList = new PatientHistoryList();

        boolean running = true;
        while (running) {
            System.out.println("\n=== HOSPITAL PATIENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Patient to Waiting Queue");
            System.out.println("2. Serve Next Patient (Queue)");
            System.out.println("3. Insert Emergency Patient at Position");
            System.out.println("4. View Waiting Queue");
            System.out.println("------------------------------------------");
            System.out.println("5. View Current Patient History Record");
            System.out.println("6. Navigate to Next History Record (Forward)");
            System.out.println("7. Navigate to Previous History Record (Backward)");
            System.out.println("8. Jump to Newest History Record");
            System.out.println("9. Jump to Oldest History Record");
            System.out.println("10. Add New Medical History Record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.next();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Reason for Visit: ");
                    String reason = scanner.nextLine();
                    waitingQueue.addPatient(new Patient(id, name, reason));
                    break;
                case 2:
                    waitingQueue.servePatient();
                    break;
                case 3:
                    waitingQueue.printQueue();
                    System.out.print("Enter index position for emergency insertion (0-indexed): ");
                    if (scanner.hasNextInt()) {
                        int pos = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String eId = scanner.nextLine();
                        System.out.print("Enter Patient Name: ");
                        String eName = scanner.nextLine();
                        System.out.print("Enter Reason for Visit: ");
                        String eReason = scanner.nextLine();
                        waitingQueue.insertEmergency(pos, new Patient(eId, eName, eReason));
                    } else {
                        scanner.next();
                        System.out.println("Invalid position input.");
                    }
                    break;
                case 4:
                    waitingQueue.printQueue();
                    break;
                case 5:
                    historyList.displayCurrent();
                    break;
                case 6:
                    historyList.navigateNext();
                    historyList.displayCurrent();
                    break;
                case 7:
                    historyList.navigatePrev();
                    historyList.displayCurrent();
                    break;
                case 8:
                    historyList.displayNewest();
                    break;
                case 9:
                    historyList.displayOldest();
                    break;
                case 10:
                    System.out.print("Enter Visit Date (YYYY-MM-DD): ");
                    String vDate = scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diag = scanner.nextLine();
                    System.out.print("Enter Treatment Notes: ");
                    String notes = scanner.nextLine();
                    historyList.addRecord(new PatientHistoryRecord(vDate, diag, notes));
                    System.out.println("-> New history record added successfully.");
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting Patient Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
        scanner.close();
    }
}