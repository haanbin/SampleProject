package com.test.sampleproject.html;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import com.test.sampleproject.R;

import java.util.ArrayList;
import java.util.Set;

public class HtmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_activity);
        /*TextView textView = findViewById(R.id.html_test_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(htmlText));
        }*/

        WebView webView = findViewById(R.id.html_text_webView);
//        webView.loadData(htmlText, "text/html", "UTF-8");
    }
}