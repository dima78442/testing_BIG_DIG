package com.dima.testing_big_dig.Presenter;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;

import com.dima.testing_big_dig.Room.ChangeObserver;
import com.dima.testing_big_dig.Room.DB.DB_Organaizer;
import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;
import com.dima.testing_big_dig.View.fragments.History_fragment.recycler_adapter.HistoryRecyclerAdapter;

import java.util.ArrayList;

public class Presenter {

    private Activity activity;
    private DB_Organaizer db_organaizer;
    private ChangeObserver changeObserver;

    Uri DATA_URI = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts");

    public Presenter(Activity activity) {
        this.activity = activity;

        db_organaizer = new DB_Organaizer(activity);
    }

    public ArrayList<Reference> QueryRefernceList(){
        return db_organaizer.dataQuery();
    }

    public void setObserver(HistoryRecyclerAdapter historyRecyclerAdapter){
        changeObserver = new ChangeObserver(new Handler(),historyRecyclerAdapter,this);

        activity.getContentResolver().
                registerContentObserver(DATA_URI,true,changeObserver);
    }
    public void unsetObserver(){
        activity.getContentResolver().unregisterContentObserver(changeObserver);
    }

    public void resetObserver(){
        activity.getContentResolver()
                .registerContentObserver(DATA_URI,true,changeObserver);
    }
}
