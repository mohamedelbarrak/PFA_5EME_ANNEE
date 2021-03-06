package com.myweb.smartshoppingapp.retrofit;

import com.myweb.smartshoppingapp.pojo.LoginRegistration;
import com.myweb.smartshoppingapp.pojo.Registration;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RegistrationEndPoint {


    @GET("/registration/list")
    Call<List<Registration>> getAllData();

    @GET("/Registration/{id}")
    Call<Optional<Registration>> getDataById(@Path("id") int id);

    @POST("/registration/add")
    Call<Map> putNewDataOnDb(@Body Registration registration);

    @POST("/registration/login/add")
    Call<Map> putNewDataOnDb(@Body LoginRegistration loginRegistration);

    @PUT("/Registration/update")
    Call<Map> updateDataOnDb(@Body Registration registration);

    @DELETE("/Registration/delete")
    Call<Map> deleteDataOnDb(@Body Registration registration);

    //http://192.168.1.6:8080/books/"+a+"/true
    @PUT("/books/{id}/true")
    Call<Map> update(@Path("id") int id);

    @PUT("/books/{id}/false")
    Call<Map> update1(@Path("id") int id);

}
