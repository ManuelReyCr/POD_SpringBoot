package com.POD.PODAPI.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.POD.PODAPI.Modelo.Persona;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {


    
}