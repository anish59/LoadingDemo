package com.example.ppd.myapplication.tabFragmentViewPager.fragments;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ppd.myapplication.R;
import com.example.ppd.myapplication.databinding.FragmentCBinding;

/**
 * Created by anish on 08-11-2016.
 */
public class FragmentC extends Fragment
{
    FragmentCBinding fragmentCBinding;
    public FragmentC() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentCBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_c,container,false);
        View view= fragmentCBinding.getRoot();
        return view;
    }
}
