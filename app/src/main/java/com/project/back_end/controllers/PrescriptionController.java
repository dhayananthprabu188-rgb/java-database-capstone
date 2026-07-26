package com.project.back_end.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @PostMapping("/{token}")
    public ResponseEntity<Map<String, String>> savePrescription(
            @PathVariable String token,
            @Valid @RequestBody PrescriptionRequest prescriptionRequest) {

        Map<String, String> response = new HashMap<>();

        boolean isTokenValid = token != null && !token.isEmpty();

        if (!isTokenValid) {
            response.put("message", "Invalid or missing token");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.put("message", "Prescription saved successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static class PrescriptionRequest {
        private Long patientId;
        private Long doctorId;
        private Long appointmentId;
        private String medication;
        private String dosage;
        private String notes;

        public Long getPatientId() { return patientId; }
        public void setPatientId(Long patientId) { this.patientId = patientId; }

        public Long getDoctorId() { return doctorId; }
        public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

        public Long getAppointmentId() { return appointmentId; }
        public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

        public String getMedication() { return medication; }
        public void setMedication(String medication) { this.medication = medication; }

        public String getDosage() { return dosage; }
        public void setDosage(String dosage) { this.dosage = dosage; }

        public String getNotes() { return notes; }
        public void setNotes(String notes) { this.notes = notes; }
    }
}
