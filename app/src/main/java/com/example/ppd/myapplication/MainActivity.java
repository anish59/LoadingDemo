package com.example.ppd.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import com.roger.catloadinglibrary.CatLoadView;

public class MainActivity extends AppCompatActivity {

    CatLoadView mView;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        mView = new CatLoadView();
//        mView.getActivity().
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        mView.show(getSupportFragmentManager(), "");
                        delay();
                    }
                });



}

    private void delay() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                mView.dismiss();
            }
        }, 9000);
    }
    }
