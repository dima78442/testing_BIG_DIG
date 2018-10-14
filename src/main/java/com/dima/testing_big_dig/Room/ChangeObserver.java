package com.dima.testing_big_dig.Room;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import com.dima.testing_big_dig.Presenter.Presenter;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.HistoryRecyclerAdapter;


public class ChangeObserver extends ContentObserver{

    private HistoryRecyclerAdapter historyRecyclerAdapter;
    private Presenter presenter;

    public ChangeObserver(Handler handler, HistoryRecyclerAdapter historyRecyclerAdapter,
                          Presenter presenter) {
        super(handler);

        this.historyRecyclerAdapter = historyRecyclerAdapter;
        this.presenter = presenter;
    }

    @Override
    public void onChange(boolean selfChange) {
        this.onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        presenter.QueryRefernceList();
    }
}
