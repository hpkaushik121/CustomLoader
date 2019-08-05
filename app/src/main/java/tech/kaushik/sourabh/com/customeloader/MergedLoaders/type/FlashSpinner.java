package tech.kaushik.sourabh.com.customeloader.MergedLoaders.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;

import tech.kaushik.sourabh.com.customeloader.MergedLoaders.shapeSupport.Circle;
import tech.kaushik.sourabh.com.customeloader.MergedLoaders.LoaderView;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class FlashSpinner extends LoaderView {
    private Circle[] circles;
    private int numberOfCircle;
    private float[] rotates;

    public FlashSpinner() {
        numberOfCircle = 5;
        rotates = new float[numberOfCircle];
    }

    @Override public void initializeObjects() {
        final float size = Math.min(width, height);
        final float circleRadius = size / 10.0f;
        circles = new Circle[numberOfCircle];

        for (int i = 0; i < numberOfCircle; i++) {
            circles[i] = new Circle();
            circles[i].setCenter(center.x, circleRadius);
            circles[i].setColor(color);
            circles[i].setRadius(circleRadius - circleRadius * i / 6);
        }
    }

    @Override public void setUpAnimation() {
        for (int i = 0; i < numberOfCircle; i++) {
            final int index = i;

            ValueAnimator fadeAnimator = ValueAnimator.ofFloat(0, 360);
            fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
            fadeAnimator.setDuration(1700);
            fadeAnimator.setStartDelay(index * 100);
            fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override public void onAnimationUpdate(ValueAnimator animation) {
                    rotates[index] = (float)animation.getAnimatedValue();
                    if (invalidateListener != null) {
                        invalidateListener.reDraw();
                    }
                }
            });

            fadeAnimator.start();
        }
    }

    @Override public void draw(Canvas canvas) {
        for (int i = 0; i < numberOfCircle; i++) {
            canvas.save();
            canvas.rotate(rotates[i], center.x, center.y);
            circles[i].draw(canvas);
            canvas.restore();
        }
    }
}
