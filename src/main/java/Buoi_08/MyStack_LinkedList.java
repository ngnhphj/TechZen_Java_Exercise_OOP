package Buoi_08;

import Buoi_07.MyLinkedList;

public class MyStack_LinkedList {
    private final MyLinkedList list = new MyLinkedList();

    public void push(int x) {
        list.addLast(x);
    }

    public Integer peek() {
        return list.getLast();
    }

    public Integer pop() {
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
