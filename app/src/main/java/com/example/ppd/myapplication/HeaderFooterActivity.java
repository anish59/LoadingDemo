package com.example.ppd.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ppd.myapplication.adpater.MovieAdapter;
import com.example.ppd.myapplication.api.ApiInterface;
import com.example.ppd.myapplication.api.MyApplication;
import com.example.ppd.myapplication.databinding.ActivityHomeBinding;
import com.example.ppd.myapplication.databinding.ActivityHomeTwoBinding;
import com.example.ppd.myapplication.model.MovieRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anish on 03-11-2016.
 */
public class HeaderFooterActivity extends AppCompatActivity
{
    ActivityHomeTwoBinding activityHomeTwoBinding;
    List<MovieRequest> movieItems;
    MovieAdapter movieAdapter;
    CatLoadView mCatView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       activityHomeTwoBinding= DataBindingUtil.setContentView(this,R.layout.activity_home_two);
        ApiInterface service= MyApplication.retrofit.create(ApiInterface.class);
        Call<List<MovieRequest>> movieRequestCall=service.getMovies();

        mCatView.show(getSupportFragmentManager(),"");
        movieRequestCall.enqueue(new Callback<List<MovieRequest>>() {
            @Override
            public void onResponse(Call<List<MovieRequest>> call, Response<List<MovieRequest>> response) {
                mCatView.dismiss();

                Log.e("1-->",response.code()+"");

               /* Log.d("name", "onResponse: "+response.body().get(1).getName());
                Log.d("timeStamp", "onResponse: "+response.body().get(1).getTimestamp());
              //  Log.d("url", "onResponse: "+response.body().get(1).getUrl().getSmall());*/


                for(int i=0;i<response.body().size();i++)
                {
                    movieItems.add(response.body().get(i));
                }

                movieAdapter.setItems(movieItems);
            }

            @Override
            public void onFailure(Call<List<MovieRequest>> call, Throwable t) {
                Log.e("2-->","failed");

            }

        });


    }
}
