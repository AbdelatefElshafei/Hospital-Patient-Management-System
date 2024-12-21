package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private String reportType;
    private List<?> data;

    public ReportGenerator(String reportType, List<?> data) {
        this.reportType = reportType;
        this.data = data;
    }


    public void generatePatientReport() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Patient)) {
            System.out.println("Invalid or empty data for patient report.");
            return;
        }

        System.out.println("Generating Patient Visit History Report...");
        @SuppressWarnings("unchecked")
        List<Patient> patients = (List<Patient>) data;
        mergeSortPatientsByPriority(patients, 0, patients.size() - 1);

        for (Patient patient : patients) {
            patient.displayPatientInfo();
            System.out.println();
        }
    }

    public void generateAppointmentReport() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Appointment)) {
            System.out.println("Invalid or empty data for appointment report.");
            return;
        }

        System.out.println("Generating Appointment Statistics Report...");
        @SuppressWarnings("unchecked")
        List<Appointment> appointments = (List<Appointment>) data;
        mergeSortAppointmentsByID(appointments, 0, appointments.size() - 1);

        for (Appointment appointment : appointments) {
            System.out.println(appointment.toString());
            System.out.println();
        }
    }

    public void generateRevenueReport() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Double)) {
            System.out.println("Invalid or empty data for revenue report.");
            return;
        }

        System.out.println("Generating Revenue Summary Report...");
        @SuppressWarnings("unchecked")
        List<Double> revenues = (List<Double>) data;
        mergeSortRevenues(revenues, 0, revenues.size() - 1);

        double totalRevenue = 0;
        for (double revenue : revenues) {
            System.out.println("Revenue: $" + revenue);
            totalRevenue += revenue;
        }

        System.out.println("\nTotal Revenue: $" + totalRevenue);
    }

    public void generateBillingReport() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Billing)) {
            System.out.println("Invalid or empty data for billing report.");
            return;
        }

        System.out.println("Generating Billing Summary Report...");
        @SuppressWarnings("unchecked")
        List<Billing> billingData = (List<Billing>) data;

        mergeSortBillingByAmount(billingData, 0, billingData.size() - 1);

        double totalRevenue = 0;

        for (Billing billing : billingData) {
            System.out.println("Patient ID: " + billing.getPatientID());
            System.out.println("Billing Amount: $" + billing.getBillingAmount());
            System.out.println("Payment History: " + billing.getPaymentHistory());
            System.out.println();
            totalRevenue += billing.getBillingAmount();
        }

        System.out.println("Total Revenue: $" + totalRevenue);
    }

    private void mergeSortPatientsByPriority(List<Patient> patients, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortPatientsByPriority(patients, left, mid);
            mergeSortPatientsByPriority(patients, mid + 1, right);
            mergePatientsByPriority(patients, left, mid, right);
        }
    }

    private void mergePatientsByPriority(List<Patient> patients, int left, int mid, int right) {
        List<Patient> temp = new ArrayList<>(patients);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i).getPriority() <= temp.get(j).getPriority()) {
                patients.set(k++, temp.get(i++));
            } else {
                patients.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            patients.set(k++, temp.get(i++));
        }
    }

    private void mergeSortAppointmentsByID(List<Appointment> appointments, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortAppointmentsByID(appointments, left, mid);
            mergeSortAppointmentsByID(appointments, mid + 1, right);
            mergeAppointmentsByID(appointments, left, mid, right);
        }
    }

    private void mergeAppointmentsByID(List<Appointment> appointments, int left, int mid, int right) {
        List<Appointment> temp = new ArrayList<>(appointments);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i).getAppointmentID() <= temp.get(j).getAppointmentID()) {
                appointments.set(k++, temp.get(i++));
            } else {
                appointments.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            appointments.set(k++, temp.get(i++));
        }
    }

    private void mergeSortRevenues(List<Double> revenues, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortRevenues(revenues, left, mid);
            mergeSortRevenues(revenues, mid + 1, right);
            mergeRevenues(revenues, left, mid, right);
        }
    }

    private void mergeRevenues(List<Double> revenues, int left, int mid, int right) {
        List<Double> temp = new ArrayList<>(revenues);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i) <= temp.get(j)) {
                revenues.set(k++, temp.get(i++));
            } else {
                revenues.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            revenues.set(k++, temp.get(i++));
        }
    }

    private void mergeSortBillingByAmount(List<Billing> billingData, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortBillingByAmount(billingData, left, mid);
            mergeSortBillingByAmount(billingData, mid + 1, right);
            mergeBillingByAmount(billingData, left, mid, right);
        }
    }

    private void mergeBillingByAmount(List<Billing> billingData, int left, int mid, int right) {
        List<Billing> temp = new ArrayList<>(billingData);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i).getBillingAmount() <= temp.get(j).getBillingAmount()) {
                billingData.set(k++, temp.get(i++));
            } else {
                billingData.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            billingData.set(k++, temp.get(i++));
        }
    }
    public String generatePatientR() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Patient)) {
            return "Invalid or empty data for patient report.";
        }

        StringBuilder report = new StringBuilder("Patient Visit History Report:\n");
        @SuppressWarnings("unchecked")
        List<Patient> patients = (List<Patient>) data;
        mergeSortPatientsByPriority(patients, 0, patients.size() - 1);

        for (Patient patient : patients) {
            report.append(patient.toString()).append("\n");
        }
        return report.toString();
    }

    public String generateAppointmentR() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Appointment)) {
            return "Invalid or empty data for appointment report.";
        }

        StringBuilder report = new StringBuilder("Appointment Statistics Report:\n");
        @SuppressWarnings("unchecked")
        List<Appointment> appointments = (List<Appointment>) data;
        mergeSortAppointmentsByID(appointments, 0, appointments.size() - 1);

        for (Appointment appointment : appointments) {
            report.append(appointment.toString()).append("\n");
        }
        return report.toString();
    }

    public String generateRevenueR() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Double)) {
            return "Invalid or empty data for revenue report.";
        }

        StringBuilder report = new StringBuilder("Revenue Summary Report:\n");
        @SuppressWarnings("unchecked")
        List<Double> revenues = (List<Double>) data;
        mergeSortRevenues(revenues, 0, revenues.size() - 1);

        double totalRevenue = 0;
        for (double revenue : revenues) {
            report.append("Revenue: $").append(revenue).append("\n");
            totalRevenue += revenue;
        }

        report.append("\nTotal Revenue: $").append(totalRevenue);
        return report.toString();
    }

    public String generateBillingR() {
        if (data == null || data.isEmpty() || !(data.get(0) instanceof Billing)) {
            return "Invalid or empty data for billing report.";
        }

        StringBuilder report = new StringBuilder("Billing Summary Report:\n");
        @SuppressWarnings("unchecked")
        List<Billing> billingData = (List<Billing>) data;
        mergeSortBillingByAmount(billingData, 0, billingData.size() - 1);

        double totalRevenue = 0;
        for (Billing billing : billingData) {
            report.append("Patient ID: ").append(billing.getPatientID()).append("\n")
                    .append("Billing Amount: $").append(billing.getBillingAmount()).append("\n")
                    .append("Payment History: ").append(billing.getPaymentHistory()).append("\n\n");
            totalRevenue += billing.getBillingAmount();
        }

        report.append("Total Revenue: $").append(totalRevenue);
        return report.toString();
    }
}