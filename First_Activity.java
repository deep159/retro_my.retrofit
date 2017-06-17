package com.example.hi.retro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_Activity extends AppCompatActivity implements View.OnClickListener {
Button Retrofit_json,Retrofit_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_);
        Retrofit_json= (Button) findViewById(R.id.retrofitjson);
        Retrofit_signup= (Button) findViewById(R.id.retrofitsignup);
        Retrofit_json.setOnClickListener(this);
        Retrofit_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.retrofitjson){
            Intent intent=new Intent(First_Activity.this,MainActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.retrofitsignup){
            Intent intent=new Intent(First_Activity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }
}
