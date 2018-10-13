package com.dima.testing_big_dig.View.fragments.History_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dima.testing_big_dig.Presenter.Presenter;
import com.dima.testing_big_dig.R;
import com.dima.testing_big_dig.View.fragments.History_fragment.HistorySort.ComparatorStatus;
import com.dima.testing_big_dig.View.fragments.History_fragment.HistorySort.ComparatorTime;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.HistoryRecyclerAdapter;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.RecyclerOnClik.RecyclerItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class History extends Fragment{
    public static ArrayList<Reference> references;
    private HistoryRecyclerAdapter historyRecyclerAdapter;

    public History() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.history,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(llm);

        Presenter presenter = new Presenter(getActivity());
        references = presenter.QueryRefernceList();

        historyRecyclerAdapter = new HistoryRecyclerAdapter(references);
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
                            CardView cardView = (CardView)view.findViewById(R.id.cv);
                            TextView url = view.findViewById(R.id.url);
                            TextView id = view.findViewById(R.id.id_reference);
                            TextView status = view.findViewById(R.id.status_reference);
                            Bundle bundle = new Bundle();
                            bundle.putString("id",id.getText().toString());
                            bundle.putString("from","history");
                            bundle.putString("status",status.getText().toString());
                            bundle.putString("url",url.getText().toString());
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
        String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Log.d("tm","" + currentDateandTime);
        return currentDateandTime;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("MENU",item.getTitle().toString());
        if (item.getTitle().equals("sort1")) {
            Log.d("1","status");
            references.sort(ComparatorStatus.sort_status);
            historyRecyclerAdapter.notifyDataSetChanged();
        }else if (item.getTitle().equals("sort2")) {
            Log.d("1","date");
            references.sort(ComparatorTime.sort_time);
            historyRecyclerAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
