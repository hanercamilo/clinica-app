package com.devsenior_sala3.clinica_app.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.stereotype.Repository;

import com.devsenior_sala3.clinica_app.exception.PacientNotFoundException;
import com.devsenior_sala3.clinica_app.model.Pacient;
@Repository
public class PacientRepository {

    public final List<Pacient> pacients = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(5);

    public PacientRepository() {
        
        pacients.add(new Pacient(1, "Juan", "30", "Paciente con hipertensión", "2023-10-01"));
        pacients.add(new Pacient(2, "María", "25", "Paciente con diabetes tipo 2", "2023-10-02"));
        pacients.add(new Pacient(3, "Carlos", "40", "Paciente con asma", "2023-10-03"));
        pacients.add(new Pacient(4, "Ana", "35", "Paciente con alergias estacionales", "2023-10-04"));
    }

    public List<Pacient> findAll() {
        return pacients;
    }

    public Boolean existsById(Integer patientId) {
        return pacients.stream().anyMatch(p -> p.getPatientId() == patientId);
    }


    

    public Optional<Pacient> findById(Integer patientId) {
        return pacients.stream()
                       .filter(p -> p.getPatientId() == patientId)
                       .findFirst();
    }

    public Pacient save(Pacient patient) {
        patient = new Pacient(contadorId.incrementAndGet(), patient.getPatientName(), patient.getPatientAge(),
                              patient.getPatientInformation(), patient.getDate());
        pacients.add(patient);
        
        return patient;
    }

    public Pacient update(Pacient patient) throws PacientNotFoundException {
        Optional<Pacient> existingPatient = findById(patient.getPatientId());
        if (existingPatient.isPresent()) {
            Pacient p = existingPatient.get();
            p.setPatientName(patient.getPatientName());
            p.setPatientAge(patient.getPatientAge());
            p.setPatientInformation(patient.getPatientInformation());
            p.setDate(patient.getDate());
            return p;
        } else {
            throw new PacientNotFoundException("Paciente con ID " + patient.getPatientId() + " no encontrado.");   
        }
    }

    public boolean deleteById(Integer patientId) {
        return pacients.removeIf(p -> p.getPatientId() == patientId);
    }

}



