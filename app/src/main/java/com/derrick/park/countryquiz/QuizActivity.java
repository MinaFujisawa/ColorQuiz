package com.derrick.park.countryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {
    private Button mTureButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQustionText;
    private int questionIndex = 0;

    private Question[] questionList = {
            new Question(R.string.q_Canada, false),
            new Question(R.string.q_France, true),
            new Question(R.string.q_japan, true),
            new Question(R.string.q_USA, false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //first question
        mQustionText = (TextView) findViewById(R.id.question_text);
        mQustionText.setText(questionList[0].getQuestionText());


        mTureButton = (Button) findViewById(R.id.true_button);
        mTureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // anything you want when the button is pressed
                result(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result(false);
            }

        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionIndex++;
                questionIndex = questionIndex % (questionList.length);
                mQustionText = (TextView) findViewById(R.id.question_text);
                mQustionText.setText(questionList[questionIndex].getQuestionText());
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionIndex == 0 ){
                    questionIndex = questionList.length-1;
                } else {
                    questionIndex--;
                }

                mQustionText = (TextView) findViewById(R.id.question_text);
                mQustionText.setText(questionList[questionIndex].getQuestionText());
            }
        });
    }

    private void result(boolean userAnswer) {
        if (questionList[questionIndex].getAnswer() == userAnswer) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

}
