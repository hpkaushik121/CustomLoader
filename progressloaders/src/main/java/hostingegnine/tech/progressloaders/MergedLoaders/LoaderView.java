package hostingegnine.tech.progressloaders.MergedLoaders;

import android.graphics.Canvas;
import android.graphics.PointF;


/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public abstract class LoaderView {
    protected int color;
    protected int width, height;
    protected int desiredWidth, desiredHeight;
    protected PointF center;
    protected MLInvalidateListener invalidateListener;

    public LoaderView() {
        this.desiredWidth = 150;
        this.desiredHeight = 150;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.center = new PointF(width / 2.0f, height / 2.0f);
    }

    public void setInvalidateListener(MLInvalidateListener invalidateListener) {
        this.invalidateListener = invalidateListener;
    }

    public int getDesiredWidth() {
        return desiredWidth;
    }

    public int getDesiredHeight() {
        return desiredHeight;
    }

    public abstract void initializeObjects();

    public abstract void setUpAnimation();

    public abstract void draw(Canvas canvas);

    public boolean isDetached() {
        return invalidateListener == null;
    }

    public void onDetach() {
        if (invalidateListener != null) {
            invalidateListener = null;
        }
    }
}
