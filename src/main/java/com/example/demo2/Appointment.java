package com.example.demo2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Appointment {
    private int appointmentID;
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
    private String status;

    public Appointment(int appointmentID, String patientId, String date, String time) {
        this.appointmentID = appointmentID;
        this.date = parseDate(date);
        this.time = parseTime(time);
        this.status = "Scheduled";
        System.out.println("Appointment scheduled successfully.");
    }

    public Appointment(int appointmentID, Patient patient, String date, String time) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.date = parseDate(date);
        this.time = parseTime(time);
        this.status = "Scheduled";
        System.out.println("Appointment scheduled successfully.");
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = parseDate(date);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = parseTime(time);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void schedule() {
        setStatus("Scheduled");
    }

    public void cancel() {
        setStatus("Canceled");
    }

    public void reschedule(LocalDate newDate, LocalTime newTime) {
        if (isValidDateTime(newDate, newTime)) {
            this.date = newDate;
            this.time = newTime;
            setStatus("Rescheduled");
        } else {
            System.out.println("Invalid date or time. Please choose another.");
        }
    }

    private boolean isValidDateTime(LocalDate date, LocalTime time) {
        return date != null && time != null && !date.isBefore(LocalDate.now());
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (Exception e) {
            System.out.println("Invalid date format. Expected MM/dd/yyyy.");
            return null;
        }
    }

    private LocalTime parseTime(String time) {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            System.out.println("Invalid time format. Expected HH:mm.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentID +
                "\nPatient: " + (patient != null ? patient.getPatientID() : "N/A") +
                "\nDate: " + (date != null ? date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "N/A") +
                "\nTime: " + (time != null ? time.format(DateTimeFormatter.ofPattern("HH:mm")) : "N/A") +
                "\nStatus: " + status;
    }


    }
