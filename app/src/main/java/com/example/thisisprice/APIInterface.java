package com.example.thisisprice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("rate.json")
    Call<List<ExchangeData>> getExchange();

}
