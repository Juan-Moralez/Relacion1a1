package com._a1.unoauno.Servicios;

import ch.qos.logback.core.net.SyslogOutputStream;
import com._a1.unoauno.Entidades.Autos;
import com._a1.unoauno.Entidades.Direccion;
import com._a1.unoauno.Entidades.Eventos;
import com._a1.unoauno.Entidades.Persona;
import com._a1.unoauno.Repositorios.repositorioAutos;
import com._a1.unoauno.Repositorios.repositorioDireccion;
import com._a1.unoauno.Repositorios.repositorioEventos;
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

    @Autowired
    private repositorioEventos repositorioEventos;

    public Persona savePersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    public Optional<Persona> getPersona(Long id) {
        return repositorioPersona.findById(id);
    }

    public List<Persona> getAllPersonas() {
        return repositorioPersona.findAll();
    }

    public Direccion saveDireccion(Direccion direccion) {
        return repositorioDireccion.save(direccion);
    }

    public Optional<Direccion> getDireccion(Long id) {
        return repositorioDireccion.findById(id);
    }

    public List<Direccion> getAllDireccion() {
        return repositorioDireccion.findAll();
    }

    public Autos saveAutos(Autos autos) {
        return repositorioAutos.save(autos);
    }

    public Optional<Autos> getAutos(Long id) {
        return repositorioAutos.findById(id);
    }

    public List<Autos> getAllAutos() {
        return repositorioAutos.findAll();
    }

    public Eventos saveEventos(Eventos eventos) {
        return repositorioEventos.save(eventos);
    }

    public Optional<Eventos> getEventos(Long id) {
        return repositorioEventos.findById(id);
    }

    public List<Eventos> getAllEventos() {
        return repositorioEventos.findAll();
    }

    @PostConstruct
    public void subirdatos() {
        try {
            Persona persona = new Persona();
            persona.setNombre("Juan");
            persona.setApellido("Moralez");
            persona.setEdad(19);

            Persona persona2 = new Persona();
            persona2.setNombre("Julian");
            persona2.setApellido("Moralez");
            persona2.setEdad(12);

            Direccion direccion = new Direccion();
            direccion.setCalle("calle");
            direccion.setCiudad("San martin");
            direccion.setProvincia("Mendoza");
            direccion.setCodigoPostal(12345);
            direccion.setPersona(persona);
            persona.setDireccion(direccion);

            Direccion direccion2 = new Direccion();
            direccion2.setCalle("otra calle");
            direccion2.setCiudad("San martin");
            direccion2.setProvincia("Mendoza");
            direccion2.setCodigoPostal(12345);
            direccion2.setPersona(persona2);
            persona2.setDireccion(direccion2);

            Autos auto1 = new Autos();
            auto1.setMarca("Honda");
            auto1.setModelo("505");
            auto1.setMatricula(123);
            auto1.setPersona(persona);

            Autos auto2 = new Autos();
            auto2.setMarca("Peugeot");
            auto2.setModelo("424");
            auto2.setMatricula(456);
            auto2.setPersona(persona);

            Autos auto3 = new Autos();
            auto3.setMarca("marca");
            auto3.setModelo("modelo");
            auto3.setMatricula(123);
            auto3.setPersona(persona2);

            Eventos eventos = new Eventos();
            eventos.setNombre("Lolapaloza");
            eventos.setFecha("15/7/2024");
            eventos.setLugar("Chacarita");
            repositorioEventos.save(eventos);

            Eventos eventos2 = new Eventos();
            eventos2.setNombre("Movistar Arena");
            eventos2.setFecha("28/4/2025");
            eventos2.setLugar("Buenos Aires");
            repositorioEventos.save(eventos2);

            persona.addEvento(eventos);
            persona2.addEvento(eventos);
            persona.addEvento(eventos2);
            persona2.addEvento(eventos2);

            repositorioPersona.save(persona);
            repositorioPersona.save(persona2);
            repositorioDireccion.save(direccion);
            repositorioDireccion.save(direccion2);
            repositorioAutos.save(auto1);
            repositorioAutos.save(auto2);
            repositorioAutos.save(auto3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+"No sirve esto");
        }
    }

}
