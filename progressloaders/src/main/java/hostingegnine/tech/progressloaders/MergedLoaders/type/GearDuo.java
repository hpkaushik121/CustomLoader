package hostingegnine.tech.progressloaders.MergedLoaders.type;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.InputStream;

import hostingegnine.tech.progressloaders.MergedLoaders.LoaderView;
import hostingegnine.tech.progressloaders.R;

/**
 * Created by Sourabh kaushik on 8/6/2019.
 */
public class GearDuo extends LoaderView {
    private static final int DEFAULT_MOVIEW_DURATION = 1000;

    private int mMovieResourceId;
    private Movie mMovie;

    private long mMovieStart = 0;
    private int mCurrentAnimationTime = 0;


    public GearDuo(Context context,int id) {

        this.mMovieResourceId = id;
        mMovie = Movie.decodeStream(context.getResources().openRawResource(mMovieResourceId));
        desiredWidth=mMovie.width();
        desiredHeight=mMovie.height();
    }





    @Override
    public void initializeObjects() {


    }

    @Override
    public void setUpAnimation() {

    }

    @Override
    public void draw(Canvas canvas) {
        if (mMovie != null){
            updateAnimtionTime();
            drawGif(canvas);
            if (invalidateListener != null) {
                invalidateListener.reDraw();
            }
        }else{
            drawGif(canvas);
        }

    }

    private void updateAnimtionTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }
        int dur = mMovie.duration();
        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }
        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    private void drawGif(Canvas canvas) {
        mMovie.setTime(mCurrentAnimationTime);
        mMovie.draw(canvas, 0, 0);
//        canvas.restore();
    }
}
