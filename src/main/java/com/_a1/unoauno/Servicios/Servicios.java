package com._a1.unoauno.Servicios;

import com._a1.unoauno.Entidades.Autos;
import com._a1.unoauno.Entidades.Direccion;
import com._a1.unoauno.Entidades.Persona;
import com._a1.unoauno.Repositorios.repositorioAutos;
import com._a1.unoauno.Repositorios.repositorioDireccion;
import com._a1.unoauno.Repositorios.repositorioPersona;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Servicios {

    @Autowired
    private repositorioPersona repositorioPersona;

    @Autowired
    private repositorioDireccion repositorioDireccion;

    @Autowired
    private repositorioAutos repositorioAutos;

    public Persona savePersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    public Optional<Persona> getPersona(Long id) {
        return repositorioPersona.findById(id);
    }

    public List<Persona> getAllPersonas() {
        return repositorioPersona.findAll();
    }

    public Direccion saveAutos(Direccion direccion){
        return repositorioDireccion.save(direccion);
    }

    public Optional<Direccion> getDireccion(Long id){
        return repositorioDireccion.findById(id);
    }

    public List<Direccion> getAllDireccion(){
        return repositorioDireccion.findAll();
    }

    public Autos saveAutos(Autos autos){
        return repositorioAutos.save(autos);
    }

    public Optional<Autos> getAutos( long id){
        return repositorioAutos.findById(id);
    }

    public List<Autos> getAllAutos(){
        return repositorioAutos.findAll();
    }

    @PostConstruct
    public void subirdatos() {
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

        Autos autos = new Autos();
        autos.setMarca("Honda");
        autos.setModelo("505");
        autos.setMatricula(123);
        autos.setPersona(persona);

        Autos auto2 = new Autos();
        auto2.setMarca("peugeo");
        auto2.setModelo("424");
        auto2.setMatricula(456);
        auto2.setPersona(persona);


        repositorioPersona.save(persona);
        repositorioDireccion.save(direccion);
        repositorioAutos.save(autos);
        repositorioAutos.save(auto2);
    }


}
