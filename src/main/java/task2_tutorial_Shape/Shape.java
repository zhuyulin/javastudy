package task2_tutorial_Shape;

/**
 * 1.父类“形状”，是抽象类。
 *  成员变量：颜色（枚举类：红黄蓝黑白），边数（int）
 *  构造函数参数：颜色，边数
 *  公共方法：获得颜色，获得边数
 *  抽象方法：面积，周长
 *2.子类“等边三角形”，“正方形”，“圆形”
 *  要有各自额外的成员变量
 *  构造要扩展自父类构造函数
 *  实现方法求面积，周长
 *3.写测试类创建4个子类打印出3个子类的颜色，边数，面积，周长
 * Created by Yuleen on 2016/12/10.
 */

public abstract class Shape {
    private Color color;
    private int edgeNumber;

    public Shape(Color color, int edgeNumber) {
        this.color = color;
        this.edgeNumber = edgeNumber;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public abstract double area();

    public abstract double perimeter();

}
