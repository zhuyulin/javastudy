package task2_tutorial_Shape;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yuleen on 2016/12/25.
 */
public class TestShape {
    @Test
    public void shapeTest() {
        Square square = new Square(Color.black,4,10);
        Assert.assertEquals(square.area(),100D,0);

    }
}
