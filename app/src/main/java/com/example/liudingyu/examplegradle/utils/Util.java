package com.example.liudingyu.examplegradle.utils;

import android.content.Context;

/**
 * Created by liudingyu on 8/8/16.
 */
public class Util {
    public final static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public final static int getNavigationBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int result = 0;
        int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static float dip2Px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dipValue * scale + 0.5f;
    }
}
