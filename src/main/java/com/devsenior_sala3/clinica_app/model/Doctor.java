package com.devsenior_sala3.clinica_app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Doctor {

    private Long doctorId;

    @NotBlank(message = "Document type is required")
    @Size(min = 2, max = 3, message = "El tipo de documento debe tener entre 2 y 3 caracteres")
    private String documentType;

    @NotBlank(message = "Document number is required")
    @Size(min = 5, max = 20, message = "El número de documento debe tener entre 5 y 20 caracteres")
    private String documentNumber;

    @NotBlank(message = "Doctor name is required")
    @Size(min = 2, max = 50, message = "El nombre del médico debe tener entre 2 y 50 caracteres")
    private String doctorName;

    @NotBlank(message = "Doctor specialty is required")
    @Size(min = 2, max = 50, message = "La especialidad del médico debe tener entre 2 y 50 caracteres")
    private String doctorSpecialty;

    public Doctor() {
    }

    public Doctor(Long doctorId, String documentType, String documentNumber, String doctorName, String doctorSpecialty) {
        this.doctorId = doctorId;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.doctorName = doctorName;
        this.doctorSpecialty = doctorSpecialty;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorSpecialty() {
        return doctorSpecialty;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorSpecialty(String doctorSpecialty) {
        this.doctorSpecialty = doctorSpecialty;
    }
   

}
