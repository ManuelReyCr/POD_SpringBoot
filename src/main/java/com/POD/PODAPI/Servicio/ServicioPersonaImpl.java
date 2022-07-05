package com.POD.PODAPI.Servicio;

import java.util.*;
import org.springframework.stereotype.Service;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Modelo.Persona;
import com.POD.PODAPI.Repositorio.RepositorioPersona;
import com.POD.PODAPI.Servicio.ServicioPersonaImpl;

@Service
public class ServicioPersonaImpl implements ServicioPersona{

    public final RepositorioPersona repositorioPersona;

    int year = Calendar.getInstance().get(Calendar.YEAR);

    public ServicioPersonaImpl(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    @Override
    public  Persona guardarPersona(DTOPersona personaDto) {
        if(Integer.parseInt(personaDto.getFechaNacimiento())>=(year - 63 ) && Integer.parseInt(personaDto.getFechaNacimiento())<=(year - 18) ){
            Persona persona = new Persona(personaDto.getNombre(),personaDto.getPrimerApellido(),personaDto.getSegundoApellido(),personaDto.getFechaNacimiento(),personaDto.getDomicilio());
            persona.edad = year - Integer.parseInt(personaDto.getFechaNacimiento());
            persona.fechaNacimiento = persona.fechaNacimiento + "/01/01";
            return repositorioPersona.save(persona);
        }
        return null;
    }

    @Override
    public Optional<Persona> obtenerPersona(Long idPersona) {
        return repositorioPersona.findById(idPersona);
    }

    @Override
    public Persona modificarPersona(Long id, DTOPersona personaModifical) {
        Persona persona=repositorioPersona.findById(id).get();
        if(Integer.parseInt(personaModifical.getFechaNacimiento())>=(year - 63) && Integer.parseInt(personaModifical.getFechaNacimiento())<= ( year - 18) ){
            persona.nombre = personaModifical.getNombre();
            persona.primerApellido = personaModifical.getPrimerApellido();
            persona.segundoApellido = personaModifical.getSegundoApellido();
            persona.fechaNacimiento = personaModifical.getFechaNacimiento();
            persona.domicilio = personaModifical.getDomicilio();
            persona.edad = year - Integer.parseInt(personaModifical.getFechaNacimiento());
            persona.fechaNacimiento = persona.fechaNacimiento + "/01/01";
            return repositorioPersona.save(persona);
        }
        return null;  
    }
}
