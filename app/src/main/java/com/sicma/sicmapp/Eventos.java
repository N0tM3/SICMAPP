package com.sicma.sicmapp;

import java.io.Serializable;


public class Eventos implements Serializable {
    private String nombre;
    private String hora;
    private String direccion;
    private String latitud;
    private String longitud;
    private String web;
    private String descripcion;

    public Eventos(String nombre, String hora, String direccion, String latitud, String longitud, String web, String descripcion) {
        this.nombre = nombre;
        this.hora = hora;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.web = web;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
