package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import com.devsenior_sala3.clinica_app.model.Pacient;

public interface IPacientService {

List<Pacient>listarpacients();
Optional<Pacient>listarPorId();
Pacient agregar(Pacient pacient);
Pacient actualizar(long id, Pacient pacient);
boolean eliminar(long id);
Optional<Pacient> listarPorId(long id);

}
