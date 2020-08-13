package com.example.encuestaproy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private CardView cv_graficaiti, cv_graficaiti2, cv_graficaie, cv_graficaie2, cv_graficaii, cv_graficaii2, cv_graficaiet, cv_graficaiet2, cv_listcar, cv_listcar2, cv_listutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //DEFINIMOS
        cv_graficaiti = (CardView) findViewById(R.id.cv_graficaiti);
        cv_graficaie = (CardView) findViewById(R.id.cv_graficaie);
        cv_graficaii = (CardView) findViewById(R.id.cv_graficaii);
        cv_graficaiet = (CardView) findViewById(R.id.cv_graficaiet);
        cv_listcar = (CardView) findViewById(R.id.cv_listcar);
        cv_graficaiti2 = (CardView) findViewById(R.id.cv_graficaiti2);
        cv_graficaii2 = (CardView) findViewById(R.id.cv_graficaii2);
        cv_graficaie2 = (CardView) findViewById(R.id.cv_graficaie2);
        cv_graficaiet2 = (CardView) findViewById(R.id.cv_graficaiet2);
        cv_listcar2 = (CardView) findViewById(R.id.cv_listcar2);

        //cv_listutor = (CardView) findViewById(R.id.cv_listutor);

        //IMPLEMENTAMOS EL CLICK DE CADA CARDVIEW
        cv_graficaiti.setOnClickListener(this);
        cv_graficaie.setOnClickListener(this);
        cv_graficaii.setOnClickListener(this);
        cv_graficaiet.setOnClickListener(this);
        cv_listcar.setOnClickListener(this);
        cv_graficaiti2.setOnClickListener(this);
        cv_graficaii2.setOnClickListener(this);
        cv_graficaie2.setOnClickListener(this);
        cv_graficaiet2.setOnClickListener(this);
        cv_listcar2.setOnClickListener(this);
        //cv_listutor.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.cv_graficaiti : i = new Intent(this,graficaiti.class); startActivity(i); break;
            case R.id.cv_graficaie : i = new Intent(this,graficaie.class); startActivity(i); break;
            case R.id.cv_graficaii : i = new Intent(this,graficaii.class); startActivity(i); break;
            case R.id.cv_graficaiet : i = new Intent(this,graficaiet.class); startActivity(i); break;
            case R.id.cv_listcar : i = new Intent(this,listcar.class); startActivity(i); break;
            case R.id.cv_listcar2 : i = new Intent(this,listcar2.class); startActivity(i); break;
            case R.id.cv_graficaiti2 : i = new Intent(this,graficaiti2.class); startActivity(i); break;
            case R.id.cv_graficaii2 : i = new Intent(this,graficaii2.class); startActivity(i); break;
            case R.id.cv_graficaie2 : i = new Intent(this,graficaie2.class); startActivity(i); break;
            case R.id.cv_graficaiet2 : i = new Intent(this,graficaiet2.class); startActivity(i); break;
            //case R.id.cv_listutor : i = new Intent(this,listutor.class); startActivity(i); break;
            default:break;
        }
    }
}
