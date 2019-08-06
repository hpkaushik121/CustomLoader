package hostingegnine.tech.progressloaders.MergedLoaders.shapeSupport;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import hostingegnine.tech.progressloaders.MergedLoaders.GraphicObject;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class Circle extends GraphicObject {
    private PointF center;
    private float radius;

    public Circle() {
        center = new PointF();
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setCenter(float x, float y) {
        center.set(x, y);
    }

    @Override public void draw(Canvas canvas) {
        canvas.drawCircle(center.x, center.y, radius, paint);
    }

    public PointF getCenter() {
        return center;
    }
    public Paint getPaint() {
        return paint;
    }
}
