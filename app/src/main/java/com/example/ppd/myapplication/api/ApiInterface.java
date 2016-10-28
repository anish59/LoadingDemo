package com.example.ppd.myapplication.api;

import com.example.ppd.myapplication.model.MovieRequest;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

/**
 * Created by anish on 28-10-2016.
 */
public interface ApiInterface
{
    @GET("json/glide.json")
    Call<List<MovieRequest>> getMovies();
}
