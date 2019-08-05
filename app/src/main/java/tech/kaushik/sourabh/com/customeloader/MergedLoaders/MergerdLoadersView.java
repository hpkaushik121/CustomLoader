package tech.kaushik.sourabh.com.customeloader.MergedLoaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import tech.kaushik.sourabh.com.customeloader.R;

/**
 * Created by Sourabh kaushik on 8/5/2019.
 */

public class MergerdLoadersView extends View implements MLInvalidateListener {
    private LoaderView loaderView;

    public MergerdLoadersView(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public MergerdLoadersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs, 0);
    }

    public MergerdLoadersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MKLoader);
        int loaderType = typedArray.getInt(R.styleable.MKLoader_mk_type,-1);

        loaderView = LoaderGenerator.generateLoaderView(loaderType);
        loaderView.setColor(typedArray.getColor(R.styleable.MKLoader_mk_color, Color.parseColor("#ffffff")));

        typedArray.recycle();
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int measuredWidth = resolveSize(loaderView.getDesiredWidth(), widthMeasureSpec);
        final int measuredHeight = resolveSize(loaderView.getDesiredHeight(), heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        loaderView.setSize(getWidth(), getHeight());
        loaderView.initializeObjects();
        loaderView.setUpAnimation();
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        loaderView.draw(canvas);
    }

    @Override public void reDraw() {
        invalidate();
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (loaderView != null && loaderView.isDetached()) {
            loaderView.setInvalidateListener(this);
        }
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (loaderView != null) {
            loaderView.onDetach();
        }
    }
}
