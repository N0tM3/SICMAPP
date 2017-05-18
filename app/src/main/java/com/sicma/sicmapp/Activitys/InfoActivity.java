package com.sicma.sicmapp.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sicma.sicmapp.R;

/**
 * Created by JoseManuelRS on 18/05/2017.
 */

public class InfoActivity extends AppCompatActivity {
    private ImageView mVSicma;
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
        mVSicma = (ImageView) findViewById(R.id.imglogoSICMA);


        tit.setText(getResources().getString(R.string.titinfo));
        des.setText(getResources().getString(R.string.desinfo));
        cola.setText(getResources().getString(R.string.colaboracion));
        mVSicma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.caminosmadrid.es/wp-content/uploads/2017/05/Folleto_SIC2017_p.pdf")));
            }
        });
    }
}

