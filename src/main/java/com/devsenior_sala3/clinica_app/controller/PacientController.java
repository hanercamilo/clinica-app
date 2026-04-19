package com.devsenior_sala3.clinica_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.devsenior_sala3.clinica_app.exception.PacientNotFoundException;
import com.devsenior_sala3.clinica_app.model.Pacient;
import com.devsenior_sala3.clinica_app.service.IPacientService;


import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacients")
public class PacientController {

    private final IPacientService pacientService;

    public PacientController(IPacientService pacientService){
        this.pacientService = pacientService;}


    @GetMapping
    public ResponseEntity <List<Pacient>>getPatients(){
        try{
            List<Pacient>patients = pacientService.getPatients();
            if(patients.isEmpty()){
                return ResponseEntity.noContent().build(); //204
            }
            return ResponseEntity.ok(patients); // 200
        
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Pacient> buscarPorId(@PathVariable Integer patientId){
        try{
            return pacientService.getPatientsById(patientId)
                                 .map(ResponseEntity::ok) // 200
                                 .orElse(ResponseEntity.notFound().build()); //404
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }


    @PostMapping
    public ResponseEntity<String> agregar(@Valid@RequestBody Pacient pacient){
        try {
            pacientService.addPatient(pacient);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Paciente agregado Correctamente");  //201
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage()); //400
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al agregar al paciente");
        }
    }
    
    @PutMapping("/{patientId}")
    public ResponseEntity<String> update(@PathVariable Integer patientId,
                                              @Valid @RequestBody Pacient patient){
    try{
        patient.setPatientId(patientId);
        pacientService.update(patientId,patient);
        return ResponseEntity.ok("Paciente actualizado correctamente"); //200
        } catch(PacientNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage()); //404
        } catch(Exception e){
            return ResponseEntity.status(500).build(); //500
        }
 }

 @DeleteMapping("/{patientId}")
 public ResponseEntity <String> eliminar(@PathVariable Integer patientId){
    try{
        boolean deleted = pacientService.delete(patientId);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No se encontro ningún paciente con ese id: "+ patientId); //404
        }
        return ResponseEntity.ok("Paciente con id: "+ patientId + " eliminado de forma correcta");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Error al eliminar al paciente"); //500
    }
 }
    


 


}
