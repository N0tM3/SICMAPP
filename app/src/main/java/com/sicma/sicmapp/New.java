package com.sicma.sicmapp;

/**
 * Created by Dani_2 on 23/04/2017.
 */

public class New {
    String title, date, urlFoto, parragraph;


    /**
     * Constructor for firebase
     */
    public New() {
    }


    /**
     * Constructor with parametres
     * @param title
     * @param date
     * @param urlFoto
     * @param parragraph
     */
    public New(String title, String date, String urlFoto, String parragraph) {
        this.title = title;
        this.date = date;
        this.urlFoto = urlFoto;
        this.parragraph = parragraph;
    }


    /**
     * Get title
     * @return
     */
    public String getTitle() {
        return title;
    }


    /**
     * Set title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Get the Date
     * @return
     */
    public String getDate() {
        return date;
    }


    /**
     * Set the Date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }


    /**
     * Get the url foto
     * @return
     */
    public String getUrlFoto() {
        return urlFoto;
    }


    /**
     Set the url foto
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }


    /**
     * Get the p of the new
     * @return
     */
    public String getParragraph() {
        return parragraph;
    }


    /**
     * Set a p for the new
     * @param parragraph
     */
    public void setParragraph(String parragraph) {
        this.parragraph = parragraph;
    }
}
