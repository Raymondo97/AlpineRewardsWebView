package com.alpinereward;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    WebView w1;
    ProgressBar progress;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w1 = (WebView)findViewById(R.id.wv);
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setMax(100);
        w1.setWebViewClient(new WebViewClient());
        w1.getSettings().setJavaScriptEnabled(true);
        w1.getSettings().setDomStorageEnabled(true);
        w1.loadUrl("https://alpineproducts.com");
        progress.setProgress(0);

        w1.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setProgress(newProgress);
                if (newProgress == 100) {
                    progress.setVisibility(View.GONE);
                } else {
                    progress.setVisibility(View.VISIBLE);
                }

                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (w1.canGoBack()) {
            w1.goBack();
        } else {
            super.onBackPressed();
        }
    }
}