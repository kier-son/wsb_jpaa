INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
                                                                              (1, 'ul. Lipowa 10', 'm. 2', 'Warszawa', '00-001'),
                                                                              (2, 'ul. Dębowa 5', NULL, 'Kraków', '30-002'),
                                                                              (3, 'ul. Klonowa 15', 'lok. 101', 'Gdańsk', '80-003'),
                                                                              (4, 'ul. Sosnowa 7', 'm. 12', 'Łódź', '90-004');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
                                                                                                                       (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@przychodnia.pl', 'D001', 'Kardiolog', 1),
                                                                                                                       (2, 'Anna', 'Nowak', '987654321', 'anna.nowak@przychodnia.pl', 'D002', 'Dermatolog', 2);

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id) VALUES
                                                                                                                             (1, 'Piotr', 'Wiśniewski', '555111222', 'piotr.wisniewski@pacjent.pl', 'P001', '1985-03-15', 3),
                                                                                                                             (2, 'Maria', 'Zielińska', '555333444', 'maria.zielinska@pacjent.pl', 'P002', '1992-07-25', 4);
INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES
                                                                     (1, 'Kontrola po operacji serca', '2024-12-01 10:00:00', 1, 1),
                                                                     (2, 'Badanie skóry', '2024-12-01 11:30:00', 2, 2),
                                                                     (3, 'Wizyta kontrolna', '2024-12-02 09:00:00', 1, 2),
                                                                     (4, 'Konsultacja kardiologiczna', '2024-12-02 12:00:00', 1, 1);

INSERT INTO medical_treatment (id, description, type, visit_id) VALUES
                                                                    (1, 'EKG', 'Diagnostyczne', 1),
                                                                    (2, 'Dermatoskopia', 'Diagnostyczne', 2);
