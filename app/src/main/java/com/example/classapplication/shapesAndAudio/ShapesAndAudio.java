package com.example.classapplication.shapesAndAudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.classapplication.R;


public class ShapesAndAudio extends AppCompatActivity {
    Button circle,rectangle,triangle,oval;
    MyDrawing myDrawing;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_and_audio);
        circle=findViewById(R.id.circleButton);
        triangle=findViewById(R.id.triangleButton);
        rectangle=findViewById(R.id.rectangleButton);
        oval=findViewById(R.id.ovalButton);
        myDrawing=findViewById(R.id.myDrawing);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(getApplicationContext(),
                        R.raw.circle);
                mp.start();

                MyDrawing.shapeType="circle";
                myDrawing.invalidate();
            }
        });
        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(getApplicationContext(),
                        R.raw.triangle);
                mp.start();
                MyDrawing.shapeType="triangle";
                myDrawing.invalidate();
            }
        });
        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(getApplicationContext(),
                        R.raw.rectangle);
                mp.start();
                MyDrawing.shapeType="rectangle";
                myDrawing.invalidate();
            }
        });
        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(getApplicationContext(),
                        R.raw.oval);
                mp.start();
                MyDrawing.shapeType="oval";
                myDrawing.invalidate();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}