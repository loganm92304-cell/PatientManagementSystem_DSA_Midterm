public class PatientSystemTest {

    public static void main(String[] args) {
        System.out.println("Running Unit Tests...");
        testQueueFIFO();
        testEmergencyInsertion();
        testDLLNavigationBounds();
        System.out.println("All Unit Tests Completed Successfully!");
    }

    public static void testQueueFIFO() {
        PatientWaitingQueue q = new PatientWaitingQueue();
        Patient p1 = new Patient("P01", "Alice", "Checkup");
        Patient p2 = new Patient("P02", "Bob", "Fever");

        q.addPatient(p1);
        q.addPatient(p2);

        assert q.size() == 2 : "Queue size should be 2";
        Patient served1 = q.servePatient();
        assert served1.getName().equals("Alice") : "First served should be Alice (FIFO)";
        System.out.println("[PASS] testQueueFIFO passed.");
    }

    public static void testEmergencyInsertion() {
        PatientWaitingQueue q = new PatientWaitingQueue();
        q.addPatient(new Patient("P01", "Alice", "Checkup"));
        q.addPatient(new Patient("P02", "Bob", "Fever"));

        q.insertEmergency(0, new Patient("EM01", "Charlie", "Severe Trauma"));

        assert q.size() == 3 : "Queue size should be 3";
        Patient servedFirst = q.servePatient();
        assert servedFirst.getName().equals("Charlie") : "Emergency patient should be served first";
        System.out.println("[PASS] testEmergencyInsertion passed.");
    }

    public static void testDLLNavigationBounds() {
        PatientHistoryList list = new PatientHistoryList();

        list.displayOldest();
        list.navigatePrev(); // Boundary test

        list.displayNewest();
        list.navigateNext(); // Boundary test

        System.out.println("[PASS] testDLLNavigationBounds passed.");
    }
}