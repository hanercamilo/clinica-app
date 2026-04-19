package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenior_sala3.clinica_app.model.Pacient;
import com.devsenior_sala3.clinica_app.repository.PacientRepository;
@Service
public class PacientService implements IPacientService {
    @Autowired
    private final PacientRepository patientRepository;

    public PacientService(PacientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Pacient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Pacient> getPatientsById(Integer patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public Pacient addPatient(Pacient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Pacient update(Integer patientId,Pacient patient) {
        return patientRepository.update(patient);
    }

    @Override
    public boolean delete(Integer patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
            return true;
        }
        return false;
    }

}
