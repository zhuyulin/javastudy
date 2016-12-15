package task3;

/**
 * Created by Yuleen on 2016/12/16.
 */
public class DoubleLinkTest
{
    public static void main(String[] args)
    {
        Mylist dll = new Mylist();
        //添加
        dll.add("A");
        dll.add("B");
        dll.add("C");
        System.out.println(dll);

        //查看指定位置上的元素
        System.out.println(dll.get(1));

        //添加到最前
        dll.addHead("D");
        System.out.println(dll);

        //添加到最后
        dll.addTail("E");
        System.out.println(dll);

        //添加到指定位置
        dll.add(4, "F");
        System.out.println(dll);

        //移除最前的
        dll.removeHead();
        System.out.println(dll);

        //移除最后的
        dll.removeTail();
        System.out.println(dll);

        //移除指定位置上的
        dll.remove(2);
        System.out.println(dll);

    }
}
