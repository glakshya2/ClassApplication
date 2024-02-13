package com.example.classapplication.uicomponents;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

public class UIComponents extends AppCompatActivity {

    CheckBox java, python, ruby;
    RadioGroup radioGroup;
    Button submit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);
        java = findViewById(R.id.checkBox);
        python = findViewById(R.id.checkBox2);
        ruby = findViewById(R.id.checkBox3);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = "";
                if (java.isChecked()) {
                    output += "JAVA";
                }
                if (python.isChecked()) {
                    output+= "PYTHON";
                }
                if (ruby.isChecked()) {
                    output += "RUBY";
                }
                Log.d("output", output);
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                char gender = ' ';
                if (checkedId == R.id.radioButton) {
                    gender = 'm';
                } else if (checkedId == R.id.radioButton2) {
                    gender = 'f';
                } else if (checkedId == R.id.radioButton3) {
                    gender = 't';
                }
                Log.d("output", String.valueOf(gender));
            }
        });
        spinner = findViewById(R.id.spinner);
        String[] items = {"nbvdfvd", "njbkfn", "fhuyireh"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.forspinner, items);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items[position];
                Log.d("output", selectedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}