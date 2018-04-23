package com.example.galgu.medicalmystery.ClickablePhoto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by galgu on 4/4/2018.
 */

public class ClickableImageView extends android.support.v7.widget.AppCompatImageView {

    private Set<PolyShape> polyShapes,clicked;
    private static final int MAX_CLICK_DURATION = 200;
    private long startClickTime;
    private Bitmap imageBitMap;

    public ClickableImageView(Context context) {
        super(context);

        polyShapes=new HashSet<>();
        clicked=new HashSet<>();

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if(clickDuration < MAX_CLICK_DURATION) {
                            for (PolyShape ps:polyShapes) {
                                float xxxxx=motionEvent.getX();
                                float xxxxyx=motionEvent.getY();
                                float xxxyyyxx=getMeasuredWidth();
                                float xxxyyxx=getMeasuredHeight();

                                if(ps.isInArea(motionEvent.getX()/getMeasuredWidth(),motionEvent.getY()/getMeasuredHeight())){
                                    if(clicked.contains(ps))
                                        clicked.remove(ps);
                                    else
                                        clicked.add(ps);
                                    reDraw();
                                    return true;
                                }
                            }
                        }
                    }
                }
                return true;
            }
        });
    }

    public ClickableImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickableImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void addShapes(List<PolyShape> ps){
        polyShapes.addAll(ps);
    }

    private void reDraw(){
        Bitmap workingBitmap = imageBitMap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(workingBitmap);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);

        float width = workingBitmap.getWidth();
        float height = workingBitmap.getHeight();

        paint.setStyle(Paint.Style.STROKE);

        for (PolyShape ps:polyShapes) {
            Path path = new Path();

            List<RelativePoint> relativePoints = ps.getPoints();

            path.moveTo(relativePoints.get(0).x*width, relativePoints.get(0).y*height);

            for (int i = 1; i < relativePoints.size(); i++){

                path.lineTo(relativePoints.get(i).x*width, relativePoints.get(i).y*height);

            }
            path.lineTo(relativePoints.get(0).x*width, relativePoints.get(0).y*height);

            canvas.drawPath(path, paint);
        }

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(75);

        for (PolyShape ps:clicked) {
            Path path = new Path();

            List<RelativePoint> relativePoints = ps.getPoints();

            path.moveTo(relativePoints.get(0).x*width, relativePoints.get(0).y*height);

            for (int i = 1; i < relativePoints.size(); i++){

                path.lineTo(relativePoints.get(i).x*width, relativePoints.get(i).y*height);

            }
            path.lineTo(relativePoints.get(0).x*width, relativePoints.get(0).y*height);

            canvas.drawPath(path, paint);
        }

        setImageBitmap(workingBitmap);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(imageBitMap==null){
            imageBitMap= ((BitmapDrawable) this.getDrawable()).getBitmap();
            reDraw();
        }
    }


}
