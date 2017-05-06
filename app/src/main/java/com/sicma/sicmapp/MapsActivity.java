package com.sicma.sicmapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MarginLayoutParamsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLngBounds MADRID = new LatLngBounds(new LatLng(40.4222453, -3.7016385), new LatLng(40.4222453, -3.7016385));
    ArrayList<MarkerOptions> marcadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ponerMarcadores(googleMap);
    }

    public void ponerMarcadores(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng museoprado = new LatLng(40.4137818, -3.6921270999999933);
        LatLng unicarlos = new LatLng(40.3317753, -3.766986299999985);
        LatLng reinasofia = new LatLng(40.4079123, -3.6945568999999523);
        LatLng bellasartes = new LatLng(40.4183042, -3.6965333000000555);

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.marcador1);
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador2);
        BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador3);

        MarkerOptions markerPrado = new MarkerOptions().position(museoprado).title("Eventos en el museo del Prado").snippet("Aqui van los eventos");
        markerPrado.snippet("Descripcion 1");
        markerPrado.icon(icon);
        mMap.addMarker(markerPrado);

        MarkerOptions markerUniCarlos = new MarkerOptions().position(unicarlos).title("Eventos en el salón Agustín Betancourt").snippet(String.valueOf(R.drawable.maplocation));
        markerUniCarlos.snippet("Descripcion 2");
        markerUniCarlos.icon(icon2);
        mMap.addMarker(markerUniCarlos);

        MarkerOptions markerreinasofia = new MarkerOptions().position(reinasofia).title("Eventos en la carpa reina sofia");
        markerreinasofia.snippet("Descripcion 3");
        markerreinasofia.icon(icon3);
        mMap.addMarker(markerreinasofia);

        MarkerOptions markerbellasartes = new MarkerOptions().position(bellasartes).title("Eventos en la sala valle-inclán");
        markerbellasartes.snippet("Descripcion 4");
        markerbellasartes.icon(icon2);
        mMap.addMarker(markerbellasartes);

        marcadores.add(markerPrado);
        marcadores.add(markerUniCarlos);
        marcadores.add(markerreinasofia);
        marcadores.add(markerbellasartes);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 12));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                DetallesEvento.setInfo(marker.getTitle(),marker.getSnippet());
                startActivity(new Intent(MapsActivity.this, DetallesEvento.class));
            }
        });
    }
}