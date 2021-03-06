package com.sicma.sicmapp.Transfroms_Adapters;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sicma.sicmapp.Objetos.New;
import com.sicma.sicmapp.R;

import java.io.InputStream;
import java.util.ArrayList;

public class NewsCards extends RecyclerView.Adapter<NewsCards.MyViewHolder> {

    static ArrayList<New> alNews;
    static boolean isInternetOnline;

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    class MyViewHolder  extends RecyclerView.ViewHolder {

        public CardView cv;
        public TextView title;
        public TextView text;
        public TextView date;
        public ImageView imagen;


        public MyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.mcard);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            text = (TextView) itemView.findViewById(R.id.txtText);
            imagen = (ImageView) itemView.findViewById(R.id.mImage);
        }
    }

    public NewsCards(){}

    /**
     * Set the ArrayList
     * @param alNew
     */
    public NewsCards(ArrayList alNew){
        alNews = alNew;
    }


    @Override
    public NewsCards.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_news_cards, parent, false);
        return new NewsCards.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsCards.MyViewHolder holder, int position) {
        holder.title.setText(alNews.get(position).getTitle());
        if(isInternetOnline) {
            holder.imagen.setScaleType(ImageView.ScaleType.CENTER);
            new DownloadImageTask(holder.imagen).execute(alNews.get(position).getUrlFoto());
            holder.cv.setVisibility(View.VISIBLE);
            holder.text.setText("");
            final String url = alNews.get(position).getParragraph();
            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
                }
            });
        }else{
            holder.text.setText(alNews.get(position).getParragraph());
            holder.imagen.setImageResource(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return alNews.size();
    }


    public static void setIsInternetOnline(boolean is){
        isInternetOnline= is;
    }
}
