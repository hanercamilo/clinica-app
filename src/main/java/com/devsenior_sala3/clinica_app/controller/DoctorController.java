package com.devsenior_sala3.clinica_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior_sala3.clinica_app.exception.DoctorNotFoundException;
import com.devsenior_sala3.clinica_app.model.Doctor;
import com.devsenior_sala3.clinica_app.service.IDoctorService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctors = doctorService.getAllDoctors();
             if (doctors.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204 — éxito pero sin contenido
            }
            return ResponseEntity.ok(doctors);
            
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId) {
        try {
            return doctorService.getDoctorById(doctorId)
                    .map(ResponseEntity::ok) // si existe → 200 con el doctor
                    .orElse(ResponseEntity.notFound().build()); // si no → 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        try {
            Doctor createdDoctor = doctorService.createDoctor(doctor);
            return ResponseEntity.status(201).body(createdDoctor); // 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long doctorId, @Valid @RequestBody Doctor doctor) {
        try {
            doctor.setDoctorId(doctorId); // Asegurar que el doctor tenga el ID de la ruta
            doctorService.updateDoctor(doctorId, doctor);
            return ResponseEntity.ok("Doctor actualizado correctamente"); // 200 OK
        } catch (DoctorNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage()); // 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId) {
        try {
            boolean eliminado = doctorService.deleteDoctor(doctorId);
            if (!eliminado) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró ningún doctor con id " + doctorId); // 404
            }
            return ResponseEntity.ok("Doctor con id " + doctorId + " eliminado correctamente"); // 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el doctor"); // 500
        }
    }

}