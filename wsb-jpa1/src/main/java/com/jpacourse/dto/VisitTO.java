package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private List<TreatmentTypeTO> treatmentTypes;

    // Gettery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public String getDoctorFirstName() { return doctorFirstName; }
    public void setDoctorFirstName(String doctorFirstName) { this.doctorFirstName = doctorFirstName; }

    public String getDoctorLastName() { return doctorLastName; }
    public void setDoctorLastName(String doctorLastName) { this.doctorLastName = doctorLastName; }

    public List<TreatmentTypeTO> getTreatmentTypes() { return treatmentTypes; }
    public void setTreatmentTypes(List<TreatmentTypeTO> treatmentTypes) { this.treatmentTypes = treatmentTypes; }
}