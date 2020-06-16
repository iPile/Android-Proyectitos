package com.example.holalistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    String[] COUNTRIES = {"Argentina", "Bolivia", "Chile", "Colombia", "Peru"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.list_item, COUNTRIES);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
