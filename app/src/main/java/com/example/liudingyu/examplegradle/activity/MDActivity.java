package com.example.liudingyu.examplegradle.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liudingyu.examplegradle.R;
import com.example.liudingyu.examplegradle.view.MDTestFragment;

import java.util.List;

public class MDActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_activity);

        //测试Recyclerview
        /*
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("" + i + " " + "Data");
        }
        adapter.setData(list);
        mRecyclerView.setAdapter(adapter);
        */


        // 测试listview
        /*
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "" + i + " This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.listview_item,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[]{"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[]{R.id.txt_title, R.id.txt_context});
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setNestedScrollingEnabled(true);
        listview.setAdapter(mSchedule);
        */

//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new MDTestFragment()).commitAllowingStateLoss();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }


    public class MyFragmentPageAdapter extends FragmentPagerAdapter {

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MDTestFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<String> mData;

        public void setData(List<String> list) {
            mData = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(LayoutInflater.from(MDActivity.this).inflate(R.layout.reclcyer_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof RecyclerViewHolder) {
                ((RecyclerViewHolder) holder).txt.setText(mData.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView txt;

        public RecyclerViewHolder(View item) {
            super(item);
            txt = (TextView) item.findViewById(R.id.item_txt);
        }
    }


}
