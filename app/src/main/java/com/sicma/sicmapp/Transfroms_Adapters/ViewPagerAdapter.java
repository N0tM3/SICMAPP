package com.sicma.sicmapp.Transfroms_Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sicma.sicmapp.Objetos.Evento;
import com.sicma.sicmapp.R;

import java.util.ArrayList;

/**
 * Created by Eduardo on 07/05/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int[] layouts;
    private Context context;
    private LayoutInflater layoutInflater;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;

    private ArrayList<Evento> pag0 = new ArrayList<Evento>();
    private ArrayList<Evento> pag1 = new ArrayList<Evento>();
    private ArrayList<Evento> pag2 = new ArrayList<Evento>();

    public ViewPagerAdapter() {
    }

    public ViewPagerAdapter(int[] layouts, Context context, ArrayList<Evento> pag0, ArrayList<Evento> pag1, ArrayList <Evento> pag2) {
        this.context = context;
        this.layouts = layouts;
        this.pag0 = pag0;
        this.pag1 = pag1;
        this.pag2 = pag2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position], container, false);

        switch (position){

            case 0:
                recycler = (RecyclerView) view.findViewById(R.id.rc_events_0);
                lManager = new LinearLayoutManager(context);
                recycler.setLayoutManager(lManager);
                RecEventos adp = new RecEventos(context,pag0);
                recycler.setAdapter(adp);
                break;
            case 1:
                recycler = (RecyclerView) view.findViewById(R.id.rc_events_1);
                lManager = new LinearLayoutManager(context);
                recycler.setLayoutManager(lManager);
                RecEventos adp1= new RecEventos(context,pag1);
                recycler.setAdapter(adp1);
                break;

            case 2:
                recycler = (RecyclerView) view.findViewById(R.id.rc_events_2);
                lManager = new LinearLayoutManager(context);
                recycler.setLayoutManager(lManager);
                RecEventos adp2= new RecEventos(context,pag2);
                recycler.setAdapter(adp2);
                break;

        }





        container.addView(view);
        return view;
    }


    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
