package com.dima.testing_big_dig.Room;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final String LOG_TAG = "myLogs";

    // // Константы для БД
    // БД
    static final String DB_NAME = "mydb";
    static final int DB_VERSION = 1;

    // Таблица
    static final String DATA_TABLE = "contacts";

    // Поля
    static final String DATA_ID = "_id";
    static final String DATA_URL = "url";
    static final String DATA_STATUS = "status";
    static final String DATA_TIME = "time";
    //static final String CONTACT_EMAIL = "email";

    // Скрипт создания таблицы
    static final String DB_CREATE = "create table " + DATA_TABLE + "("
            + DATA_ID + " integer primary key autoincrement, "
            + DATA_URL + " text, " + DATA_STATUS + " text, " + DATA_TIME + " text" + ");";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        ContentValues cv = new ContentValues();
        for (int i = 1; i <= 3; i++) {
            cv.put(DATA_URL, "url " + i);
            cv.put(DATA_STATUS, "status " + i);
            cv.put(DATA_TIME, "time" + i);
            db.insert(DATA_TABLE, null, cv);
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
