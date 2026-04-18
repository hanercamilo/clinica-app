package com.devsenior_sala3.clinica_app.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Pacient {
@NotBlank(message = ("El campo no puede estar vacio"))  
private  String pacientName;
@NotBlank(message = ("El campo no puede estar vacio"))
@Min(value = 0, message = "La edad debe ser mayor o igual a 0")
@Max(value = 100, message = "La edad debe ser menor a 100")
private  int age;
@NotBlank(message = ("El campo no puede estar vacio"))
private  String information;
private  String date;
private long id;
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public Pacient() {
}
public Pacient(@NotBlank(message = "El campo no puede estar vacio") String pacientName,
        @NotBlank(message = "El campo no puede estar vacio") int age,
        @NotBlank(message = "El campo no puede estar vacio") String information, String date, long id) {
    this.pacientName = pacientName;
    this.age = age;
    this.information = information;
    this.date = date;
    this.id = id;
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
public void setPacientName(String pacientName) {
    this.pacientName = pacientName;
}
public void setAge(int age) {
    this.age = age;
}
public void setInformation(String information) {
    this.information = information;
}
public void setDate(String date) {
    this.date = date;
}








}
