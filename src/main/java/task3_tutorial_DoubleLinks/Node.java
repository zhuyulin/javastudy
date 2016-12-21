package task3_tutorial_DoubleLinks;

/**
 * Created by Yuleen on 2016/12/16.
 * 创建节点类
 */
class Node
{
    Object date;
    Node prev = this;
    Node next = this;
    Node(Object date) {
        this.date = date;
    }
    public String toString() {
        return date.toString();
    }
}
