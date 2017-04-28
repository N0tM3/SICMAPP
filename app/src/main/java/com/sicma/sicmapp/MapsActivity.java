package com.sicma.sicmapp;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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
        LatLng museoprado = new LatLng(40.4137818, -3.6921270999999933);
        LatLng unicarlos=new LatLng(40.3317753,-3.766986299999985);
        LatLng reinasofia=new LatLng(40.4079123,-3.6945568999999523);
        LatLng bellasartes=new LatLng(40.4183042,-3.6965333000000555);
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.marcador1);
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador2);
        BitmapDescriptor icon3=BitmapDescriptorFactory.fromResource(R.mipmap.marcador3);
        MarkerOptions markerPrado = new MarkerOptions().position(museoprado).title("Eventos en el museo del Prado").snippet("Aqui van los eventos");
        markerPrado.icon(icon);
        mMap.addMarker(markerPrado);
        MarkerOptions markerUniCarlos = new MarkerOptions().position(unicarlos).title("Eventos en el salón Agustín Betancourt");
        markerUniCarlos.icon(icon2);
        mMap.addMarker(markerUniCarlos);
        MarkerOptions markerreinasofia = new MarkerOptions().position(reinasofia).title("Eventos en la carpa reina sofia");
        markerreinasofia.icon(icon3);
        mMap.addMarker(markerreinasofia);
        MarkerOptions markerbellasartes = new MarkerOptions().position(bellasartes).title("Eventos en la sala valle-inclán");
        markerbellasartes.icon(icon2);
        mMap.addMarker(markerbellasartes);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(museoprado));


    }

}
