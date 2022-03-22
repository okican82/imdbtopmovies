package com.seng405.imdbtopmovies.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.seng405.imdbtopmovies.Entity.TopMovieResult;
import com.seng405.imdbtopmovies.databinding.ActivityClassicApicallBinding;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class ClassicAPICallActivity extends AppCompatActivity {

    ActivityClassicApicallBinding activityClassicApicallBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityClassicApicallBinding = ActivityClassicApicallBinding.inflate(getLayoutInflater());
        View view = activityClassicApicallBinding.getRoot();
        setContentView(view);

        activityClassicApicallBinding.getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

    }

    private void getData()
    {
        showProgress();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://imdb-api.com/API/")
                .build();
        Api api = retrofit.create(Api.class);
        api.getTop250Movies().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                hideProgress();
                try
                {
                    String myResponse = response.body().string();
                    TopMovieResult topMovieResults = new Gson().fromJson(myResponse, TopMovieResult.class);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                hideProgress();
            }
        });
    }

    interface Api
    {
        @GET("Top250Movies/k_uq7ec3ar")
        Call<ResponseBody> getTop250Movies();
    }

    private void showProgress()
    {
        activityClassicApicallBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress()
    {
        activityClassicApicallBinding.progressBar.setVisibility(View.GONE);
    }



}