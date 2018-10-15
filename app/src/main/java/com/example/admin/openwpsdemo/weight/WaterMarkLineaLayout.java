package com.example.admin.openwpsdemo.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 水印View
 */
public class WaterMarkLineaLayout extends LinearLayout {
    private String name;
    private String id;

    public WaterMarkLineaLayout(Context context) {
        this(context, null);
    }

    public WaterMarkLineaLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public WaterMarkLineaLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = Bitmap.createBitmap(900, 900, Bitmap.Config.ARGB_8888);
        Canvas waterMarkCanvas = new Canvas(bitmap);
        waterMarkCanvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAlpha(80);
        paint.setAntiAlias(true);
        paint.setTextSize(90);
        paint.setTextAlign(Paint.Align.CENTER);
        Path path = new Path();
        path.moveTo(30, 800);
        path.lineTo(900, 0);
        waterMarkCanvas.drawTextOnPath(name, path, 0, 60, paint);
        waterMarkCanvas.drawTextOnPath(id, path, 0, 140, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapDrawable.setDither(true);
        setBackground(bitmapDrawable);

    }

    public void setMarkText(String name, String id) {
        this.name = name;
        this.id = id;
        postInvalidate();
    }
}
