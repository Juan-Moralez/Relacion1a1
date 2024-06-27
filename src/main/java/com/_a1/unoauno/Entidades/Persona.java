package com._a1.unoauno.Entidades;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    @JsonManagedReference
    private Direccion direccion;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Autos> autos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Autos> getAutos() {
        return autos;
    }

    public void setAutos(List<Autos> autos) {
        this.autos = autos;
    }

}
