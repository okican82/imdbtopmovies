package com.seng405.imdbtopmovies.Activities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.seng405.imdbtopmovies.Network.IntroductionApi.RetrofitAPI;
import com.seng405.imdbtopmovies.databinding.ActivityIntroductionRetrofitBinding;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IntroductionRetrofitActivity extends AppCompatActivity {

    ActivityIntroductionRetrofitBinding activityIntroductionRetrofitBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIntroductionRetrofitBinding = ActivityIntroductionRetrofitBinding.inflate(getLayoutInflater());
        View view = activityIntroductionRetrofitBinding.getRoot();
        setContentView(view);


        activityIntroductionRetrofitBinding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleGet();
            }
        });

        activityIntroductionRetrofitBinding.getUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUsers();
            }
        });

        activityIntroductionRetrofitBinding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postUser();
            }
        });

        activityIntroductionRetrofitBinding.getUserByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserById("1");
            }
        });

        activityIntroductionRetrofitBinding.getUserByIdAndPostIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPostByUserIdAndPostId();
            }
        });
    }

    private void getPostByUserIdAndPostId() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostsByUserAndPostId(1,2).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d(TAG, "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void getUserById(String s) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPostsByUser(1).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d(TAG, "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void postUser()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        String jsonBody = "{\"id\":100,\"name\":\"Okay YILDIRIM\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        retrofitAPI.postUser(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String myResponse = response.body().string();
                    Log.d(TAG, "onResponse: ");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void getUsers()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getUsers().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d(TAG, "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void simpleGet()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        retrofitAPI.getPosts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String myResponse = response.body().string();
                        Log.d(TAG, "onResponse: ");
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }


}