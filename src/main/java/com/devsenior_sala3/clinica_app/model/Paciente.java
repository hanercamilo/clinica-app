package com.devsenior_sala3.clinica_app.model;

import jakarta.validation.constraints.NotBlank;

public class Paciente {
@NotBlank(message = ("El campo no puede estar vacio"))
private  String pacientName;
@NotBlank(message = ("El campo no puede estar vacio"))
private  int age;
@NotBlank(message = ("El campo no puede estar vacio"))
private  String information;
private  String date;
public Paciente() {
}
public Paciente(@NotBlank(message = "El campo no puede estar vacio") String pacientName,
        @NotBlank(message = "El campo no puede estar vacio") int age,
        @NotBlank(message = "El campo no puede estar vacio") String information, String date) {
    this.pacientName = pacientName;
    this.age = age;
    this.information = information;
    this.date = date;
}
public String getPacientName() {
    return pacientName;
}
public int getAge() {
    return age;
}
public String getInformation() {
    return information;
}
public String getDate() {
    return date;
}





}
