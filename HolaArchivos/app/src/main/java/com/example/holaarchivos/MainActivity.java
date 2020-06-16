package com.example.holaarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void escribirArchivo(View view) {
        try {
            FileOutputStream fout = openFileOutput("prueba_int.txt", Context.MODE_PRIVATE);
            String texto = "Texto de prueba desde memoria interna";
            fout.write(texto.getBytes());
            fout.close();

            txtResultado.setText("Archivo creado!");
        } catch (Exception e) {
            Log.e("HolaArchivos","Excepcion: " + e.getMessage());
            txtResultado.setText("Erra un error !");
        }
    }


    public void leerArchivo(View view) {
        try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("prueba_int.txt")));
            String texto = fin.readLine();
            fin.close();

            txtResultado.setText(texto);
        } catch(Exception e) {

        }
    }

    public void escribirSD(View view) {
        boolean sdDisponisble = false;
        boolean sdAccesoEscritura = false;

        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponisble = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponisble = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponisble = false;
            sdAccesoEscritura = false;
        }
    }
}
