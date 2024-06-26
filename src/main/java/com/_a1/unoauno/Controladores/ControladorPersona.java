package com._a1.unoauno.Controladores;
import com._a1.unoauno.Entidades.Direccion;
import com._a1.unoauno.Servicios.Servicios;
import com._a1.unoauno.Entidades.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class ControladorPersona {
    @Autowired
    private Servicios personaService;

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.savePersona(persona);
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersona(@PathVariable Long id) {
        return personaService.getPersona(id);
    }

    @PostMapping("/with-address")
    public Persona createPersonaWithAddress(@RequestBody Persona persona, @RequestBody Direccion direccion) {
        direccion.setPersona(persona);
        persona.setDireccion(direccion);
        return personaService.savePersona(persona);
    }

}
