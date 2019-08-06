package hostingegnine.tech.progressloaders.MergedLoaders.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

import hostingegnine.tech.progressloaders.MergedLoaders.shapeSupport.Line;
import hostingegnine.tech.progressloaders.MergedLoaders.LoaderView;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class Radar extends LoaderView {
    private Line line;
    private float degree;

    @Override public void initializeObjects() {
        final float size = Math.min(width, height);
        line = new Line();
        line.setPoint1(center);
        line.setPoint2(new PointF(0, size / 2f));
        line.setColor(color);
        line.setWidth(5);
    }

    @Override public void setUpAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 359);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                degree = (float)animation.getAnimatedValue();
                if (invalidateListener != null) {
                    invalidateListener.reDraw();
                }
            }
        });

        animator.start();
    }

    @Override public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(degree, center.x, center.y);
        line.draw(canvas);
        canvas.restore();
    }
}
