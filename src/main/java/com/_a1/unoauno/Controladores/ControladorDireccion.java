package com._a1.unoauno.Controladores;


import com._a1.unoauno.Entidades.Direccion;
import com._a1.unoauno.Servicios.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Direccion")
public class ControladorDireccion {

    @Autowired
    private Servicios direccionServicio;

    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion){
        return direccionServicio.saveAutos(direccion);
    }

    @GetMapping("/{id}")
    public Optional<Direccion> getDireccion(@PathVariable Long id){
        return direccionServicio.getDireccion(id);
    }

   @GetMapping
    public List<Direccion> getAllDirecciones(){
        return direccionServicio.getAllDireccion();
   }


}
