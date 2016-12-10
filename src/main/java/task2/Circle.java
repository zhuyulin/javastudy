package task2;

/**
 * Created by Yuleen on 2016/12/10.
 */
public class Circle extends Shape {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return radius * 2 * Math.PI;
    }

}
