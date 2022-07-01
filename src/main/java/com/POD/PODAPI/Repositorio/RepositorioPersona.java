package com.POD.PODAPI.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.POD.PODAPI.Modelo.Persona;

public interface RepositorioPersona extends JpaRepository<Persona, Long> {;

    
}
