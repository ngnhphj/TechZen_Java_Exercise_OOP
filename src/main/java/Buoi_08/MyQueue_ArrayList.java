package Buoi_08;

import Buoi_06.MyArrayList;

public class MyQueue_ArrayList {
    private final MyArrayList arr = new MyArrayList();

    public void add(int x) {
        arr.add(x);
    }

    public Integer peek() {
        if (isEmpty())
            return null;
        return arr.get(0);
    }

    public Integer poll() {
        if (isEmpty())
            return null;
        int value = arr.get(0);
        arr.remove(0);
        return value;
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int size() {
        return arr.size();
    }
}
