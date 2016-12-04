package com.example.liudingyu.examplegradle.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liudingyu.examplegradle.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by liudingyu on 7/7/16.
 */
public class MyListActivity extends FragmentActivity {

    public static final String DEVELOPER_KEY = "AIzaSyAdBk21kVxMRpk92v2b0xzHI5ouZ41b0-Q";
    private static final String VIDEO_ID = "cdgQpa1pUUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter(this));
    }

    public class MyAdapter extends BaseAdapter {
        private Context mContext;

        public MyAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                View v = LayoutInflater.from(mContext).inflate(R.layout.list_activity_item, parent, false);
                holder = new ViewHolder(mContext, v);
                v.setTag(holder);
                convertView = v;
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.bind(position);
            return convertView;
        }
    }

    public class ViewHolder {
        public Context mContext;
        public TextView mPlay;
        public View mRootView;
        public YouTubePlayerSupportFragment mYoutubeFragment;

        public ViewHolder(Context context, View rootView) {
            mContext = context;
            mRootView = rootView;
            mPlay = (TextView) rootView.findViewById(R.id.play);
            mYoutubeFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);

        }

        public void bind(int position) {
            mPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mContext instanceof Activity) {
                        mYoutubeFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
                            @Override
                            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                                if (!b) {
                                    youTubePlayer.loadVideo(VIDEO_ID);
                                }
                            }

                            @Override
                            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                            }
                        });
                    }
                }
            });
        }
    }
}
