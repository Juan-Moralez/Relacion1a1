package com._a1.unoauno.Repositorios;

import com._a1.unoauno.Entidades.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioEventos extends JpaRepository<Eventos, Long> {

}
