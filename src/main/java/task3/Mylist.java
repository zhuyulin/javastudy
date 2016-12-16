package task3;

/**
 * Created by Yuleen on 2016/12/16.
 */

public class Mylist {
    private Node head = new Node(null); // 头节点
    private int size; // 链表大小

    // 以下是数据处理
    public void add(Object date) {
        addFront(new Node(date), head);
    }

    public void add(int location, Object date) {
        addFront(new Node(date), getNode(location));
    }

    public void addHead(Object date) {
        addBehind(new Node(date), head);
    }

    public void addTail(Object date) {

        addFront(new Node(date), head);
    }

    public Object get(int location){
        return getNode(location).date;
    }

    public void remove(int location) {
        removeNode(getNode(location));
    }

    public void removeHead() {
        removeNode(head.next);
    }

    public void removeTail() {
        removeNode(head.prev);
    }


    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        Node node = head;
        for (int i = 0; i < size(); i++) {
            node = node.next;
            if (i > 0)
                s.append(", ");
            s.append(node.date);
        }

        return s.toString();
    }


    //节点处理
    private Node getNode(int location)
    {
        if (location < 0 || location >= size())
            throw new IndexOutOfBoundsException();
        Node node = head.next;
        for (int i = 0; i < location; i++)
            node = node.next;
        return node;
    }


    private void addFront(Node newNode, Node node)
    {
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev = newNode;
        newNode.prev.next=newNode;
        size++;
    }

    private void addBehind(Node newNode, Node node)
    {
        newNode.prev = node;
        newNode.next = node.next;
        node.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }
    private void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }
}