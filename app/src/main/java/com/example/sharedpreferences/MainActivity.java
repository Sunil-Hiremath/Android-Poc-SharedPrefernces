package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);//login is the name under which the key value pair is stored.
                Boolean check=pref.getBoolean("flag",false);
                Log.d("flag vlaue",check.toString());
                Intent iNext;
                if(check){// for true when user is logged in
                    iNext=new Intent(MainActivity.this,HomeActivity.class);

                }
                else {// either first time or user is logged out

                    iNext=new Intent(MainActivity.this,LoginActivity.class);

                }
                startActivity(iNext);
            }
        },4000);
    }
}