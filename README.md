# Patient Management System - Mid Term Sprint

## Unit Test Descriptions (Part 4)
1. **`testQueueFIFO`**: Verifies that standard patient additions adhere to First-In, First-Out (FIFO) queue ordering.
2. **`testEmergencyInsertion`**: Verifies that emergency patients can be inserted at specific queue indices (e.g., position 0) and served immediately out of normal order.
3. **`testDLLNavigationBounds`**: Verifies that traversing past the Head (oldest) or Tail (newest) record in the Doubly Linked List is handled safely without throwing exceptions or crashing.

---

## Written Documentation Answers (Part 5)

### Why was a Queue appropriate for the waiting room?
A queue is appropriate because real-world waiting rooms operate on a fair, sequential order where the person who arrives first gets served first. A queue's linear structure mirrors this operational flow accurately.

### Explain FIFO principle
FIFO stands for **First-In, First-Out**. The element added to the data structure earliest is the first one to be removed or processed.

### Explain what could happen if a stack was used instead of a queue in Part 1
If a Stack (LIFO - Last-In, First-Out) were used, the last patient who checked in would always be treated first. Earlier patients would suffer from "starvation," waiting indefinitely while newly arriving patients continuously cut in front of them.

### Suggest ways that you could improve this system (Theory)
* Implement a **Priority Queue** where patients are automatically sorted by medical triage severity levels rather than manual index insertion.
* Integrate a persistent database or file storage (JSON/SQL) so patient records aren't lost when the program terminates.
* Add multi-threading or a graphical user interface (GUI) for concurrent receptionist and doctor desks.

### Why is a Doubly Linked List appropriate for patient history?
A Doubly Linked List allows bidirectional traversal (`next` and `prev` pointers). This is ideal for medical history where clinicians need to easily step forward or backward chronologically through past diagnoses without costly index lookups.

### What would happen in the DLL if you forgot to update the next and previous pointers when manipulating the DLL?
Failing to update pointers results in broken links, dangling references, or `NullPointerException` crashes when attempting to traverse the list. It can also cause nodes to become permanently disconnected and orphaned in memory.

### Explain why a Doubly Linked List works in this case compared to an Array or Array List
Arrays have a fixed size and require costly $O(N)$ shifting when inserting elements in the middle. ArrayLists resize dynamically but still require reallocation overhead and linear-time insertions. A Doubly Linked List allows constant-time $O(1)$ insertions and deletions anywhere once the node reference is established, making it optimal for dynamic history appending.