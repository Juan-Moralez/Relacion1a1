package com._a1.unoauno.Servicios;

import com._a1.unoauno.Entidades.Persona;
import com._a1.unoauno.Repositorios.repositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Servicios {
    @Autowired
    private repositorioPersona repositoriopersona;

    public Persona savePersona(Persona persona) {
        return repositoriopersona.save(persona);
    }

    public Optional<Persona> getPersona(Long id) {
        return repositoriopersona.findById(id);
    }



}
