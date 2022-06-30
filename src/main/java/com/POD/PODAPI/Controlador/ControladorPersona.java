package com.POD.PODAPI.Controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POD.PODAPI.Modelo.Persona;
import com.POD.PODAPI.Servicio.ServicioPersona;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class ControladorPersona {


    private final ServicioPersona servicioPersona;


    public ControladorPersona(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }


    @PostMapping
    public ResponseEntity guardarPersona(@RequestBody Persona persona){
        if(Integer.parseInt(persona.getFechaNacimiento())>= 1959 && Integer.parseInt(persona.getFechaNacimiento())<= 2004 ){
            persona.setFechaNacimiento( persona.getFechaNacimiento() + "/01/01");
            return new ResponseEntity<>(servicioPersona.guardarPersona(persona), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/{id}/nombre")
    public ResponseEntity obtenerPersona(@PathVariable("id") Long idPersona){
        return new ResponseEntity<>(servicioPersona.obtenerPersona(idPersona), HttpStatus.OK);
    } 

    @PutMapping("/{id}/persona")
    public ResponseEntity modificarPersona(@PathVariable("id") Long idPersona, @RequestBody Persona persona){
        return new ResponseEntity<>(servicioPersona.modificarPersona(idPersona,persona), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPersona(@PathVariable("id") Long idPersona){
        boolean respuesta = servicioPersona.eliminarPersona(idPersona);
        if(respuesta == true){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
