import java.util.HashMap;
import java.util.Map;

public class Billing {
    private Map<String, Double> billingRecords;

    public Billing() {
        billingRecords = new HashMap<>();
    }

    public void generateBill(String patientID, double amount) {
        billingRecords.put(patientID, billingRecords.getOrDefault(patientID, 0.0) + amount);
        System.out.println("Bill generated for Patient ID: " + patientID + ", Amount: $" + amount);
    }

    public void addPayment(String patientID, double payment) {
        if (billingRecords.containsKey(patientID)) {
            double remaining = billingRecords.get(patientID) - payment;
            billingRecords.put(patientID, remaining);
            System.out.println("Payment of $" + payment + " received for Patient ID: " + patientID);
        } else {
            System.out.println("No billing for Patient ID: " + patientID);
        }
    }

    public double getPaymentStatus(String patientID) {
        return billingRecords.getOrDefault(patientID, 0.0);
    }
}