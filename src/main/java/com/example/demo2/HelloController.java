package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {

    @FXML
    private TextField Bill;
    @FXML
    private TextField patientID;
    @FXML
    private TextField patientId;
    @FXML
    private TextField Payment;
    @FXML
    private TextField Patien;
    @FXML
    private TextField patienti;
    @FXML
    private TextArea stetus;
    @FXML
    private TextArea Report;
    @FXML
    private TextArea Wait;
    @FXML
    private TextField P;
    @FXML
    private TextField AppIDField;
    @FXML
    private TextField patientIDField;
    @FXML
    private TextField appointmentDateField;
    @FXML
    private TextField appointmentTimeField;
    @FXML
    private ListView<String> appointmentListView;
    @FXML
    private TextField deleteAppointmentField;
    @FXML
    private TextField rescheduleAppointmentIDField;
    @FXML
    private TextField rescheduleDateField;
    @FXML
    private TextField rescheduleTimeField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button waitingListButton;
    @FXML
    private Button appointmentManagementButton;
    @FXML
    private Button billingManagementButton;
    @FXML
    private Button patientManagementButton;
    @FXML
    private Button reportGenerationButton;
    @FXML
    private Button addPatientButton;
    @FXML
    private TextField a, b, c, d, e, f, Search, visit, Cont;
    @FXML
    private TextField searchID, searchIDd, SearchI;
    @FXML
    private Label label, label2;
    @FXML
    private Pane Hidden, Hidden1, Hidden2, Hidden3, Hidden4;
    @FXML
    private Pane H;
    @FXML
    private Pane Ha;
    @FXML
    private Pane Hj;
    @FXML
    private Pane F;
    @FXML
    private Pane FF;
    @FXML
    private Pane FFf;
    @FXML
    private Button findPatientButton, addVisitRecordButton, SearchB, Back, getPatientInfoButton, updateContactInfoButton;
    @FXML
    private TextField cancelAppointmentIDField;
    @FXML
    private Button generateBillButton;
    @FXML
    private Button addPaymentButton;
    @FXML
    private Button getPaymentStatusButton;
    @FXML
    private Pane Wa;
    @FXML
    private Pane W;
    @FXML
    private Pane Wi;

    private static final String VALID_USERNAME = "2";
    private static final String VALID_PASSWORD = "1";

    private PatientManagementSystem pa = PatientManagementSystem.getInstance();
    private Stage stage;
    private Scene scene;

    @FXML
    public void initialize() {

        if (loginButton != null) {
            loginButton.setOnAction(this::handleLogin);
        }
        configureButton(waitingListButton, "/com/example/demo2/Waiting List.fxml");
        configureButton(appointmentManagementButton, "/com/example/demo2/Appointment.fxml");
        configureButton(billingManagementButton, "/com/example/demo2/Payment.fxml");
        configureButton(patientManagementButton, "/com/example/demo2/PM.fxml");
        configureButton(reportGenerationButton, "/com/example/demo2/Report Generator.fxml");
    }

    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            try {
                switchScene(event, "/com/example/demo2/Main.fxml");
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to load main scene.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private void configureButton(Button button, String fxmlPath) {
        if (button == null || fxmlPath == null || getClass().getResource(fxmlPath) == null) return;
        button.setOnMouseClicked(event -> {
            try {
                switchScene(event, fxmlPath);
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to load scene.");
            }
        });
    }

    private void switchScene(Event event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleAddPatientButton(ActionEvent event) {
        Hidden4.setVisible(false);
        Hidden3.setVisible(false);
        Hidden2.setVisible(false);
        Hidden1.setVisible(false);
        Hidden.setVisible(!Hidden.isVisible());
    }

    @FXML
    private void handleAddPatient(ActionEvent event) {
        try {
            String patientID = a.getText();
            String name = b.getText();
            int age = Integer.parseInt(c.getText());
            String contactInfo = d.getText();
            String medicalHistory = e.getText();
            String visitRecord = f.getText();
            int Pry = Integer.parseInt(P.getText());
            Patient patient = new Patient(patientID, name, age, contactInfo, medicalHistory, Pry);
            patient.addVisit(visitRecord);
            pa.addPatient(patient);

            showAlert(Alert.AlertType.CONFIRMATION, "Success", "Patient added successfully!");
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid age. Please enter a number.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while adding the patient.");
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            switchScene(event, "/com/example/demo2/Main.fxml");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load main scene.");
        }
    }

    @FXML
    private void handleFindPatient(ActionEvent event) {
        String id = Search.getText();
        label.setText(pa.findPatient(id));
    }

    @FXML
    private void handleAddButton(ActionEvent event) {
        Hidden4.setVisible(false);
        Hidden3.setVisible(false);
        Hidden1.setVisible(false);
        Hidden.setVisible(false);
        Hidden2.setVisible(!Hidden1.isVisible());
    }

    @FXML
    private void handleGetInfoButton(ActionEvent event) {
        Hidden4.setVisible(false);
        Hidden1.setVisible(false);
        Hidden2.setVisible(false);
        Hidden.setVisible(false);
        Hidden3.setVisible(!Hidden1.isVisible());
    }

    @FXML
    private void handleFindButton(ActionEvent event) {
        Hidden4.setVisible(false);
        Hidden3.setVisible(false);
        Hidden2.setVisible(false);
        Hidden.setVisible(false);
        Hidden1.setVisible(!Hidden1.isVisible());
    }

    @FXML
    private void handleUpdateButton(ActionEvent event) {
        Hidden3.setVisible(false);
        Hidden1.setVisible(false);
        Hidden2.setVisible(false);
        Hidden.setVisible(false);
        Hidden4.setVisible(!Hidden1.isVisible());
    }

    @FXML
    private void handleAddVisit(ActionEvent event) {
        String id = searchID.getText();
        Patient p = pa.findPatientByID(id);
        p.addVisit(", " + visit.getText());
        showAlert(Alert.AlertType.CONFIRMATION, "Success", "visit added successfully!");
    }

    @FXML
    private void handleGetPatientInfo(ActionEvent event) {
        String id = searchIDd.getText();
        Patient p = pa.findPatientByID(id);
        label2.setText(p.toString());
    }

    @FXML
    private void handleUpdateContactInfo(ActionEvent event) {
        String id = SearchI.getText();
        Patient p = pa.findPatientByID(id);
        p.setContactInfo(Cont.getText());
        showAlert(Alert.AlertType.CONFIRMATION, "Success", "visit added successfully!");
    }

    @FXML
    private void handleScheduleAppointment(ActionEvent event) {
        try {
            int appID = Integer.parseInt(AppIDField.getText());
            String patientID = patientIDField.getText();
            String date = appointmentDateField.getText();
            String time = appointmentTimeField.getText();
            Patient patient = pa.findPatientByID(patientID);
            if (patient == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Patient not found.");
                return;
            }

            Appointment appointment = new Appointment(appID, patient, date, time);
            pa.scheduleAppointment(appointment);
            patient.addVisit(appointment.toString());

            showAlert(Alert.AlertType.CONFIRMATION, "Success", "Appointment scheduled successfully.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input or appointment creation failed.");
        }
    }

    @FXML
    private void handleCancelAppointment(ActionEvent event) {
        try {
            int appID = Integer.parseInt(cancelAppointmentIDField.getText());
            pa.cancelAppointment(appID);
            showAlert(Alert.AlertType.CONFIRMATION, "Success", "Appointment canceled successfully.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input or cancellation failed.");
        }
    }

    @FXML
    private void handleRescheduleAppointment(ActionEvent event) {
        try {
            int appID = Integer.parseInt(rescheduleAppointmentIDField.getText());
            String newDate = rescheduleDateField.getText();
            String newTime = rescheduleTimeField.getText();
            pa.rescheduleAppointment(appID, newDate, newTime);
            showAlert(Alert.AlertType.CONFIRMATION, "Success", "Appointment rescheduled successfully.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input or rescheduling failed.");
        }
    }

    @FXML
    private void h1(ActionEvent event) {
        Ha.setVisible(false);
        Hj.setVisible(false);
        H.setVisible(!H.isVisible());
    }

    @FXML
    private void h2(ActionEvent event) {
        H.setVisible(false);
        Hj.setVisible(false);
        Ha.setVisible(!Ha.isVisible());
    }

    @FXML
    private void h3(ActionEvent event) {
        Ha.setVisible(false);
        H.setVisible(false);
        Hj.setVisible(!Hj.isVisible());
    }

    @FXML
    private void F(ActionEvent event) {
        FF.setVisible(false);
        FFf.setVisible(false);
        F.setVisible(!F.isVisible());
    }

    @FXML
    private void FF(ActionEvent event) {
        F.setVisible(false);
        FFf.setVisible(false);
        FF.setVisible(!FF.isVisible());
    }

    @FXML
    private void FFF(ActionEvent event) {
        FF.setVisible(false);
        F.setVisible(false);
        FFf.setVisible(!FFf.isVisible());
    }

    @FXML
    private void onGenerateBillClick(ActionEvent event) {
        String PID = patientID.getText();
        double billAmount = Double.parseDouble(Bill.getText());
        pa.generateBillForPatient(PID, billAmount);
        showAlert(Alert.AlertType.INFORMATION, "Generated", "A Bill of " + billAmount + " has been added ");
    }

    @FXML
    private void onAddPaymentClick(ActionEvent event) {
        String PID = patientId.getText();
        double paymentAmount = Double.parseDouble(Payment.getText());
        pa.addPaymentForPatient(PID, paymentAmount);
        showAlert(Alert.AlertType.INFORMATION, "Generated", "A Payment of " + paymentAmount + " has been added ");
    }

    @FXML
    private void onGetPaymentStatusClick(ActionEvent event) {
        String pID = patienti.getText();
        pa.getPaymentStatusForPatient(pID);
        stetus.setText(pa.getPaymentStatusForPatient(pID));
    }

    @FXML
    private void OnPatientReport(ActionEvent event) {
        Report.setText(pa.generateReport("patient"));
    }

    @FXML
    private void OnAppointmentReport(ActionEvent event) {
        Report.setText(pa.generateReport("appointment"));
    }

    @FXML
    private void OnreReport(ActionEvent event) {
        Report.setText(pa.generateReport("revenue"));
    }

    @FXML
    private void OnBillingsReport(ActionEvent event) {
        Report.setText(pa.generateReport("billing"));
    }
    @FXML
    private void ADD(ActionEvent event){
        Wa.setVisible(false);
        Wi.setVisible(false);
        W.setVisible(!W.isVisible());
    }
    @FXML
    private void Remove(ActionEvent event){
        Wa.setVisible(false);
        W.setVisible(false);
        Wi.setVisible(!Wi.isVisible());
    }
    @FXML
    private void View(ActionEvent event){
        Wi.setVisible(false);
        W.setVisible(false);
        Wa.setVisible(!Wa.isVisible());
        Wait.setText(pa.view());
    }
    @FXML
    private void ADDPa(ActionEvent event){
        pa.manageWaitingList("add",Patien.getText());
        showAlert(Alert.AlertType.INFORMATION, "Generated", "Patient Added....!");
    }
    @FXML
    private void Rem(ActionEvent event){
        pa.manageWaitingList("remove","");
        showAlert(Alert.AlertType.INFORMATION, "Generated", "Patient Added....!");
    }

}

