package com.example.liudingyu.examplegradle.Network;

import com.example.liudingyu.examplegradle.Mode.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeatherAPI {
    @GET("/x3/weather")
    Call<Weather> getWeather(@Query("cityid") String cityid, @Query("key") String key);
}