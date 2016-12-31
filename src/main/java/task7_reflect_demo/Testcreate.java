package task7_reflect_demo;

import task6_tutorial_jdbc.dateobject.StudentsDO;

import java.lang.reflect.Method;

/**
 * Created by Yuleen on 2016/12/31.
 */
public class Testcreate {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("task6_tutorial_jdbc.dateobject.StudentsDO");
        Method method = clazz.getMethod("setSno",String.class);

        StudentsDO studentsDO = (StudentsDO) clazz.newInstance(); //new StudentDO();
        method.invoke(studentsDO,"张三");//studentsDO.setSno("xxx");
        Method method2= clazz.getMethod("getSno");
        System.out.println(method2.invoke(studentsDO));//studentsDO.getSno();
    }
}
