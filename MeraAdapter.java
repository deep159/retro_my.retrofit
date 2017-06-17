package com.example.hi.retro;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hi on 04-06-2017.
 */

public class MeraAdapter extends RecyclerView.Adapter<MeraAdapter.MyHolder> {
    Context mcontext;
    View view;
    LayoutInflater inflater;
    Actors[] actors2;
    MyHolder holder;


    public MeraAdapter(Context context, Actors[] actors) {
        mcontext=context;
        actors2=actors;
        inflater=inflater.from(mcontext);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.list_item,parent,false);
        holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.mspouse.setText(actors2[position].getSpouse());
        holder.mheight.setText(actors2[position].getHeight());
        holder.mdes.setText(actors2[position].getDescription());

        //Picasso.with(mcontext).load(actors2[position].getImage()).into(holder.mimage); //working by jaggi
        Glide.with(mcontext).load(actors2[position].getImage()).into(holder.mimage);
    }

    @Override
    public int getItemCount() {
        return actors2.length;
    }

    public  class MyHolder extends RecyclerView.ViewHolder {
        TextView mspouse,mheight,mdes;
        ImageView mimage;
        public  MyHolder(View view){
            super(view);
            mspouse=(TextView) view.findViewById(R.id.spouse);
            mheight=(TextView) view.findViewById(R.id.height);
            mdes=(TextView) view.findViewById(R.id.des);
            mimage= (ImageView) view.findViewById(R.id.image);
        }
    }
}
