package com._a1.unoauno.Servicios;

import com._a1.unoauno.Entidades.Direccion;
import com._a1.unoauno.Entidades.Persona;
import com._a1.unoauno.Repositorios.repositorioDireccion;
import com._a1.unoauno.Repositorios.repositorioPersona;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Servicios {

    @Autowired
    private repositorioPersona repositorioPersona;

    @Autowired
    private repositorioDireccion repositorioDireccion;

    public Persona savePersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    public Optional<Persona> getPersona(Long id) {
        return repositorioPersona.findById(id);
    }

    @PostConstruct
    public void subirdatos(){
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Moralez");
        persona.setEdad(19);

        Direccion direccion = new Direccion();
        direccion.setCalle("calle");
        direccion.setCiudad("San martin");
        direccion.setProvincia("Mendoza");
        direccion.setCodigoPostal(12345);
        direccion.setPersona(persona);

        persona.setDireccion(direccion);

        repositorioPersona.save(persona);
        repositorioDireccion.save(direccion);
    }
}
