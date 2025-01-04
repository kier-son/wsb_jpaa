-- Add addresses
INSERT INTO address (address_line1, address_line2, city, postal_code) VALUES
                                                                          ('ul. Główna 1', 'mieszkanie 10', 'Warszawa', '00-001'),
                                                                          ('ul. Słoneczna 2', 'mieszkanie 5', 'Kraków', '30-002');

-- Add doctors
INSERT INTO doctor (doctor_number, email, first_name, last_name, specialization, telephone_number) VALUES
                                                                                                       ('D1234', 'doctor1@example.com', 'Jan', 'Kowalski', 'Cardiology', '123456789'),
                                                                                                       ('D5678', 'doctor2@example.com', 'Anna', 'Nowak', 'Dermatology', '987654321');

-- Add medical treatments
INSERT INTO medical_treatment (description, type) VALUES
                                                      ('Consultation', 'General'),
                                                      ('Surgery', 'Specialist');

-- Add patients
INSERT INTO patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id) VALUES
                                                                                                                    ('1985-06-15', 'patient1@example.com', 'Piotr', 'Wiśniewski', 'P1234', '555123456', 1),
                                                                                                                    ('1990-11-22', 'patient2@example.com', 'Katarzyna', 'Zielinska', 'P5678', '555987654', 2);

-- Add visits
INSERT INTO visit (description, time, doctor_id, medical_treatment_id, patient_id) VALUES
                                                                                       ('Regular check-up', '2025-01-05 10:00:00', 1, 1, 1),
                                                                                       ('Skin check', '2025-01-06 11:00:00', 2, 1, 2);