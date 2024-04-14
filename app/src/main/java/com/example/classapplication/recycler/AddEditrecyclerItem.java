package com.example.classapplication.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AddEditrecyclerItem extends AppCompatActivity {
    EditText nameEditText, emailEditText, ageEditText, imageEditText;
    Button okButton, cancelButton;
    ArrayList<Person> personList;
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
        personList = RecyclerHelper.personList;
        personList.add(new Person(nameEditText.getText().toString(), emailEditText.getText().toString(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBmhiayzUj7t9rq8b1nL1S0eSDUHYeK1d6kPvb3OFtsQ&s", Integer.parseInt(ageEditText.getText().toString())));
        startActivity(new Intent(getApplicationContext(), RecycleViewActivity.class));
    }
}