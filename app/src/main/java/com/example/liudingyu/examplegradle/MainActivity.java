package com.example.liudingyu.examplegradle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private String[] mData = new String[]{"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.switcher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick();
            }
        });
    }

    private void handleClick() {
        Observable.from(mData)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !TextUtils.isEmpty(s) && s.toLowerCase().startsWith("what");
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d("d.d", s);
                    }
                });
    }
}
