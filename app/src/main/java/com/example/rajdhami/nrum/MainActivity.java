package com.example.rajdhami.nrum;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    WebView wb;
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb=(WebView)findViewById(R.id.webView1);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.setWebViewClient(new HelloWebViewClient());
        wb.loadUrl("http://10.0.2.2/mahen.dev/nrum");
//        wb.loadUrl("http://192.168.137.1/mahen.dev/nrum");
    }
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if( url.startsWith("http:") || url.startsWith("https:") ) {
            return false;
        }
        // Otherwise allow the OS to handle it
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity( intent );
        return true;
    }
}
