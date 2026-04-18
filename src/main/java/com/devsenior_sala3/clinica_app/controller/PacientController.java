package com.devsenior_sala3.clinica_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior_sala3.clinica_app.model.Pacient;
import com.devsenior_sala3.clinica_app.service.IPacientService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacients")
public class PacientController {

    private final IPacientService pacientService;

    public PacientController(IPacientService pacientService){
        this.pacientService = pacientService;}


    @GetMapping
    public ResponseEntity <List<Pacient>>listarTodos(){
        try{
            List<Pacient>pacients = pacientService.listarpacients();
            if(pacients.isEmpty()){
                return ResponseEntity.noContent().build(); //204
            }
            return ResponseEntity.ok(pacients); // 200
        
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacient> buscarPorId(@PathVariable Long id){
        try{
            return pacientService.listarPorId(id)
                                 .map(ResponseEntity::ok) // 200
                                 .orElse(ResponseEntity.notFound().build()); //404
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }


    @PostMapping
    public ResponseEntity<String> agregar(@Valid@RequestBody Pacient pacient){
        try {
            pacientService.agregar(pacient);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Paciente agregado Correctamente");  //201
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage()); //400
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al agregar al paciente");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pacient> actualizar(@PathVariable Long id,
                                              @Valid @RequestBody Pacient pacient){
    try{
        Pacient actualizado = pacientService.actualizar(id, pacient);
        if (actualizado== null){
             return ResponseEntity.notFound().build(); //404
            } 
            return ResponseEntity.ok(actualizado); // 200
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity <String> eliminar(@PathVariable Long id){
    try{
        boolean eliminado = pacientService.eliminar(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No se encontro ningún paciente con ese id: "+ id); //404
        }
        return ResponseEntity.ok("Paciente con id: "+ id + " eliminado de forma correcta");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Error al eliminar al paciente"); //500
    }
 }
    


 


}
