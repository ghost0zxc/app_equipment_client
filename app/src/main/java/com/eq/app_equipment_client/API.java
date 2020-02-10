package com.eq.app_equipment_client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("Login")
    Call<ResponseBody> getJson(@Query("username") String username, @Query("password") String password);
    @GET("Register")
    Call<ResponseBody> getJson2(@Query("username") String username,@Query("password") String password);
    @GET("ShowEQ")
    Call<ResponseBody> getJson3(@Query("eqid") int eqid);
    @GET("UpdateEQ")
    Call<ResponseBody> getJson4(@Query("eqid") int eqid,@Query("status") int status);
}
