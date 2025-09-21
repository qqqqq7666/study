package oop1.ex;

public class RectangleProceduralMain {
    public static void main(String[] args) {
        RectangleProcedural rectangleProcedural = new RectangleProcedural();
        rectangleProcedural.width = 5;
        rectangleProcedural.height = 8;
        rectangleProcedural.calculateArea();
        rectangleProcedural.calculatePerimeter();
        if (rectangleProcedural.isSquare())
            System.out.println("square");
        else
            System.out.println("rectangle");
    }
}
