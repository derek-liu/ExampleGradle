package com.example.liudingyu.examplegradle;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] mData = new String[]{"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.switcher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                handleClick();
                handleNotification();
            }
        });
    }

    private void handleClick() {
        Random random = new Random();
      for (int i = 0; i < 100; i++) {
          Log.d("d.d", "next:" + Math.abs(random.nextLong()) % 10);
      }
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
}
