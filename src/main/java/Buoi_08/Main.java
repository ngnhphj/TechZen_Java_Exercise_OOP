package Buoi_08;

public class Main {
    public static void main(String[] args) {
        MyStack_LinkedList stl = new MyStack_LinkedList();
        stl.push(100);
        stl.push(200);
        stl.push(300);
        System.out.println(stl.peek());
        System.out.println(stl.pop());
        System.out.println(stl.pop());
        System.out.println(stl.size());

        MyQueue_LinkedList ql = new MyQueue_LinkedList();
        ql.add(100);
        ql.add(200);
        ql.add(300);
        System.out.println(ql.size());
        System.out.println(ql.peek());
        System.out.println(ql.poll());
        System.out.println(ql.poll());
        System.out.println(ql.size());

        MyStack_ArrayList sta = new MyStack_ArrayList();
        sta.push(10);
        sta.push(20);
        sta.push(30);
        System.out.println(sta.peek());
        System.out.println(sta.pop());
        System.out.println(sta.pop());
        System.out.println(sta.size());

        MyQueue_ArrayList qa = new MyQueue_ArrayList();
        qa.add(10);
        qa.add(20);
        qa.add(30);
        System.out.println(qa.size());
        System.out.println(qa.peek());
        System.out.println(qa.poll());
        System.out.println(qa.poll());
        System.out.println(qa.size());
    }
}
