package com.sicma.sicmapp.Activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sicma.sicmapp.*;
import com.sicma.sicmapp.Objetos.Place;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLngBounds MADRID = new LatLngBounds(new LatLng(40.434814, -3.683919400000036), new LatLng(40.434814, -3.683919400000036));
    ArrayList<Place> mplaces;




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

    public ArrayList<Place> getPlaces(){
        ArrayList<Place> mplaces = new ArrayList<>();
        //--
        //Jornadas y conferencias
        //--
        mplaces.add(new Place(new LatLng(40.4137818, -3.6921270999999933),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titMuseoprado),getResources().getString(R.string.desMuseoprado),getResources().getString(R.string.imgMuseoprado)));
        mplaces.add(new Place(new LatLng(40.4201134, -3.705888800000025),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titCallao),getResources().getString(R.string.desCallao),getResources().getString(R.string.imgCallao)));
        mplaces.add(new Place(new LatLng(40.4319696, -3.691550799999959),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titAgustin),getResources().getString(R.string.desAgustin),getResources().getString(R.string.imgAgustin)));
        mplaces.add(new Place(new LatLng(40.416406, -3.7038),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titRealCasaCorreos),getResources().getString(R.string.desRealCasaCorreos),getResources().getString(R.string.imgRealCasaCorreos)));
        mplaces.add(new Place(new LatLng(40.4183042, -3.6965333000000555),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titBellasArtes),getResources().getString(R.string.descBellasArtes),getResources().getString(R.string.imgBellasArtes)));
        mplaces.add(new Place(new LatLng(40.440677, -3.687981),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titResidenciaEstudiantes),getResources().getString(R.string.desResidenciaEstudiantes),getResources().getString(R.string.imgResidenciaEstudiantes)));
        mplaces.add(new Place(new LatLng(40.447825, -3.728587),BitmapDescriptorFactory.fromResource(R.mipmap.marcador3),getResources().getString(R.string.titCienciasExactasComplutense),getResources().getString(R.string.desCienciasExactasComplutense),getResources().getString(R.string.imgCienciasExtractasComplutense)));

        //--
        //Actividades
        //--
        mplaces.add(new Place(new LatLng(40.448637, -3.71928),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titUPM),getResources().getString(R.string.desUPM),getResources().getString(R.string.imgUPM)));
        mplaces.add(new Place(new LatLng(40.4079123, -3.6945568999999523),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titCarpaReinaSofia),getResources().getString(R.string.desCarpaReinaSofia),getResources().getString(R.string.imgCarpaReinaSofia)));
        mplaces.add(new Place(new LatLng(40.411676, -3.699073),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titCineDore),getResources().getString(R.string.desCineDore),getResources().getString(R.string.imgCineDore)));
        mplaces.add(new Place(new LatLng(40.417066,-3.712296),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titFundacionAlbeniz),getResources().getString(R.string.descFundacionAlbeniz),getResources().getString(R.string.imgFundacionAlbeniz)));
        mplaces.add(new Place(new LatLng(40.439124,-3.7008069999999407),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titCICCP),getResources().getString(R.string.titCICCP),getResources().getString(R.string.imgCICCP)));
        mplaces.add(new Place(new LatLng(40.439124,-3.7008069999999407),BitmapDescriptorFactory.fromResource(R.mipmap.marcador2),getResources().getString(R.string.titDespositoCanalPCastilla),getResources().getString(R.string.desDespositoCanalPCastilla),getResources().getString(R.string.imgDespositoCanalPCastilla)));

        //--
        //MUESTRA “ICONOS POR MADRID DE LA INGENIERÍA DE CAMINOS”
        //--
        mplaces.add(new Place(new LatLng(40.4201134, -3.705888800000025),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titAereoPlazaCallao),getResources().getString(R.string.despAereoPlazaCallao),getResources().getString(R.string.imgAereoPlazaCallao)));
        mplaces.add(new Place(new LatLng(40.42472046352701,-3.6892632999999933),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titCompuertaCanalPan),getResources().getString(R.string.desCompuertaCanalPan),getResources().getString(R.string.imgCompuertaCanalPan)));
        mplaces.add(new Place(new LatLng(40.40969641351984,-3.6903641999999763),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titBoyaOleaje),getResources().getString(R.string.desBoyaOleaje),getResources().getString(R.string.imgBoyaOleaje)));
        mplaces.add(new Place(new LatLng(40.4070519,-3.6913500000000568),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titRozadora),getResources().getString(R.string.desRozadora),getResources().getString(R.string.imgRozadora)));

        //--
        //VISITAS
        //--
        mplaces.add(new Place(new LatLng(40.3929345,-3.7049173000000337),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titCEDEX),getResources().getString(R.string.desCEDEX),getResources().getString(R.string.imgCEDEX)));
        mplaces.add(new Place(new LatLng(40.3897726,-3.6452193999999736),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titALtoReal),getResources().getString(R.string.desAltoReal),getResources().getString(R.string.imgAltoReal)));
        mplaces.add(new Place(new LatLng(40.419765,-3.7487290000000257),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titTeleferico),getResources().getString(R.string.desTeleferico),getResources().getString(R.string.imgTeleferico)));
        mplaces.add(new Place(new LatLng(40.4723136,-3.6717512999999826),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titEduardoTorroja),getResources().getString(R.string.desEduardoTorroja),getResources().getString(R.string.imgEduardoTorroja)));
        mplaces.add(new Place(new LatLng(40.437304,-3.7216728999999305),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titFaroMoncloa),getResources().getString(R.string.desFaroMoncloa),getResources().getString(R.string.imgFaroMoncloa)));
        mplaces.add(new Place(new LatLng(40.3559,-3.622690000000034),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titTormentas),getResources().getString(R.string.descTormentas),getResources().getString(R.string.imgTormentas)));
        mplaces.add(new Place(new LatLng(40.4791118,-3.686590199999955),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titPaseoCastellas),getResources().getString(R.string.desPaseoCastellas),getResources().getString(R.string.imgPaseoCastellas)));
        mplaces.add(new Place(new LatLng(40.0364203,-3.608865499999979),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titAranjuez),getResources().getString(R.string.desAranjuez),getResources().getString(R.string.imgAranjuez)));
        mplaces.add(new Place(new LatLng(40.4070519,-3.6913500000000568),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titAtocha),getResources().getString(R.string.desAtocha),getResources().getString(R.string.imgAtocha)));
        mplaces.add(new Place(new LatLng(40.4361737,-3.599310599999967),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titWada),getResources().getString(R.string.desWada),getResources().getString(R.string.imgWada)));
        mplaces.add(new Place(new LatLng(40.4685005,-3.757951999999932),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titZarzuela),getResources().getString(R.string.desZarzuela),getResources().getString(R.string.imgZarzuela)));
        mplaces.add(new Place(new LatLng(40.3980331,-3.710934599999973),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titMadridRio),getResources().getString(R.string.desMadridRio),getResources().getString(R.string.imgMadridRio)));
        mplaces.add(new Place(new LatLng(40.4759299,-3.6836779000000206),BitmapDescriptorFactory.fromResource(R.mipmap.marcador1),getResources().getString(R.string.titEMT),getResources().getString(R.string.desEMT),getResources().getString(R.string.imgEMT)));
        return mplaces;
    }

    public void ponerMarcadores(GoogleMap googleMap){
        mMap = googleMap;
        mplaces = getPlaces();
        for (int i = 0;i < mplaces.size();i++){
            MarkerOptions marker = new MarkerOptions().position(mplaces.get(i).getLatPlace())
                    .title(mplaces.get(i).getTitle());
            marker.snippet(mplaces.get(i).getUrlImage());
            marker.icon(mplaces.get(i).getIcon());
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(final Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window_layout, null);
                    TextView txtTitle = (TextView) v.findViewById(R.id.tv_lat);
                    ImageView ivImage = (ImageView) v.findViewById(R.id.tv_lng);
                    txtTitle.setText(marker.getTitle());

                    //Code from https://github.com/migueloxx/OpenHouseMadrid/blob/master/app/src/main/java/com/example/miguel/openhousemadrid/UserInfoWindowAdapter.java
                    //line 46
                    Glide.with(v.getContext()).load(marker.getSnippet()).asBitmap().listener(new RequestListener<String, Bitmap>() {
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
                    }).centerCrop().override(300,200).into(ivImage);
                    return v;
                }
            });
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                    for(int i =0;i<mplaces.size();i++){
                        if(marker.getTitle().equals(mplaces.get(i).getTitle())){
                            DetallesEvento.setInfo(marker.getTitle(),mplaces.get(i).getDescripcion(),marker.getSnippet());
                            startActivity(new Intent(MapsActivity.this, DetallesEvento.class));
                        }
                    }


                }
            });
            mMap.addMarker(marker);
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 12));
    }
    /**
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

        LatLng albeniz=new LatLng(40.417066,-3.712296);
        LatLng plazacastilla=new LatLng(40.465536,-3.688597);
        LatLng canalisabel=new LatLng(40.439124,-3.7008069999999407);
        LatLng cedex=new LatLng(40.3929345,-3.7049173000000337);


        LatLng altoarenal=new LatLng(40.3897726,-3.6452193999999736);
        LatLng telefe=new LatLng(40.419765,-3.7487290000000257);
        LatLng eduardotorr=new LatLng(40.4723136,-3.6717512999999826);
        LatLng faromoncloa=new LatLng(40.437304,-3.7216728999999305);

        LatLng tormentas=new LatLng(40.3559,-3.622690000000034);
        LatLng paseocastellana=new LatLng(40.4791118,-3.686590199999955);
        LatLng aranjuez=new LatLng(40.0364203,-3.608865499999979);
        LatLng atocha=new LatLng(40.4070519,-3.6913500000000568);
        LatLng wanda=new LatLng(40.4361737,-3.599310599999967);

        LatLng hipodromozarzuela=new LatLng(40.4685005,-3.757951999999932);
        LatLng madridrio=new LatLng(40.3980331,-3.710934599999973);
        LatLng emt=new LatLng(40.4759299,-3.6836779000000206);

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.marcador1);
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador2);
        BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.mipmap.marcador3);


        MarkerOptions markerPrado = new MarkerOptions().position(museoprado).title("Eventos en el museo del Prado");
       // markerPrado.snippet(getResources().getString(R.string.museoprado));
        markerPrado.snippet("http://imagenpng.com/wp-content/uploads/2015/08/google-homero.jpg");
        markerPrado.icon(icon);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window_layout, null);
                TextView txtTitle = (TextView) v.findViewById(R.id.tv_lat);
                ImageView ivImage = (ImageView) v.findViewById(R.id.tv_lng);
                txtTitle.setText(marker.getTitle());
                ivImage.setScaleType(ImageView.ScaleType.CENTER);
                ivImage.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
                    return v;
            }
        });
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
    }
*/
}