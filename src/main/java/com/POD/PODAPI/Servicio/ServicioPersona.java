package com.POD.PODAPI.Servicio;

import java.util.*;
import org.springframework.stereotype.Service;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Modelo.Persona;
import com.POD.PODAPI.Repositorio.RepositorioPersona;

@Service
public class ServicioPersona{

    public final RepositorioPersona repositorioPersona;

    public ServicioPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    private Date today = Calendar.getInstance().getTime();
    private Date this_year = new GregorianCalendar((today.getYear() + 1900), today.getMonth(), today.getDay()).getTime();

    public Persona guardarPersona(DTOPersona personaDto) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR, -63);
        c.add(Calendar.DATE, -364);
        Date limiteInferior = c.getTime();
        Calendar e = Calendar.getInstance();
        e.setTime(today);
        e.add(Calendar.YEAR, -18);
        e.add(Calendar.DATE, -364);
        Date limiteSuperior = e.getTime();
        int x = personaDto.getFechaNacimiento().compareTo(limiteInferior);
        int y = personaDto.getFechaNacimiento().compareTo(limiteSuperior);
        if( ( x == 1 ) && ( y == -1 )){
            Persona persona = new Persona(personaDto.getNombre(),personaDto.getPrimerApellido(),personaDto.getSegundoApellido(),personaDto.getFechaNacimiento(),personaDto.getDomicilio());
            persona.edad =  today.getYear() - personaDto.getFechaNacimiento().getYear();
            return repositorioPersona.save(persona);
        }
        return null;
    }

    public Optional<Persona> obtenerPersona(Long idPersona) {
        return repositorioPersona.findById(idPersona);
    }

    public Persona modificarPersona(ServicioPersona servicioPersona, Long id, DTOPersona personaModifical) { 
        try{
            Persona persona=repositorioPersona.findById(id).get();
            Calendar c = Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.YEAR, -63);
            c.add(Calendar.DATE, -364);
            Date limiteInferior = c.getTime();
            Calendar e = Calendar.getInstance();
            e.setTime(today);
            e.add(Calendar.YEAR, -18);
            e.add(Calendar.DATE, -364);
            Date limiteSuperior = e.getTime();
            int x = personaModifical.getFechaNacimiento().compareTo(limiteInferior);
            int y = personaModifical.getFechaNacimiento().compareTo(limiteSuperior);
            if(( x == 1 ) && ( y == -1 )){
                persona.nombre = personaModifical.getNombre();
                persona.primerApellido = personaModifical.getPrimerApellido();
                persona.segundoApellido = personaModifical.getSegundoApellido();
                persona.fechaNacimiento = personaModifical.getFechaNacimiento();
                persona.domicilio = personaModifical.getDomicilio();
                persona.edad =  today.getYear() - personaModifical.getFechaNacimiento().getYear();
                return repositorioPersona.save(persona);
            }
        }catch(Exception e){
            return null;
        }
        return null;  
    }
}
