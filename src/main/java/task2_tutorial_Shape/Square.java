package task2_tutorial_Shape;

/**
 * Created by Yuleen on 2016/12/10.
 */
public class Square extends Shape {
    private int squareLength;

    public Square(Color color, int edgeNumber, int squareLength) {
        super(color, edgeNumber);
        this.squareLength = squareLength;
    }

    public double area() {
        return squareLength * squareLength;
    }

    public double perimeter() {
        return squareLength * getEdgeNumber();
    }

    public int getSquareLength() {
        return squareLength;
    }

    public void setSquareLength(int squareLength) {
        this.squareLength = squareLength;
    }
}
