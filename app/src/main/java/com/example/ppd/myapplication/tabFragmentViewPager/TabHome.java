package com.example.ppd.myapplication.tabFragmentViewPager;

import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;


import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.ActivityTabhomeBinding;
import com.example.ppd.myapplication.tabFragmentViewPager.fragmentAdpaters.TabFragmentAdapter;

/**
 * Created by anish on 08-11-2016.
 */
public class TabHome extends FragmentActivity implements ActionBar.TabListener
{
    ActivityTabhomeBinding activityTabhomeBinding;
    TabFragmentAdapter mtabFragmentAdapter;
    ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTabhomeBinding= DataBindingUtil.setContentView(this, R.layout.activity_tabhome);
        FragmentManager fragmnetManager = getSupportFragmentManager();
        mtabFragmentAdapter=new TabFragmentAdapter(fragmnetManager);
        activityTabhomeBinding.pager.setAdapter(mtabFragmentAdapter);

        activityTabhomeBinding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //actionBar.

    }




    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
