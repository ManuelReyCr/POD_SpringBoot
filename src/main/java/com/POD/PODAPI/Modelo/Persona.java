package com.POD.PODAPI.Modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public Date fechaNacimiento;
    public String domicilio;
    public int edad;

    public Persona(){

    }

    public Persona( String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String domicilio ){
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

    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento){
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
