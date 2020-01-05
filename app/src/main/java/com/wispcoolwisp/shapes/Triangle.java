package com.wispcoolwisp.shapes;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected double getPerimeter() {
        return a + b + c;
    }

    @Override
    protected double getSquare() {
        double perimeter = getPerimeter();
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }
}
