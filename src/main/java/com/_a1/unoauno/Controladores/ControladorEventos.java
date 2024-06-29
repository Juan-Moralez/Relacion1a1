package com._a1.unoauno.Controladores;

import com._a1.unoauno.Entidades.Eventos;
import com._a1.unoauno.Servicios.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Eventos")
public class ControladorEventos {
    @Autowired
    private Servicios serviciosEventos;

    @PostMapping
    public Eventos createEventos(@RequestBody Eventos eventos){
        return serviciosEventos.saveEventos(eventos);
    }

    @GetMapping("/{id}")
    public Optional<Eventos> getEventos(@PathVariable Long id){
        return serviciosEventos.getEventos(id);
    }

    @GetMapping
    public List<Eventos> getAllEventos(){
        return serviciosEventos.getAllEventos();
    }


}
