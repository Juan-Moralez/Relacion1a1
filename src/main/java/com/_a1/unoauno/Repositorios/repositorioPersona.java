package com._a1.unoauno.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com._a1.unoauno.Entidades.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioPersona extends JpaRepository<Persona, Long> {

}
