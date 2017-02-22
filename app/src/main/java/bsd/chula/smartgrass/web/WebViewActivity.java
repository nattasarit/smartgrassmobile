package bsd.chula.smartgrass.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/21/17.
 */

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    private String URL = "http://smartgrasss.gear.host/test/index.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(URL);
    }

}
