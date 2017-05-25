package com.derrick.park.countryquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    private Button mRetryBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mRetryBtn = (Button) findViewById(R.id.btn_retry);
        mRetryBtn.setOnClickListener(new View.OnClickListener() {

        }
    }
}
