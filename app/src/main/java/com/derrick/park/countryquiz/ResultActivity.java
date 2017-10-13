package com.derrick.park.countryquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private QuizList quizList = new QuizList();
    private Button mRetryBtn;
    private TextView mScoreTextView;
    private TextView mQuestionNumTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mScoreTextView = (TextView) findViewById(R.id.score);
        int score = getIntent().getIntExtra("score", 0);
        mScoreTextView.setText(String.valueOf(score));

//        mQuestionNumTextView = (TextView) findViewById(R.id.questionNum);
//        mQuestionNumTextView.setText(String.valueOf(quizList.getQuestionNum()));

        mRetryBtn = (Button) findViewById(R.id.btn_retry);
        mRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
