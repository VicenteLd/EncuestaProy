package com.example.encuestaproy;

import androidx.appcompat.app.AppCompatActivity;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.SliceValue;
import android.graphics.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class graficaiet2 extends AppCompatActivity {
    PieChartView pieChartView;
    RequestQueue requestQueue;
    public int FN;
    public int PN;
    public int NF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficaiet);

        imprimirgrafica("https://chronox.me/trayectoria/web_service/php_c2/ietencuestaFN.php");
    }

    public void imprimirgrafica(String URL){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        if (i==0){
                            PN = jsonObject.getInt("PN");
                        }
                        if (i==1) {
                            NF = jsonObject.getInt("NF");
                        }
                        if (i==2){
                            FN = jsonObject.getInt("FN");
                        }
                        //nombre = "hola";
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "hola", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                PieChartView pieChartView = findViewById(R.id.chart3);

                pieChartView = findViewById(R.id.chart3);

                List pieData = new ArrayList<>();
                pieData.add(new SliceValue(FN, Color.GREEN).setLabel("#"+FN));
                pieData.add(new SliceValue(PN, Color.RED).setLabel("#"+PN));
                pieData.add(new SliceValue(NF, Color.GRAY).setLabel("#"+NF));

                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(14);
                pieChartData.setHasCenterCircle(true).setCenterText1("[ROJO = PENDIENTE] [VERDE = FINALIZADO]").setCenterText1FontSize(10).setCenterText1Color(Color.parseColor("#0097A7"));
                pieChartData.setHasCenterCircle(true).setCenterText2("[GRIS = NO FINALIZADO]").setCenterText2FontSize(10).setCenterText2Color(Color.parseColor("#0097A7"));
                pieChartView.setPieChartData(pieChartData);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
        //return nombre;
    }
}
