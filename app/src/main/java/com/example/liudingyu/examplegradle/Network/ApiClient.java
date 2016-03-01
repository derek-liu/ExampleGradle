package com.example.liudingyu.examplegradle.Network;

import com.example.liudingyu.examplegradle.Mode.Weather;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient extends ApiClientErrorHandler {

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
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                // add common parameter
                HttpUrl url = request.url().newBuilder().addQueryParameter("name", "commomparamater").build();
                request = request.newBuilder().url(url).build();
                return handleHTTPError(chain.proceed(request));
            }
        };
        OkHttpClient client = clientBuilder
                .addInterceptor(interceptor)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.heweather.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client);
        mWeatherAPI = builder.build().create(IWeatherAPI.class);
    }

    public Weather getWeather(String cityID, String key) {
        try {
            Call<Weather> call = mWeatherAPI.getWeather(cityID, key);
            Request request = call.request();
            retrofit2.Response<Weather> response = call.execute();
            return (Weather) handleStatusError(request, response.body());
        } catch (Exception e) {
            handleRuntimeException(e);
            return null;
        }
    }


    public Weather postWeather(String cityID, String key) {
        try {
            Weather weather = new Weather();
            weather.weather = "post test";
            Call<Weather> call = mWeatherAPI.postWeather(cityID, key, weather);
            Request request = call.request();
            retrofit2.Response<Weather> response = call.execute();
            return (Weather)handleStatusError(request, response.body());
        } catch (Exception e) {
            handleRuntimeException(e);
            return null;
        }
    }

}
