package com.example.demo2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PatientManagementSystem {
    private static PatientManagementSystem instance;
    private PatientBST patientList;
    private AppointmentQueue appointmentQueue;
    private List<Appointment> appointmentList;
    private Billing billing;
    private List<String> billings ;
    WaitingList waitingList ;

    private PatientManagementSystem() {
        this.patientList = new PatientBST();
        this.appointmentQueue = new AppointmentQueue();
        this.appointmentList = new ArrayList<>();
        this.billing = new Billing();
        this.billings = new ArrayList<>();
        this.waitingList = new WaitingList(10);
    }

    public static PatientManagementSystem getInstance() {
        if (instance == null) {
            instance = new PatientManagementSystem();
        }
        return instance;
    }

    public void addPatient(Patient patient) {
        if (patient == null) {
            System.out.println("Invalid patient details.");
            return;
        }
        patientList.insert(patient);
        System.out.println("Patient added successfully: " + patient.getName());
    }

    public String findPatient(String patientID) {
        if (patientID == null || patientID.isEmpty()) {
            System.out.println("Invalid patient ID.");
            return "Invalid patient ID.";
        }

        Patient patient = patientList.search(patientID);
        if (patient != null) {
            patient.displayPatientInfo();
            return patient.toString();
        } else {
            System.out.println("Patient not found.");
            return "Patient not found.";
        }
    }

    public Patient findPatientByID(String patientID) {
        if (patientID == null || patientID.isEmpty()) {
            System.out.println("Invalid patient ID.");
            return null;
        }
        return patientList.search(patientID);
    }

    public void scheduleAppointment(Appointment appointment) {
        if (appointment == null || appointment.getPatient() == null) {
            System.out.println("Invalid appointment details.");
            return;
        }

        appointmentList.add(appointment);
        appointment.getPatient().addVisit(appointment.toString());
        System.out.println("Appointment scheduled successfully for Patient: " + appointment.getPatient().getName());
    }

    public void cancelAppointment(int appointmentID) {
        boolean removed = appointmentList.removeIf(appointment -> appointment.getAppointmentID() == appointmentID);

        if (removed) {
            System.out.println("Appointment canceled successfully: ID " + appointmentID);
        } else {
            System.out.println("Appointment not found: ID " + appointmentID);
        }
    }
    public void rescheduleAppointment(int appointmentID, String newDate, String newTime) {
        Appointment appointmentToReschedule = appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentID() == appointmentID)
                .findFirst()
                .orElse(null);

        if (appointmentToReschedule != null) {
            appointmentToReschedule.setDate(newDate);
            appointmentToReschedule.setTime(newTime);
            System.out.println("Appointment rescheduled successfully: ID " + appointmentID);
        } else {
            System.out.println("Appointment not found: ID " + appointmentID);
        }
    }
    public void manageWaitingList(String action, String patientID) {
        Patient patient = findPatientByID(patientID);
        switch (action.toLowerCase()) {
            case "add":
                if (patient != null) {
                    waitingList.addToWaitList(patient);
                } else {
                    System.out.println("Invalid patient details.");
                }
                break;

            case "remove":
                waitingList.removeFromWaitList();
                break;

            default:
                System.out.println("Invalid action. Please use 'add', 'remove', or 'view'.");
                break;
        }
    }
    public String view() {
        return waitingList.viewWait();
    }

    public PatientBST getPatientList() {
        return patientList;
    }

    public List<Appointment> getAppointmentList() {
        return new ArrayList<>(appointmentList);
    }

    public Billing getBilling() {
        return billing;
    }
    public void generateBillForPatient(String patientID, double billAmount) {
        billing.generateBill(patientID, billAmount);

        billings.add("Payment for patient1 " + patientID+ " with amount: " + billAmount+"\n");
        System.out.println("Bill generated for patient " + patientID + " with amount: " + billAmount);
    }

    public void addPaymentForPatient(String patientID, double paymentAmount) {
        billing.addPayment(patientID, paymentAmount);
        System.out.println("Payment of " + paymentAmount + " added for patient " + patientID);
    }

    public String getPaymentStatusForPatient(String patientID) {
        String status = billing.getPaymentStatus(patientID);
        System.out.println("Payment status for patient " + patientID + ": " + status);
        return("Payment status for patient " + patientID + ": " + status);
    }

    public void getBillAmountForPatient(String patientID) {
        double billAmount = billing.getBillAmount(patientID);
        System.out.println("Bill amount for patient " + patientID + ": " + billAmount);
    }
    public String generateReport(String reportType) {
        ReportGenerator reportGenerator;
        List<?> data;

        switch (reportType.toLowerCase()) {
            case "patient":
                data = patientList.getInOrderTraversal();
                reportGenerator = new ReportGenerator("Patient Report", data);
                reportGenerator.generatePatientReport();
                return reportGenerator.generatePatientR();


            case "appointment":
                data = new ArrayList<>(appointmentList);
                reportGenerator = new ReportGenerator("Appointment Report", data);
                reportGenerator.generateAppointmentReport();
                return reportGenerator.generateAppointmentR();

            case "revenue":
                data = billing.getAllRevenues();
                reportGenerator = new ReportGenerator("Revenue Report", data);
                reportGenerator.generateRevenueReport();
                return reportGenerator.generateRevenueR();

            case "billing":
                return billings.toString();

            default:
                System.out.println("Invalid report type: " + reportType);
                return "Invalid report type: " + reportType;
        }
    }
}
