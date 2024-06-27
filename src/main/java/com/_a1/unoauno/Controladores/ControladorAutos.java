package com._a1.unoauno.Controladores;

import com._a1.unoauno.Entidades.Autos;
import com._a1.unoauno.Servicios.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autos")
public class ControladorAutos {

    @Autowired
    private Servicios autoService;

    @PostMapping
    public Autos createAuto(@RequestBody Autos auto) {
        return autoService.saveAutos(auto);
    }

    @GetMapping("/{id}")
    public Optional<Autos> getAuto(@PathVariable Long id) {
        return autoService.getAutos(id);
    }

    @GetMapping
    public List<Autos> getAllAutos() {
        return autoService.getAllAutos();
    }
}

