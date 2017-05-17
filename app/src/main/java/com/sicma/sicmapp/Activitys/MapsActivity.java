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
        //VISITAS
        //--
        mplaces.add(new Place(new LatLng(40.4659672,-3.689901700000064),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titpiezacicloagua),getResources().getString(R.string.d1),getResources().getString(R.string.imgpieza)));
        mplaces.add(new Place(new LatLng(40.4530541,-3.688344499999971),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titcabezatuneladora),getResources().getString(R.string.d2),getResources().getString(R.string.imgcabezatuneladora)));
        mplaces.add(new Place(new LatLng(40.4324205,-3.6972862999999734),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titcompactadora),getResources().getString(R.string.d3),getResources().getString(R.string.imgcompactadora)));
        mplaces.add(new Place(new LatLng(40.4248641,-3.6891348000000335),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titcompuertacanal),getResources().getString(R.string.desCompuertaCanalPan),getResources().getString(R.string.imgcompuerta)));
        mplaces.add(new Place(new LatLng(40.4201134,-3.705888800000025),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titaerogenerador),getResources().getString(R.string.despAereoPlazaCallao),getResources().getString(R.string.imgaerogenerador)));
        mplaces.add(new Place(new LatLng(40.419992,-3.6887369999999464),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.tittopopuertaalcala),getResources().getString(R.string.d4),getResources().getString(R.string.imgtopo)));
        mplaces.add(new Place(new LatLng(40.4096964,-3.6903641999999763),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titboya),getResources().getString(R.string.desBoyaOleaje),getResources().getString(R.string.imgboya)));
        mplaces.add(new Place(new LatLng(40.4079123,-3.6945568999999523),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.tittramovias),getResources().getString(R.string.desEMT),getResources().getString(R.string.imgtramo)));
        mplaces.add(new Place(new LatLng(40.4070519,-3.6913500000000568),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titAtocha),getResources().getString(R.string.desAtocha),getResources().getString(R.string.imgAtocha)));
        mplaces.add(new Place(new LatLng(40.3911506,-3.6951195000000325),BitmapDescriptorFactory.fromResource(R.mipmap.punterosicmadef),getResources().getString(R.string.titcubipodo),getResources().getString(R.string.d6),getResources().getString(R.string.imgcubipodo)));
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
                    }).fitCenter().override(500,500).into(ivImage);
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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 12));
    }
}