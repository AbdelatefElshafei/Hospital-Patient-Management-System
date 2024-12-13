import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalManagementGUI {
    private PatientManagementSystem pms;

    public HospitalManagementGUI(PatientManagementSystem pms) {
        this.pms = pms;
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Background panel with an image
        JPanel mainPanel = new BackgroundPanel("Back.jpg");
        mainPanel.setLayout(new BorderLayout());

        // Menu Panel
        JPanel menuPanel = new JPanel(new GridLayout(5, 1));
        menuPanel.setOpaque(false); // Make the panel transparent for the background
        JButton managePatientsButton = new JButton("Manage Patients");
        JButton manageAppointmentsButton = new JButton("Manage Appointments");
        JButton manageBillingButton = new JButton("Manage Billing");
        JButton generateReportsButton = new JButton("Generate Reports");
        JButton exitButton = new JButton("Exit");

        menuPanel.add(managePatientsButton);
        menuPanel.add(manageAppointmentsButton);
        menuPanel.add(manageBillingButton);
        menuPanel.add(generateReportsButton);
        menuPanel.add(exitButton);

        mainPanel.add(menuPanel, BorderLayout.WEST);

        // Dynamic Content Panel
        JPanel contentPanel = new JPanel(new CardLayout());
        contentPanel.setOpaque(false); // Make the content panel transparent
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Manage Patients Panel
        JPanel managePatientsPanel = new JPanel();
        managePatientsPanel.setLayout(new BoxLayout(managePatientsPanel, BoxLayout.Y_AXIS));
        managePatientsPanel.setOpaque(false); // Transparent
        JButton addPatientButton = new JButton("Add Patient");
        JButton findPatientButton = new JButton("Find Patient");
        managePatientsPanel.add(addPatientButton);
        managePatientsPanel.add(findPatientButton);

        // Add Patient Dialog
        addPatientButton.addActionListener(e -> showAddPatientDialog());

        // Find Patient Dialog
        findPatientButton.addActionListener(e -> showFindPatientDialog());

        contentPanel.add(managePatientsPanel, "ManagePatients");

        // Manage Appointments Panel
        JPanel manageAppointmentsPanel = new JPanel();
        manageAppointmentsPanel.setLayout(new BoxLayout(manageAppointmentsPanel, BoxLayout.Y_AXIS));
        manageAppointmentsPanel.setOpaque(false); // Transparent
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        JButton cancelAppointmentButton = new JButton("Cancel Appointment");
        manageAppointmentsPanel.add(scheduleAppointmentButton);
        manageAppointmentsPanel.add(cancelAppointmentButton);

        // Schedule Appointment Dialog
        scheduleAppointmentButton.addActionListener(e -> showScheduleAppointmentDialog());

        // Cancel Appointment Dialog
        cancelAppointmentButton.addActionListener(e -> showCancelAppointmentDialog());

        contentPanel.add(manageAppointmentsPanel, "ManageAppointments");

        // Event Listeners for Navigation
        managePatientsButton.addActionListener(e -> switchPanel(contentPanel, "ManagePatients"));
        manageAppointmentsButton.addActionListener(e -> switchPanel(contentPanel, "ManageAppointments"));
        exitButton.addActionListener(e -> System.exit(0));

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showAddPatientDialog() {
        JFrame dialog = new JFrame("Add Patient");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(8, 2));

        JLabel idLabel = new JLabel("Patient ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel contactLabel = new JLabel("Contact Info:");
        JTextField contactField = new JTextField();
        JLabel hhLabel = new JLabel("Health Info:");
        JTextField healthField = new JTextField();
        JButton submitButton = new JButton("Add Patient");

        submitButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String contact = contactField.getText();
            String health = healthField.getText();
            pms.addPatient(new Patient(id, name, age, contact, health));
            dialog.dispose();
            JOptionPane.showMessageDialog(null, "Patient added successfully!");
        });

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(ageLabel);
        dialog.add(ageField);
        dialog.add(contactLabel);
        dialog.add(contactField);
        dialog.add(hhLabel);
        dialog.add(healthField);
        dialog.add(new JLabel());
        dialog.add(submitButton);

        dialog.setVisible(true);
    }

    private void showFindPatientDialog() {
        JFrame dialog = new JFrame("Find Patient");
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Patient ID:");
        JTextField idField = new JTextField();
        JButton findButton = new JButton("Find Patient");

        findButton.addActionListener(e -> {
            String id = idField.getText();
            Patient patient = pms.findPatient(id);
            if (patient != null) {
                JOptionPane.showMessageDialog(null, patient.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Patient not found!");
            }
            dialog.dispose();
        });

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel());
        dialog.add(findButton);

        dialog.setVisible(true);
    }

    private void showScheduleAppointmentDialog() {
        JFrame dialog = new JFrame("Schedule Appointment");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel patientIdLabel = new JLabel("Patient ID:");
        JTextField patientIdField = new JTextField();
        JLabel dateLabel = new JLabel("Date (yyyy-mm-dd):");
        JTextField dateField = new JTextField();
        JLabel timeLabel = new JLabel("Time:");
        JTextField timeField = new JTextField();
        JButton scheduleButton = new JButton("Schedule");

        scheduleButton.addActionListener(e -> {
            String patientId = patientIdField.getText();
            Patient patient = pms.findPatient(patientId);
            if (patient != null) {
                Appointment appointment = new Appointment(
                        pms.getAppointments().size() + 1, patient, dateField.getText(), timeField.getText());
                pms.scheduleAppointment(appointment);
                JOptionPane.showMessageDialog(null, "Appointment scheduled successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Patient not found!");
            }
            dialog.dispose();
        });

        dialog.add(patientIdLabel);
        dialog.add(patientIdField);
        dialog.add(dateLabel);
        dialog.add(dateField);
        dialog.add(timeLabel);
        dialog.add(timeField);
        dialog.add(new JLabel());
        dialog.add(scheduleButton);

        dialog.setVisible(true);
    }

    private void showCancelAppointmentDialog() {
        JFrame dialog = new JFrame("Cancel Appointment");
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("Appointment ID:");
        JTextField idField = new JTextField();
        JButton cancelButton = new JButton("Cancel Appointment");

        cancelButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            pms.cancelAppointment(id);
            dialog.dispose();
            JOptionPane.showMessageDialog(null, "Appointment cancelled successfully!");
        });

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel());
        dialog.add(cancelButton);

        dialog.setVisible(true);
    }

    private void switchPanel(JPanel contentPanel, String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }

    // Custom JPanel for background image
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = new ImageIcon(imagePath).getImage();
            } catch (Exception e) {
                System.err.println("Background image not found: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        PatientManagementSystem pms = new PatientManagementSystem();
        new HospitalManagementGUI(pms);
    }
}
