package Buoi_06;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        System.out.println(list);

        list.add(1, 99);
        System.out.println(list);

        list.set(2, 100);
        System.out.println(list);

        System.out.println(list.get(3));

        System.out.println(list.indexOf(2));
        System.out.println(list.lastIndexOf(2));

        list.remove(1);
        System.out.println(list);

        list.removeElement(2);
        System.out.println(list);
    }
}
