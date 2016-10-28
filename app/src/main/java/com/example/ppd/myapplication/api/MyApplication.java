package com.example.ppd.myapplication.api;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anish on 28-10-2016.
 */
public class MyApplication extends Application
{
    public static final String BASE_URL="http://api.androidhive.info/";
    public static Retrofit retrofit=null;

    @Override
    public void onCreate() {
        super.onCreate();


        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }
}
