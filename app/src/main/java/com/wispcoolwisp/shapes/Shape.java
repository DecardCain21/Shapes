package com.wispcoolwisp.shapes;

import android.graphics.Color;

public abstract class Shape {

    //Допустим я решил задать всем фигурам по дефолту толщину строки 1.0
    protected double strokeWidth = 1.0;

    protected int color = Color.BLACK;

    protected abstract double getPerimeter();

    protected abstract double getSquare();

    //Здесь я задал стандартное задание строки.
    //В любой фигуре этот метод будет работать таким образом.
    //Но если к примеру в фигуре круг я хочу эту логику по другому реализовать,
    //я могу переопределить этот метод только в круге
    void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    double getStrokeWidth() {
        return strokeWidth;
    }

    public int getColor() {
        return color;
    }

    //Здесь у меня есть 2 метода задания цвета.
    //Я могу передать ему интовое значение
    //А могу передать строковое значение типа #519c3f и класс под капотом сам конвертирует мне его в инт
    //Это и есть перегрузка
    void setColor(int color) {
        this.color = color;
    }

    void setColor(String color) {
        this.color = Color.parseColor(color);
    }
}
