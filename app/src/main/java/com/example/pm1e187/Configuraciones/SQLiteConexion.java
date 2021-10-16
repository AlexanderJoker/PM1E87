package com.example.pm1e187.Configuraciones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TContactos.CreateTableContactos);
        db.execSQL(TPaises.CreateTablePaises);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TContactos.DROPTABLEContactos);
        db.execSQL(TPaises.DROPTABLEPaises);
        onCreate(db);
    }
}
