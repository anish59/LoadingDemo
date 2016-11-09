package com.example.ppd.myapplication.pagerDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.adpater.CustomPagerAdapter;

/**
 * Created by anish on 04-11-2016.
 */
public class MainPagerDemo extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
      /*  viewPager.setAdapter(new CustomPagerAdapter(this));*/
    }
}
