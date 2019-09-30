package com.test.innersharecode12.custome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.test.innersharecode12.R;

/**
 * 描述：
 * 日期：2019/9/30
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
public class CustomeView extends View {

    private static final int DEFAULT_WIDTH_HEIGHT = 200;
    private static final int DEFAULT_COLOR = Color.BLUE;
    private static final int START_X_Y = 0;

    private RectF mRect = new RectF();
    private Paint mPaint = new Paint();

    private int mWidth;
    private int mHeight;
    private int mColor;

    public CustomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeArray(context, attrs);
        initPaint();
    }

    private void initPaint(){
        mRect.set(START_X_Y, START_X_Y, START_X_Y + mWidth, START_X_Y + mHeight);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true); //去锯齿
        mPaint.setColor(mColor);
    }

    private void initTypeArray(Context context, AttributeSet attrs){
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CustomeView, 0, 0);
        try {
            mWidth = typedArray.getDimensionPixelSize(R.styleable.CustomeView_width, DEFAULT_WIDTH_HEIGHT);
            mHeight = typedArray.getDimensionPixelOffset(R.styleable.CustomeView_heigh, DEFAULT_WIDTH_HEIGHT);
            mColor = typedArray.getColor(R.styleable.CustomeView_color, DEFAULT_COLOR);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(mRect, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minwidth;
        int minheight;
        if(getSuggestedMinimumWidth() > mWidth){
            minwidth = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight();
        }else {
            minwidth = mWidth + getPaddingLeft() + getPaddingRight();
        }
        if(getSuggestedMinimumHeight() > mHeight){
            minheight = getSuggestedMinimumHeight() + getPaddingBottom() + getPaddingTop();
        }else{
            minheight = mHeight + getPaddingBottom() + getPaddingTop();
        }
        int w = resolveSizeAndState(minwidth, widthMeasureSpec, 1);
        int h = resolveSizeAndState(minheight, heightMeasureSpec, 0);
        setMeasuredDimension(w, h);
    }
}
