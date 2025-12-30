package Buoi_08;

import Buoi_07.MyLinkedList;

public class MyQueue_LinkedList {
    private final MyLinkedList list = new MyLinkedList();

    public void add(int x) {
        list.addLast(x);
    }

    public Integer peek() {
        return list.getFirst();
    }

    public Integer poll() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
