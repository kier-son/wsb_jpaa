package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;

public class TreatmentTypeTO {
    private TreatmentType type;
    private String description;

    // Gettery
    public TreatmentType getType() { return type; }
    public void setType(TreatmentType type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}