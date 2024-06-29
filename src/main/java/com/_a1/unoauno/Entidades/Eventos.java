package com._a1.unoauno.Entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String Lugar;
    private String fecha;

    @ManyToMany(mappedBy = "eventos")
    @JsonBackReference
    private Set<Persona> personas=new HashSet<>();

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String  fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }
    public void addPersona(Persona persona) {
        this.personas.add(persona);
        persona.getEventos().add(this);
    }

    public void removePersona(Persona persona) {
        this.personas.remove(persona);
        persona.getEventos().remove(this);
    }
}
