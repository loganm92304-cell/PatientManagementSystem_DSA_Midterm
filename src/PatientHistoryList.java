public class PatientHistoryList {
    private PatientHistoryRecord head; // Oldest record
    private PatientHistoryRecord tail; // Newest record
    private PatientHistoryRecord current; // Currently viewed record

    public PatientHistoryList() {
        loadDefaultRecords();
    }

    // Preload 10 patient history records
    private void loadDefaultRecords() {
        addRecord(new PatientHistoryRecord("2024-01-10", "Common Cold", "Prescribed rest and fluids."));
        addRecord(new PatientHistoryRecord("2024-03-15", "Mild Sprained Ankle", "RICE protocol and bandage applied."));
        addRecord(new PatientHistoryRecord("2024-05-20", "Seasonal Allergies", "Antihistamines recommended."));
        addRecord(new PatientHistoryRecord("2024-07-02", "Annual Physical", "All vitals normal. Blood work ordered."));
        addRecord(new PatientHistoryRecord("2024-08-12", "Gastroenteritis", "Hydration therapy and bland diet."));
        addRecord(new PatientHistoryRecord("2024-09-05", "Acute Bronchitis", "Inhaler prescribed for 7 days."));
        addRecord(new PatientHistoryRecord("2024-10-19", "Migraine", "Pain relievers and dark room rest."));
        addRecord(new PatientHistoryRecord("2024-11-22", "Strep Throat", "Antibiotics course (Amoxicillin)."));
        addRecord(new PatientHistoryRecord("2024-12-14", "Minor Cut / Stitches", "3 sutures applied, tetanus booster given."));
        addRecord(new PatientHistoryRecord("2025-01-25", "Routine Checkup", "Blood pressure stable, weight healthy."));
    }

    // Add new record to the end (newest)
    public void addRecord(PatientHistoryRecord newRecord) {
        if (head == null) {
            head = newRecord;
            tail = newRecord;
            current = newRecord;
        } else {
            tail.next = newRecord;
            newRecord.prev = tail;
            tail = newRecord;
        }
    }

    // Navigate forward in time
    public void navigateNext() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("-> Navigated to Next Record.");
        } else {
            System.out.println("-> Cannot navigate further. You are already at the newest record (Tail).");
        }
    }

    // Navigate backward in time
    public void navigatePrev() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("-> Navigated to Previous Record.");
        } else {
            System.out.println("-> Cannot navigate further. You are already at the oldest record (Head).");
        }
    }

    // Display newest record (Tail)
    public void displayNewest() {
        if (tail != null) {
            current = tail;
            System.out.println("\n=== Newest Record ===");
            System.out.println(current);
            System.out.println("=====================");
        } else {
            System.out.println("-> No history records available.");
        }
    }

    // Display oldest record (Head)
    public void displayOldest() {
        if (head != null) {
            current = head;
            System.out.println("\n=== Oldest Record ===");
            System.out.println(current);
            System.out.println("=====================");
        } else {
            System.out.println("-> No history records available.");
        }
    }

    // Display current viewing record
    public void displayCurrent() {
        if (current != null) {
            System.out.println("\n=== Current Viewing Record ===");
            System.out.println(current);
            System.out.println("==============================");
        } else {
            System.out.println("-> No records to display.");
        }
    }
}