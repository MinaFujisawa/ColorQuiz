package com.derrick.park.countryquiz;

import android.app.Activity;

import android.content.res.Resources;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    Random random = new Random();
    final int BTNNUM = 4;
    private ArrayList<Button> btnList = new ArrayList<>();
    private ArrayList<Integer> colorList = new ArrayList<>();
    private TextView mQustionColor;
    private TextView mCountDownText;
    private TextView mIndexText;
    private int questionIndex = 0;
    private int point = 1;

    private Question[] questionList = {
            new Question(R.string.c_blue),
            new Question(R.string.c_yellow),
            new Question(R.string.c_black),
            new Question(R.string.c_pink),
            new Question(R.string.c_red),
            new Question(R.string.c_green)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btnList.add((Button) findViewById(R.id.btn1));
        btnList.add((Button) findViewById(R.id.btn2));
        btnList.add((Button) findViewById(R.id.btn3));
        btnList.add((Button) findViewById(R.id.btn4));

        colorList.add(getResources().getColor(R.color.colorRed));
        colorList.add(getResources().getColor(R.color.colorBlack));
        colorList.add(getResources().getColor(R.color.colorBlue));
        colorList.add(getResources().getColor(R.color.colorGreen));
        colorList.add(getResources().getColor(R.color.colorYellow));
        colorList.add(getResources().getColor(R.color.colorPink));


        mIndexText = (TextView) findViewById(R.id.index);
        mIndexText.setText(String.valueOf(questionIndex));


        //first question
        mQustionColor = (TextView) findViewById(R.id.question_color);
        setQandA();


//        mBtnRed = (Button) findViewById(R.id.btn_red);
//        mBtnRed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                check("Red");
//                showQuestion();
//                countIndex();
//            }
//        });


    }


    private void check(String userAnswer) {
        if ((mQustionColor.getText().toString()).equals(userAnswer)) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            point++;
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void setQandA() {
        int QIndex = randomNum();
        mQustionColor.setText(questionList[QIndex].getQuestionColor());
        setAnswerBtn(QIndex);
        mQustionColor.setTextColor(colorList.get(randomNum()));
    }

    private void setAnswerBtn(int currentQIndex) {
        int ranNum = random.nextInt(BTNNUM);
        boolean num[] = new boolean[questionList.length];

        // set other option btns
        int i = 0;
        while (i < BTNNUM) {
            int p = random.nextInt(BTNNUM);
            if (num[p] == false && p != currentQIndex) {
                btnList.get(i).setText(questionList[p].getQuestionColor());
                num[p] = true;
                i++;
            }
        }

        // set collect answer btn
        btnList.get(ranNum).setText(mQustionColor.getText().toString());

    }

    private void countIndex() {
        questionIndex++;
        mIndexText.setText(String.valueOf(questionIndex));
    }

    private int randomNum() {
        return random.nextInt(questionList.length);
    }

}
