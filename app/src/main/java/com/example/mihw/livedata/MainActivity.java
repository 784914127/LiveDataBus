package com.example.mihw.livedata;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_TEST = "KEY_TEST";
    private static final String TAG = "MainActivity";
    private Button toOtherPage;
    private TextView otherPageValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toOtherPage = findViewById(R.id.to_other_page_bt);
        otherPageValue = findViewById(R.id.other_page_value_tv);

        toOtherPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });

        //订阅
        LiveDataBus.get().with(KEY_TEST, String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i(TAG, "++s+++" + s);
                otherPageValue.setText(s);
            }
        });
    }
}
