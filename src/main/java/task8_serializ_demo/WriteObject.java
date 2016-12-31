package task8_serializ_demo;

import task6_tutorial_jdbc.dateobject.StudentsDO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Yuleen on 2016/12/31.
 */
public class WriteObject {
    public static void main(String[] args) throws IOException {
        StudentsDO studentsDO = new StudentsDO();
        studentsDO.setSname("张三");

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/Yuleen/Downloads/output.txt"));
        os.writeObject(studentsDO);
        os.close();
    }
}
