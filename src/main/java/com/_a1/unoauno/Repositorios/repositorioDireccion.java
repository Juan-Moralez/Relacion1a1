package com._a1.unoauno.Repositorios;

import com._a1.unoauno.Entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioDireccion extends JpaRepository<Direccion, Long> {


}
