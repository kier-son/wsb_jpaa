package com.jpacourse.persistence.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// One-sided relationship from Patient to Address
	@ManyToOne(optional = false) // Many-to-One relationship
	@JoinColumn(name = "address_id", nullable = false)
	private AddressEntity address; // Many-to-One relationship

	// One-to-many relationship from Patient to Visit
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VisitEntity> visits = new ArrayList<>(); // One-to-Many relationship

	@Column(nullable = false)
	private int age;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VisitEntity> visits;
	@ManyToMany
	@JoinTable(
			name = "PATIENT_TO_ADDRESS",
			joinColumns = @JoinColumn(name = "patient_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "address_id", nullable = false)
	)
	private Set<AddressEntity> addresses;

	public Set<VisitEntity> getVisits() {
		return (Set<VisitEntity>) visits;
	}

	public void setVisits(Set<VisitEntity> visits) {
		this.visits = (List<VisitEntity>) visits;
	}
	public Set<AddressEntity> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressEntity> addresses) {
		this.addresses = addresses;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
