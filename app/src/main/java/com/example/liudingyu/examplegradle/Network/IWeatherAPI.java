package com.example.liudingyu.examplegradle.Network;

import com.example.liudingyu.examplegradle.Mode.Weather;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IWeatherAPI {
    @GET("/x3/weather")
    Call<Weather> getWeather(@Query("cityid") String cityid, @Query("key") String key);

    @POST("/x3/weather/post")
    Call<Weather> postWeather(@Query("cityid") String cityid, @Query("key") String key, @Body Weather weather);
}