package com.POD.PODAPI.Servicio;

import java.util.Optional;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Modelo.Persona;

public interface ServicioPersona {
    
    Persona guardarPersona(DTOPersona personaDto);

    Optional <Persona> obtenerPersona(Long idPersona);

    Persona modificarPersona(Long id, DTOPersona personaModificar);
}
