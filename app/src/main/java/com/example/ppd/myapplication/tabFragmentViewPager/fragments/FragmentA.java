package com.example.ppd.myapplication.tabFragmentViewPager.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.FragmentABinding;

/**
 * Created by anish on 08-11-2016.
 */
public class FragmentA extends Fragment
{
    FragmentABinding fragmentABinding;
    public FragmentA() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentABinding= DataBindingUtil.inflate(inflater, R.layout.fragment_a,container,false);
        View view=fragmentABinding.getRoot();
        return view;
    }
}
