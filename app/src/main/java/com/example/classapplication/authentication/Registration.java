package com.example.classapplication.authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    EditText email, password;
    Button register;
    TextView signIn;
    FirebaseAuth auth;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.editTextTextEmailRegister);
        password = findViewById(R.id.editTextTextPasswordRegister);
        register = findViewById(R.id.buttonRegister);
        signIn = findViewById(R.id.textViewSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignIn.class));
            }
        });
        auth = FirebaseAuth.getInstance();
        sharedPreferences = getApplication().getSharedPreferences("my-pref", 0);
        editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("isRegistered", false)) {
            startActivity(new Intent(getApplicationContext(), SignIn.class));
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                                    editor.putBoolean("isRegistered", true);
                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), SignIn.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }
}