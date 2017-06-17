package com.example.hi.retro;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hi on 25-05-2017.
 */

public interface EndApis {
    @GET("/JSONParsingTutorial/jsonActors")
    Call<ActorBean> getActorResponse();
}
