package com.example.mihw.livedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    private Button sendMsgMainPageBt;
    private EditText inputMsgEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        initView();
    }

    private void initView() {
        sendMsgMainPageBt = findViewById(R.id.send_message_main_page_bt);
        inputMsgEt = findViewById(R.id.inout_message_et);

        sendMsgMainPageBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = inputMsgEt.getText().toString();
                if (!TextUtils.isEmpty(value)) {
                    LiveDataBus.get().with(MainActivity.KEY_TEST).setValue(value);
                    finish();
                } else {
                    Toast.makeText(OtherActivity.this, "请输入文字", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
