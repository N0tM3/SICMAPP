package com.sicma.sicmapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Dani_2 on 23/04/2017.
 */

public class AccessToNet {

    String html = null;
    static public Context mContext =null;

    public AccessToNet(){

    }

    public void Volley(String Url){
        RequestQueue rq = Volley.newRequestQueue(mContext);
        String url =Url;

        Response.Listener oyente=new Response.Listener() {
            @Override
            public void onResponse(Object o) {
                String html_respuesta=(String)o;
                Log.v("html",html_respuesta);
                html = html_respuesta;
            }
        };

        Response.ErrorListener oyente_fallo=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        };

        StringRequest respuesta=new StringRequest(url, oyente, oyente_fallo);
        rq.add(respuesta);
    }

    public static void setContext(){

    }
}
