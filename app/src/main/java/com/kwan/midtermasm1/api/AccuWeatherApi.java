package com.kwan.midtermasm1.api;

import com.kwan.midtermasm1.model.AccuWeatherHourlyTwelve;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccuWeatherApi {
    String DOMAIN = "http://dataservice.accuweather.com";

//    @GET("/forecasts/v1/hourly/12hour/353412")
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=vF2qA4zm5oFjtl5w4uJ1umvgvJS4gM2s&language=vi-vn&metric=true")
    Call<List<AccuWeatherHourlyTwelve>> getAccuWeather();
}
