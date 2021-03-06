package com.example.liudingyu.examplegradle.activity;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.liudingyu.examplegradle.R;

import cn.campusapp.router.annotation.RouterMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@RouterMap("activity://VideoActivity")
public class VideoActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener, IMediaPlayer.OnPreparedListener {

    private TextureView mTextureView;
    private IMediaPlayer mMediaPlayer;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
//        mTextureView = (TextureView) findViewById(R.id.texture);
//        mTextureView.setSurfaceTextureListener(this);
        mImageView = (ImageView) findViewById(R.id.imageview);
        Glide.with(this).load("http://p0.ipstatp.com/list/0058618f9999404760f6").into(mImageView);
//        Glide.with(this).load("http://p0.ipstatp.com/list/0058618c90bbc03717b9").into(mImageView);
    }

    private void initMediaPlayer() {
        mMediaPlayer = new IjkMediaPlayer();
        IjkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);
        mMediaPlayer.setOnPreparedListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if (mMediaPlayer == null) {
            initMediaPlayer();
        }
        try {
            mMediaPlayer.setSurface(new Surface(surface));
            mMediaPlayer.setDataSource("http://baobab.wdjcdn.com/1455782903700jy.mp4");
            mMediaPlayer.prepareAsync();
        } catch (Exception e) {

        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        iMediaPlayer.start();
        iMediaPlayer.getVideoWidth();
    }
}
