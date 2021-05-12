package com.kwan.midtermasm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwan.midtermasm1.adapter.AccuWeatherAdapter;
import com.kwan.midtermasm1.api.AccuWeatherApi;
import com.kwan.midtermasm1.model.AccuWeatherHourlyTwelve;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<AccuWeatherHourlyTwelve> data;
    RecyclerView rvAccuWeatherList;
    AccuWeatherAdapter accuWeatherAdapter;
    TextView tvWeatherDescription;
    TextView tvAveTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_hour_list);

        // init text view
        tvWeatherDescription = findViewById(R.id.tvWeatherDescription);
        tvAveTemp = findViewById(R.id.tvAveTemp);

        // get data source
        getData();

        // adapter
        data = new ArrayList<>();
        accuWeatherAdapter = new AccuWeatherAdapter(MainActivity.this, data);

        // layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        // recycleView
        rvAccuWeatherList = findViewById(R.id.rvAccuWeatherList);
        rvAccuWeatherList.setLayoutManager(layoutManager);
        rvAccuWeatherList.setAdapter(accuWeatherAdapter);
    }

    public void getData() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AccuWeatherApi.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AccuWeatherApi service = retrofit.create(AccuWeatherApi.class);

        service.getAccuWeather().enqueue(new Callback<List<AccuWeatherHourlyTwelve>>() {
            @Override
            public void onResponse(Call<List<AccuWeatherHourlyTwelve>> call, Response<List<AccuWeatherHourlyTwelve>> response) {
                if(response.body() != null) {
                    data = response.body();

                    tvWeatherDescription.setText(data.get(0).getIconPhrase());

                    // set average temp
                    float ave = 0;
                    for(AccuWeatherHourlyTwelve accuWeatherHourlyTwelve: data) {
                        ave += accuWeatherHourlyTwelve.getTemperature().getValue()/data.size();
                    }

                    DecimalFormat df = new DecimalFormat("#.#");

                    tvAveTemp.setText(String.valueOf(df.format(ave)) + "°");

                    accuWeatherAdapter.reloadData(data);
                }
            }

            @Override
            public void onFailure(Call<List<AccuWeatherHourlyTwelve>> call, Throwable t) {
                Log.d("WEATHER", "onFailure: " + t);
            }
        });
    }
}