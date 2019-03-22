package com.moaaz.task001.API.Model;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofitInstance;


    private static Retrofit getInstance() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.e("api", message);
                    }
                });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();


        if (retrofitInstance == null) {
            //create instance
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://souq.hardtask.co/app/app.asmx/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }

        return retrofitInstance;

    }


    public static Services getAPIs() {

        return getInstance().create(Services.class);
    }


}
