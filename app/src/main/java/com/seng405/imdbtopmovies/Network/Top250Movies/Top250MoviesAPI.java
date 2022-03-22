package com.seng405.imdbtopmovies.Network.Top250Movies;

import com.seng405.imdbtopmovies.Entity.TopMovieResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Top250MoviesAPI {

        @GET("Top250Movies/k_uq7ec3ar")
        Call<TopMovieResult> getTop250MoviesApi();
}
