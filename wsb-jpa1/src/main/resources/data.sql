-- Add addresses
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
                                                                              (1, 'ul. Główna 1', 'mieszkanie 10', 'Warszawa', '00-001'),
                                                                              (2, 'ul. Słoneczna 2', 'mieszkanie 5', 'Kraków', '30-002');

-- Add doctors
INSERT INTO doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number) VALUES
                                                                                                           (1, 'D1234', 'doctor1@example.com', 'Jan', 'Kowalski', 'Cardiology', '123456789'),
                                                                                                           (2, 'D5678', 'doctor2@example.com', 'Anna', 'Nowak', 'Dermatology', '987654321');

-- Add medical treatments
INSERT INTO medical_treatment (id, description, type) VALUES
                                                          (1, 'Consultation', 'General'),
                                                          (2, 'Surgery', 'Specialist');

-- Add patients
INSERT INTO patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, health_score, address_id) VALUES
                                                                                                                                      (1, '1985-06-15', 'patient1@example.com', 'Piotr', 'Wiśniewski', 'P1234', '555123456', 85, 1),
                                                                                                                                      (2, '1990-11-22', 'patient2@example.com', 'Katarzyna', 'Zielinska', 'P5678', '555987654', 90, 2);

-- Add visits
INSERT INTO visit (id, description, time, doctor_id, medical_treatment_id, patient_id) VALUES
                                                                                           (1, 'Regular check-up', '2025-01-05 10:00:00', 1, 1, 1),
                                                                                           (2, 'Skin check', '2025-01-06 11:00:00', 2, 1, 2);
