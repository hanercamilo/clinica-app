package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsenior_sala3.clinica_app.model.Doctor;
import com.devsenior_sala3.clinica_app.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long doctorId, Doctor doctor) {
        return doctorRepository.update(doctor);
    }

    @Override
    public boolean deleteDoctor(Long doctorId) {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
            return true;
        }
        return false;
    }
}
