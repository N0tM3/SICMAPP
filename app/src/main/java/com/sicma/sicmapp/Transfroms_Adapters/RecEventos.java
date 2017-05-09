package com.sicma.sicmapp.Transfroms_Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sicma.sicmapp.Objetos.Evento;
import com.sicma.sicmapp.R;

import java.util.ArrayList;

/**
 * Created by Eduardo on 07/05/2017.
 */

public class RecEventos extends RecyclerView.Adapter<RecEventos.EventosViewHolder> {

    private ArrayList<Evento> items;
    public Context context;


    public RecEventos(Context context, ArrayList<Evento> items){
        this.context = context;
        this.items = items;
    }

    public class EventosViewHolder extends RecyclerView.ViewHolder{

        public TextView date;
        public TextView place;
        public RelativeLayout background;

        public EventosViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.txt_card_fecha);
            place = (TextView) itemView.findViewById(R.id.txt_card_lugar);
            background = (RelativeLayout) itemView.findViewById(R.id.rl_cv_events);



        }
    }


    @Override
    public RecEventos.EventosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_events, parent, false);
        return new RecEventos.EventosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecEventos.EventosViewHolder holder, final int position) {

        holder.date.setText(items.get(position).getFecha());
        holder.place.setText("");
        holder.background.setBackgroundResource(items.get(position).getImg());
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(items.get(position).getWeb());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}
