package lendkazazi.com.projektifinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by kazazi on 11/01/2018.
 */

public class WebViewExample extends AppCompatActivity {

    WebView web_view_container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        web_view_container = (WebView) findViewById(R.id.web_view_container);
        web_view_container.getSettings().setJavaScriptEnabled(true);
        web_view_container.getSettings().setLoadWithOverviewMode(true);
        web_view_container.getSettings().setUseWideViewPort(true);
        web_view_container.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
            }
        });
        web_view_container.loadUrl("http://www.google.com/");
    }
}
