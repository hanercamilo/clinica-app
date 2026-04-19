package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import com.devsenior_sala3.clinica_app.model.Pacient;

public interface IPacientService {
    

List<Pacient>getPatients();
Optional<Pacient>getPatientsById(Integer patientId);
Pacient addPatient(Pacient pacient);
Pacient update(Integer patientId, Pacient patient);
boolean delete(Integer patientId);

}



