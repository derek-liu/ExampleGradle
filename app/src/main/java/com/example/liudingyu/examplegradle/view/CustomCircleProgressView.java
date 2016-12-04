package com.example.liudingyu.examplegradle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.liudingyu.examplegradle.R;

/**
 * Created by liudingyu on 11/23/16.
 */
public class CustomCircleProgressView extends View {
    private int mWidth;
    private int mHeight;
    private int mRadius = 200;
    private int mStrokeWidth = 10;

    private Paint mStrokePaint;
    private RectF mRectF;
    private int mProgress = 0;


    public CustomCircleProgressView(Context context) {
        this(context, null);
    }

    public CustomCircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.custom_circle_progress);
        mRadius = a.getDimensionPixelOffset(R.styleable.custom_circle_progress_circle_progressbar_inner_radius, 200);
        mStrokeWidth = a.getDimensionPixelOffset(R.styleable.custom_circle_progress_circle_progressbar_stroke_width, 10);
        mProgress = a.getInt(R.styleable.custom_circle_progress_circle_progressbar_progress, 0);
        a.recycle();
        mStrokePaint = new Paint();
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(mStrokeWidth);
        mStrokePaint.setColor(Color.RED);
        mStrokePaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth = getRealSize(widthMeasureSpec);
        mHeight = getRealSize(heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private int getRealSize(int measureSpec) {
        int result = 1;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            //自己计算
            result = (int) 2 * (mRadius + mStrokeWidth);
        } else {
            result = size;
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRectF == null) {
            mRectF = new RectF(mWidth / 2 - mRadius - mStrokeWidth / 2, mHeight / 2 - mRadius - mStrokeWidth / 2, mWidth / 2 + mRadius + mStrokeWidth / 2, mHeight / 2 + mRadius + mStrokeWidth / 2);
        }
        // RectF边界是stroke的中心线
        canvas.drawArc(mRectF, -90, 360 * mProgress / 100, false, mStrokePaint);
    }
}
