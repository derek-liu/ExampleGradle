package com.example.liudingyu.examplegradle.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.liudingyu.examplegradle.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MDTestFragment extends Fragment {
    private ListView mListview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.md_fragment, container, false);
        mListview = (ListView) view.findViewById(R.id.listview);
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
        mListview.setNestedScrollingEnabled(true);
        mListview.setAdapter(mSchedule);
    }
}
