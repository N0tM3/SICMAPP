package com.sicma.sicmapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetallesEvento extends AppCompatActivity {

    TextView nombre, descripcion, fechayhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_evento);
        cargarVistas();

    }

    private void cargarVistas() {
        nombre = (TextView) findViewById(R.id.txtnombre);
        descripcion = (TextView) findViewById(R.id.txtdescripcion);
        fechayhora = (TextView) findViewById(R.id.txtfechayhora);
        String nombreevento = getIntent().getExtras().getString("nombre");
        nombre.setText(nombreevento);


    }
}
