package com.example.ppd.myapplication.tabFragmentViewPager.fragments;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.FragmentBBinding;

/**
 * Created by anish on 08-11-2016.
 */
public class FragmentB extends Fragment
{
    FragmentBBinding fragmentBBinding;
    public FragmentB() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentBBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_b,container,false);
        View view= fragmentBBinding.getRoot();
        return view;
    }
}
