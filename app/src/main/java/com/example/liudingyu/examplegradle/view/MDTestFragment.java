package com.example.liudingyu.examplegradle.view;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.liudingyu.examplegradle.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MDTestFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private ListView mListview;
    private SwipeRefreshLayout mSwipeRefresh;
    private Handler mHandler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.md_fragment, container, false);
        mListview = (ListView) view.findViewById(R.id.listview);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mSwipeRefresh.setOnRefreshListener(this);
        view.findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mSwipeRefresh.setRefreshing(true);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "" + i + " This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        SimpleAdapter mSchedule = new SimpleAdapter(getActivity(), //没什么解释
                mylist,//数据来源
                R.layout.listview_item,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[]{"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[]{R.id.txt_title, R.id.txt_context});
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mListview.setNestedScrollingEnabled(true);
        }
        mListview.setAdapter(mSchedule);
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefresh.setRefreshing(false);
            }
        }, 4000);
    }
}
