package com.devsenior_sala3.clinica_app.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.devsenior_sala3.clinica_app.model.Pacient;
@Repository
public class PacientRepository {

    public final List<Pacient> pacients = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(4);

    public PacientRepository() {
        pacients.add(new Pacient("Juan", 30, "Paciente con dolor de cabeza", "2023-10-01", 4457));
        pacients.add(new Pacient("Maria", 25, "Paciente con fiebre alta", "2023-10-02", 0112));
        pacients.add(new Pacient("Carlos", 40, "Paciente con dolor abdominal", "2023-10-03", 7894));
       
    }


    public List<Pacient> findAll() {
        return pacients;
    }

    public Optional<Pacient> findById(long id) {
        return pacients.stream()
                       .filter(p -> p.getId() == id)
                       .findFirst();
    }

    public Pacient save(Pacient pacient) {
        long id = contadorId.getAndIncrement();
        pacient.setId(id);
        pacients.add(pacient);
        return pacient;
    }

    public Pacient update(long id, Pacient pacient) {
        Optional<Pacient> existingPacient = findById(id);
        if (existingPacient.isPresent()) {
            Pacient p = existingPacient.get();
            p.setPacientName(pacient.getPacientName());
            p.setAge(pacient.getAge());
            p.setInformation(pacient.getInformation());
            p.setDate(pacient.getDate());
            return p;
        }
        return null;
    }

}



