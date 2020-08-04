package com.test.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.orhanobut.hawk.Hawk;
import com.test.sampleproject.dialogtest.DialogTestActivity;
import com.test.sampleproject.html.HtmlActivity;
import com.test.sampleproject.notification.NotificationActivity;
import com.test.sampleproject.pdf.PdfActivity;
import com.test.sampleproject.tts.TTSActivity;

import org.w3c.dom.Text;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hawk.init(this).build();
        Timber.plant(new Timber.DebugTree());
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(count++));
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "테스트");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        TextView textView = findViewById(R.id.tts_text);
        textView.setOnClickListener(v -> {
            Bundle bundle1 = new Bundle();
            Intent intent = new Intent(this, TTSActivity.class);
            startActivity(intent);
        });
        TextView textView2 = findViewById(R.id.notification_text);
        textView2.setOnClickListener(v -> {
            Bundle bundle2 = new Bundle();
            bundle2.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle2.putString(FirebaseAnalytics.Param.ITEM_NAME, "1");
            bundle2.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
            mFirebaseAnalytics.logEvent("개찰", bundle2);
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        });
        TextView textView3 = findViewById(R.id.dialog_text);
        textView3.setOnClickListener(v -> {
            Bundle bundle2 = new Bundle();
            bundle2.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle2.putString(FirebaseAnalytics.Param.ITEM_NAME, "1");
//            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle2);
            mFirebaseAnalytics.logEvent("투찰", bundle2);
            Intent intent = new Intent(this, DialogTestActivity.class);
            startActivity(intent);
        });
        TextView textView4 = findViewById(R.id.pdf_text);
        textView4.setOnClickListener(v -> {
            Bundle bundle2 = new Bundle();
            bundle2.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle2.putString(FirebaseAnalytics.Param.ITEM_NAME, "1");
            mFirebaseAnalytics.logEvent("기간", bundle2);
//            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle2);
            Intent intent = new Intent(this, PdfActivity.class);
            startActivity(intent);
        });
        TextView textView5 = findViewById(R.id.html_text);
        textView5.setOnClickListener(v -> {
            Intent intent = new Intent(this, HtmlActivity.class);
            startActivity(intent);
        });
    }
}
