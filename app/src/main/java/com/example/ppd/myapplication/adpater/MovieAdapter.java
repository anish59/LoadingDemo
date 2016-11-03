package com.example.ppd.myapplication.adpater;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.ActivityRowBinding;
import com.example.ppd.myapplication.model.MovieRequest;
import com.example.ppd.myapplication.model.Url;

import java.util.List;

/**
 * Created by anish on 02-11-2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<MovieRequest> items;
    ActivityRowBinding activityRowBinding;
    Context context;

    public MovieAdapter(List<MovieRequest> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        activityRowBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.activity_row, null, false);
        View itemView = activityRowBinding.getRoot();
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        //Glide.with(context)
        // .load(items.get(position).getMedium()).thumbnail(0.5f).into((MovieViewHolder)holder.moviePic);
        holder.name.setText(items.get(position).getName());
        holder.timeStamp.setText(items.get(position).getTimestamp());

        if (!(items.get(position).getUrl().getSmall().equals(""))) {
            Glide.with(context)
                    .load(items.get(position).getUrl().getSmall()).into(holder.moviePic);
            Log.d("Test", "notEmpty");
        } else {
            Glide.with(context).load(R.drawable.not_available);
            Log.d("Test", "Empty");
        }

    }

    public void setItems(List<MovieRequest> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePic;
        TextView name, timeStamp;

        public MovieViewHolder(View itemView) {
            super(itemView);

            moviePic = activityRowBinding.imgPic;
            name = activityRowBinding.txtName;
            timeStamp = activityRowBinding.timeStamp;

        }
    }
}
