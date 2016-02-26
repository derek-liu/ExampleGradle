package com.example.liudingyu.examplegradle.Network;

import com.example.liudingyu.examplegradle.Mode.Weather;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private IWeatherAPI mWeatherAPI;
    private static volatile ApiClient INSTANCE;

    public static ApiClient getInstance() {
        if (INSTANCE == null) {
            synchronized (ApiClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ApiClient();
                }
            }
        }
        return INSTANCE;
    }

    private ApiClient() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.heweather.com")
                .addConverterFactory(GsonConverterFactory.create());
        mWeatherAPI = builder.build().create(IWeatherAPI.class);
    }

    public Weather getWeather(String cityID, String key) {
        try {
            Call<Weather> call = mWeatherAPI.getWeather(cityID, key);
            return call.execute().body();
        } catch (Exception e) {
            return null;
        }
    }

}
