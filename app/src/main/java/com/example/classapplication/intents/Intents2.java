package com.example.classapplication.intents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

import java.util.Arrays;

public class Intents2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents2);
        Intent i = getIntent();
        Log.d("tag", i.getStringExtra("name"));
        Log.d("tag", Arrays.toString(i.getIntArrayExtra("array")));
        Log.d("tag", Arrays.toString(i.getFloatArrayExtra("floatArray")));
        Log.d("tag", String.valueOf(i.getDoubleExtra("double", 0.0)));
    }
}