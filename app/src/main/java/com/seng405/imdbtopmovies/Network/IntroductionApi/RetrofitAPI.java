package com.seng405.imdbtopmovies.Network.IntroductionApi;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("/posts")
    Call<ResponseBody> getPosts();

    @GET("/users")
    Call<ResponseBody> getUsers();

    @POST("/user")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);

    @GET("/posts")
    Call<ResponseBody> getPostsByUser(@Query("userId") int userId);

    @GET("/posts")
    Call<ResponseBody> getPostsByUserAndPostId(@Query("userId") int userId, @Query("id") int postId);
}
