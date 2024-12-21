package com.example.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billing {
    private Map<String, Double> patientBills;
    private Map<String, Double> patientPayments;
    private double totalRevenue;

    public Billing() {
        this.patientBills = new HashMap<>();
        this.patientPayments = new HashMap<>();
        this.totalRevenue = 0.0;
    }

    public void generateBill(String patientID, double amount) {
        patientBills.put(patientID, amount);
        System.out.println("Bill generated for patient " + patientID + " with amount: " + amount);
    }

    public void addPayment(String patientID, double paymentAmount) {
        patientPayments.put(patientID, patientPayments.getOrDefault(patientID, 0.0) + paymentAmount);
        totalRevenue += paymentAmount;
        System.out.println("Payment of " + paymentAmount + " added for patient " + patientID);
    }

    public String getPaymentStatus(String patientID) {
        double billAmount = patientBills.getOrDefault(patientID, 0.0);
        double paymentsMade = patientPayments.getOrDefault(patientID, 0.0);
        if (paymentsMade >= billAmount) {
            return "Paid";
        } else {
            return "Pending: " + (billAmount - paymentsMade);
        }
    }

    public double getBillAmount(String patientID) {
        return patientBills.getOrDefault(patientID, 0.0);
    }

    public double getBillingAmount() {
        return totalRevenue;
    }

    public String getPatientID() {
        return "Billing Summary Report (No Specific Patient)";
    }

    public Map<String, Double> getPaymentHistory() {
        return patientPayments;
    }

    public List<BillingDetail> getAllBillingDetails() {
        List<BillingDetail> billingDetails = new ArrayList<>();
        for (String patientID : patientBills.keySet()) {
            double billAmount = patientBills.get(patientID);
            double paymentsMade = patientPayments.getOrDefault(patientID, 0.0);
            double outstandingAmount = Math.max(0, billAmount - paymentsMade);

            billingDetails.add(new BillingDetail(patientID, billAmount, paymentsMade, outstandingAmount));
        }
        return billingDetails;
    }

    public List<Double> getAllRevenues() {
        List<Double> revenueEntries = new ArrayList<>();
        revenueEntries.add(totalRevenue);
        return revenueEntries;
    }

    public static class BillingDetail {
        private String patientID;
        private double billAmount;
        private double paymentsMade;
        private double outstandingAmount;

        public BillingDetail(String patientID, double billAmount, double paymentsMade, double outstandingAmount) {
            this.patientID = patientID;
            this.billAmount = billAmount;
            this.paymentsMade = paymentsMade;
            this.outstandingAmount = outstandingAmount;
        }

        public String getPatientID() {
            return patientID;
        }

        public double getBillAmount() {
            return billAmount;
        }

        public double getPaymentsMade() {
            return paymentsMade;
        }

        public double getOutstandingAmount() {
            return outstandingAmount;
        }

        @Override
        public String toString() {
            return "BillingDetail{" +
                    "patientID='" + patientID + '\'' +
                    ", billAmount=" + billAmount +
                    ", paymentsMade=" + paymentsMade +
                    ", outstandingAmount=" + outstandingAmount +
                    '}';
        }
    }
}
