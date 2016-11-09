package com.example.ppd.myapplication.tabFragmentViewPager.fragmentAdpaters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ppd.myapplication.tabFragmentViewPager.fragments.FragmentA;
import com.example.ppd.myapplication.tabFragmentViewPager.fragments.FragmentB;
import com.example.ppd.myapplication.tabFragmentViewPager.fragments.FragmentC;

/**
 * Created by anish on 08-11-2016.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter
{
    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0)
        {
            fragment=new FragmentA();
        }
        if(position==1)
        {
            fragment=new FragmentB();
        }
        if(position==2)
        {
            fragment=new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
