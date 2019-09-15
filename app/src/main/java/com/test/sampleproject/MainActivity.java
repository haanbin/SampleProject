package com.test.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hawk.init(this).build();
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tts_text);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(this, TTSActivity.class);
            startActivity(intent);
        });
        TextView textView2 = findViewById(R.id.notification_text);
        textView2.setOnClickListener(v -> {
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        });


    }
}