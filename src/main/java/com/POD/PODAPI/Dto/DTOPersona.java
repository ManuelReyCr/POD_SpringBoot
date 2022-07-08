package com.POD.PODAPI.Dto;

import java.util.Date;

public class DTOPersona {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String domicilio;

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

}
