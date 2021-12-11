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

    // Create webview and progress bar variables
    WebView w1;
    ProgressBar progress;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect webview and progressbar variables to views
        w1 = (WebView)findViewById(R.id.wv);
        progress = (ProgressBar)findViewById(R.id.progressBar);

        // Set beginning progress amount and max
        progress.setMax(100);
        progress.setProgress(0);

        // Start webview client with JavaScript functionality
        w1.setWebViewClient(new WebViewClient());
        w1.getSettings().setJavaScriptEnabled(true);
        w1.getSettings().setDomStorageEnabled(true);

        // Load Alpine Website
        w1.loadUrl("https://alpineproducts.com");

        // Set ChromeClient to track progress of website loading
        w1.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // Set progress to current progress
                progress.setProgress(newProgress);

                // Hides progress bar only when page loaded
                if (newProgress == 100) {
                    progress.setVisibility(View.GONE);
                } else {
                    progress.setVisibility(View.VISIBLE);
                }

                // Run usual progress method
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    // Change functionality of back button to go to previous web page
    @Override
    public void onBackPressed() {
        if (w1.canGoBack()) {
            w1.goBack();
        } else {
            super.onBackPressed();
        }
    }
}