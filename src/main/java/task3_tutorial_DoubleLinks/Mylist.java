package task3_tutorial_DoubleLinks;

/**
 * Created by Yuleen on 2016/12/16.
 */

public class Mylist<T> {
    private Node head = new Node(null); // 头节点
    private int size; // 链表大小

    // 以下是数据处理
    public void add(T date) {
        addFront(new Node(date), head);
    }

    public void add(int location, T date) {
        addFront(new Node(date), getNode(location));
    }

    public void addHead(T date) {
        addBehind(new Node(date), head);
    }

    public void addTail(T date) {

        addFront(new Node(date), head);
    }

    public T get(int location){
        return (T) getNode(location).date;
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
        StringBuilder display = new StringBuilder();
        Node node = head;
        for (int i = 0; i < size(); i++) {
            node = node.next;
            display.append(node.date);
        }
        return display.toString();
    }


    //节点处理
    private Node getNode(int location)
    {
        if (location < 0 || location >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head.next;
        for (int i = 0; i < location; i++) {
            node = node.next;
        }
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