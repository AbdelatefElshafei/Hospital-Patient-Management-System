package com.example.demo2;

import java.util.LinkedList;
import java.util.*;

class AppointmentQueue {
    private Queue<Appointment> queue = new LinkedList<>();

    public void addAppointment(Appointment appointment) {
        queue.offer(appointment);
    }

    public Appointment processNextAppointment() {
        return queue.poll();
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(queue);
    }
}
