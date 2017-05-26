package com.derrick.park.countryquiz;

/**
 * Created by MinaFujisawa on 2017/05/19.
 */

public class Quiz {
    private int quiz;

    public Quiz(int quizColor) {
        this.quiz = quizColor;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuestion(int quizColor) {
        this.quiz = quizColor;
    }

}
