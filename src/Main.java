import  java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PatientBST patientTree = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientTree.displayInOrder();
                case 5 -> addEmergencyPatient();
                case 6 -> treatNextPatient();
                case 7 -> emergencyQueue.display();
                case 8 -> addTreatmentRecord();
                case 9 -> undoTreatmentRecord();
                case 10 -> treatmentStack.display();
                case 11 -> manageVisitHistory();
                case 0 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n=== Mini Hospital Emergency System ===");
        System.out.println("1. Register patient");
        System.out.println("2. Search patient");
        System.out.println("3. Delete patient");
        System.out.println("4. Display patients in ID order");
        System.out.println("5. Add patient to emergency queue");
        System.out.println("6. Treat next patient");
        System.out.println("7. Display emergency queue");
        System.out.println("8. Add treatment record");
        System.out.println("9. Remove latest treatment record");
        System.out.println("10. Display treatment history");
        System.out.println("11. Manage patient visit history");
        System.out.println("0. Exit");
    }

    private static int readInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void addPatient() {
        int id = readInt("Patient ID: ");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age = readInt("Age: ");

        System.out.print("Contact number: ");
        String contact = scanner.nextLine();

        System.out.print("Medical condition: ");
        String condition = scanner.nextLine();

        patientTree.insert(
                new Patient(id, name, age, contact, condition)
        );

        System.out.println("Patient registered.");
    }

    private static void searchPatient() {
        int id = readInt("Enter patient ID: ");
        Patient patient = patientTree.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println(patient);
        }
    }

    private static void deletePatient() {
        int id = readInt("Enter patient ID: ");
        patientTree.delete(id);
    }

    private static void addEmergencyPatient() {
        int id = readInt("Enter registered patient ID: ");
        Patient patient = patientTree.search(id);

        if (patient == null) {
            System.out.println("Patient is not registered.");
        } else {
            emergencyQueue.enqueue(patient);
        }
    }

    private static void treatNextPatient() {
        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {
            System.out.println("Now treating: " + patient);
        }
    }

    private static void addTreatmentRecord() {
        int id = readInt("Patient ID: ");

        System.out.print("Doctor name: ");
        String doctor = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        treatmentStack.push(
                new TreatmentRecord(id, doctor, diagnosis, treatment)
        );
    }

    private static void undoTreatmentRecord() {
        TreatmentRecord record = treatmentStack.pop();

        if (record != null) {
            System.out.println("Removed: " + record);
        }
    }

    private static void manageVisitHistory() {
        int id = readInt("Enter patient ID: ");
        Patient patient = patientTree.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("1. Add visit");
        System.out.println("2. Search visit");
        System.out.println("3. Remove visit");
        System.out.println("4. Display visits");

        int choice = readInt("Enter choice: ");

        switch (choice) {
            case 1 -> addVisit(patient);
            case 2 -> searchVisit(patient);
            case 3 -> removeVisit(patient);
            case 4 -> patient.getVisitHistory().display();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void addVisit(Patient patient) {
        System.out.print("Visit date: ");
        System.out.print("Doctor name: ");
        System.out.print("Diagnosis: ");
        System.out.print("Treatment: ");
        int visitId = 0;
        patient.getVisitHistory().addVisit(
                new Visit(visitId, null, null, null, null)
        );

        System.out.println("Visit added.");
    }

    private static void searchVisit(Patient patient) {
        int visitId = readInt("Visit ID: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        System.out.println(visit == null ? "Visit not found." : visit);
    }

    private static void removeVisit(Patient patient) {
        int visitId = readInt("Visit ID: ");
        patient.getVisitHistory().removeVisit(visitId);
    }
}
