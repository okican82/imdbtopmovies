package com.seng405.imdbtopmovies.Network.Top250Movies;

import com.google.gson.Gson;
import com.seng405.imdbtopmovies.Entity.TopMovieResult;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Top250MoviesAPICall {

    private Top250ApiCallListener top250ApiCallListener;

    public Top250MoviesAPICall(Top250ApiCallListener top250ApiCallListener) {
        this.top250ApiCallListener = top250ApiCallListener;
    }

    public void getMovies()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://imdb-api.com/API/")
                .build();
        Top250MoviesAPI api = retrofit.create(Top250MoviesAPI.class);
        api.getTop250MoviesApi().enqueue(new Callback<TopMovieResult>() {
            @Override
            public void onResponse(Call<TopMovieResult> call, Response<TopMovieResult> response) {
                TopMovieResult topMovieResults = response.body();
                top250ApiCallListener.onSuccess();
            }

            @Override
            public void onFailure(Call<TopMovieResult> call, Throwable t) {
                top250ApiCallListener.onFail();
            }
        });
    }

}
