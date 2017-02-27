package com.example.liudingyu.examplegradle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import cn.campusapp.router.Router;

/**
 * Created by liudingyu on 12/4/16.
 */
public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Router.initActivityRouter(getApplicationContext());
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d("d.d", "oncreate");
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
