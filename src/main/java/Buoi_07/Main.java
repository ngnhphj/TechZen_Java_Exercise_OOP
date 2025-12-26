package Buoi_07;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList   list = new MyLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);
        list.add(1, 99);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));

        list.set(2, 88);
        System.out.println(list);

        System.out.println(list.indexOf(20));
        System.out.println(list.lastIndexOf(20));

        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.remove(1));
        System.out.println(list);
    }
}
