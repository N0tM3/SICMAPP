package com.sicma.sicmapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private LatLngBounds MADRID = new LatLngBounds(new LatLng(40.434814, -3.683919400000036), new LatLng(40.434814, -3.683919400000036));
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
        LatLng plazacallao = new LatLng(40.4201134, -3.705888800000025);
        LatLng realcasacorreos = new LatLng(40.416406, -3.7038);
        LatLng residenciaestudiantes = new LatLng(40.440677, -3.687981);
        LatLng ucomplutense = new LatLng(40.447825, -3.728587);
        LatLng upm = new LatLng(40.448637, -3.71928);
        LatLng cinedore = new LatLng(40.411676, -3.699073);

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.marcador1);
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador2);
        BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador3);

        MarkerOptions markerPrado = new MarkerOptions().position(museoprado).title("Eventos en el museo del Prado");
        markerPrado.snippet(getResources().getString(R.string.museoprado));
        markerPrado.icon(icon);
        mMap.addMarker(markerPrado);

        MarkerOptions markerUniCarlos = new MarkerOptions().position(unicarlos).title("Eventos en el salón Agustín Betancourt");
        markerUniCarlos.snippet(getResources().getString(R.string.agustin));
        markerUniCarlos.icon(icon2);
        mMap.addMarker(markerUniCarlos);

        MarkerOptions markerreinasofia = new MarkerOptions().position(reinasofia).title("Eventos en la carpa reina sofia");
        markerreinasofia.snippet(getResources().getString(R.string.reinasofia));
        markerreinasofia.icon(icon3);
        mMap.addMarker(markerreinasofia);

        MarkerOptions markerbellasartes = new MarkerOptions().position(realcasacorreos).title("Eventos en la sala valle-inclán");
        markerbellasartes.snippet(getResources().getString(R.string.bellasartes));
        markerbellasartes.icon(icon2);
        mMap.addMarker(markerbellasartes);

        MarkerOptions markerplazacallao = new MarkerOptions().position(plazacallao).title("Eventos en la plaza callao");
        markerplazacallao.snippet(getResources().getString(R.string.plazacallao));
        markerplazacallao.icon(icon);
        mMap.addMarker(markerplazacallao);

        MarkerOptions markerrealcasa = new MarkerOptions().position(bellasartes).title("Eventos en la Real Casa de correos");
        markerrealcasa.snippet(getResources().getString(R.string.realcasa));
        markerrealcasa.icon(icon2);
        mMap.addMarker(markerrealcasa);

        MarkerOptions markerresestudiantes = new MarkerOptions().position(residenciaestudiantes).title("Eventos en la Residencia de estudiantes");
        markerresestudiantes.snippet(getResources().getString(R.string.residenciaestudiantes));
        markerresestudiantes.icon(icon3);
        mMap.addMarker(markerresestudiantes);

        MarkerOptions markerucomplutense = new MarkerOptions().position(ucomplutense).title("Eventos en la Universidad Complutense");
        markerucomplutense.snippet(getResources().getString(R.string.ucomplutense));
        markerucomplutense.icon(icon);
        mMap.addMarker(markerucomplutense);

        MarkerOptions markerupm = new MarkerOptions().position(upm).title("Eventos en la upm");
        markerupm.snippet(getResources().getString(R.string.upm));
        markerupm.icon(icon2);
        mMap.addMarker(markerupm);

        MarkerOptions markercinedore = new MarkerOptions().position(cinedore).title("Eventos en el cine dore");
        markercinedore.snippet(getResources().getString(R.string.cinedore));
        markercinedore.icon(icon3);
        mMap.addMarker(markercinedore);

        marcadores.add(markerPrado);
        marcadores.add(markerUniCarlos);
        marcadores.add(markerreinasofia);
        marcadores.add(markerbellasartes);
        marcadores.add(markercinedore);
        marcadores.add(markerplazacallao);
        marcadores.add(markerrealcasa);
        marcadores.add(markerresestudiantes);
        marcadores.add(markerucomplutense);
        marcadores.add(markerupm);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 12));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                DetallesEvento.setInfo(marker.getTitle(), marker.getSnippet());
                startActivity(new Intent(MapsActivity.this, DetallesEvento.class));
            }
        });
        /*
        public class UserInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
            LayoutInflater inflater= null;
            Context c;


            UserInfoWindowAdapter(Context ctx, LayoutInflater inflater) {
                this.inflater = inflater;
                this.c = ctx;
            }

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }


            @Override
            public View getInfoContents(final Marker marker) {

                View infoWindows = inflater.inflate(R.layout.user_info_windows, null);
                String imagen = marker.getSnippet();
                ImageView img = (ImageView)infoWindows.findViewById(R.id.imagenEdificio);
                TextView title= (TextView)infoWindows.findViewById(R.id.title);
                title.setText(marker.getTitle());


                Glide.with(this.c).load(imagen).asBitmap().listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        e.printStackTrace();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target,
                                                   boolean isFromMemoryCache, boolean isFirstResource) {
                        if(!isFromMemoryCache) marker.showInfoWindow();
                        return false;
                    }
                }).centerCrop().override(200,170).into(img);

                return (infoWindows);
            }
        }
        */
    }

}