package com.example.encuestaproy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.encuestaproy.adapter.adapterCarr;
import com.example.encuestaproy.entidades.VolleySingleton;
import com.example.encuestaproy.entidades.alumnos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listado2 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    //TextView txt;
    RecyclerView recyclerAlumnos;
    ArrayList<alumnos> listaAlumnos;
    ProgressDialog progress;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado2);

        listaAlumnos =new ArrayList<>();

        recyclerAlumnos = (RecyclerView) findViewById(R.id.idRecycler);
        recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerAlumnos.setHasFixedSize(true);

        String dato = getIntent().getStringExtra("carrera");

        cargarWebService(dato);

        //txt = (TextView) findViewById(R.id.prueba);

        //txt.setText(dato);
    }

    private void cargarWebService(String carrera) {

        String url = "https://chronox.me/trayectoria/web_service/php_c2/listadocarr.php?carrera=" + carrera;
        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "NO EXISTE NINGUN ALUMNO REGISTRADO", Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {
        alumnos alumno = null;

        JSONArray json=response.optJSONArray("usuario");

        try {

            for (int i=0;i<json.length();i++){
                alumno =new alumnos();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                alumno.setMatricula(jsonObject.optString("nocuenta"));
                alumno.setNombre(jsonObject.optString("alumno"));
                alumno.setTutor(jsonObject.optString("Tutor"));
                listaAlumnos.add(alumno);
            }

            adapterCarr adapter=new adapterCarr(listaAlumnos);
            recyclerAlumnos.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
            progress.hide();
        }

    }
}
