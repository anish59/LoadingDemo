package com.example.ppd.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ppd.myapplication.adpater.MovieAdapter;
import com.example.ppd.myapplication.api.ApiInterface;
import com.example.ppd.myapplication.api.MyApplication;
import com.example.ppd.myapplication.databinding.ActivityHomeBinding;
//import com.example.ppd.myapplication.model.List<MovieRequest>
import com.example.ppd.myapplication.helperClass.CheckNetwork;
import com.example.ppd.myapplication.model.MovieRequest;


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
    List<MovieRequest> movieItems;
    MovieAdapter movieAdapter;
    CatLoadView mCatView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        activityHomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        mCatView=new CatLoadView();


        ApiInterface service= MyApplication.retrofit.create(ApiInterface.class);
        Call<List<MovieRequest>> movieRequestCall=service.getMovies();
        if(CheckNetwork.isInternetAvailable(HomeActivty.this)) //returns true if internet available
        {
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
            init();
        }
        else
        {
            Toast.makeText(HomeActivty.this, "Please Check Internet", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    private void init()
    {
        movieItems=new ArrayList<MovieRequest>();

        movieAdapter= new MovieAdapter(movieItems,this);

        activityHomeBinding.rvList.setLayoutManager(new GridLayoutManager(this,3));
        activityHomeBinding.rvList.setAdapter(movieAdapter);


    }

    public void GridSelected(View view) {
        activityHomeBinding.rvList.setLayoutManager(new GridLayoutManager(this,3));
        activityHomeBinding.rvList.setAdapter(movieAdapter);

    }

    public void linearSelected(View view) {

       //activityHomeBinding.rvList.setLayoutManager(new LinearLayoutManager(this));
        activityHomeBinding.rvList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        activityHomeBinding.rvList.setAdapter(movieAdapter);
    }


    public void linearVerticalSelected(View view) {
        activityHomeBinding.rvList.setLayoutManager(new LinearLayoutManager(this));
        activityHomeBinding.rvList.setAdapter(movieAdapter);
    }
}
