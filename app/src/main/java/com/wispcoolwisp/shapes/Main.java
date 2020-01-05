package com.wispcoolwisp.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();

//      Вот это восходящее преобразование, оно происходит автоматически
//      у rect1 я могу вызвать только те методы которые есть у Shape
        Shape rect1 = new Rectangle(10, 15);
        rect1.getPerimeter(); //OK
        rect1.getSquare(); //OK
//        rect1.getDiagonals(); Ошибка. Такого метода нет в классе Shape

        Rectangle rect2 = new Rectangle(12.6, 19.1);
        rect2.getPerimeter();//OK
        rect2.getSquare();//OK
        rect2.getDiagonals();//OK. Потому, что здесь я работаю с квадратом не как с фигурой, а как с квадратом.

        Shape triangle1 = new Triangle(1.3, 3, 6.7);
        Triangle triangle2 = new Triangle(12, 10, 9.6);

        Shape circle1 = new Circle(7);
        Circle circle2 = new Circle(19.3);

        shapes.add(rect1);
        shapes.add(rect2);
        shapes.add(triangle1);
        shapes.add(triangle2);
        shapes.add(circle1);
        shapes.add(circle2);

//      Тут я мог бы каждый раз писать цикл в котором бы проходился по всем элементам списка.
//      Но я инкапсулировал логику.
//      У меня есть общая логика: пройтись по списку, а меняться может только список который я ему дам на вход
//      Таким образом я могу переиспользовать код.
        showShapesSquare(shapes);
        showShapesPerimeters(shapes);
        getShapeType(shapes);

        //Обрати внимание, что когда выводится толщина строки кругов(они последние в списке) то она удвоена
        //т.к. я переопределил этот метод в классе Circle. А в остальных она равна тому же значению, что я задал
        setStrokeWidth(shapes);


        ////////////////////////////////////////////////////////////////////////////////////////////
        List<Shape> anotherShapes = new ArrayList<>();

        Shape anotherRect1 = new Rectangle(10, 15);
        Rectangle anotherRect2 = new Rectangle(12.6, 19.1);

        Shape anotherTriangle1 = new Triangle(1.3, 3, 6.7);
        Triangle anotherTriangle2 = new Triangle(12, 10, 9.6);

        Shape anotherCircle1 = new Circle(7);
        Circle anotherCircle2 = new Circle(19.3);

        shapes.add(anotherRect1);
        shapes.add(anotherRect2);
        shapes.add(anotherTriangle1);
        shapes.add(anotherTriangle2);
        shapes.add(anotherCircle1);
        shapes.add(anotherCircle2);

        showShapesSquare(anotherShapes);
        showShapesPerimeters(anotherShapes);
        getShapeType(anotherShapes);

        ////////////////////////////////////////////////////////////////////////////////////////////
        Shape someRectangle = new Rectangle(5, 7);
        //double diagonal = someRectangle.getDiagonal(); ошибка, потому что ты объявил объект как фигуру,
        //и он не знает про существоание методов получения диагонали

        //А здесь я явно говорю компилятору, что someRectangle является квадратом.
        //Но за такое нисходящее преобразование отвечает программист.
        double diagonal = ((Rectangle)someRectangle).getDiagonals();

        Shape someShape = new Circle(9);
        //Здесь я тоже делаю нисходящее преобразование и тоже могу вызвать метод getDiagonals().
        //Компилятор мне доверяет, но когда программа попытается это сделать, она упадет, потому что по факту там круг, а не квадрат
        //double someDiagonal = ((Rectangle)someShape).getDiagonals();
    }

    //Вот тут я инкапсулировал локигу вывода на экран площадей фигур
    private static void showShapesSquare(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Square = " + shape.getSquare());
        }
    }

    //Вот тут я инкапсулировал локигу вывода на экран периметров фигур
    private static void showShapesPerimeters(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Perimeter = " + shape.getPerimeter());
        }
    }

    //Вот тут я инкапсулировал локигу вывода на экран типов фигур
    private static void getShapeType(List<Shape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
//            shape.getDiagonals(); Error, тут компилятор не знает квадрат ли это. Если к примеру тут будет круг, то программа упадет
            if (shape instanceof Rectangle) {
                //Нисходящее преобразование. Должно приводится явно
                ((Rectangle) shape).getDiagonals();//OK Так как ты проверил выше, что shape это квадрат и ты можешь вызывать методы квадрата
                System.out.println("Shape by index " + i + " is Rectangle");
            } else if (shape instanceof Circle) {
                System.out.println("Shape by index " + i + " is Circle");
            } else if (shape instanceof Triangle) {
                System.out.println("Shape by index " + i + " is Triangle");
            } else {
                System.out.println("Shape by index " + i + " is unknown shape");
            }
        }
    }

    private static void setStrokeWidth(List<Shape> shapes) {
        for (Shape shape : shapes) {
            int random = new Random().nextInt(10);
            shape.setStrokeWidth(random);
            System.out.println("Random =  " + random + "\nShape has strokeWidth = " + shape.getStrokeWidth() + "\n");
        }
    }
}
