package com.example.classapplication.addRows;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

public class AddRows extends Activity {
    Button add, extract;
    LinearLayout vertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rows);
        add = findViewById(R.id.button8);
        extract = findViewById(R.id.button10);
        vertical = findViewById(R.id.container);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRow();
            }
        });
        extract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extract();
            }
        });
    }

    void extract() {
        for (int i = 0; i < vertical.getChildCount(); i++) {
            LinearLayout horizontal = (LinearLayout) vertical.getChildAt(i);
            EditText edit = (EditText) horizontal.getChildAt(0);
            Log.d("output", edit.getText().toString());
            edit = (EditText) horizontal.getChildAt(1);
            Log.d("output", edit.getText().toString());
        }
    }
    void addRow() {
        LinearLayout horizontal = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        horizontal.setLayoutParams(layoutParams);
        EditText name = new EditText(this);
        EditText email = new EditText(this);
        Button del = new Button(this);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vertical.removeView(horizontal);
            }
        });
        horizontal.addView(name);
        horizontal.addView(email);
        horizontal.addView(del);
        vertical.addView(horizontal);
    }


}