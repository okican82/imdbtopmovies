package com.seng405.imdbtopmovies.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.seng405.imdbtopmovies.Entity.TopMovieResult;
import com.seng405.imdbtopmovies.databinding.ActivityMainBinding;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class MainActivity extends Activity {


    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.openClassicWayActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openClassicWayActivity();
            }
        });

        activityMainBinding.openDifferentClassApiCallActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDifferentClassAPICall();
            }
        });

        activityMainBinding.openIntroductionActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntroductionActivity();
            }
        });

    }

    private void openIntroductionActivity()
    {
        startActivity(new Intent(MainActivity.this,IntroductionRetrofitActivity.class));
    }

    private void openDifferentClassAPICall() {
        startActivity(new Intent(MainActivity.this,CallAPIDifferentClassActivity.class));
    }

    private void openClassicWayActivity(){
        startActivity(new Intent(MainActivity.this,ClassicAPICallActivity.class));
    }



}