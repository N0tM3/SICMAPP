package com.sicma.sicmapp.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sicma.sicmapp.R;

public class DetallesEvento extends AppCompatActivity {
    static String nombre,descripcion,fecha;
    TextView tvnombre, tvdescripcion, tvfechayhora;
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
        tvfechayhora = (TextView) findViewById(R.id.txtfechayhora);
        tvfechayhora.setText(" ");
    }

    /**
     * Charge in the activity all the static string nombre,descripcion,fecha
     */
    public void writeData(){
        tvnombre.setText(nombre);
        tvdescripcion.setText(descripcion);
    }

    /**
     * method to set the info in the CTIVITY
     * @param nombre1
     * @param descripcion1
     */
    public static void setInfo(String nombre1,String descripcion1){
        nombre = nombre1;
        descripcion = descripcion1;
    }
}
