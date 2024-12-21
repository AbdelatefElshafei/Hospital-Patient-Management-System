# Patient Management System
<img width="494" alt="2" src="https://github.com/user-attachments/assets/13bc13b1-cc3c-4a5b-a630-af87333c1809" /> 

The Patient Management System is a Java-based application designed to manage appointments, billing, patient information, and waiting lists efficiently. It provides a user-friendly interface for healthcare facilities to handle their daily operations.

## Table of Contents
- Features
- Getting Started
  - Prerequisites
  - Installation
  - Usage
- User Interface
  - Appointment Management
  - Billing Management
  - Patient Management
  - Waiting List Management
  - Report Generation
- Class Structure
- Data Structures Used
- Design Patterns Used
- Contributing
- License
- Contact

## Features
- **Appointment Management:** Schedule, reschedule, and cancel appointments.
- **Billing Management:** Generate bills, add payments, and check payment statuses.
- **Patient Management:** Add, search, and update patient information.
- **Waiting List Management:** Manage a waiting list for patients based on priority.
- **Report Generation:** Generate detailed reports on patients, appointments, revenue, and billing.
- **User Interface:** A graphical user interface built with JavaFX for ease of use.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- JavaFX: Ensure JavaFX is set up in your development environment.
- An IDE like Eclipse, IntelliJ IDEA, or NetBeans (optional but recommended)

### Installation

Clone the repository:

```bash
git clone https://github.com/AbdelatefElshafei/Hospital-Patient-Management-System.git
```

Navigate to the project directory:

```bash
cd patient-management-system
```

Open the project in your IDE:
- Import the project as a Java project.
- Ensure that JavaFX is properly configured in your IDE.

## Usage

### User Interface
The application features a JavaFX-based graphical user interface (GUI) that allows users to interact with the system through various buttons and text fields. The main functionalities include:

- **Login:** Secure access to the system using a username and password.
  <img width="501" alt="1" src="https://github.com/user-attachments/assets/486b347d-b9d8-409b-9728-2ba0c4802ee2" />
- **Navigation:** Buttons to navigate between different management sections (appointments, billing, patients, reports).

### Appointment Management
<img width="470" alt="3" src="https://github.com/user-attachments/assets/7419a35b-ddd6-4b04-b819-3f9f97a943b9" />

- **Scheduling an Appointment:**

```java
Patient patient = new Patient("PatientID123", "John Doe", 30, "Male");
Appointment appointment = new Appointment(1, patient, "10/15/2023", "10:00");
```

- **Rescheduling an Appointment:**

```java
appointment.reschedule(LocalDate.of(2023, 10, 16), LocalTime.of(11, 0));
```

- **Canceling an Appointment:**

```java
appointment.cancel();
```

### Billing Management
<img width="474" alt="4" src="https://github.com/user-attachments/assets/c8bf7daf-a24d-44c7-8392-f20d3a722069" />

- **Generating a Bill:**

```java
Billing billing = new Billing();
billing.generateBill("PatientID123", 500.00);
```

- **Adding a Payment:**

```java
billing.addPayment("PatientID123", 200.00);
```

- **Checking Payment Status:**

```java
String status = billing.getPaymentStatus("PatientID123");
System.out.println(status);
```

### Patient Management
<img width="456" alt="5" src="https://github.com/user-attachments/assets/269c2b03-822a-4e7c-987c-a0527b6bc52c" />

- **Adding a Patient:**

```java
Patient patient = new Patient("PatientID123", "John Doe", 30, "123-456-7890", "No known allergies", 1);
pa.addPatient(patient);
```

- **Finding a Patient:**

```java
Patient foundPatient = pa.findPatientByID("PatientID123");
```

- **Updating Patient Information:**

```java
foundPatient.updateContactInfo("987-654-3210");
```

### Waiting List Management
<img width="488" alt="7" src="https://github.com/user-attachments/assets/798263b2-dc2e-4b6c-a868-0dafa28e71db" />

- **Adding a Patient to the Waiting List:**

```java
pa.manageWaitingList("add", "PatientID123");
```

- **Removing a Patient from the Waiting List:**

```java
pa.manageWaitingList("remove", "");
```

- **Viewing the Waiting List:**

```java
String waitingList = pa.view();
System.out.println(waitingList);
```

### Report Generation
<img width="502" alt="6" src="https://github.com/user-attachments/assets/42983135-9cab-437b-af74-fe223dfcc66e" />

- **Generating a Patient Report:**

```java
String patientReport = pa.generateReport("patient");
System.out.println(patientReport);
```

- **Generating an Appointment Report:**

```java
String appointmentReport = pa.generateReport("appointment");
System.out.println(appointmentReport);
```

- **Generating a Revenue Report:**

```java
String revenueReport = pa.generateReport("revenue");
System.out.println(revenueReport);
```

- **Generating a Billing Report:**

```java
String billingReport = pa.generateReport("billing");
System.out.println(billingReport);
```

## Class Structure
- **PatientManagementSystem:** Singleton class that integrates all functionalities, including patient, appointment, billing, and waiting list management.
- **ReportGenerator:** Generates reports based on the data provided, including patient, appointment, revenue, and billing reports.
- **Appointment:** Manages appointment details and operations.
- **Billing:** Handles billing operations and maintains payment records.
- **Patient:** Represents patient information and visit records.
- **PatientBST:** Implements a binary search tree for efficient patient data management.
- **WaitingList:** Manages a priority queue for patients waiting for appointments.
- **HelloController:** Manages the JavaFX UI interactions and event handling.
- **HelloApplication:** Main application class for launching the JavaFX interface.

## Data Structures Used
- **Binary Search Tree (BST):** Used in PatientBST to efficiently store and retrieve patient records based on patient ID.
- **Priority Queue:** Implemented in WaitingList to manage patients waiting for appointments, sorted by priority.
- **ArrayList:** Used for managing lists of appointments, billing records, and other collections where dynamic resizing is beneficial.

## Design Patterns Used
- **Singleton Pattern:** Used in PatientManagementSystem to ensure only one instance of the system exists, providing a global point of access.
- **MVC (Model-View-Controller):** The application follows the MVC pattern, with HelloController managing the UI logic, and other classes like Patient, Appointment, and Billing representing the model.

