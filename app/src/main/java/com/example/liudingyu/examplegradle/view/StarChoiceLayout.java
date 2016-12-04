package com.example.liudingyu.examplegradle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liudingyu.examplegradle.R;

import java.util.ArrayList;
import java.util.List;

public class StarChoiceLayout extends RelativeLayout {

    public String[] mData = new String[]{
            "Politics", "Tech", "Autos", "Style", "Entertainment", "Sports", "Science", "Business",
            "Food", "Eletion", "Health", "Travel", "Design", "Home", "Game"
    };

    private List<ItemType> mModeList = new ArrayList<>();

    private final int DESIGNED_WIDTH = 770; //dp
    private final int DESIGNED_HEIGHT = 940; //dp

    private int mHeight = DESIGNED_HEIGHT;

    public class ItemType {
        public ItemType(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public int x;
        public int y;
        public int radius;
    }


    public StarChoiceLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StarChoiceLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarChoiceLayout(Context context) {
        this(context, null);
    }

    public void setSize(int height) {
        mHeight = height;
    }

    public void init() {
        /*
        mModeList.add(new ItemType(102, 116, 50));
        mModeList.add(new ItemType(255, 76, 39));
        mModeList.add(new ItemType(379, 100, 50));
        mModeList.add(new ItemType(532, 65, 50));
        mModeList.add(new ItemType(94, 256, 65));
        mModeList.add(new ItemType(208, 188, 50));
        mModeList.add(new ItemType(328, 215, 50));
        mModeList.add(new ItemType(471, 224, 65));
        mModeList.add(new ItemType(607, 162, 50));
        mModeList.add(new ItemType(170, 370, 50));
        mModeList.add(new ItemType(297, 327, 39));
        mModeList.add(new ItemType(411, 363, 50));
        mModeList.add(new ItemType(527, 332, 39));
        mModeList.add(new ItemType(655, 293, 65));
        mModeList.add(new ItemType(515, 426, 39));
        */


        mModeList.add(new ItemType(205, 232, 100));
        mModeList.add(new ItemType(510, 152, 78));
        mModeList.add(new ItemType(758, 199, 100));
        mModeList.add(new ItemType(1064, 130, 100));
        mModeList.add(new ItemType(188, 512, 130));
        mModeList.add(new ItemType(416, 375, 100));
        mModeList.add(new ItemType(656, 430, 100));
        mModeList.add(new ItemType(942, 448, 130));
        mModeList.add(new ItemType(1214, 324, 100));
        mModeList.add(new ItemType(340, 740, 100));
        mModeList.add(new ItemType(594, 654, 78));
        mModeList.add(new ItemType(822, 726, 100));
        mModeList.add(new ItemType(1054, 664, 78));
        mModeList.add(new ItemType(1310, 585, 130));
        mModeList.add(new ItemType(1030, 853, 78));

        for (int i = 0; i < mModeList.size(); i++) {
            ItemType item = mModeList.get(i);
            int left_dp = item.x - item.radius;
            int top_dp = item.y - item.radius;

            TextView textView = new TextView(getContext());
            textView.setText(mData[i]);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(17);
            textView.setTextColor(Color.parseColor("#eb3b6b"));
            textView.setBackgroundResource(R.drawable.interest_select_item_bg);
            /*
            LayoutParams lp = new LayoutParams((int)Util.dip2Px(getContext(), item.radius * 2),
                    (int)Util.dip2Px(getContext(), item.radius * 2));
            lp.topMargin = (int) (Util.dip2Px(getContext(), top_dp) / DESIGNED_HEIGHT * mHeight);
            lp.leftMargin = (int) (Util.dip2Px(getContext(), left_dp) / DESIGNED_HEIGHT * mHeight);
            */
            LayoutParams lp = new LayoutParams(item.radius * 2 * mHeight / DESIGNED_HEIGHT, item.radius * 2 * mHeight / DESIGNED_HEIGHT);
            lp.topMargin = (item.y - item.radius) * mHeight / DESIGNED_HEIGHT;
            lp.leftMargin = (item.x - item.radius) * mHeight / DESIGNED_HEIGHT;
            addView(textView, lp);
        }
    }

}
