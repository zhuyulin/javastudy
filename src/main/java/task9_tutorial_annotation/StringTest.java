package task9_tutorial_annotation;

import task6_tutorial_jdbc.dateobject.StudentsDO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Yuleen on 2017/1/2.
 */
public class StringTest {
    @StringLimit(maxLength = 10)
    private String text1;

    @StringLimit(maxLength = 5)
    private String text2;

    private String text3;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }


    public static void main(String[] args)  throws Exception{
        StringTest test = new StringTest();
        test.setText1("1234567890abcdefg");
        test.setText2("1234567890abcdefg");
        test.setText3("1234567890abcdefg");

        Class<?> c1 = StringTest.class;
        Field[] fields = StringTest.class.getDeclaredFields();
        for (Field field : fields) {
            StringLimit sl = field.getAnnotation(StringLimit.class);
            if (sl != null){
                //把首字母小写的变量名转化为首字母大写的方法名
                    String setFunction = field.getName().replaceFirst(field.getName().substring(0, 1),
                            field.getName().substring(0, 1).toUpperCase());
                    //生成set方法名
                    String methodNameSet = ("set"+setFunction);
                    //生成get方法名
                    String methodNameGet = ("get"+setFunction);
                    //获取set、get方法
                    Method methodSet = c1.getMethod(methodNameSet,String.class);
                    Method methodGet = c1.getMethod(methodNameGet);
                    //实例化
                    StringTest stringTest = (StringTest) c1.newInstance();
                    //字符串截取
                    String newString = methodGet.invoke(stringTest).toString().substring(0,
                        field.getAnnotation(StringLimit.class).maxLength());
                    methodSet.invoke(stringTest,newString);
                    System.out.println(methodGet.invoke(stringTest));

                }
            }


        }
    }






