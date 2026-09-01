public class PatientVisitHistory {
    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
        }
    }

    private Node head;

    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public Visit searchVisit(int visitId) {
        Node current = head;

        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed.");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Visit removed.");
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No previous visits.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}

