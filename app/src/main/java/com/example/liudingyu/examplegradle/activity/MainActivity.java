package com.example.liudingyu.examplegradle.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.liudingyu.examplegradle.R;

public class MainActivity extends AppCompatActivity {

    private String[] mData = new String[]{"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};
    private ImageView mImageView, mSecondImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                handleClick(mImageView);
//                ((BitmapDrawable) mImageView.getDrawable()).getBitmap().recycle();
//                findViewById(R.id.root_view).invalidate();
//                mImageView.requestLayout();
//                mSecondImageView.requestLayout();
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
        });
        /*
        mImageView = (ImageView) findViewById(R.id.firstImage);
        mSecondImageView = (ImageView) findViewById(R.id.secondImage);
        mSecondImageView.setImageDrawable(mImageView.getDrawable());
        */
    }

    private void handleClick(View view) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, "sharedView").toBundle());
    }

    private void handleNotification() {
        String bigText = "bigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigTextbigText";
        Drawable drawable = getResources().getDrawable(R.drawable.smoke);
        Bitmap icon = null;
        if (drawable instanceof BitmapDrawable) {
            icon = ((BitmapDrawable) drawable).getBitmap();
        }
        NotificationManager mNm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Ticker").setSmallIcon(R.drawable.fire).setAutoCancel(true);
        builder.setContentTitle("contentTitle").setContentText("contentText").setLargeIcon(icon).setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(bigText));

        mNm.notify(1, builder.build());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
