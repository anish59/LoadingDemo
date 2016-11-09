package com.example.ppd.myapplication.adpater;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.ppd.myapplication.HeaderFooterActivity;
import com.example.ppd.myapplication.HomeActivty;
import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.ActivityFirstBinding;
import com.example.ppd.myapplication.pagerDemo.MainPagerDemo;

/**
 * Created by anish on 04-11-2016.
 */
public class FirstActivity extends Activity
{
    ActivityFirstBinding activityFirstBinding;
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        activityFirstBinding= DataBindingUtil.setContentView(this,R.layout.activity_first);



    }

    public void gotoMultiple(View view)
    {
        Intent intent= new Intent(this, HomeActivty.class);
        startActivity(intent);
    }

    public void gotoHaderFooterDemo(View view)
    {
        Intent intent= new Intent(this, HeaderFooterActivity.class);
        startActivity(intent);
    }

   /* public void gotoViewPager(View view)
    {
        Intent intent= new Intent(this, MainPagerDemo.class);
        startActivity(intent);
    }*/
}
