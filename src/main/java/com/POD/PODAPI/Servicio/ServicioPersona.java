package com.POD.PODAPI.Servicio;

import java.util.Optional;

import com.POD.PODAPI.Modelo.Persona;

public interface ServicioPersona {
    Persona guardarPersona(Persona persona);

    Optional <Persona> obtenerPersona(Long idPersona);

    Persona modificarPersona(Long id, Persona personaModificar);

    boolean eliminarPersona(Long id);
}
