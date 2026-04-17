package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import com.devsenior_sala3.clinica_app.model.Doctor;

public interface IDoctorService {
    
    List<Doctor> getAllDoctors();

    Optional<Doctor> getDoctorById(Long id);

    Doctor createDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);
}
