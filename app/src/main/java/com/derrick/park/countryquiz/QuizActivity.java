package com.derrick.park.countryquiz;

import android.app.Activity;

import android.content.res.Resources;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    Random random = new Random();
    private Button mBtnRed;
    private Button mBtnGreen;
    private Button mBtnYellow;
    private Button mBtnBlue;
    private TextView mQustionColor;
    private TextView mCountDownText;
    private int questionIndex = 0;
    private int point = 0;

    private Question[] questionList = {
            new Question(R.string.c_blue),
            new Question(R.string.c_yellow),
            new Question(R.string.c_red),
            new Question(R.string.c_green)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //first question
        mQustionColor = (TextView) findViewById(R.id.question_color);
        mQustionColor.setText(questionList[randomNum()].getQuestionColor());


        mBtnRed = (Button) findViewById(R.id.btn_red);
        mBtnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Red");
            }
        });

        mBtnGreen = (Button) findViewById(R.id.btn_green);
        mBtnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Green");
            }

        });

//        mNextButton = (ImageButton) findViewById(R.id.next_button);
//        mNextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                questionIndex++;
//                questionIndex = questionIndex % (questionList.length);
//                mQustionColor = (TextView) findViewById(R.id.question_text);
//                mQustionColor.setText(questionList[questionIndex].getQuestionText());
//            }
//        });
//
    }

    private void check(String userAnswer) {
        if (String.valueOf(questionList[randomNum()].getQuestionColor()).   equals(userAnswer)) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private int randomNum(){
        return random.nextInt(questionList.length);
    }

}
