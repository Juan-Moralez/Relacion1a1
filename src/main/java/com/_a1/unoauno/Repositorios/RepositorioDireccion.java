package com._a1.unoauno.Repositorios;

import com._a1.unoauno.Entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public class RepositorioDireccion {
    public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    }

}
