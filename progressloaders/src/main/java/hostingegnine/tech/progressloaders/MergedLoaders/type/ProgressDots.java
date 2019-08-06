package hostingegnine.tech.progressloaders.MergedLoaders.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

import hostingegnine.tech.progressloaders.MergedLoaders.LoaderView;
import hostingegnine.tech.progressloaders.MergedLoaders.shapeSupport.Circle;

/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class ProgressDots extends LoaderView {
    public static final float SCALE = 1.0f;
    //scale x ,y
    private float[] scaleFloats = new float[]{SCALE,
            SCALE,
            SCALE};
    private Circle[] circles;
    private int circlesSize=3;
    private float radius;
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    protected Rect drawBounds = ZERO_BOUNDS_RECT;
    public ProgressDots() {
    }

    @Override
    public void initializeObjects() {
        for (int i = 0; i < circlesSize; i++) {
            circles[i] = new Circle();
            circles[i].setColor(color);
            circles[i].setRadius(15);
            circles[i].setCenter(75, 105);
        }


    }




    @Override
    public void setUpAnimation() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        int[] delays = new int[]{120, 240, 360,480,600};
        for (int i = 0; i < circlesSize; i++) {
            final int index = i;

            ValueAnimator scaleAnim = ValueAnimator.ofFloat(1, 0.3f, 1);

            scaleAnim.setDuration(750);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);

            scaleAnim.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleFloats[index] = (float) animation.getAnimatedValue();
                    if (invalidateListener != null) {
                        invalidateListener.reDraw();
                    }
//                    postInvalidate();
                }
            });
            animators.add(scaleAnim);
            scaleAnim.start();
        }
    }


    @Override
    public void draw(Canvas canvas) {
        float circleSpacing = 4;
        float radius = (Math.min(150, 150) - circleSpacing * 2) / 6;
        float x = 150 / 2 - (radius * 2 + circleSpacing);
        float y = 150 / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float translateX = x + (radius * 2) * i + circleSpacing * i;
            canvas.translate(translateX, y);
            canvas.scale(scaleFloats[i], scaleFloats[i]);
            canvas.drawCircle(0, 0, radius, circles[i].getPaint());
            canvas.restore();
        }
    }

}
