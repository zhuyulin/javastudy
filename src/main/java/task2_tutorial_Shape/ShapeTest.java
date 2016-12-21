package task2_tutorial_Shape;

/**
 * Created by Yuleen on 2016/12/10.
 */
public class ShapeTest {
    public static void main(String[] args){
        //Shape square = new Square(Color.black,4,10);
        Square square = new Square(Color.black,4,10);
        System.out.println("正方形的面积"+square.area());
        System.out.println("正方形的周长"+square.perimeter());
        System.out.println("正方形的颜色"+square.getColor());


        //Shape circle = new Circle(Color.black,4);
        Circle circle = new Circle(Color.black,4);
        System.out.println("圆的面积"+circle.area());
        System.out.println("圆的周长"+circle.perimeter());
        System.out.println("圆的颜色"+circle.getColor());
    }
}
