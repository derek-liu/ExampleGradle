package com.example.liudingyu.examplegradle.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import java.util.Random;

/**
 * Created by liudingyu on 21/05/2017.
 */

public class VolumeWaveView extends View {

    private Paint mPaint;
    private int mDrawHeight = 0;
    private ValueAnimator mValueAnimator;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_START_ANIMATION) {
                int random = new Random().nextInt(getMeasuredHeight());
                startWaveAnimation(random);
            }
        }
    };

    private final int MSG_START_ANIMATION = 1;

    public VolumeWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public VolumeWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeWaveView(Context context) {
        this(context, null, 0);
    }

    private void startWaveAnimation(int endHeight) {
        int curHeight = mDrawHeight;
        ValueAnimator animator = ValueAnimator.ofInt(curHeight, endHeight);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDrawHeight = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setInterpolator(mInterpolator);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mHandler.sendEmptyMessage(MSG_START_ANIMATION);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(100);
        animator.start();
        mValueAnimator = animator;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            start();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        end();
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == View.VISIBLE) {
            start();
        } else {
            end();
        }
    }

    private void start() {
        end();
        mHandler.sendEmptyMessage(MSG_START_ANIMATION);
    }

    private void end() {
        mHandler.removeMessages(MSG_START_ANIMATION);
        if (mValueAnimator != null) {
            mValueAnimator.cancel();
        }
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, getMeasuredHeight() - mDrawHeight, getMeasuredWidth(), getMeasuredHeight(), mPaint);
    }
}
