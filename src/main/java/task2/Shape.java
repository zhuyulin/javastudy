package task2;

/**
 * Created by Yuleen on 2016/12/10.
 */
public abstract class Shape {
    private Color color;
    private int edgeNumber;

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

    public Shape(Color color) {
        this.color = color;
    }

    public Shape(Color color, int edgeNumber) {
        this.color = color;
        this.edgeNumber = edgeNumber;
    }



    public abstract double area();

    public abstract double perimeter();
}
