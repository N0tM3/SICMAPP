package com.sicma.sicmapp;

import android.content.Context;
import android.util.Log;

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
    String html = null;
    private static Context mContext =null;
    private final static String URL_UEM_CIVIL_CULUB = "https://uemclubcivil.wordpress.com/2017/";

    /**
     * Constructor for get the web
     * @param mContext
     */
    public AccessToNet(Context mContext){
        this.mContext = mContext;
        Volley(URL_UEM_CIVIL_CULUB);
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
                setHTML(html_respuesta);
                parseDocument(html_respuesta);
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

    /**
     *
     * @param html
     */
    public void setHTML(String html){
        this.html = html;
    }

    /**
     * Parse the HTml and get an arrayList of news
     * @param doc
     * @return
     */
    ArrayList<New> parseDocument(String doc){
        String title, date, urlFoto, p;
        news = new ArrayList<>();
        Document html = convertStringToDocument(doc);
        //NodeList articule = html.getElementsByTagName("article");

        /**
        * Example of a articule
        *
        * <artitucle id = "post-639"  class = "post-639 post type-post status-publish format-standard has-post-thunail hentry
        * category hentry category-actividades-de-interes">
        *   <header class="entry-header">
        *         <h2 class="entry-title">
        *
        *
        *             <a href="http://uemclubcivil.wordpress.com/2017/
        *               01/26/conferencia-zorrotzaurre-la-transformacion-urbana-sotenible-en-uem/" rel = "bookmark">
        *               Conferencia "Zorrotzaurre - La transformacion urbana sostenible" en UEM
        *              </a>
        *
        *
        *          </h2>
        *           <div class="entry-meta">
        *               <span class="posted-on">
        *                   Publicado el
        *                       <a href="http://uemclubcivil.wordpress.com/2017/
        *                       01/26/conferencia-zorrotzaurre-la-transformacion-urbana-sotenible-en-uem/" rel = "bookmark">
        *
        *
        *                          <time class = "entry-date published" datetime = "2017-01-26TL9:10:32+00:00">
        *                            26 enero, 2017
        *                          </time>
        *
        *
        *                       </a>
        *               </span>
        *               <span class = "byline"> por
        *                     <span class = "author vcard">
        *                         <a class = "url fnn" href="https://uemcivil.wordpres.com/author/uemclubcivil/">
        *                             uemcivil
        *                         </a>
        *                     </span>
        *               </span>
        *           </div>
        *   </header>
        *   <a class = "post-thumbnail" href = "http://uemclubcivil.wordpress.com/2017/01/26/conferencia-zorrotzaurre-la
        *   -transformacion-urbana.sostenible-en-uem/">
        *
        *
        *       <img width = "648" height ="378" src=" "/>
        *
        *
        *   </a>
        *   <div class="entry-content">
        *
        *
        *
        *       <p>
        *           Desde club civil queremos informaros......
        *           <a href = "http://uemclubcivil.wordpress.com/2017/01/26/conferencia-zorrotzaurre-la
        *           -transformacion-urbana.sostenible-en-uem/" class = "more-link" >
        *                   Continua leyendo
        *               <span class = "screen-reader-text">
        *                       Conferencia "Zorrotzaure - La transformacion urbana ostenible" en UEM
        *               </span>
        *           </a>
        *       </p>
        *
        *
        *   </div>
        *   <footer class = "entry-footer">
        *       <span class = "cat-links"
        *           Publicado en
        *               <a href="http://uemclubcivil.wordpress.com/2017/01/26/conferencia-zorrotzaurre-la
        *               -transformacion-urbana.sostenible-en-uem/" rel = "category tag">
        *                       Actividades de interes
        *               </a>
        *       </span>
        *   </footer>
        *</articule>
        */

/*
        for (int i = 0; i>articule.getLength();i++) {
            Node actualArticule = articule.item(i);
            Element elementArticule = actualArticule.getOwnerDocument().getDocumentElement();

            //Search for the thing needed
            NodeList actualsA = elementArticule.getElementsByTagName("a");
            NodeList acualsImg = elementArticule.getElementsByTagName("img");
            NodeList actualsP = elementArticule.getElementsByTagName("p");

            //get the title in the first a of the article
            title = actualsA.item(0).getNodeValue();

            //get the date in the second a of article inside of time
            date = actualsA.item(1).getChildNodes().item(0).getNodeValue();

            //get the img url in the first img of the document inside of the atibute src
            urlFoto = acualsImg.item(0).getAttributes().getNamedItem("src").getNodeValue();

            //get the parragraph, the first parragraph of the article
            p = actualsP.item(0).getNodeValue();

            news.add(new New (title, date, urlFoto, p));
        }
*/
        return news;
    }

    /**
     * method to transform the Document to an String
     * @param html
     * @return
     */
    public  Document convertStringToDocument(String html){
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return db.parse(new InputSource(new StringReader(html)));

        }catch (Exception e){
            return null;
        }
    }

}
