package com.sicma.sicmapp.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sicma.sicmapp.R;

public class PlaceDetails extends AppCompatActivity {

    static String nombre,descripcion,imgUrl;
    Toolbar tvTitle;
    TextView tvdescripcion;
    ImageView imgImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        cargarVistas();
        writeData();
    }

    /**
     * Charge the view
     */
    private void cargarVistas() {
        imgImagen = (ImageView) findViewById(R.id.ImgPlace);
        tvTitle = (Toolbar) findViewById(R.id.mToolbar);
        tvdescripcion = (TextView) findViewById(R.id.mText);
        /*
        ImageView mButton = (ImageView) findViewById(R.id.mShareImg);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWhith();
            }
        });
        */
    }

    /**
     * Charge in the activity all the static string nombre,descripcion,imgUrl
     */
    public void writeData(){
        tvTitle.setTitle(nombre);
        tvdescripcion.setText(descripcion);
        Glide.with(PlaceDetails.this).load(imgUrl).centerCrop().into(imgImagen);
    }

    /**
     * Method to share with varios plataforms
     */
    public void shareWhith(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,descripcion);
        shareIntent.putExtra(Intent.EXTRA_STREAM,imgUrl);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent,nombre));
    }

    /**
     * method to set the info in the CTIVITY
     * @param nombre1
     * @param descripcion1
     * @param imgUrl1
     */
    public static void setInfo(String nombre1,String descripcion1,String imgUrl1){
        nombre = nombre1;
        descripcion = descripcion1;
        imgUrl = imgUrl1;
    }
}
