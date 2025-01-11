package com.jpacourse.dto;

import com.jpacourse.persistence.enums.Specialization;

public class DoctorTO 
{
    private Long id;
    private String firstName;
    private String lastName;
    private Specialization specialization;

    public DoctorTO() 
    {
    }

    public DoctorTO(Long id, String firstName, String lastName, Specialization specialization) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public Specialization getSpecialization() 
    {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) 
    {
        this.specialization = specialization;
    }

    @Override
    public String toString() 
    {
        return "DoctorTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", specialization=" + specialization + '}';
    }
}
