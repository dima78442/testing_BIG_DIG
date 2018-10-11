package com.dima.testing_big_dig.View.fragments.History_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dima.testing_big_dig.R;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.HistoryRecyclerAdapter;

import java.util.ArrayList;

public class History extends Fragment {
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
        ArrayList<Reference> arrayList = new ArrayList<Reference>();
        for (int i = 0; i < 10; i++) {
            Reference reference = new Reference().newBuilder().setUrl("this").setStatus(1).setTimeAt("10.01").build();
            arrayList.add(reference);
        }
        HistoryRecyclerAdapter historyRecyclerAdapter = new HistoryRecyclerAdapter(arrayList);
        recyclerView.setAdapter(historyRecyclerAdapter);
    }
}
