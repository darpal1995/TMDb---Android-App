package com.example.darpal.themoviesapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darpal.themoviesapp.Getter_Setter.NowPlaying_GetterSetter;
import com.example.darpal.themoviesapp.R;

import java.util.ArrayList;

public class NowPlaying_RecyclerAdapter extends RecyclerView.Adapter<NowPlaying_RecyclerAdapter.MyVH> {

    Context context;
    ArrayList<NowPlaying_GetterSetter> arrayList = new ArrayList<>();

    public NowPlaying_RecyclerAdapter(Context context, ArrayList<NowPlaying_GetterSetter> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public NowPlaying_RecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cell, parent, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlaying_RecyclerAdapter.MyVH holder, int position) {
        holder.MovieName.setText(arrayList.get(position).getMoviename());
        holder.Date.setText(arrayList.get(position).getRelease());
        holder.Rating.setText(arrayList.get(position).getRate());
        holder.Synopsis.setText(arrayList.get(position).getSynopsis());
        if(holder.imgURL == null){
            holder.imgURL.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgURL;
        TextView MovieName, Date, Rating, Synopsis;

        public MyVH(View itemView) {
            super(itemView);
            MovieName = (TextView) itemView.findViewById(R.id.name);
            Date = (TextView) itemView.findViewById(R.id.Release);
            Rating = (TextView) itemView.findViewById(R.id.rating);
            Synopsis = (TextView) itemView.findViewById(R.id.Synopsis);
            imgURL = (ImageView) itemView.findViewById(R.id.img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "" + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
