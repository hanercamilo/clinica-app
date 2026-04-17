package com.devsenior_sala3.clinica_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsenior_sala3.clinica_app.model.Pacient;
import com.devsenior_sala3.clinica_app.repository.PacientRepository;
@Service
public class PacientService implements IPacientService {
    private final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    @Override
    public List<Pacient> listarpacients() {
        return pacientRepository.findAll();

    }

    @Override
    public Optional<Pacient> listarPorId(long id) {
        return pacientRepository.findById(id);
    }

    @Override
    public Pacient agregar(Pacient pacient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public Pacient actualizar(long id, Pacient pacient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Optional<Pacient> listarPorId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorId'");
    }

}
