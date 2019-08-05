package tech.kaushik.sourabh.com.customeloader.MergedLoaders.shapeSupport;

import android.graphics.Canvas;
import android.graphics.RectF;

import tech.kaushik.sourabh.com.customeloader.MergedLoaders.GraphicObject;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class Arc extends GraphicObject {
    private RectF oval;
    private float startAngle;
    private float sweepAngle;
    private boolean useCenter;

    public void setOval(RectF oval) {
        this.oval = oval;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    public void setUseCenter(boolean useCenter) {
        this.useCenter = useCenter;
    }

    public float getStartAngle() {
        return startAngle;
    }

    @Override public void draw(Canvas canvas) {
        canvas.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
    }
}