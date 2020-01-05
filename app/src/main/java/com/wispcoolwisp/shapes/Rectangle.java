package com.wispcoolwisp.shapes;

public class Rectangle extends Shape {

    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    protected double getSquare() {
        return width * height;
    }

    double getDiagonals() {
        return Math.sqrt(width * width + height * height);
    }
}
