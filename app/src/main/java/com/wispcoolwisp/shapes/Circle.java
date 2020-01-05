package com.wispcoolwisp.shapes;

public class Circle extends Shape {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected double getSquare() {
        return Math.PI * radius * radius;
    }

    //Допустим я хочу, чтоб тут толщина строки всегда была в 2 раза толще.
    //Если этот метод не переопределять то он будет работать как в родителе
    @Override
    protected void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth * 2;
    }
}
