package com.devsenior_sala3.clinica_app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.devsenior_sala3.clinica_app.model.Doctor;

@Repository
public class DoctorRepository {

    private final List<Doctor> doctors = new ArrayList<>();

    private final AtomicLong idGenerator = new AtomicLong(5);

    public DoctorRepository() {
        doctors.add(new Doctor(1L, "CC", "1118888954", "Dr. Juan Pérez", "Cardiología"));
        doctors.add(new Doctor(2L, "CC", "1118888955", "Dra. María Gómez", "Pediatría"));
        doctors.add(new Doctor(3L, "CC", "1118888956", "Dr. Carlos Rodríguez", "Dermatología"));
        doctors.add(new Doctor(4L, "CC", "1118888957", "Dra. Ana Martínez", "Ginecología"));
        doctors.add(new Doctor(5L, "CE", "1118888958", "Dr. Luis Fernández", "Neurología"));
    }

    public List<Doctor> findAll() {
        return doctors;
    }

    public Optional<Doctor> findById(Long id) {
        return doctors.stream().filter(d -> d.getDoctorId().equals(id)).findFirst();
    }

    public boolean existsById(Long id) {
        return doctors.stream().anyMatch(d -> d.getDoctorId().equals(id));
    }

    public Doctor save(Doctor doctor) {
        doctor = new Doctor(idGenerator.incrementAndGet(), doctor.getDocumentType(), doctor.getDocumentNumber(),
                doctor.getDoctorName(), doctor.getDoctorSpecialty());
        doctors.add(doctor);

        return doctor;
    }

    public Doctor update(Doctor doctor) {
        Optional<Doctor> existingDoctorOpt = findById(doctor.getDoctorId());
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();
            existingDoctor.setDocumentType(doctor.getDocumentType());
            existingDoctor.setDocumentNumber(doctor.getDocumentNumber());
            existingDoctor.setDoctorName(doctor.getDoctorName());
            existingDoctor.setDoctorSpecialty(doctor.getDoctorSpecialty());
            return existingDoctor;
        }
        return null;
    }

    public boolean deleteById(Long id) {
        return doctors.removeIf(d -> d.getDoctorId().equals(id));
    }

}
