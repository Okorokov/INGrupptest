package com.example.hpsus.ingrupptest;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String  KEY_ID="KEY_ID";
    public static String  KEY_NAME="KEY_NAME";
    public static String  KEY_DES="KEY_DES";
    public static String  KEY_LOGO="KEY_LOGO";
    public static String  KEY_URL="KEY_URL";
    public static String  KEY_BTN="KEY_BTN";
    public static String  KEY_BTN2="KEY_BTN2";
    public static String  KEY_BROWSER="KEY_BROWSER";
    public static String  KEY_ENABLED="KEY_ENABLED";
    public static String  KEY_DESC_FULL="KEY_DESC_FULL";

    private List<Offer> data = new ArrayList<>();
    private static RequestInterface requestInterface;
    private DataAdapter adapter;
    private RecyclerView recyclerView;
    private String info;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sandytrast.info")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("Error",retrofit.baseUrl().url().toString());
        RequestInterface request = retrofit.create(RequestInterface.class);

        Call<JsonData> call = request.getJSON(1);
        call.enqueue(new Callback<JsonData>() {
            @Override
            public void onResponse(Call<JsonData> call, Response<JsonData> response) {
                try {

                    name=response.body().getName();
                    getSupportActionBar().setTitle(response.body().getName());
                    info=response.body().getInfo();

                    data = response.body().getOffers();
                    Log.d("Error","data  :  " + data.size());
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);
                } catch (Exception e) {
                    Log.d("Error", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonData> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.info) {
            Toast.makeText(this, info,Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        private boolean isNetworkAvailable() {

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

        }
}
