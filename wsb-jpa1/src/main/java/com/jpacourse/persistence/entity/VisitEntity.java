package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	// One-sided relationship from Visit to Patient
	@ManyToOne(optional = false) // Many-to-One relationship
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient; // Many-to-One relationship

	// One-sided relationship from Visit to Doctor
	@ManyToOne(optional = false) // Many-to-One relationship
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor; // Many-to-One relationship

	// One-to-many relationship from Visit to MedicalTreatment
	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalTreatmentEntity> medicalTreatments = new ArrayList<>(); // One-to-Many relationship


}
