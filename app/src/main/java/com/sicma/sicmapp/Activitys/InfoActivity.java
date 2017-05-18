package com.sicma.sicmapp.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sicma.sicmapp.R;

/**
 * Created by JoseManuelRS on 18/05/2017.
 */

public class InfoActivity extends AppCompatActivity {
    private TextView tit, des, cola;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infolayout);
        cargarVistas();

    }

    private void cargarVistas() {
        tit = (TextView) findViewById(R.id.tituloinfo);
        des = (TextView) findViewById(R.id.descipinfo);
        cola = (TextView) findViewById(R.id.colaboraciontexto);
        tit.setText(getResources().getString(R.string.titinfo));
        des.setText(getResources().getString(R.string.desinfo));
        cola.setText(getResources().getString(R.string.colaboracion));
    }
}

