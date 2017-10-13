package com.derrick.park.countryquiz;

/**
 * Created by MinaFujisawa on 2017/05/24.
 */

public class QuizList {
    private Quiz[] quizList = {
            new Quiz(R.string.c_blue),
            new Quiz(R.string.c_yellow),
            new Quiz(R.string.c_black),
            new Quiz(R.string.c_pink),
            new Quiz(R.string.c_red),
            new Quiz(R.string.c_green)
    };

    public Quiz[] getQuizList() {
        return quizList;
    }

    public int getQuestionLength(){
        return quizList.length;
    }

}
