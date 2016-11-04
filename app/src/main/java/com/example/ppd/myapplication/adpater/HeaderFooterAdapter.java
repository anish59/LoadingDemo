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
import com.example.ppd.myapplication.databinding.ActivityHomeTwoBinding;
import com.example.ppd.myapplication.databinding.ActivityRowBinding;
import com.example.ppd.myapplication.databinding.FooterBinding;
import com.example.ppd.myapplication.databinding.HeaderItemsBinding;
import com.example.ppd.myapplication.model.MovieRequest;

import java.util.List;

/**
 * Created by anish on 03-11-2016.
 */
public class HeaderFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
   // ActivityHomeTwoBinding activityHomeTwoBinding;
    ActivityRowBinding activityRowBinding;
    HeaderItemsBinding headerItemsBinding;
    FooterBinding footerBinding;
    List<MovieRequest> items;
    Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;


    public HeaderFooterAdapter(List<MovieRequest> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("view type",viewType+"");
        if(viewType==TYPE_HEADER)
        {
            headerItemsBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.header_items,null,false);
            View v=headerItemsBinding.getRoot();
            return new HeaderViewholder(v);
        }
        else if(viewType==TYPE_FOOTER)
        {
            footerBinding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.footer,null,false);
            View v=footerBinding.getRoot();
            return new footerViewholder(v);
        }

        else if(viewType==TYPE_ITEM)
        {
            activityRowBinding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.activity_row,null,false);
            View v=activityRowBinding.getRoot();
            return new ItemHolder(v);
        }

        return null;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
//        Log.e("total pos", getItemCount()+"" );
        if(holder instanceof HeaderViewholder)
        {
//            Log.e("type","header");
            HeaderViewholder headerHolder=(HeaderViewholder)holder;
            headerHolder.header.setText("Header!!");
        }
        else if (holder instanceof footerViewholder)
        {
//            Log.e("type","footer");
            footerViewholder footerholder=(footerViewholder)holder;
            footerholder.footer.setText("Footer!!");
        }
        else if(holder instanceof ItemHolder)
        {
//            Log.e("type","other");

            Log.e("Adapter-name-->",items.get(position-1).getName());
            ItemHolder itemHolder=(ItemHolder)holder;
            itemHolder.name.setText(items.get(position-1).getName());

            itemHolder.timeStamp.setText(items.get(position-1).getTimestamp());

            if (!(items.get(position-1).getUrl().getSmall().equals(""))) {
                Glide.with(context)
                        .load(items.get(position-1).getUrl().getSmall()).into(itemHolder.moviePic);
                Log.d("Test", "notEmpty");
            } else {
                Glide.with(context).load(R.drawable.not_available);
                Log.d("Test", "Empty");
            }

        }

    }

   /* public void setItems(List<MovieRequest> items) {
        this.items = items;
        notifyDataSetChanged();
    }*/


    @Override
    public int getItemViewType(int position) {
//        Log.e("pos-->", position+"" );
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        } else if(isPositionFooter (position)) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;

    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    private boolean isPositionFooter (int position) {
        return position == items.size () + 1;
    }


    @Override
    public int getItemCount() {
        return items.size()+2;
    }


    class footerViewholder extends RecyclerView.ViewHolder{
    TextView footer;

        public footerViewholder(View itemView)
        {
            super(itemView);
            footer=footerBinding.txtFooterItem;

        }
    }

    class HeaderViewholder extends RecyclerView.ViewHolder{
    TextView header;

        public HeaderViewholder(View itemView)
        {
            super(itemView);
            header=headerItemsBinding.txtHeaderItem;

        }
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        ImageView moviePic;
        TextView name, timeStamp;

        public ItemHolder(View itemView)
        {
            super(itemView);
            moviePic = activityRowBinding.imgPic;
            name = activityRowBinding.txtName;
            timeStamp = activityRowBinding.timeStamp;

        }
    }

}
