package com.example.classapplication.shapesAndAudio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyDrawing extends View {
    static String shapeType="";
    public MyDrawing(Context context) {
        super(context);
    }

    public MyDrawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyDrawing(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint brush = new Paint();
        brush.setColor(Color.YELLOW);
        brush.setStrokeWidth(25);
        brush.setStyle(Paint.Style.STROKE);
        if (shapeType.equals("circle"))
            canvas.drawCircle(300,300,250,brush);
        else if (shapeType.equals("rectangle"))
            canvas.drawRect(10,10,400,400,brush);
        else if (shapeType.equals("triangle")){
            Path p=new Path();
            p.moveTo(300,10);
            p.lineTo(10,10);
            p.lineTo(300,700);
            p.lineTo(300,10);
            canvas.drawPath(p,brush);
        } else if (shapeType.equals("oval"))
            canvas.drawOval(10,10,400,400,brush);
    }
}
