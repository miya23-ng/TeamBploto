package com.camera.teambploto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import org.opencv.core.Point;

import java.util.List;

public class CanvasView extends View {
    private Bitmap mBitmap;
    List<List<Point>> mPoints;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBitmap = null;
        mPoints = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasDraw(canvas);
    }

    private void canvasDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(100);

        /* ⑤：背景色を設定 */
        canvas.drawColor(Color.BLACK);

        /* ⑥：原画像（Bitmap）を描画 */
        if(mBitmap != null) {
            float scale = (float)getWidth() / mBitmap.getWidth();
            canvas.scale(scale, scale);
            canvas.drawBitmap(mBitmap, 0, 0, paint);
        }

        /* ⑦：輪郭を描画 */
        if(mPoints != null) {
            Path path = new Path();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.argb(128, 255, 0, 0));

            for(int i = 0; i < mPoints.size(); i++) {
                List<Point> point = mPoints.get(i);

                path.moveTo((float)point.get(0).x, (float)point.get(0).y);
                for(int j = 0; j < point.size(); j++) {
                    path.lineTo((float)point.get(j).x, (float)point.get(j).y);
                }
                path.lineTo((float)point.get(0).x, (float)point.get(0).y);
                for(int j = 0; j < point.size(); j++) {
                    path.lineTo((float)point.get(j).x, (float)point.get(j).y);
                }
            }

            canvas.drawPath(path, paint);
        }
    }

    public void setmBitmap(Bitmap bmp) {
        mBitmap = bmp;
    }

    public void setmPoints(List<List<Point>> points) {
        mPoints = points;
    }
}