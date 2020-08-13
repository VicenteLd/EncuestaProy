package com.example.encuestaproy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class listcar extends AppCompatActivity {
    Button busc;
    String Carrera = "";
    private Spinner spinner;

    String carreras[] = {"Ingeniería Industrial","Ingeniería en Energía", "Ingeniería en Tecnologías de la Información" ,"Ingeniería en Electrónica y Telecomunicaciones"};

    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcar);
        busc = (Button) findViewById(R.id.busc);
        spinner = (Spinner) findViewById(R.id.spinner4);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, carreras);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Carrera = "II";
                        break;
                    case 1:
                        Carrera = "IE";
                        break;
                    case 2:
                        Carrera = "ITI";
                        break;
                    case 3:
                        Carrera = "IET";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        busc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), listado1.class);
                i.putExtra("carrera",Carrera);
                startActivity(i);


            }
        });

    }



}
