package com.company.enums;

/**
 * Created by alex_ on 6/12/2017.
 */
public enum Color {
    WHITE("White"),
    BLACK("Black"),
    EMPTY("Empty");

    private final String color;


    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
