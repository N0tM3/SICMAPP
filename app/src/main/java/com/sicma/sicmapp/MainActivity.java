package com.sicma.sicmapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    AccessToNet atn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        atn = new AccessToNet(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chargeView();
    }

    public void chargeView(){
        RelativeLayout rlEvents = (RelativeLayout) findViewById(R.id.rl_eventos);
        rlEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("http://semanaingenieriacaminosmadrid.com/programa/actividades/");
            }
        });
        RelativeLayout rlNew = (RelativeLayout) findViewById(R.id.rl_noticias);
        rlNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewNewsActivity.setAtn(atn);
                Intent chageToRecyclerViewNews = new Intent(MainActivity.this,RecyclerViewNewsActivity.class);
                startActivity(chageToRecyclerViewNews);
            }
        });
        RelativeLayout rlMap = (RelativeLayout) findViewById(R.id.rl_mapa);
        rlMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chageToMapEvente = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(chageToMapEvente);
            }
        });
    }

    /**
     * Open a web page of a specified URL
     *
     * @param url URL to open
     */
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}