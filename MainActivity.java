package com.example.hi.retro;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.LinearLayoutManager.*;

public class MainActivity extends AppCompatActivity {
    Retrofit mRetrofit;
    String BASE_URL="http://microblogging.wingnity.com/";
    ListView listView;
    RecyclerView mList;
    MeraAdapter adapter;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList= (RecyclerView) findViewById(R.id.list_list);

        mRetrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();

        EndApis endApis=mRetrofit.create(EndApis.class);
        Call<ActorBean> mBeans=endApis.getActorResponse();
        mBeans.enqueue(new Callback<ActorBean>(){

            @Override
            public void onResponse(Call<ActorBean> call, Response<ActorBean> response) {
                int status=response.code();
                Log.e(">>>","on response....."+ status);
                Actors actors[] = response.body().getActors();
                try {
                    for (int i = 0; i <= actors.length; i++) {

                        Log.e(">>>", actors[i].getDescription());
                        Log.e(">>>", actors[i].getHeight());
                        Log.e(">>>", actors[i].getSpouse());
                        Log.e(">>>", actors[i].getImage());


                    }
                }catch (Exception e){

                }
                adapter = new MeraAdapter(MainActivity.this,actors);
                manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                //GridLayoutManager manager=new GridLayoutManager(MainActivity.this,1);
                mList.setLayoutManager(manager);
                mList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ActorBean> call, Throwable t) {

            }
        });


    }
}
