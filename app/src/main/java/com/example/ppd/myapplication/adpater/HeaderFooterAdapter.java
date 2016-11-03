package com.example.ppd.myapplication.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ppd.myapplication.model.MovieRequest;

import java.util.List;

/**
 * Created by anish on 03-11-2016.
 */
public class HeaderFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    List<MovieRequest> items;
    Context context;

    public HeaderFooterAdapter(List<MovieRequest> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class footerViewholder extends RecyclerView.ViewHolder{
    TextView header;

        public footerViewholder(View itemView)
        {
            super(itemView);

        }
    }
}
