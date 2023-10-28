package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView2 = findViewById(R.id.webView);
        WebSettings webSettings = webView2.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView2.addJavascriptInterface(new JavaScriptInterface(), "appInterface");
    }
    
    public void loadURL(View view){
        EditText urlEditText = findViewById(R.id.et_url);
        String url = urlEditText.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this, "Ingresa una URL Valida", Toast.LENGTH_SHORT).show();
        }else{
            webView2.loadUrl(url);
        }
    }

    private class JavaScriptInterface{
        @android.webkit.JavascriptInterface
        public void showToast(String message){

        }
    }
}