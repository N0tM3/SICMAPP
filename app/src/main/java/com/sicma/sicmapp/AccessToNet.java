package com.sicma.sicmapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Dani_2 on 23/04/2017.
 */
public class AccessToNet {
    ArrayList<New> news = null;
    private static Context mContext =null;
    //private final String URL_UEM_CIVIL_CULUB = "https://uemclubcivil.wordpress.com/2017/";//Not using Doc because is not a valid html
    private final String URL_CAMINOS_MADRID = "http://www.caminosmadrid.es/";

    /**
     * Constructor for get the web
     * @param mContext
     */
    public AccessToNet(Context mContext){
        this.mContext = mContext;
        Volley(URL_CAMINOS_MADRID);
    }

    /**
     * Get the Web
     * @param Url
     */
    public void Volley(String Url){
        RequestQueue rq = Volley.newRequestQueue(mContext);
        String url =Url;

        Response.Listener oyente=new Response.Listener() {
            @Override
            public void onResponse(Object o) {
                String html_respuesta=(String)o;
                Log.v("html",html_respuesta);

               news = parseDocument(html_respuesta);
                NewsCards.setIsInternetOnline(true);
                for (New mNew:news) {
                    printInLogs(mNew);
                }
            }
        };

        Response.ErrorListener oyente_fallo=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                news = new ArrayList<>();
                NewsCards.setIsInternetOnline(false);
                news.add(new New("Internet Error","","","Please active internet an reloap the app"));
            }
        };

        StringRequest respuesta=new StringRequest(url, oyente, oyente_fallo);
        rq.add(respuesta);
    }

    /**
     * //TODO:Method for deveoper logs
     * @param mNew
     */
    public void printInLogs(New mNew){
        Log.d("new_html","    ");
        Log.d("new_html","----- Actual log----- ");
        Log.d("new_html","title: "+mNew.getTitle());
        Log.d("new_html","date: "+mNew.getDate());
        Log.d("new_html","imagen: "+mNew.getUrlFoto());
        Log.d("new_html","parragraph: "+mNew.getParragraph());
    }

    /**
     * Method to get the ArrayList of article
     * @param doc
     * @return
     */
    ArrayList<New> parseDocument(String doc){
        ArrayList<New> alArticules = new ArrayList();
        String title, date, urlFoto, parragraph;

        //get the ul of the imagen
        String ul = splitByTarGetLabel(splitByTarGetLabel(doc, "<div class=\"slider frame flexslider col-8\" data-animation=\"fade\" data-animation-speed=\"600\" data-slide-delay=\"5000\">")[1],"<div class=\"pages\" data-number=\"5\">")[0];

        String li [] =splitByTarGetLabel(ul,"li>");

          for(int i = 1; i < (li.length-1);i+=2){
              String news = li[i];
              title = getTitleOfThisURL(news);
              // date = getDateOfThisURL(news);
              urlFoto = getImagenUrlOfThisURL(news);
              parragraph = getParragarphOfThisURL(news);
            //alArticules.add(new New(title, date, urlFoto, parragraph));
              alArticules.add(new New(title, "", urlFoto, parragraph));
        }

        return alArticules;
    }

    /**
     * Parse the url and get the title we get the h2 tag, delete was before of > and delete the </a
     * @param urlTogetTitile
     * @return
     */
    String getTitleOfThisURL(String urlTogetTitile){
        /*
        * li>
						<a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" class="image-link"><img width="702" height="336" src="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg" class="attachment-main-slider size-main-slider wp-post-image" alt="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid" title="" srcset="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg 702w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144.jpg 300w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144@2x.jpg 600w" sizes="(max-width: 702px) 100vw, 702px" /></a>


						<div class="caption">

							<h3><a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" title="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid">El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid</a></h3>

						</div>

					</*/
        return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"title=\"")[2],"\">")[0].replace("&#8211;"," - ");
    }

    /**
     *  get the tag time and get the thing by geting was inside the tag
     * @param urlTogetTitile
     * @return
     */
    String getDateOfThisURL(String urlTogetTitile) {
        /*
        * li>
						<a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" class="image-link"><img width="702" height="336" src="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg" class="attachment-main-slider size-main-slider wp-post-image" alt="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid" title="" srcset="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg 702w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144.jpg 300w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144@2x.jpg 600w" sizes="(max-width: 702px) 100vw, 702px" /></a>


						<div class="caption">

							<h3><a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" title="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid">El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid</a></h3>

						</div>

					</*/

    return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"time")[2],">")[1].replace("</","");
    }

    /**
     * get the src and deliting the "
     * @param urlTogetTitile
     * @return
     */
    String getImagenUrlOfThisURL(String urlTogetTitile) {
                /*
        * li>
						<a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" class="image-link"><img width="702" height="336" src="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg" class="attachment-main-slider size-main-slider wp-post-image" alt="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid" title="" srcset="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg 702w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144.jpg 300w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144@2x.jpg 600w" sizes="(max-width: 702px) 100vw, 702px" /></a>


						<div class="caption">

							<h3><a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" title="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid">El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid</a></h3>

						</div>

					</*/

        return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"src=\"")[1],"\"")[0];
    }

    /**
     * Method to get the parragraph
     * Get the 2 parts and join them
     * @param urlTogetTitile
     * @return
     */
    String getParragarphOfThisURL(String urlTogetTitile) {
        /*
        * li>
						<a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" class="image-link"><img width="702" height="336" src="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg" class="attachment-main-slider size-main-slider wp-post-image" alt="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid" title="" srcset="http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey.jpg 702w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144.jpg 300w, http://www.caminosmadrid.es/wp-content/uploads/2017/04/rey-300x144@2x.jpg 600w" sizes="(max-width: 702px) 100vw, 702px" /></a>


						<div class="caption">

							<h3><a href="http://www.caminosmadrid.es/rey-ha-aceptado-la-presidencia-del-comite-honor-la-iv-semana-la-ingenieria-caminos" title="El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid">El Rey ha aceptado la presidencia del Comité de Honor de la IV Semana de la Ingeniería de Caminos en  Madrid</a></h3>

						</div>

					</*/
        String pStringContent = splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"href=\"")[1],"\"")[0];
        return pStringContent;
    }

    /**
         * Genera method to get something of an html
         * @param stringDoc
         * @param tag
         * @return
         */
    String[] splitByTarGetLabel(String stringDoc,String tag){
        return stringDoc.split(tag);
    }

    /**
     *
     * @return
     */
    ArrayList<New> getNews(){
        return news;
    }

}