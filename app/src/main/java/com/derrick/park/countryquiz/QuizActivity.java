package com.derrick.park.countryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private Random random = new Random();
    private QuizList quizList = new QuizList();
    final int BTNNUM = 4;
    private ArrayList<Button> btnList = new ArrayList<>();
    private List<Colors> colorList = new ArrayList<>();
    private TextView mQustionColor;
    private TextView mCountDownText;
    private TextView mIndexText;
    private int quizIndex = 0;
    private int mScore;
    int QIndex;

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        check(buttonText);

        setquiz();
        setAnswerBtn(QIndex);
        countIndex();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btnList.add((Button) findViewById(R.id.btn1));
        btnList.add((Button) findViewById(R.id.btn2));
        btnList.add((Button) findViewById(R.id.btn3));
        btnList.add((Button) findViewById(R.id.btn4));

        colorList.add(new Colors(getResources().getColor(R.color.colorRed), true));
        colorList.add(new Colors(getResources().getColor(R.color.colorBlack), true));
        colorList.add(new Colors(getResources().getColor(R.color.colorYellow), false));
        colorList.add(new Colors(getResources().getColor(R.color.colorBlue), true));
        colorList.add(new Colors(getResources().getColor(R.color.colorGreen), false));
        colorList.add(new Colors(getResources().getColor(R.color.colorPink), false));

        //Show Index number
        mIndexText = (TextView) findViewById(R.id.index);
        mIndexText.setText(String.valueOf(quizIndex));

        //CountDownTimer
        mCountDownText = (TextView) findViewById(R.id.countDown);
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mCountDownText.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                Intent intent = new Intent(getApplication(), ResultActivity.class);
                intent.putExtra("score", mScore);
                startActivity(intent);
            }

        }.start();


        //first quiz
        mQustionColor = (TextView) findViewById(R.id.quiz_color);
        setquiz();
        setAnswerBtn(QIndex);

        // add click listeners
        for (int i = 0; i < BTNNUM; i++) {
            btnList.get(i).setOnClickListener(this);
        }

    }


    private void check(String userAnswer) {
        if ((mQustionColor.getText().toString()).equals(userAnswer)) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void setquiz() {
        QIndex = randomNum();
        mQustionColor.setText(quizList.getQuizList()[QIndex].getQuiz());
        mQustionColor.setTextColor(colorList.get(randomNum()).getColorName());
    }

    private void setAnswerBtn(int currentQIndex) {
        boolean num[] = new boolean[quizList.getQuestionNum()];

        // set other option btns
        int i = 0;
        while (i < BTNNUM) {
            int p = random.nextInt(quizList.getQuestionNum());
            if (num[p] == false && p != currentQIndex) {
                btnList.get(i).setText(quizList.getQuizList()[p].getQuiz());
                num[p] = true;
                i++;
            }
        }
        // set collect answer btn
        btnList.get(random.nextInt(BTNNUM)).setText(mQustionColor.getText().toString());

        setColorToBtn();
    }


    private void setColorToBtn() {
        for (int i = 0; i < BTNNUM; i++) {
            int randNum = randomNum();
            btnList.get(i).setBackgroundColor(colorList.get(randNum).getColorName());
            if (colorList.get(randNum).isDeepColor()) {
                btnList.get(i).setTextColor(getResources().getColor(R.color.colorWhite));
            } else {
                btnList.get(i).setTextColor(getResources().getColor(R.color.colorBlack));
            }
        }
    }

    private void countIndex() {
        quizIndex++;
        mIndexText.setText(String.valueOf(quizIndex));
    }

    private int randomNum() {
        return random.nextInt(quizList.getQuestionNum());
    }
}