package com.example.kolmonen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
/*
        En saanut tehtyä loppuun, vaikka kuusi tuntia tähän käytin;( Tulostus ei suostu toiminaan jostain syystä.
 */
public class MainActivity extends AppCompatActivity {
     Button button;
     ListView listView;
     ArrayList<Date> aika;
     ArrayAdapter<Date> dateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.Nappi);
        listView = findViewById(R.id.Lista);

        aika = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Hello");
                alertDialog.setMessage("Add current time to the list");

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Calendar calendar = new GregorianCalendar();
                        aika.add(calendar.getTime());

                    }
                });
            alertDialog.show();
            }
        });

        dateAdapter = new ArrayAdapter<>(this, R.layout.adapter_view_layout, aika);
        listView.setAdapter(dateAdapter);

    }
}
