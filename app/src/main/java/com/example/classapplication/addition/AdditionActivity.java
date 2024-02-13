package com.example.classapplication.addition;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classapplication.R;

public class AdditionActivity extends Activity {
    EditText op1, op2;
    TextView result;
    Button add, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        op1 = findViewById(R.id.operand1);
        op2 = findViewById(R.id.operand2);
        result = findViewById(R.id.result);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(op1.getText().toString());
                float b = Float.parseFloat(op2.getText().toString());
                result.setText(String.format("%s", a + b));
                Toast.makeText(getApplicationContext(), String.format("%s", a + b), Toast.LENGTH_LONG).show();
                Log.d("Result", String.format("%s", a + b));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(op1.getText().toString());
                float b = Float.parseFloat(op2.getText().toString());
                result.setText(String.format("%s", a - b));
                Toast.makeText(getApplicationContext(), String.format("%s", a - b), Toast.LENGTH_SHORT).show();
                Log.d("Result", String.format("%s", a - b));
            }
        });
    }
}