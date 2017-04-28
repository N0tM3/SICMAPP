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
    private static Context mContext =null;
    private final String URL_UEM_CIVIL_CULUB = "https://uemclubcivil.wordpress.com/2017/";//Not using Doc because is not a valid html

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

               news = parseDocument(html_respuesta);
                for (New mNew:news) {
                    printInLogs(mNew);
                }
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
     * Methos to get the ArrayList of article
     * @param doc
     * @return
     */
    ArrayList<New> parseDocument(String doc){
        ArrayList<New> alArticules = new ArrayList();
        String title, date, urlFoto, parragraph;
        String[] articules = splitByTarGetLabel(doc, "article");
          for(int i = 1; i < (articules.length-1);i+=2){
              String articule = articules[i];
              title = getTitleOfThisUEMURL(articule);
              date = getDateOfThisUEMURL(articule);
              urlFoto = getImagenUrlOfThisUEMURL(articule);
              parragraph = getParragarphOfThisUEMURL(articule);
            alArticules.add(new New(title, date, urlFoto, parragraph));
        }
        return alArticules;
    }

    /**
     * Parse the url and get the title we get the h2 tag, delete was before of > and delete the </a
     * @param urlTogetTitile
     * @return
     */
    String getTitleOfThisUEMURL(String urlTogetTitile){
        /*
        *id="post-865" class="post-865 post type-post status-publish format-standard has-post-thumbnail hentry category-actividades-de-interes category-cursos category-jornada-bim-civil">
        *                                                   	<header class="entry-header">
        *                                                   		<h2 class="entry-title"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark">#BIMcivilUEM2017</a></h2>
        *                                                   				<div class="entry-meta">
        *                                                   			<span class="posted-on">Publicado el <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark"><time class="entry-date published" datetime="2017-04-13T14:31:11+00:00">13 abril, 2017</time></a></span><span class="byline"> por <span class="author vcard"><a class="url fn n" href="https://uemclubcivil.wordpress.com/author/uemclubcivil/">uemclubcivil</a></span></span>		</div><!-- .entry-meta -->
        *                                                   			</header><!-- .entry-header -->
        *
        *
        *                                                   	<a class="post-thumbnail" href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/">
        *                                                   		<img width="648" height="183" src="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" class="attachment-edin-featured-image size-edin-featured-image wp-post-image" alt="" srcset="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648 648w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1296 1296w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=150 150w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300 300w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=768 768w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1024 1024w" sizes="(max-width: 648px) 100vw, 648px" data-attachment-id="867" data-permalink="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/wordpress/" data-orig-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg" data-orig-size="1740,492" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;0&quot;,&quot;credit&quot;:&quot;Daniel L&quot;,&quot;camera&quot;:&quot;&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1492099906&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;0&quot;,&quot;iso&quot;:&quot;0&quot;,&quot;shutter_speed&quot;:&quot;0&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;0&quot;}" data-image-title="wordpress" data-image-description="" data-medium-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300" data-large-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" />	</a>
        *
        *
        *                                                   	<div class="entry-content">
        *                                                   		<p>¡¡Desde la UEM abrimos el mes BIM en España!! Los próximos días 5 y 6 mayo tendrán lugar las Jornadas de BIM en Ingeniería Civil celebrándose en el Campus de la UEM de Villaviciosa de Odón (Madrid). #BIMcivilUEM2017 Las Jornadas estarán formadas por talleres y conferencias sobre aspectos interesantes de esta nueva metodología de trabajo. &hellip; <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" class="more-link">Continúa leyendo <span class="screen-reader-text">#BIMcivilUEM2017</span></a></p>	</div><!-- .entry-content -->
        *
        *                                                   	<footer class="entry-footer">
        *                                                   		<span class="cat-links">Publicado en <a href="https://uemclubcivil.wordpress.com/category/actividades-de-interes/" rel="category tag">Actividades de Interés</a>, <a href="https://uemclubcivil.wordpress.com/category/cursos/" rel="category tag">Cursos</a>, <a href="https://uemclubcivil.wordpress.com/category/jornada-bim-civil/" rel="category tag">Jornada BIM Civil</a></span><span class="comments-link"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/#respond">Deja un comentario</a></span>	</footer><!-- .entry-footer -->
        *                                                   </
        */
        return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"h2")[1],">")[2].replace("</a","");
    }

    /**
     *  get the tag time and get the thing by geting was inside the tag
     * @param urlTogetTitile
     * @return
     */
    String getDateOfThisUEMURL(String urlTogetTitile) {
        /*
        *id="post-865" class="post-865 post type-post status-publish format-standard has-post-thumbnail hentry category-actividades-de-interes category-cursos category-jornada-bim-civil">
        *                                                   	<header class="entry-header">
        *                                                   		<h2 class="entry-title"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark">#BIMcivilUEM2017</a></h2>
        *                                                   				<div class="entry-meta">
        *                                                   			<span class="posted-on">Publicado el <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark"><time class="entry-date published" datetime="2017-04-13T14:31:11+00:00">13 abril, 2017</time></a></span><span class="byline"> por <span class="author vcard"><a class="url fn n" href="https://uemclubcivil.wordpress.com/author/uemclubcivil/">uemclubcivil</a></span></span>		</div><!-- .entry-meta -->
        *                                                   			</header><!-- .entry-header -->
        *
        *
        *                                                   	<a class="post-thumbnail" href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/">
        *                                                   		<img width="648" height="183" src="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" class="attachment-edin-featured-image size-edin-featured-image wp-post-image" alt="" srcset="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648 648w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1296 1296w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=150 150w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300 300w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=768 768w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1024 1024w" sizes="(max-width: 648px) 100vw, 648px" data-attachment-id="867" data-permalink="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/wordpress/" data-orig-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg" data-orig-size="1740,492" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;0&quot;,&quot;credit&quot;:&quot;Daniel L&quot;,&quot;camera&quot;:&quot;&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1492099906&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;0&quot;,&quot;iso&quot;:&quot;0&quot;,&quot;shutter_speed&quot;:&quot;0&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;0&quot;}" data-image-title="wordpress" data-image-description="" data-medium-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300" data-large-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" />	</a>
        *
        *
        *                                                   	<div class="entry-content">
        *                                                   		<p>¡¡Desde la UEM abrimos el mes BIM en España!! Los próximos días 5 y 6 mayo tendrán lugar las Jornadas de BIM en Ingeniería Civil celebrándose en el Campus de la UEM de Villaviciosa de Odón (Madrid). #BIMcivilUEM2017 Las Jornadas estarán formadas por talleres y conferencias sobre aspectos interesantes de esta nueva metodología de trabajo. &hellip; <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" class="more-link">Continúa leyendo <span class="screen-reader-text">#BIMcivilUEM2017</span></a></p>	</div><!-- .entry-content -->
        *
        *                                                   	<footer class="entry-footer">
        *                                                   		<span class="cat-links">Publicado en <a href="https://uemclubcivil.wordpress.com/category/actividades-de-interes/" rel="category tag">Actividades de Interés</a>, <a href="https://uemclubcivil.wordpress.com/category/cursos/" rel="category tag">Cursos</a>, <a href="https://uemclubcivil.wordpress.com/category/jornada-bim-civil/" rel="category tag">Jornada BIM Civil</a></span><span class="comments-link"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/#respond">Deja un comentario</a></span>	</footer><!-- .entry-footer -->
        *                                                   </
        */

    return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"time")[2],">")[1].replace("</","");
    }

    /**
     * get the src and deliting the "
     * @param urlTogetTitile
     * @return
     */
    String getImagenUrlOfThisUEMURL(String urlTogetTitile) {
        /*
        *id="post-865" class="post-865 post type-post status-publish format-standard has-post-thumbnail hentry category-actividades-de-interes category-cursos category-jornada-bim-civil">
        *                                                   	<header class="entry-header">
        *                                                   		<h2 class="entry-title"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark">#BIMcivilUEM2017</a></h2>
        *                                                   				<div class="entry-meta">
        *                                                   			<span class="posted-on">Publicado el <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark"><time class="entry-date published" datetime="2017-04-13T14:31:11+00:00">13 abril, 2017</time></a></span><span class="byline"> por <span class="author vcard"><a class="url fn n" href="https://uemclubcivil.wordpress.com/author/uemclubcivil/">uemclubcivil</a></span></span>		</div><!-- .entry-meta -->
        *                                                   			</header><!-- .entry-header -->
        *
        *
        *                                                   	<a class="post-thumbnail" href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/">
        *                                                   		<img width="648" height="183" src="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" class="attachment-edin-featured-image size-edin-featured-image wp-post-image" alt="" srcset="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648 648w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1296 1296w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=150 150w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300 300w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=768 768w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1024 1024w" sizes="(max-width: 648px) 100vw, 648px" data-attachment-id="867" data-permalink="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/wordpress/" data-orig-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg" data-orig-size="1740,492" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;0&quot;,&quot;credit&quot;:&quot;Daniel L&quot;,&quot;camera&quot;:&quot;&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1492099906&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;0&quot;,&quot;iso&quot;:&quot;0&quot;,&quot;shutter_speed&quot;:&quot;0&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;0&quot;}" data-image-title="wordpress" data-image-description="" data-medium-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300" data-large-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" />	</a>
        *
        *
        *                                                   	<div class="entry-content">
        *                                                   		<p>¡¡Desde la UEM abrimos el mes BIM en España!! Los próximos días 5 y 6 mayo tendrán lugar las Jornadas de BIM en Ingeniería Civil celebrándose en el Campus de la UEM de Villaviciosa de Odón (Madrid). #BIMcivilUEM2017 Las Jornadas estarán formadas por talleres y conferencias sobre aspectos interesantes de esta nueva metodología de trabajo. &hellip; <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" class="more-link">Continúa leyendo <span class="screen-reader-text">#BIMcivilUEM2017</span></a></p>	</div><!-- .entry-content -->
        *
        *                                                   	<footer class="entry-footer">
        *                                                   		<span class="cat-links">Publicado en <a href="https://uemclubcivil.wordpress.com/category/actividades-de-interes/" rel="category tag">Actividades de Interés</a>, <a href="https://uemclubcivil.wordpress.com/category/cursos/" rel="category tag">Cursos</a>, <a href="https://uemclubcivil.wordpress.com/category/jornada-bim-civil/" rel="category tag">Jornada BIM Civil</a></span><span class="comments-link"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/#respond">Deja un comentario</a></span>	</footer><!-- .entry-footer -->
        *                                                   </
        */

        return splitByTarGetLabel(splitByTarGetLabel(urlTogetTitile,"src")[1],"\"")[1];
    }

    /**
     * Method to get the parragraph
     * Get the 2 parts and join them
     * @param urlTogetTitile
     * @return
     */
    String getParragarphOfThisUEMURL(String urlTogetTitile) {
        /*
        *id="post-865" class="post-865 post type-post status-publish format-standard has-post-thumbnail hentry category-actividades-de-interes category-cursos category-jornada-bim-civil">
        *                                                   	<header class="entry-header">
        *                                                   		<h2 class="entry-title"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark">#BIMcivilUEM2017</a></h2>
        *                                                   				<div class="entry-meta">
        *                                                   			<span class="posted-on">Publicado el <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" rel="bookmark"><time class="entry-date published" datetime="2017-04-13T14:31:11+00:00">13 abril, 2017</time></a></span><span class="byline"> por <span class="author vcard"><a class="url fn n" href="https://uemclubcivil.wordpress.com/author/uemclubcivil/">uemclubcivil</a></span></span>		</div><!-- .entry-meta -->
        *                                                   			</header><!-- .entry-header -->
        *
        *
        *                                                   	<a class="post-thumbnail" href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/">
        *                                                   		<img width="648" height="183" src="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" class="attachment-edin-featured-image size-edin-featured-image wp-post-image" alt="" srcset="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648 648w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1296 1296w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=150 150w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300 300w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=768 768w, https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=1024 1024w" sizes="(max-width: 648px) 100vw, 648px" data-attachment-id="867" data-permalink="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/wordpress/" data-orig-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg" data-orig-size="1740,492" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;0&quot;,&quot;credit&quot;:&quot;Daniel L&quot;,&quot;camera&quot;:&quot;&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1492099906&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;0&quot;,&quot;iso&quot;:&quot;0&quot;,&quot;shutter_speed&quot;:&quot;0&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;0&quot;}" data-image-title="wordpress" data-image-description="" data-medium-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=300" data-large-file="https://uemclubcivil.files.wordpress.com/2017/04/wordpress.jpg?w=648" />	</a>
        *
        *
        *                                                   	<div class="entry-content">
        *                                                   		<p>¡¡Desde la UEM abrimos el mes BIM en España!! Los próximos días 5 y 6 mayo tendrán lugar las Jornadas de BIM en Ingeniería Civil celebrándose en el Campus de la UEM de Villaviciosa de Odón (Madrid). #BIMcivilUEM2017 Las Jornadas estarán formadas por talleres y conferencias sobre aspectos interesantes de esta nueva metodología de trabajo. &hellip; <a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/" class="more-link">Continúa leyendo <span class="screen-reader-text">#BIMcivilUEM2017</span></a></p>	</div><!-- .entry-content -->
        *
        *                                                   	<footer class="entry-footer">
        *                                                   		<span class="cat-links">Publicado en <a href="https://uemclubcivil.wordpress.com/category/actividades-de-interes/" rel="category tag">Actividades de Interés</a>, <a href="https://uemclubcivil.wordpress.com/category/cursos/" rel="category tag">Cursos</a>, <a href="https://uemclubcivil.wordpress.com/category/jornada-bim-civil/" rel="category tag">Jornada BIM Civil</a></span><span class="comments-link"><a href="https://uemclubcivil.wordpress.com/2017/04/13/bimciviluem2017/#respond">Deja un comentario</a></span>	</footer><!-- .entry-footer -->
        *                                                   </
        */
        String pStringContent = splitByTarGetLabel(urlTogetTitile,"p>")[1];
        String firstPartOfTheParragrph = splitByTarGetLabel(pStringContent,"<a href")[0];
        String secondPartOfTheParragrph = splitByTarGetLabel(pStringContent,"<span class=\"screen-reader-text\">")[1].replace("</span></a></"," ");
        return firstPartOfTheParragrph+" "+secondPartOfTheParragrph;
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

}
