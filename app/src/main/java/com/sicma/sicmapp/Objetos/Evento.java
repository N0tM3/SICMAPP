package com.sicma.sicmapp.Objetos;

import android.graphics.drawable.Drawable;

/**
 * Created by Eduardo on 10/04/2017.
 */

public class Evento {

    private String titulo, direccion, descripcion, latitud_x, longitud_y, fecha, hora, web, precio;
    private int img;

    public Evento() {
    }

    public Evento(String titulo, String direccion, String descripcion, String latitud_x, String longitud_y, String fecha, String hora, String web, String precio, int img) {
        this.titulo = titulo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.latitud_x = latitud_x;
        this.longitud_y = longitud_y;
        this.fecha = fecha;
        this.hora = hora;
        this.web = web;
        this.precio = precio;
        this.img = img;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud_x() {
        return latitud_x;
    }

    public void setLatitud_x(String latitud_x) {
        this.latitud_x = latitud_x;
    }

    public String getLongitud_y() {
        return longitud_y;
    }

    public void setLongitud_y(String longitud_y) {
        this.longitud_y = longitud_y;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
