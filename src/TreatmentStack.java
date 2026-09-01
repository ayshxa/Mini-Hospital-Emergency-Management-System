class TreatmentRecord {
    private int patientId;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public TreatmentRecord(int patientId, String doctorName,
                           String diagnosis, String treatment) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Doctor: " + doctorName +
               ", Diagnosis: " + diagnosis +
               ", Treatment: " + treatment;
    }
}

public class TreatmentStack {
    private class Node {
        TreatmentRecord record;
        Node next;

        Node(TreatmentRecord record) {
            this.record = record;
        }
    }

    private Node top;

    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;

        System.out.println("Treatment record added.");
    }

    public TreatmentRecord pop() {
        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public void display() {
        if (top == null) {
            System.out.println("No treatment records.");
            return;
        }

        Node current = top;

        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}