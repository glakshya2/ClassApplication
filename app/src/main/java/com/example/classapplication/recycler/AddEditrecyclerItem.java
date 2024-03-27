package com.example.classapplication.recycler;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

public class AddEditrecyclerItem extends AppCompatActivity {
    EditText nameEditText, emailEditText, ageEditText, imageEditText;
    Button okButton, cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_editrecycler_item);
        nameEditText = findViewById(R.id.addeditname);
        emailEditText = findViewById(R.id.addeditemail);
        ageEditText = findViewById(R.id.addeditage);
        imageEditText = findViewById(R.id.addeditimage);
        okButton = findViewById(R.id.addeditok);
        cancelButton = findViewById(R.id.addeditcancel);
    }
}