package com.sicma.sicmapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/**
 * Created by Eduardo on 06/05/2017.
 */

public class SplashScreen extends AppCompatActivity {

    //RelativeLayout bars ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //bars = (RelativeLayout) findViewById(R.id.rl_bar0);

       // final Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_slpash);
       // bars.startAnimation(slideUp);


    }
}
