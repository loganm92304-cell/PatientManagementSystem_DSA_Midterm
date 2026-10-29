
import java.util.LinkedList;

public class PatientWaitingQueue {
    private LinkedList<Patient> queue = new LinkedList<>();

    // Add a patient to the back of the queue (Standard FIFO)
    public void addPatient(Patient patient) {
        queue.addLast(patient);
        System.out.println("-> Added " + patient.getName() + " to the waiting queue.");
    }

    // Serve (remove) the next patient in the queue
    public Patient servePatient() {
        if (queue.isEmpty()) {
            System.out.println("-> Waiting queue is empty. No patients to serve.");
            return null;
        }
        Patient served = queue.removeFirst();
        System.out.println("-> Serving patient: " + served.getName());
        return served;
    }

    // Insert a patient at a specific position (Emergency case)
    public boolean insertEmergency(int position, Patient patient) {
        if (position < 0 || position > queue.size()) {
            System.out.println("-> Invalid position! Current queue size is " + queue.size());
            return false;
        }
        queue.add(position, patient);
        System.out.println("-> EMERGENCY: Inserted " + patient.getName() + " at position " + position);
        return true;
    }

    // Print all patients currently in the queue
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("-> The waiting queue is currently EMPTY.");
            return;
        }
        System.out.println("\n--- Current Patient Waiting Queue ---");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println("[" + i + "] " + queue.get(i));
        }
        System.out.println("-------------------------------------");
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}