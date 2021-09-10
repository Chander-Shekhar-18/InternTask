package com.example.interntask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private static final String JSON_URL = "https://restcountries.eu/rest/v2/region/asia";

    private Adapter adapter;
    private ArrayList<ExampleItem> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mExampleList = new ArrayList<>();

        extractData();
    }

    private void extractData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(MainActivity.this, "Data Fetched Successfully", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String imgFlag = jsonObject.getString("flag");
                                String countryName = jsonObject.getString("name");
                                String capitalName = jsonObject.getString("capital");
                                String region = jsonObject.getString("region");
                                String subRegion = jsonObject.getString("subregion");
                                String population = jsonObject.getString("population");

                                mExampleList.add(new ExampleItem(imgFlag, countryName, capitalName, region, subRegion, population));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new Adapter(MainActivity.this, mExampleList);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
    }
}


















