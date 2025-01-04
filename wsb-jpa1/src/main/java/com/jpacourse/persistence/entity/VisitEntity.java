package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;

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

	@ManyToOne(optional = false)
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor; // Jednostronna relacja od strony dziecka (Visit)

	@ManyToOne(optional = false)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient; // Jednostronna relacja od strony dziecka (Visit)

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_treatment_id", nullable = false)
	private MedicalTreatmentEntity medicalTreatment; // Jednostronna relacja od strony rodzica (Visit)

}
