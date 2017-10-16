package com.derrick.park.stroopTest;

/**
 * Created by MinaFujisawa on 2017/05/21.
 */

public class Color {
    private int colorId;
    private String colorName;
    private boolean canBeBlackBg;

    public Color(int colorId, String colorName, boolean isDeepColor) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.canBeBlackBg = isDeepColor;
    }

    public String getColorName() {
        return colorName;
    }

    public int getColorId() {
        return colorId;
    }

    public boolean canBeBlackBg() {
        return canBeBlackBg;
    }
}
