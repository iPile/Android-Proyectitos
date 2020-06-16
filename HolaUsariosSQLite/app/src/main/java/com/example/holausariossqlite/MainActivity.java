package com.example.holausariossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HolaUsuariosSQLiteHelper usdbh = new HolaUsuariosSQLiteHelper(this, "DBUsuarios", null, 2);

        SQLiteDatabase db = usdbh.getReadableDatabase();

        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Usuarios", null);

            if(c.moveToFirst()) {
                StringBuilder sb = new StringBuilder();

                do {
                    sb.append(c.getString(1));
                } while (c.moveToNext());

                String usuarios = sb.toString();

                TextView textView = findViewById(R.id.txt);
                textView.setText(usuarios);
            }
        }
    }
}
