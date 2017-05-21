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
    private TextView mIndexText;
    private int questionIndex = 0;
    private int point = 1;

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

        mIndexText = (TextView) findViewById(R.id.index);
        mIndexText.setText(String.valueOf(questionIndex));


        //first question
        mQustionColor = (TextView) findViewById(R.id.question_color);
        showQuestion();


        mBtnRed = (Button) findViewById(R.id.btn_red);
        mBtnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Red");
                showQuestion();
                countIndex();
            }
        });

        mBtnGreen = (Button) findViewById(R.id.btn_green);
        mBtnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Green");
                questionIndex++;
                showQuestion();
                countIndex();
            }

        });

        mBtnBlue = (Button) findViewById(R.id.btn_blue);
        mBtnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Blue");
                questionIndex++;
                showQuestion();
                countIndex();
            }

        });

        mBtnYellow = (Button) findViewById(R.id.btn_yellow);
        mBtnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check("Yellow");
                questionIndex++;
                showQuestion();
                countIndex();
            }

        });

    }

    private void check(String userAnswer) {
        if ((mQustionColor.getText().toString()).equals(userAnswer)) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void showQuestion(){
        mQustionColor.setText(questionList[randomNum()].getQuestionColor());
        int colorList[]  =  {
                getResources().getColor(R.color.colorRed),
                getResources().getColor(R.color.colorBlue),
                getResources().getColor(R.color.colorYellow),
                getResources().getColor(R.color.colorGreen)
        };
        mQustionColor.setTextColor(colorList[randomNum()]);
    }

    private void countIndex(){
        questionIndex++;
        mIndexText.setText(String.valueOf(questionIndex));
    }

    private int randomNum(){
        return random.nextInt(questionList.length);
    }

}
