package com.example.user.transculture;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TouristSitesRecyclerAdapter extends RecyclerView
        .Adapter<TouristSitesRecyclerAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<TouristSitesDO> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime,txtLocation;
        ImageButton favourites;
        ImageView thumbnail;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            txtLocation = (TextView) itemView.findViewById(R.id.txtLocation);
            /*favourites = (ImageButton) itemView.findViewById(R.id.btnFavourite);*/
            thumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public TouristSitesRecyclerAdapter(ArrayList<TouristSitesDO> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,

                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_tourists_sites_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
            TouristSitesDO dao = mDataset.get(position);
        holder.label.setText(mDataset.get(position).getmText1());
        holder.dateTime.setText(mDataset.get(position).getmText2());
        holder.txtLocation.setText(mDataset.get(position).getmText3());
        holder.thumbnail.setImageResource(mDataset.get(position).getThumbnail());


    }

    public void addItem(TouristSitesDO dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}