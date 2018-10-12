package com.dima.testing_big_dig.View.fragments.History_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dima.testing_big_dig.Presenter.Presenter;
import com.dima.testing_big_dig.R;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.HistoryRecyclerAdapter;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.RecyclerOnClik.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class History extends Fragment{
    public History() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(llm);

        Presenter presenter = new Presenter(getActivity());
        ArrayList<Reference> references;
        references = presenter.QueryRefernceList();

        HistoryRecyclerAdapter historyRecyclerAdapter = new HistoryRecyclerAdapter(references);
        recyclerView.setAdapter(historyRecyclerAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(),"work",Toast.LENGTH_LONG).show();
                view.findViewById(R.id.cv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage("com.dima.testing_big_dig_b");
                        if (launchIntent != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("from","test");
                            bundle.putString("url","1");
                            bundle.putString("time",timeGetter());
                            launchIntent.putExtra("Reference",bundle);
                            startActivity(launchIntent);//null pointer check in case package name was not found
                        }
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
    public String timeGetter(){
        Date currentTime = Calendar.getInstance().getTime();
        return Long.toString(currentTime.getTime());
    }

}
