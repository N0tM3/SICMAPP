package com.sicma.sicmapp.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sicma.sicmapp.R;

public class DetallesEvento extends AppCompatActivity {
    static String nombre,descripcion,imgUrl;
    TextView tvnombre, tvdescripcion;
    ImageView imgImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_evento);
        cargarVistas();
        writeData();
    }

    /**
     * Charge the view
     */
    private void cargarVistas() {
        imgImagen = (ImageView) findViewById(R.id.imgEvento);
        tvnombre = (TextView) findViewById(R.id.txtnombre);
        tvdescripcion = (TextView) findViewById(R.id.txtdescripcion);
        //TODO:This part has no utility

    }

    /**
     * Charge in the activity all the static string nombre,descripcion,imgUrl
     */
    public void writeData(){
        tvnombre.setText(nombre);
        tvdescripcion.setText(descripcion);
        Glide.with(DetallesEvento.this).load(imgUrl).centerCrop().into(imgImagen);
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