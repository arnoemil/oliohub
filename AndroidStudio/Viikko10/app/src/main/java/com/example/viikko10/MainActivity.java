package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    WebView web;
    Button refresh;
    EditText webAddressBar;
    LinkedList<String> history = new LinkedList<String>();
    int countPrevious = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        refresh = findViewById(R.id.refresh);
        webAddressBar = findViewById(R.id.webAddress);


        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView v, String url) {
                if (history.isEmpty() || !history.contains(url))
                    history.add(url);
                    System.out.println(history);
            }
        });

        web.getSettings().setJavaScriptEnabled(true);
        //web.loadUrl(String.valueOf(webAddressBar.getText()));

        webAddressBar.setOnKeyListener(this);
    }



    @Override
    public boolean onKey(View v, int i, KeyEvent keyEvent) {
        if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
            String url = String.valueOf(webAddressBar.getText());
            if (url.equals("index.html")) {
                web.loadUrl("file:///android_asset/index.html");
            } else {
                web.loadUrl(url);
            }
            return true;
        }
        return false;
    }



    public void refreshPage(View v) {
        int i = history.size();
        System.out.println(i);
        web.loadUrl(history.get(i - 1));
    }

    public void previousPage(View v) {
        int size = history.size();
        if (size > 1) {
            if (countPrevious < size) {
                countPrevious++;
            }
            web.loadUrl(history.get(size - countPrevious));
            System.out.println(history);
            System.out.println(countPrevious);
        }
    }

    public void nextPage(View v) {
        int size = history.size();
        if (size > 1) {
                if (countPrevious > 1) {
                    countPrevious--;
                }
                web.loadUrl(history.get(size - countPrevious));
                System.out.println(history);
                System.out.println(countPrevious);
            }
        }

    public void initializeButton(View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void shoutOutButton(View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }
}