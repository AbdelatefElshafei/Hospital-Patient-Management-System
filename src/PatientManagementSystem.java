import java.util.ArrayList;
import java.util.List;

public class PatientManagementSystem {
    private PatientBST patientList;
    AppointmentQueue appointmentQueue1 = new AppointmentQueue();
    //private WaitingList waitingList;
    List<Appointment> appointmentQueue;
    private Billing billing;

    public PatientManagementSystem() {
        patientList = new PatientBST();
        //waitingList = new WaitingList();
        appointmentQueue = new ArrayList<>();
        billing = new Billing();
    }

    public void addPatient(Patient patient) {
        patientList.insert(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    public void findPatient(String patientID) {
        Patient patient = patientList.search(patientID);
        if (patient != null) {
            patient.displayPatientInfo();
        } else {
            System.out.println("Patient not found.");
        }
    }

    public Patient findPatien(String patientID) {
        Patient patient = patientList.search(patientID);
        if (patient != null) {
            return patient;
        } else {
            return null;
        }
        
    }

    public void scheduleAppointment(Appointment appointment) {
        appointmentQueue.add(appointment);
        appointment.getPatient().addvisits(appointment);
        System.out.println("Appointment scheduled for Patient: " + appointment.getPatient().getName());
    }

    public void cancelAppointment(int appointmentID) {
        appointmentQueue.removeIf(appointment -> appointment.getAppointmentID() == appointmentID);
        System.out.println("Appointment canceled: ID " + appointmentID);
    }

    /*public void generateReport(String type) {
        ReportGenerator reportGenerator = new ReportGenerator();
        switch (type) {
            case "patient":
                List<Patient> patients = new ArrayList<>();
                patientList.displayInOrder(); 
                break;
            case "appointment":
                reportGenerator.generateAppointmentReport(appointmentQueue);
                break;
            case "revenue":
                reportGenerator.generateRevenueReport(billing, new ArrayList<>());
                break;
            default:
                System.out.println("Invalid report type.");
        }*/
    }
