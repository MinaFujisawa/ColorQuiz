package com.derrick.park.countryquiz;

/**
 * Created by MinaFujisawa on 2017/05/19.
 */

public class Quiz {
    private int colorNameStringId;

    public Quiz(int quizColor) {
        this.colorNameStringId = quizColor;
    }

    public int getColorNameStringId() {
        return colorNameStringId;
    }

    public void setQuestion(int quizColor) {
        this.colorNameStringId = quizColor;
    }

}
