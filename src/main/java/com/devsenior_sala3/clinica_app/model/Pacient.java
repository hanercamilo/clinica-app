package com.devsenior_sala3.clinica_app.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Pacient {

private Integer patientId;

@NotBlank(message = ("El campo no puede estar vacio"))  
private  String patientName;
@NotBlank(message = ("El campo no puede estar vacio"))
@Min(value = 0, message = "La edad debe ser mayor o igual a 0")
@Max(value = 100, message = "La edad debe ser menor a 100")
private  String patientAge;
@NotBlank(message = ("El campo no puede estar vacio"))
private  String patientInformation;
private  String date;


public Pacient() {
}


public Pacient(Integer patientId, String patientName,String patientAge, String patientInformation, String date) {
    this.patientId = patientId;
    this.patientName = patientName;
    this.patientAge = patientAge;
    this.patientInformation = patientInformation;
    this.date = date;
}


public Integer getPatientId() {
    return patientId;
}


public String getPatientName() {
    return patientName;
}


public String getPatientAge() {
    return patientAge;
}


public String getPatientInformation() {
    return patientInformation;
}


public String getDate() {
    return date;
}


public void setPatientId(Integer patientId) {
    this.patientId = patientId;
}


public void setPatientName(String patientName) {
    this.patientName = patientName;
}


public void setPatientAge(String patientAge) {
    this.patientAge = patientAge;
}


public void setPatientInformation(String patientInformation) {
    this.patientInformation = patientInformation;
}


public void setDate(String date) {
    this.date = date;
}











}
