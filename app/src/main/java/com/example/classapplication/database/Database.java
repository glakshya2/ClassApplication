package com.example.classapplication.database;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

public class Database extends AppCompatActivity {

    EditText name, age, email;
    Button add, retrieve;

    TableLayout tableLayout;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_database);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        add = findViewById(R.id.addRow);
        retrieve = findViewById(R.id.retrieve);
        tableLayout = findViewById(R.id.tableLayout);
        databaseHelper = new DatabaseHelper(this, "myDb", null, 1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.addData(name.getText().toString(), Integer.parseInt(age.getText().toString()), email.getText().toString());
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = databaseHelper.getData();
                cursor.moveToFirst();
                tableLayout.removeAllViews();
                do {
                    TextView nameView = new TextView(getApplicationContext());
                    nameView.setText(cursor.getString(0));
                    TextView ageView = new TextView(getApplicationContext());
                    ageView.setText(cursor.getString(1));
                    TextView emailView = new TextView(getApplicationContext());
                    emailView.setText(cursor.getString(2));
                    TableRow tableRow = new TableRow(getApplicationContext());
                    tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    tableRow.addView(nameView);
                    tableRow.addView(ageView);
                    tableRow.addView(emailView);
                    tableLayout.addView(tableRow);
                } while (cursor.moveToNext());
            }
        });
    }
}