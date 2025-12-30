package Buoi_08;

import Buoi_06.MyArrayList;

public class MyStack_ArrayList {
    private final MyArrayList arr = new MyArrayList();

    public void push(int x) {
        arr.add(x);
    }

    public Integer peek() {
        if (isEmpty())
            return null;
        return arr.get(arr.size() - 1);
    }

    public Integer pop() {
        if (isEmpty())
            return null;
        int lastIndex = arr.size() - 1;
        int value = arr.get(lastIndex);
        arr.remove(lastIndex);
        return value;
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int size() {
        return arr.size();
    }
}
