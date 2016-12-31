package task8_serializ_demo;

import task6_tutorial_jdbc.dateobject.StudentsDO;

import java.io.*;

/**
 * Created by Yuleen on 2016/12/31.
 */
public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("/Users/Yuleen/Downloads/output.txt"));
        StudentsDO studentsDO = (StudentsDO) is.readObject();
        System.out.println(studentsDO.getSname());
        is.close();
    }

}
