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


        Evento pg0_ev0 = new Evento("VIERNES 19 MAYO","","09:00 a.m.","Inauguración de la IV edición de la Semana de la Ingeniería de Caminos en Madrid","Lugar: Museo del Prado.","","","","","","","", R.drawable.m_prado_auditorio_claustro_jeronimo);
        Evento pg0_ev1 = new Evento("LUNES 22 MAYO","","11:00 a.m.","Inauguración muestra de iconos","Lugar: Plaza de Callao","12.30 p.m.","Federico Cantero Villamil. Inauguración exposición y conferencia sobre su obra.","Lugar: Colegio Ingenieros de Caminos.","18:00 p.m.","La investigación, el desarrollo y la innovación en las empresas de Ingeniería","Lugar: Salón de actos. Real Casa de Correos.","", R.drawable.callao_madrid);
        Evento pg0_ev2 = new Evento("MARTES 23 MAYO","","19:00 p.m.","La internacionalización de la ingeniería de caminos.","Lugar: Circulo Bellas Artes.","","","","","","","", R.drawable.circulo_bellas_artes);
        Evento pg0_ev3 = new Evento("MIÉRCOLES 24 MAYO","","09:00 a.m.","Jornada sobre el cambio climático y la ingeniería de caminos","Lugar: Residencia de Estudiantes","14:00 p.m.","Sesión sobre “La ingeniería y los Objetivos de Desarrollo Sostenible (ODS)","Lugar: Residencia de Estudiantes","","","","", R.drawable.residencia_de_estudiantes);

        Evento pg0_ev4 = new Evento("JUEVES 25 MAYO","","18:30 p.m.","Singularidad en la gestión del saneamiento en Madrid","Lugar: Canal Isabel II.(C/Santa Engracia 125)","","","","","","","", R.drawable.foto_colegio_caminos);
        Evento pg0_ev5 = new Evento("VIERNES 26 MAYO","","11:30 a.m.","Pintura del siglo XIX en el mundo occidental.","Lugar: Colegio Ingenieros de Caminos.","19:00 p.m.","Las Crisis Económicas a través de la Historia","Lugar: Colegio Ingenieros de Caminos.","","","","", R.drawable.foto_colegio_caminos);

        Evento pg0_ev6 = new Evento("SABADO 27 MAYO","","11:30 a.m.","Contribución de la Ingeniería de Caminos al progreso. Canales de Navegación","Lugar: Facultad de Ciencias Exactas. U. Complutense.","","","","","","","", R.drawable.f_ciencias_exactas);

        pag0.add(pg0_ev0);
        pag0.add(pg0_ev1);
        pag0.add(pg0_ev2);
        pag0.add(pg0_ev3);
        pag0.add(pg0_ev4);
        pag0.add(pg0_ev5);
        pag0.add(pg0_ev6);



        Evento pg1_ev0 = new Evento("LUNES 22 MAYO","visita","10:00 a.m.","Centro de Estudios de Puertos y Costas","","11:00 a.m.","Metro de Madrid- Puesto de Control Central- Estación de Alto del Arenal (L1)","","12:30 p.m.","Teleférico de Madrid","","", R.drawable.teleferico_madrid);
        Evento pg1_ev1 = new Evento("MARTES 23 MAYO","visita","11:00 a.m.","Instituto de Ciencias de la Construcción Eduardo Torroja","","12:00 p.m.","Faro de Moncloa","","","","","", R.drawable.faromoncloa);
        Evento pg1_ev2 = new Evento("MIÉRCOLES 24 MAYO","visita","10:00 a.m.","Depuradora de Aguas Residuales de la Gavia y Estanque de Tormentas de Abroñigales","","11:00 a.m.","Torrespacio","","","","","", R.drawable.torre_espacio);
        Evento pg1_ev3 = new Evento("JUEVES 25 MAYO","","9:00 a.m.","Aranjuez, Embocador, Azuda, Canales, Huertas y Jardines","","10:00 a.m.","","Nuevo Túnel de Alta Velocidad y Centro de Regulación y Control Atocha","","","","", R.drawable.tunel);
        Evento pg1_ev4 = new Evento("VIERNES 26 MAYO","","9:00 a.m.","Construcción Estadio Wanda Metropolitano","","10:30 a.m.","Depósitos y Galerías Históricas del Canal","","","","","", R.drawable.estadio);
        Evento pg1_ev5 = new Evento("SÁBADO 27 MAYO","","10:00 a.m.","Hipódromo de la Zarzuela, Edificios de Tribunas y Museo Eduardo Torroja","","","","","","","","", R.drawable.hipodromo_zarzuela);
        Evento pg1_ev6 = new Evento("DOMINGO 28 MAYO","","10:00 a.m.","Madrid Rio","","11:00 a.m.","Museo de autobuses históricos EMT","","","","","", R.drawable.museo_emt);

        pag1.add(pg1_ev0);
        pag1.add(pg1_ev1);
        pag1.add(pg1_ev2);
        pag1.add(pg1_ev3);
        pag1.add(pg1_ev4);
        pag1.add(pg1_ev5);
        pag1.add(pg1_ev6);



        Evento pg2_ev0 = new Evento("SABADO 20 MAYO","","11:00 a.m.","Torneo fútbol mixto","Lugar: Instalaciones UPM","","","","","","","", R.drawable.balon_cesped);
        Evento pg2_ev1 = new Evento("DOMINGO 21 MAYO","","10:00 a.m.","Torneo fútbol mixto","Lugar: Instalaciones UPM","","","","","","","", R.drawable.balon_cesped);

//
        Evento pg2_ev2 = new Evento("LUNES 22 MAYO","","17:00 p.m.","Cata de aguas diferentes (de manantial y potable de Madrid...)","Lugar: Carpa Reina Sofía","19:00 p.m.","Visionado de fotografías y cortos finalista. Entrega de premios de los concurso de cortometrajes y concurso de fotografías","Lugar: CICCP. Demarcación de Madrid","","","","", R.drawable.carpa);


        Evento pg2_ev3 = new Evento("MARTES 23 MAYO","","11:00 a.m.","Panel demostración nuevas tecnologías y aplicaciones: realidad aumentada, impresión 3D, 360o...","Lugar: Carpa Reina Sofía","17:30 p.m.","-Taller de montaje de elementos de ingeniería con piezas de Lego","Lugar: Carpa Reina Sofía","","","","", R.drawable.carpa);

//
        Evento pg2_ev4 = new Evento("MIÉRCOLES 24 MAYO","","11:00 a.m.","Taller sobre la potabilización del agua","Lugar: Carpa Reina Sofía","19:00 p.m.","Concierto 'CuartetoMendelsshon de BP'","Lugar: Fundación Albéniz ","","","","", R.drawable.f_albeniz);


        Evento pg2_ev5 = new Evento("JUEVES 25 MAYO","","11:00 a.m.","Construcción de pasarela por alumnos de la UEM","Lugar: Carpa Reina Sofía","","","","","","","", R.drawable.carpa);

//Evento pg2_ev6 = new Evento("VIERNES 26 MAYO","","11:00 a.m.","Montaje maqueta del Depósito elevado de Chamberí","Lugar: Carpa Reina Sofía","18:00 p.m.","Representación de una obra de teatro, por grupo teatro Caminosmadrid","Lugar: Colegio Ingenieros de Caminos, Canales y Puertos.","","","","", R.drawable.carpa);

//
        Evento pg2_ev7 = new Evento("SABADO 27 MAYO","","10:00 a.m. - 15:00 p.m.","Ruta de la Ingenieria de Caminos de Madrid Circuitos en autobús descapotable por la Muestra de los iconos de la ingeniería","Puto de encuentro / Salida : Depósito del Canal en Plaza Castilla","10:00 a.m.","Itinerario con “Andariegos Madrid” por la muestra de iconos","","","","","", R.drawable.deposito_agua);

//
        Evento pg2_ev8 = new Evento("DOMINGO 28 MAYO","","10:00 a.m.","Taller de montaje de elementos de ingeniería con piezas de Lego","Lugar: Carpa Reina Sofía","11:30","Teatro familiar","Lugar: Carpa Reina Sofía","12:30","Montaje maqueta del Depósito elevado de Chamberí","Lugar: Carpa Reina Sofía","", R.drawable.carpa);

        Evento pg2_ev9 = new Evento("CONCURSO FOTOGRÁFICO","","","Consultar bases en www.caminosmadrid.es","","","","","","","","", R.drawable.concurso_foto);
        Evento pg2_ev10 = new Evento("CONCURSO CORTOMETRAJES","","","Consultar bases en www.caminosmadrid.es","","","","","","","","", R.drawable.concurso_cortos);
        Evento pg2_ev11 = new Evento("CONCURSO DE REDES SOCIALES","","","Consultar bases en www.caminosmadrid.es","","","","","","","","", R.drawable.iconos);


        pag2.add(pg2_ev0);
        pag2.add(pg2_ev1);
        pag2.add(pg2_ev2);
        pag2.add(pg2_ev3);
        pag2.add(pg2_ev4);
        pag2.add(pg2_ev5);
        pag2.add(pg2_ev7);
        pag2.add(pg2_ev8);
        pag2.add(pg2_ev9);
        pag2.add(pg2_ev10);
        pag2.add(pg2_ev11);

}
}