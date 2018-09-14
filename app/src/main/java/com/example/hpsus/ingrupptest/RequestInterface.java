package com.example.hpsus.ingrupptest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("/ins/")
    Call<JsonData> getJSON(@Query("id") int count);
}
