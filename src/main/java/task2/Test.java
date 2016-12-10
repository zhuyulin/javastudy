package task2;

/**
 * Created by Yuleen on 2016/12/10.
 */
public class Test {
    public static void main(String[] args){
        Shape square = new Square(Color.black,4,10);
        System.out.println("长方形的面积"+square.area());
        System.out.println("长方形的周长"+square.perimeter());

        Shape circle = new Circle(Color.black,4);
        System.out.println("圆的面积"+circle.area());
        System.out.println("圆的周长"+circle.perimeter());
    }
}
