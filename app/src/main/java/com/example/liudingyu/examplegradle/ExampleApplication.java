package com.example.liudingyu.examplegradle;

import android.app.Application;

import cn.campusapp.router.Router;

/**
 * Created by liudingyu on 12/4/16.
 */
public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Router.initActivityRouter(getApplicationContext());
    }
}
