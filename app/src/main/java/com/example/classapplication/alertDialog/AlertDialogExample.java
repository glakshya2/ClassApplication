package com.example.classapplication.alertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.classapplication.R;

public class AlertDialogExample extends Activity {

    ProgressBar progressBar;
    Button button, inc, dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_example);
        button = findViewById(R.id.button3);
        inc = findViewById(R.id.button5);
        dec = findViewById(R.id.button4);
        progressBar = findViewById(R.id.progressBar);
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(Math.min(progressBar.getProgress() + 10, 100));
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(Math.max(progressBar.getProgress() - 10, 0));
            }
        });
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Dialog title");
        alertDialog.setMessage("Alert Dialog message");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("output", String.valueOf(which));
                dialog.cancel();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("output", String.valueOf(which));
            }
        });
        alertDialog.setNeutralButton("NEUTRAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("output", String.valueOf(which));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}