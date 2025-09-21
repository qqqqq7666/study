package oop1.ex;

public class RectangleProcedural {
    int width;
    int height;

    int calculateArea(){
        System.out.println("area = " + width * height);
        return width * height;
    }

    int calculatePerimeter(){
        System.out.println("perimeter = " + (width * 2 + height * 2));
        return width * 2 + height * 2;
    }

    boolean isSquare(){
        if(width == height)
            return true;
        else
            return false;
    }
}
