package com.seng405.imdbtopmovies.Activities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.seng405.imdbtopmovies.Network.Top250Movies.Top250ApiCallListener;
import com.seng405.imdbtopmovies.Network.Top250Movies.Top250MoviesAPICall;
import com.seng405.imdbtopmovies.databinding.ActivityClassicApicallBinding;

public class CallAPIDifferentClassActivity extends AppCompatActivity implements Top250ApiCallListener {
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
        Top250MoviesAPICall top250MoviesAPICall = new Top250MoviesAPICall(this);
        top250MoviesAPICall.getMovies();
    }

    private void showProgress()
    {
        activityClassicApicallBinding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress()
    {
        activityClassicApicallBinding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {
        hideProgress();
        Log.d(TAG, "onSuccess: ");
    }

    @Override
    public void onFail() {
        hideProgress();
        Log.d(TAG, "onFail: ");
    }

    @Override
    public void onSerializeError() {
        hideProgress();
        Log.d(TAG, "onSerializeError: ");
    }
}