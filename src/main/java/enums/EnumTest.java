package enums;
import java.util.*;
/**
 * Created by Yuleen on 2016/12/13.
 */
public class EnumTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input=in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        System.out.println(Size.EXTRA_LARGE);
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention");
    }
}
enum Size{
    SMALL("S"),MEDIEUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }

}