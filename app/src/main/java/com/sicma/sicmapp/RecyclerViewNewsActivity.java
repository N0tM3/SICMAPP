package com.sicma.sicmapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewNewsActivity extends AppCompatActivity {
    static AccessToNet atn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_news);
        RecyclerView rv = (RecyclerView) findViewById(R.id.mrc);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new NewsCards(atn.getNews()));
    }

    public static void setAtn(AccessToNet atns){
        atn = atns;
    }
}