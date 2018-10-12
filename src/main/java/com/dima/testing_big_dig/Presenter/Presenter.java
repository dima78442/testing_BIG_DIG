package com.dima.testing_big_dig.Presenter;

import android.app.Activity;

import com.dima.testing_big_dig.Room.DB.DB_Organaizer;
import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;

import java.util.ArrayList;

public class Presenter {

    private Activity activity;
    private DB_Organaizer db_organaizer;

    public Presenter(Activity activity) {
        this.activity = activity;
        db_organaizer = new DB_Organaizer(activity);
    }

    public ArrayList<Reference> QueryRefernceList(){
        return db_organaizer.dataQuery();
    }


}
