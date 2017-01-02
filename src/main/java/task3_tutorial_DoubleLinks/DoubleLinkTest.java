package task3_tutorial_DoubleLinks;

/**
 * Created by Yuleen on 2016/12/16.
 */
public class DoubleLinkTest
{
    public static void main(String[] args)
    {
        Mylist<Object> test = new Mylist<Object>();
        //添加节点
        test.add("A");
        test.add("B");
        test.add("C");
        System.out.println(test);

        //查看指定位置上的节点
        System.out.println(test.get(1));

        //添加节点到最前
        test.addHead("D");
        System.out.println(test);

        //添加节点到最后
        test.addTail("E");
        System.out.println(test);

        //添加节点到指定位置
        test.add(4, "F");
        System.out.println(test);

        //移除最前的节点
        test.removeHead();
        System.out.println(test);

        //移除最后的节点
        test.removeTail();
        System.out.println(test);

        //移除指定位置上的节点
        test.remove(2);
        System.out.println(test);

    }
}
