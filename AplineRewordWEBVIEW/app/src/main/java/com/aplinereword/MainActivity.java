package com.aplinereword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w1 = (WebView)findViewById(R.id.wv);
        w1.setWebViewClient(new WebViewClient());
        w1.loadUrl("https://alpineproducts.com");
    }
}