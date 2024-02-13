package com.example.classapplication.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.classapplication.R;

public class Intents extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               Intent i = new Intent(Intent.ACTION_VIEW);
//               i.setData(Uri.parse("https://www.chennai.vit.ac.in"));
//                Intent i = new Intent(Intent.ACTION_DIAL);
//                i.setData(Uri.parse("tel:8454880847"));
//               Intent i = new Intent(Intent.ACTION_CALL);
//               i.setData(Uri.parse("tel:8454880847"));
//               Intent i = new Intent(Intent.ACTION_SENDTO);
//               i.setData(Uri.parse("mailto:glakshya629171@gmail.com"));
//               i.putExtra(Intent.EXTRA_EMAIL, new String[]{"glakshya009@gmail.com", "glakshya155@gmail.com"});
//               i.putExtra(Intent.EXTRA_CC, new String[]{"glakshya155@gmail.com"});
//               i.putExtra(Intent.EXTRA_BCC, new String[]{"glakshya55@gmail.com"});
//               i.putExtra(Intent.EXTRA_TEXT, "nkvnfjdnvkdfjnvdnvfkjnvjdn");
//               i.putExtra(Intent.EXTRA_SUBJECT, "njfdknv");
               Intent i = new Intent(getApplicationContext(), Intents2.class);
                i.putExtra("name", "lakshya");
                i.putExtra("array", new int[]{1,2,3,4});
                i.putExtra("floatArray", new float[]{1.0F, 2.0F});
                i.putExtra("double", 12.3);
               startActivity(i);
           }
        });
    }
}