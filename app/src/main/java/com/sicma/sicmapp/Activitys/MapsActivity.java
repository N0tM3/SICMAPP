package com.sicma.sicmapp.Activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.StringLoader;
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
        chargeView();

    }

    /**
     * Method for charging all the view componets
     */
    public void chargeView(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //View Auto Complete EditText
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.searchPlaces);
        autoCompleteTextView.setAdapter(makeArrayAdapterFromPlaces(getPlaces()));

        //Button
        ImageView mSearchButton = (ImageView) findViewById(R.id.mSearchButton);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveCamarera(autoCompleteTextView.getText().toString(),getPlaces());
            }
        });
    }

    /**
     * Method for get the move the camera to de place selected
     * @param title
     * @param mPlaces
     */
    public void moveCamarera(String title, ArrayList<Place> mPlaces){
        for(Place mPlace : mPlaces){
            if(title.equals(mPlace.getTitle().toString())){
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mPlace.getLatPlace(), 20));
            }
        }
    }

    /**
     * method to create a list of places that are in the map
     * @return ArrayList<Places> of the places in the map
     * @return ArrayAdapter<String> of places in the map
     */
    public ArrayAdapter<String> makeArrayAdapterFromPlaces(ArrayList<Place> mPlaces){
        ArrayList<String> mTitles = new ArrayList<>();
        try{
         for (Place mPlace :mPlaces){
             mTitles.add(mPlace.getTitle());
         }
            return new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mTitles);
        }catch (Exception e) {
            return null;
        }
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

    /**
     * Get all the info that will be seen in the map
     * @return ArrayList<Place> with all the maps positions
     */
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

    /**
     * Puts all the marker sin the map that are needed
     * @param googleMap
     */
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
                    }).fitCenter().override(300,200).into(ivImage);
                    return v;
                }
            });
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {

                    for(int i =0;i<mplaces.size();i++){
                        if(marker.getTitle().equals(mplaces.get(i).getTitle())){
                            PlaceDetails.setInfo(marker.getTitle(),mplaces.get(i).getDescripcion(),marker.getSnippet());
                            startActivity(new Intent(MapsActivity.this, PlaceDetails.class));
                        }
                    }


                }
            });
            mMap.addMarker(marker);
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 9));
    }
}