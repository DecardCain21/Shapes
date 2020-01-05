package com.wispcoolwisp.shapes;

public abstract class Shape {

    //Допустим я решил задать всем фигурам по дефолту толщину строки 1.0
    protected double strokeWidth = 1.0;

    protected abstract double getPerimeter();

    protected abstract double getSquare();

    //Здесь я задал стандартное задание строки.
    //В любой фигуре этот метод будет работать таким образом.
    //Но если к примеру в фигуре круг я хочу эту логику по другому реализовать,
    //я могу переопределить этот метод только в круге
    protected void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    double getStrokeWidth() {
        return strokeWidth;
    }
}
