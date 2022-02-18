package com.myweb.smartshoppingapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface BaseEndPoint {
//192.168.56.1
    String BASE_URL = "http://192.168.56.1:8080";//"http://192.168.86.1:8080";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
