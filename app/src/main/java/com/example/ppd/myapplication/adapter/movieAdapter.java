package com.example.ppd.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.ActivityRowBinding;
import com.example.ppd.myapplication.model.Url;

import java.util.List;

/**
 * Created by anish on 28-10-2016.
 */
public class movieAdapter extends RecyclerView.Adapter<movieAdapter.MovieViewHolder> {
    List<Url> items;
    ActivityRowBinding activityRowBinding;
    Context context;

    public movieAdapter(List<Url> items,Context context) {
        this.items = items;
        this.context=context;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        activityRowBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.activity_row,null,false);
        View itemView=activityRowBinding.getRoot();
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position)
    {
        //Glide.with(context)
               // .load(items.get(position).getMedium()).thumbnail(0.5f).into((MovieViewHolder)holder.moviePic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView moviePic;
        TextView name,timeStamp;

        public MovieViewHolder(View itemView) {
            super(itemView);

            moviePic=activityRowBinding.imgPic;
            name=activityRowBinding.txtName;
            timeStamp=activityRowBinding.timeStamp;

        }
    }
}
