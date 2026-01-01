package Buoi_07;

public class MyLinkedList<E> {
    private class Node {
        private final E value;
        private Node next;

        private Node(E value) {
            this.value = value;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size;

    public void addFirst(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size += 1;
    }

    public void addLast(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            addFirst(value);
        } else {
            Node temp = head;
            tail.next = newNode;
            tail = newNode;
            size += 1;
        }
    }

    public void add(int index, E value) {
        Node temp = head;
        Node newNode = new Node(value);
        if (head == null) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else if (index > size) {
            System.out.println("Index is out of size!");
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            size += 1;
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public Integer removeFirst() {
        if (head == null) return null;
        int removeValue = (int) head.value;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return removeValue;
    }

    public Integer removeLast() {
        if (head == null) return null;
        int removeValue = (int) tail.value;
        if (head == tail) {
            head = tail = null;
            size--;
            return removeValue;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
        return removeValue;
    }


    public Integer remove(int index) {
        int removeValue = 0;
        if (head == null) {
            return null;
        } else if (index == 1) {
            removeValue = removeFirst();
        } else if (index == size) {
            removeValue = removeLast();
        } else {
            Node temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            removeValue = (int) temp.next.value;
            temp.next = temp.next.next;
            size -= 1;
        }
        return removeValue;
    }

    public Integer getFirst() {
        if (head == null) {
            return null;
        } else {
            return (Integer) head.value;
        }
    }

    public Integer getLast() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            return (Integer) head.value;
        } else {
            return (Integer) tail.value;
        }
    }

    public Integer get(int index) {
        int result = 0;
        if (index == 1) {
            result = getFirst();
        } else if (index == size) {
            result = getLast();
        } else if (index > size || index < 1) {
            return null;
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            result = (int) temp.value;
        }
        return result;
    }

    public Integer set(int index, E element) {
        if (index < 1 || index > size || head == null) return null;
        Integer oldValue = get(index);
        if (index == 1) {
            Node newHead = new Node(element);
            newHead.next = head.next;
            head = newHead;
            if (size == 1) tail = head;
            return oldValue;
        }
        Node prev = head;
        for (int i = 1; i < index - 1; i++) {
            prev = prev.next;
        }
        Node target = prev.next;
        Node newNode = new Node(element);
        newNode.next = target.next;
        prev.next = newNode;
        if (index == size) tail = newNode;
        return oldValue;
    }


    public int indexOf(int element) {
        if (head == null) return -1;
        Node temp = head;
        int index = 1;
        while (temp != null) {
            int cur = (int) temp.value;
            if (cur == element) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }


    public int lastIndexOf(int element) {
        int result = -1;
        Node temp = head;
        int index = 1;
        int cur = (int) temp.value;
        while (temp != null) {
            if (cur == element) {
                result = index;
            }
            temp = temp.next;
            index++;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (head == null) {
            stringBuilder.append(" ");
        } else {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                stringBuilder.append(temp.value).append(" ");
                temp = temp.next;
            }
        }
        return stringBuilder.toString();
    }
}
