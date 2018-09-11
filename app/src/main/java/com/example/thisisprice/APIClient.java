package com.example.thisisprice;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.manana.kr/exchange/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
