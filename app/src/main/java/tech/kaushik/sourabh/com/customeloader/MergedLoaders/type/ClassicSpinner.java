package tech.kaushik.sourabh.com.customeloader.MergedLoaders.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;

import tech.kaushik.sourabh.com.customeloader.MergedLoaders.shapeSupport.Circle;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.LoaderView;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class ClassicSpinner extends LoaderView {
    private Circle[] circles;
    private int circlesSize;

    public ClassicSpinner() {
        circlesSize = 8;
    }

    @Override public void initializeObjects() {
        final float size = Math.min(width, height);
        final float circleRadius = size / 10.0f;
        circles = new Circle[circlesSize];

        for (int i = 0; i < circlesSize; i++) {
            circles[i] = new Circle();
            circles[i].setCenter(center.x, circleRadius);
            circles[i].setColor(color);
            circles[i].setAlpha(126);
            circles[i].setRadius(circleRadius);
        }
    }

    @Override public void setUpAnimation() {
        for (int i = 0; i < circlesSize; i++) {
            final int index = i;

            ValueAnimator fadeAnimator = ValueAnimator.ofInt(126, 255, 126);
            fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
            fadeAnimator.setDuration(1000);
            fadeAnimator.setStartDelay(index * 120);
            fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override public void onAnimationUpdate(ValueAnimator animation) {
                    circles[index].setAlpha((int)animation.getAnimatedValue());
                    if (invalidateListener != null) {
                        invalidateListener.reDraw();
                    }
                }
            });

            fadeAnimator.start();
        }
    }

    @Override public void draw(Canvas canvas) {
        for (int i = 0; i < circlesSize; i++) {
            canvas.save();
            canvas.rotate(45 * i, center.x, center.y);
            circles[i].draw(canvas);
            canvas.restore();
        }
    }
}