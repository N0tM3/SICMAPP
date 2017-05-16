package com.sicma.sicmapp.Objetos;

/**
 * Created by Eduardo on 10/04/2017.
 */

public class Evento {

    private String fecha, lugar, hora0, dec0, lugar0, hora1, dec1, lugar1, hora2, dec2, lugar2, web;
    private int bg;

    public Evento(String fecha, String lugar, String hora0, String dec0, String lugar0, String hora1, String dec1, String lugar1, String hora2, String dec2, String lugar2, String web, int bg) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.hora0 = hora0;
        this.dec0 = dec0;
        this.lugar0 = lugar0;
        this.hora1 = hora1;
        this.dec1 = dec1;
        this.lugar1 = lugar1;
        this.hora2 = hora2;
        this.dec2 = dec2;
        this.lugar2 = lugar2;
        this.web = web;
        this.bg = bg;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora0() {
        return hora0;
    }

    public void setHora0(String hora0) {
        this.hora0 = hora0;
    }

    public String getDec0() {
        return dec0;
    }

    public void setDec0(String dec0) {
        this.dec0 = dec0;
    }

    public String getLugar0() {
        return lugar0;
    }

    public void setLugar0(String lugar0) {
        this.lugar0 = lugar0;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getDec1() {
        return dec1;
    }

    public void setDec1(String dec1) {
        this.dec1 = dec1;
    }

    public String getLugar1() {
        return lugar1;
    }

    public void setLugar1(String lugar1) {
        this.lugar1 = lugar1;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getDec2() {
        return dec2;
    }

    public void setDec2(String dec2) {
        this.dec2 = dec2;
    }

    public String getLugar2() {
        return lugar2;
    }

    public void setLugar2(String lugar2) {
        this.lugar2 = lugar2;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }
}
