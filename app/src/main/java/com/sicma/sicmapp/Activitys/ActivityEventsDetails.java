package com.sicma.sicmapp.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sicma.sicmapp.R;

/**
 * Created by Eduardo on 13/05/2017.
 */

public class ActivityEventsDetails extends AppCompatActivity {
    private RelativeLayout bg;
    private TextView fecha, h0, desc0, lugar0,h1, desc1, lugar1,h2, desc2, lugar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_events);

        Intent i = getIntent();

        bg = (RelativeLayout) findViewById(R.id.rl_detail_bg);
        bg.setBackgroundResource(i.getIntExtra("bg",00));
        fecha =  (TextView) findViewById(R.id.txt_date);
        fecha.setText(i.getStringExtra("fecha"));

        h0 =  (TextView) findViewById(R.id.txt_h0);
        h0.setText(i.getStringExtra("h0"));
        desc0 =  (TextView) findViewById(R.id.txt_h0_details);
        desc0.setText(i.getStringExtra("dec0"));
        lugar0 =  (TextView) findViewById(R.id.txt_h0_place);
        lugar0.setText(i.getStringExtra("lugar0"));

        h1 =  (TextView) findViewById(R.id.txt_h1);
        desc1 =  (TextView) findViewById(R.id.txt_h1_details);
        lugar1 =  (TextView) findViewById(R.id.txt_h1_place);
        h1.setText(i.getStringExtra("h1"));
        desc1.setText(i.getStringExtra("dec1"));
        lugar1.setText(i.getStringExtra("lugar1"));

        h2 =  (TextView) findViewById(R.id.txt_h2);
        desc2 =  (TextView) findViewById(R.id.txt_h2_details);
        lugar2 =  (TextView) findViewById(R.id.txt_h2_place);
        h2.setText(i.getStringExtra("h2"));
        desc2.setText(i.getStringExtra("dec2"));
        lugar2.setText(i.getStringExtra("lugar2"));

    }
}
