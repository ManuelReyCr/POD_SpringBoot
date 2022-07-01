package com.POD.PODAPI.Modelo;

import javax.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String nombre;
    @Column(nullable = false)
    public String primerApellido;
    @Column(nullable = false)
    public String segundoApellido;
    @Column(nullable = false)
    public String fechaNacimiento;
    @Column(nullable = false)
    public String domicilio;
    public int edad;

    public Persona(){

    }

    public Persona( String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, String domicilio ){
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
        this.fechaNacimiento=fechaNacimiento;
        this.domicilio=domicilio;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPrimerApellido(){
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido(){
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio(){
        return domicilio;
    }

    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

}
