package com.dima.testing_big_dig.Room.DB;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.dima.testing_big_dig.View.fragments.History_fragment.Reference;

import java.util.ArrayList;

public class DB_Organaizer {

    private Activity activity;
    private int id;
    private String url;
    private String time;
    private String status;
    private ArrayList<Reference> references = new ArrayList<>();

    public DB_Organaizer(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Reference> dataQuery(){
        Uri DATA_URI = Uri
                .parse("content://ru.startandroid.providers.AdressBook/contacts");
        Cursor c = activity.getContentResolver().query(DATA_URI, null, null,
                null, null);
        //activity.startManagingCursor(c);

        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("_id");
            int nameColIndex = c.getColumnIndex("url");
            int emailColIndex = c.getColumnIndex("time");
            int statusColIndex = c.getColumnIndex("status");
            //int statusColIndex = c.getColumnIndex("status");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                id = c.getInt(idColIndex);
                url = c.getString(nameColIndex);
                time = c.getString(emailColIndex);
                status = c.getString(statusColIndex);
               // status = c.getString(statusColIndex);
                Log.d("RX",
                        "ID = " + c.getInt(idColIndex) +
                                ", name = " + c.getString(nameColIndex) +
                                ", email = " + c.getString(emailColIndex));
                Reference reference = new Reference().newBuilder().setUrl(url).setTimeAt(time).setStatus(status).setId(id).build();
                references.add(reference);
            } while (c.moveToNext());
        } else
            Log.d("RX", "0 rows");
        c.close();
        return references;
    }

}
