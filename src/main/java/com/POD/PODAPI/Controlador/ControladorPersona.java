package com.POD.PODAPI.Controlador;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Servicio.ServicioPersona;

@RestController
@RequestMapping("/persona")

public class ControladorPersona {

    private final ServicioPersona servicioPersona;

    public ControladorPersona(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }

    @PostMapping
    public ResponseEntity guardarPersona(@RequestBody DTOPersona personaDto){
        return new ResponseEntity<>(servicioPersona.guardarPersona(personaDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/nombre")
    public ResponseEntity obtenerPersona(@PathVariable("id") Long idPersona){
        return new ResponseEntity<>(servicioPersona.obtenerPersona(idPersona), HttpStatus.OK);
    } 

    @PutMapping("/{id}/persona")
    public ResponseEntity modificarPersona(@PathVariable("id") Long idPersona, @RequestBody DTOPersona persona){
        return new ResponseEntity<>(servicioPersona.modificarPersona(idPersona,persona), HttpStatus.OK);
    }
}
