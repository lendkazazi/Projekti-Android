package lendkazazi.com.projektifinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button customView;
    private Button viewPager;
    private Button apiList;
    private Button webView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = (Button) findViewById(R.id.customView);
        viewPager = (Button) findViewById(R.id.viewpager);
        apiList = (Button) findViewById(R.id.apilist);
        webView = (Button) findViewById(R.id.webView);
        editText = (EditText) findViewById(R.id.edit_text);

        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomView.class));
            }
        });

        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewPagerExample.class));
            }
        });

        apiList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ApiListActivity.class));
            }
        });

        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WebViewExample.class));
            }
        });

        if (savedInstanceState != null) {
            String txt = savedInstanceState.getString("editText");
            assert txt != null;
            if (!txt.isEmpty()) {
                editText.setText(txt);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("editText", editText.getText().toString());
    }
}
