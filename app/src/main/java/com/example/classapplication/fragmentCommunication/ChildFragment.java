package com.example.classapplication.fragmentCommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.classapplication.R;

public class ChildFragment extends Fragment {
    interface SimpleEvent{
        void transferData(String message);
    }
    SimpleEvent simpleEvent;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        simpleEvent=(SimpleEvent) context;
    }
    EditText inputdata;
    Button clicktoSend;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_child, container, false);
        inputdata=view.findViewById(R.id.editTextText10);
        clicktoSend=view.findViewById(R.id.button17);
        textView=view.findViewById(R.id.recieve);
        clicktoSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleEvent.transferData(inputdata.getText().toString());
            }
        });
        return view;
    }
    public void ReceiveData(String message){
        textView.setText(message);
    }
}