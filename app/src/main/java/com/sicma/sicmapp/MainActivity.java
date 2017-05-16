package com.sicma.sicmapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sicma.sicmapp.Activitys.ActivityEvents;
import com.sicma.sicmapp.Activitys.MapsActivity;
import com.sicma.sicmapp.Activitys.RecyclerViewNewsActivity;
import com.sicma.sicmapp.Transfroms_Adapters.AccessToNet;


public class MainActivity extends AppCompatActivity {

    private RelativeLayout rl_noticias, rl_eventos, rl_mapa;
    private ImageView img_info, img_twitter, img_web;
    private AccessToNet atn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        atn = new AccessToNet(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_eventos = (RelativeLayout) findViewById(R.id.rl_eventos);
        rl_mapa = (RelativeLayout) findViewById(R.id.rl_mapa);
        rl_noticias = (RelativeLayout) findViewById(R.id.rl_noticias);

        img_web = (ImageView) findViewById(R.id.img_web);
        img_info = (ImageView) findViewById(R.id.img_info);

        //EVENTOS ONCLICK
        rl_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity.this, ActivityEvents.class);
                startActivity(i);

            }
        });
        rl_noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerViewNewsActivity.setAtn(atn);
                Intent i= new Intent(MainActivity.this, RecyclerViewNewsActivity.class);
                startActivity(i);
            }
        });
        rl_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chageToMapEvente = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(chageToMapEvente);
            }
        });


        //BUTTONS GREEN
        img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "PRÓXIMAMENTE", Toast.LENGTH_SHORT).show();
            }
        });



        img_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://semanaingenieriacaminosmadrid.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });



    }
}
