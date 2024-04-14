package com.example.classapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.classapplication.R;

public class ParentforFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentfor_fragment);
    }
    public void change(View view){
        FragmentTransaction ft=getSupportFragmentManager()
                .beginTransaction();
        if(view.getId()==R.id.button13){
            ft.replace(R.id.l22,new f1());
        }
        else if(view.getId()==R.id.button14){
            ft.replace(R.id.l22,new f2());
        }
        ft.commit();
    }
}