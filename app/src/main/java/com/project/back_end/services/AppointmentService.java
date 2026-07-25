package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("booked");
        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        if (appointment != null) {
            appointment.setStatus("cancelled");
            return appointmentRepository.save(appointment);
        }
        return null;
    }
}
