# Schema Design (MySQL)

## Table: patients
- id (INT, PK, AUTO_INCREMENT)
- name (VARCHAR)
- email (VARCHAR, UNIQUE)
- phone (VARCHAR)
- password (VARCHAR)

## Table: doctors
- id (INT, PK, AUTO_INCREMENT)
- name (VARCHAR)
- specialization (VARCHAR)
- email (VARCHAR, UNIQUE)
- available_slots (VARCHAR/TEXT)

## Table: admins
- id (INT, PK, AUTO_INCREMENT)
- username (VARCHAR)
- password (VARCHAR)

## Table: appointments
- id (INT, PK, AUTO_INCREMENT)
- patient_id (INT, FK -> patients.id)
- doctor_id (INT, FK -> doctors.id)
- appointment_date (DATETIME)
- status (VARCHAR: booked/completed/cancelled)
