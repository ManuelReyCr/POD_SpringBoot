package com.POD.PODAPI.Servicio;

import java.net.http.HttpClient;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import com.POD.PODAPI.Modelo.Persona;
import com.POD.PODAPI.Repositorio.RepositorioPersona;
import com.POD.PODAPI.Servicio.ServicioPersonaImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicioPersonaImpl implements ServicioPersona{

    public final RepositorioPersona repositorioPersona;

    public ServicioPersonaImpl(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    @Override
    public  Persona guardarPersona(Persona persona) {
        return repositorioPersona.save(persona);
    }

    @Override
    public Optional<Persona> obtenerPersona(Long idPersona) {
        return repositorioPersona.findById(idPersona);
    }

    @Override
    public Persona modificarPersona(Long id, Persona personaModifical) {
        Persona personaBuscado=repositorioPersona.findById(id).get();
        personaBuscado.setNombre(personaModifical.getNombre());
        personaBuscado.setPrimerApellido(personaModifical.getPrimerApellido());
        personaBuscado.setSegundoApellido(personaModifical.getSegundoApellido());
        personaBuscado.setFechaNacimiento(personaModifical.getFechaNacimiento());
        personaBuscado.setDomicilio(personaModifical.getDomicilio());
       return repositorioPersona.save(personaBuscado);
    }

    @Override
    public boolean eliminarPersona(Long id) {
        try{
            repositorioPersona.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
