package bsd.chula.smartgrass.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/21/17.
 */

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView mWebView;

    public static final String EXTRA_URL = "EXTRA_URL";

    private String URL = "http://websmartgrass.gear.host/core_testing/SmartGrassNew.html?WOID=04";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        URL = getIntent().getStringExtra(EXTRA_URL);

        initView();
    }

    private void initView() {

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        mWebView.loadUrl(URL);
    }

   /* @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.pauseTimers();
            mWebView.onHide();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.resumeTimers();
            mWebView.onShow();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.onDestroy();
        }
    }*/
}
