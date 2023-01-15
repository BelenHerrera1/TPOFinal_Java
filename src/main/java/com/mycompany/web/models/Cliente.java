package com.mycompany.web.models;
import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    // , cantVouchers;
    private String nombre,apellido,correo;
    // ,servicio;
    // public double costoTotal;

    public Cliente(){

    }

    public int getId(){
        return id;
    }

    public void setId(int nuevoId){
        this.id = nuevoId;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String nuevoApellido){
        this.apellido = nuevoApellido;
    }

    
    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String nuevoCorreo){
        this.correo = nuevoCorreo;
    }

    // public int getCant(){
    //     return cantVouchers;
    // }

    // public void setCant(int nuevoCant){
    //     this.cantVouchers = nuevoCant;
    // }

    // public String getServicio(){
    //     return servicio;
    // }

    // public void setServicio(String nuevoServicio){
    //     this.servicio = nuevoServicio;
    // }

    // public double getCosto(){
    //     return costoTotal;
    // }

    // public void setCosto(Double nuevoCostoTotal){
    //     this.costoTotal = nuevoCostoTotal;
    // }
}


