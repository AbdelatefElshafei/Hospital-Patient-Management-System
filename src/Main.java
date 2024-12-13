import java.util.List;

public class Main {
    public static void main(String[] args) {
        PatientManagementSystem pms = new PatientManagementSystem();
        new HospitalManagementGUI(pms);
    }
}
