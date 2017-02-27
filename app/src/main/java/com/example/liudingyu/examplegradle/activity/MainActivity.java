package com.example.liudingyu.examplegradle.activity;

import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.liudingyu.examplegradle.R;

public class MainActivity extends AppCompatActivity {

    private String[] mData = new String[]{"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};
    private ImageView mImageView, mSecondImageView;

    private static final String AUTHORITY = "com.derek.myapp";
    private static Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    private static String PATH_PEOPLE = "people";
    private static String PATH_PEOPLE_NUMBER = "people_number";

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int PATH_PEOPLE_ID = 0;
    private static final int PATH_PEOPLE_NUMBER_ID = 1;

    static {
        uriMatcher.addURI(AUTHORITY, PATH_PEOPLE, PATH_PEOPLE_ID);
        uriMatcher.addURI(AUTHORITY, PATH_PEOPLE_NUMBER, PATH_PEOPLE_NUMBER_ID);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick(v);
            }
        });
    }

    private void handleClick(View v) {
        Uri uri = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PEOPLE_NUMBER).build();
        int id = uriMatcher.match(uri);
        Log.d("d.d", "id: " + id);
    }

}
