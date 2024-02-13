package com.example.classapplication.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.classapplication.R;

public class Calculator extends Activity {

    TextView result;
    Button plus, minus, multiply, divide, dot, equal, clear;
    Button[] digits = new Button[10];

    float op1, op2;

    char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result = findViewById(R.id.result1);
        digits[0] = findViewById(R.id.number0);
        digits[1] = findViewById(R.id.number1);
        digits[2] = findViewById(R.id.number2);
        digits[3] = findViewById(R.id.number3);
        digits[4] = findViewById(R.id.number4);
        digits[5] = findViewById(R.id.number5);
        digits[6] = findViewById(R.id.number6);
        digits[7] = findViewById(R.id.number7);
        digits[8] = findViewById(R.id.number8);
        digits[9] = findViewById(R.id.number9);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.star);
        divide = findViewById(R.id.div);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equa);
        clear = findViewById(R.id.clear);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            digits[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    String temp = result.getText().toString();
//                    temp += finalI;
//                    result.setText(temp);
                    result.append(String.format("%s", finalI));
                }
            });
        }
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                result.append(".");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation('+');
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation('-');
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation('*');
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation('/');
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op2 = Float.parseFloat(result.getText().toString());
                result.setText(String.format("%s", performOperation(operation)));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(null);
            }
        });
    }

    float performOperation(char operation) {
        switch (operation) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                return 0;
        }
    }
    void setOperation(char operation) {
        this.operation = operation;
        op1 = Float.parseFloat(result.getText().toString());
        result.setText(null);
    }
}