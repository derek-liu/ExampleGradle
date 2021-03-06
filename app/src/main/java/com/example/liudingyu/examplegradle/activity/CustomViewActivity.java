package com.example.liudingyu.examplegradle.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.liudingyu.examplegradle.R;
import com.example.liudingyu.examplegradle.utils.Util;
import com.example.liudingyu.examplegradle.view.StarChoiceLayout;

import cn.campusapp.router.annotation.RouterMap;

@RouterMap({"activity://CustomViewActivity/{key1}/{key2}",
        "activity://CustomViewActivity2/{key1}/{key2}"})
public class CustomViewActivity extends AppCompatActivity {
//    private StarChoiceLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_activity);
        init();
    }

    private void init() {

        Log.d("d.d", getIntent().getStringExtra("key1"));
        Log.d("d.d", getIntent().getStringExtra("key2"));
        /*
        mLayout = (StarChoiceLayout) findViewById(R.id.star_layout);
        int viewHeight = getResources().getDisplayMetrics().heightPixels - Util.getStatusBarHeight(this) - Util.getNavigationBarHeight(this);
        mLayout.setSize(1000);
        mLayout.init();
        */
    }
}
