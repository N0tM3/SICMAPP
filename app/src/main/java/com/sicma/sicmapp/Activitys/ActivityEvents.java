package com.sicma.sicmapp.Activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sicma.sicmapp.Objetos.Evento;
import com.sicma.sicmapp.R;
import com.sicma.sicmapp.Transfroms_Adapters.ViewPagerAdapter;
import java.util.ArrayList;

/**
 * Created by Eduardo on 28/04/2017.
 */

public class ActivityEvents extends AppCompatActivity {

private ViewPager vp_noticias;
private ViewPagerAdapter viewPagerAdapter;
private int[] layouts;

private TabLayout tabPuntos;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ArrayList<Evento> pag0 = new ArrayList<Evento>();
        ArrayList<Evento> pag1 = new ArrayList<Evento>();
        ArrayList<Evento> pag2 = new ArrayList<Evento>();


        vp_noticias = (ViewPager) findViewById(R.id.vp_eventos);
        tabPuntos = (TabLayout) findViewById(R.id.tab_puntos);

        layouts = new int[]{
        R.layout.activity_events_0,
        R.layout.activity_events_1,
        R.layout.activity_events_2,
        };

        viewPagerAdapter = new ViewPagerAdapter(layouts,this,pag0,pag1,pag2);
        vp_noticias.setAdapter(viewPagerAdapter);
        tabPuntos.setupWithViewPager(vp_noticias,true);


        Evento pg0_ev0 = new Evento("","","","","","VIERNES 19 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.m_prado_auditorio_claustro_jeronimo);
        Evento pg0_ev1 = new Evento("","","","","","LUNES 22 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.callao_madrid);
        Evento pg0_ev2 = new Evento("","","","","","MARTES 23 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.circulo_bellas_artes);
        Evento pg0_ev3 = new Evento("","","","","","MIÉRCOLES 24 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.residencia_de_estudiantes);
        Evento pg0_ev4 = new Evento("","","","","","JUEVES 25 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.foto_colegio_caminos);
        Evento pg0_ev5 = new Evento("","","","","","VIERNES 26 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.foto_colegio_caminos);
        Evento pg0_ev6 = new Evento("","","","","","SABADO 27 MAYO","","http://semanaingenieriacaminosmadrid.com/programa/jornadas-y-conferencias/","",R.drawable.f_ciencias_exactas);

        pag0.add(pg0_ev0);
        pag0.add(pg0_ev1);
        pag0.add(pg0_ev2);
        pag0.add(pg0_ev3);
        pag0.add(pg0_ev4);
        pag0.add(pg0_ev5);
        pag0.add(pg0_ev6);




        }
}