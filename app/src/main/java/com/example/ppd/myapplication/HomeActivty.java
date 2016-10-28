package com.example.ppd.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ppd.myapplication.api.ApiInterface;
import com.example.ppd.myapplication.api.BaseClass;
import com.example.ppd.myapplication.api.MyApplication;
import com.example.ppd.myapplication.databinding.ActivityHomeBinding;
//import com.example.ppd.myapplication.model.List<MovieRequest>
import com.example.ppd.myapplication.model.MovieRequest;
import com.example.ppd.myapplication.model.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anish on 28-10-2016.
 */
public class HomeActivty extends AppCompatActivity
{

    ActivityHomeBinding activityHomeBinding;
    List<Url> urlList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ApiInterface service= MyApplication.retrofit.create(ApiInterface.class);
        Call<List<MovieRequest>> movieRequestCall=service.getMovies();
        movieRequestCall.enqueue(new Callback<List<MovieRequest>>() {
            @Override
            public void onResponse(Call<List<MovieRequest>> call, Response<List<MovieRequest>> response) {


                Log.e("1-->",response.code()+"");
            }

            @Override
            public void onFailure(Call<List<MovieRequest>> call, Throwable t) {
                Log.e("2-->","failed");

            }
        });
    }
}
