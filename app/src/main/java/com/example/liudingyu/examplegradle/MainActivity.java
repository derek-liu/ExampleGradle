package com.example.liudingyu.examplegradle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class MainActivity extends AppCompatActivity {

    private String[] mData = new String[] {"What is design?", "Design", "Design is not just", "what it looks like", "and feels like.", "Design", "is how it works.", "- Steve Jobs", "Older people", "sit down and ask,", "'What is it?'", "but the boy asks,", "'What can I do with it?'.", "- Steve Jobs", "Swift", "Objective-C", "iPhone", "iPad", "Mac Mini", "MacBook Pro", "Mac Pro", "爱老婆", "老婆和女儿"};
    private int mIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final HTextView hTextView = (HTextView) findViewById(R.id.h_textView);
        hTextView.setTextColor(Color.BLACK);
        hTextView.setBackgroundColor(Color.WHITE);
        hTextView.setAnimateType(HTextViewType.FALL);

        findViewById(R.id.switcher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hTextView.animateText(mData[mIndex++]);
                if (mIndex == mData.length) {
                    mIndex = 0;
                }
            }
        });
    }
}
