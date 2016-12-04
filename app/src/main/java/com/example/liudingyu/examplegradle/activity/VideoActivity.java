package com.example.liudingyu.examplegradle.activity;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;

import com.example.liudingyu.examplegradle.R;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener, IMediaPlayer.OnPreparedListener {

    private TextureView mTextureView;
    private IMediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        mTextureView = (TextureView) findViewById(R.id.texture);
        mTextureView.setSurfaceTextureListener(this);
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
