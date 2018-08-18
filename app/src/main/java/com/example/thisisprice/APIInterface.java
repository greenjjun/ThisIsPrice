package com.example.thisisprice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("exchange")
    Call<Exchange> getExchange();

}
