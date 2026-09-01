public class PatientBST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
        }

    }

    private Node root;

    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientID() < current.patient.getPatientID()) {
            current.left = insertRecursive(current.left, patient);

        } else if (patient.getPatientID() > current.patient.getPatientID()) {
            current.right = insertRecursive(current.right, patient);

        } else {
            System.out.println("The ID you enterd already exists");
        }
        return current;
    }

    public Patient search(int id) {
        Node result = searchRecursive(root, id);
        return result == null ? null : result.patient;
    }

    private Node searchRecursive(Node current, int id) {
        if (current == null || current.patient.getPatientID() == id) {
            return current;
        }

        if (id < current.patient.getPatientID()) {
            return searchRecursive(current.left, id);
        }

        return searchRecursive(current.right, id);
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.println(current.patient);
            inOrder(current.right);
        }
    }

    public void delete1(int PatientID) {
    }

    public void delete(int PatientID) {
        root = deleteRecursive(root, PatientID);

    }

    private Node deleteRecursive(Node current, int patientId) {
        if (current == null) {
            System.out.println("Patient not found.");
            return null;
        }

        if (patientId < current.patient.getPatientID()) {
            current.left = deleteRecursive(current.left, patientId);
        } else if (patientId > current.patient.getPatientID()) {
            current.right = deleteRecursive(current.right, patientId);
        } else {
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // Node with two children
            Node minRight = findMin(current.right);
            current.patient = minRight.patient;
            current.right = deleteRecursive(current.right, minRight.patient.getPatientID());
        }
        return current;
    }

    private Node findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}

