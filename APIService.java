package com.example.hi.retro;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.Callback;
/**
 * Created by Hi on 11-06-2017.
 */

public interface APIService {

            @FormUrlEncoded
            @POST("/android_login_api/register.php")
                    Call<MSG> userSignUp(@Field("name") String name,
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("/android_login_api/login.php")
    Call<MSG> userLogIn(@Field("email") String email,
                        @Field("password") String password);
}
