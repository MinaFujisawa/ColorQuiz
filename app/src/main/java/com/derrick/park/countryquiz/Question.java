package com.derrick.park.countryquiz;

/**
 * Created by MinaFujisawa on 2017/05/19.
 */

public class Question {
    private int questionText;
    private boolean answer;

    public Question(int questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public int getQuestionText() {
        return questionText;
    }

    public void setQuestionText(int questionText) {
        this.questionText = questionText;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
