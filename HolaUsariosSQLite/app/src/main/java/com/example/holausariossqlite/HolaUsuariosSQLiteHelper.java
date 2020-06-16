package com.example.holausariossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HolaUsuariosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Usuarios (codigo Integer, nombre Text)";

    public HolaUsuariosSQLiteHelper(@Nullable Context context,
                                    @Nullable String name,
                                    @Nullable SQLiteDatabase.CursorFactory factory,
                                    int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

        for (int i = 1; int <= 6; i++) {
            int codigo = i;
            String nombre = "Usuario " + i;

            db.execSQL("Insert INTO Usuarios (codigo, nombre) VALUES (" + codigo + ", '" + nombre + "')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        db.execSQL(sqlCreate);

        for (int i = 1; int <= 6; i++) {
            int codigo = i;
            String nombre = "Usuario " + i;

            db.execSQL("Insert INTO Usuarios (codigo, nombre) VALUES (" + codigo + ", '" + nombre + "')");
        }
    }
}
