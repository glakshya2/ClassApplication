package com.example.classapplication.fragmentCommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classapplication.R;

public class HostActivity extends AppCompatActivity implements ChildFragment.SimpleEvent{

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        editText=findViewById(R.id.message);
        textView=findViewById(R.id.textView5);
        button=findViewById(R.id.senddata1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildFragment childFragment=
                        (ChildFragment) getSupportFragmentManager()
                                .findFragmentById(R.id.childfragment);
                childFragment.ReceiveData(editText.getText().toString());
            }
        });
    }
    public void transferData(String message){
//        Toast.makeText(HostActivity.this,message,Toast.LENGTH_LONG).show();
        textView.setText(message);
    }
}