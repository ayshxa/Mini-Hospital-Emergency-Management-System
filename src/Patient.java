public class Patient {
    private int PatientID;
    private String name;
    private int age;
    private String contactNo;
    private String medicalCondition;

    public Patient (int PatientID, String name, int age, String contactNO, String medicalCondition)
    {
        this.PatientID = PatientID;
        this.name = name;
        this.age = age;
        this.contactNo = contactNO;
        this.medicalCondition = medicalCondition;
    }
     public int getPatientID() {
        return PatientID;
     }


    @Override
    public String toString() {
        return "ID: " + PatientID
                + ", Name: " + name
                + ", Age: " + age
                + ", Contact: " + contactNo
                + ", Condition: " + medicalCondition;

    }
    public String getName() {
        return name;
    }
    public App getVisitHistory() {
        
        return getVisitHistory();
    }
}
    