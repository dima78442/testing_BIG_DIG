package com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dima.testing_big_dig.R;
import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;

import java.util.ArrayList;



public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.MyViewHolder>{

    private ArrayList<Reference> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView url;
        TextView time;

        public MyViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            url = (TextView)itemView.findViewById(R.id.url);
            time = (TextView)itemView.findViewById(R.id.time);
        }
    }

    public HistoryRecyclerAdapter(ArrayList<Reference> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reference_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView url = holder.url;
        TextView time = holder.time;
        CardView cv = holder.cv;

        url.setText(dataSet.get(listPosition).getUrl());
        time.setText(dataSet.get(listPosition).getTimeAt());

        if(dataSet.get(listPosition).getStatus().equals("1")){
            cv.setBackgroundColor(Color.GREEN);
        }else if(dataSet.get(listPosition).getStatus().equals("2")){
            cv.setBackgroundColor(Color.RED);
        }else if(dataSet.get(listPosition).getStatus().equals("3")){
            cv.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

