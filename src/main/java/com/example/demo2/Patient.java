package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class Patient 
{
    private String patientID;
    private String name;
    private int age;
    private String contactInfo;
    private String medicalHistory;
    private List<String> visitRecords;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public Patient(String patientID, String name, int age, String contactInfo, String medicalHistory, int priority)
    {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        this.medicalHistory = medicalHistory;
        this.visitRecords = new ArrayList<>();
        this.priority= priority;
    }
    public String getPatientID() {
        return patientID;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public int getAge() {
        return age;
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public String getName() {
        return name;
    }
    public List<String> getVisitRecords() {
        return visitRecords;
    }
    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
       System.out.println(" contact updated ");
    }
    public void addvisits( String visit){
        this.visitRecords.add(visit);
        System.out.println("visit is added for   "+name +" :"+ visit);
    }
    public void displayPatientInfo() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Medical History: " + medicalHistory);
    
        if (visitRecords.isEmpty()) {
            System.out.println("No visits recorded.");
        } else {
            System.out.println("Visit Records:");
            for (String appointment : visitRecords) {
                System.out.println(appointment);
            }
        }
    }
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Patient ID: ").append(patientID).append("\n");
    sb.append("Name: ").append(name).append("\n");
    sb.append("Age: ").append(age).append("\n");
    sb.append("Contact Info: ").append(contactInfo).append("\n");
    sb.append("Medical History: ").append(medicalHistory).append("\n");
    sb.append("Visit Records: ").append(visitRecords.isEmpty() ? "No visits recorded." : "").append("\n");

    for (String visit : visitRecords) {
        sb.append(visit);
    }

    return sb.toString();
}

    public void addVisit(String visitRecord) {
        visitRecords.add(visitRecord);
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setVisitRecords(List<String> visitRecords) {
        this.visitRecords = visitRecords;
    }
}
