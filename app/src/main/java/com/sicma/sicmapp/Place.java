package com.sicma.sicmapp;


import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Dani_2 on 08/05/2017.
 */

public class Place {
    LatLng latPlace;
    BitmapDescriptor icon;
    String title, descripcion, urlImage;

    public Place(){};

    public Place(LatLng latPlace, BitmapDescriptor icon, String title, String descripcion, String urlImage) {
        this.latPlace = latPlace;
        this.icon = icon;
        this.title = title;
        this.descripcion = descripcion;
        this.urlImage = urlImage;
    }

    public LatLng getLatPlace() {
        return latPlace;
    }

    public void setLatPlace(LatLng latPlace) {
        this.latPlace = latPlace;
    }

    public BitmapDescriptor getIcon() {
        return icon;
    }

    public void setIcon(BitmapDescriptor icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
