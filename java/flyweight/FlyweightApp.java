package flyweight;

// Допустим, нам нужно создать много тысяч разных объектов

import java.util.HashMap;
import java.util.Map;

public class FlyweightApp {
    public static void main(String[] args) {

    }
}

// Flyweight
interface Shape{
    void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем точку");
    }
}

//Circle Flyweight
class Circle implements Shape{
    int r = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем круг с радиусом " + r);
    }
}

//Square Flyweight
class Square implements Shape{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): рисуем квадрат со стороной " + a);
    }
}

class ShapeFactory{
    private static final Map<String, Shape> SHAPES = new HashMap<>();

    public Shape getShape(String shapeName){
        Shape shape = SHAPES.get(shapeName);
        if (shape == null){

        }
        return null;
    }
}