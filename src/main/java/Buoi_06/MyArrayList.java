package Buoi_06;

public class MyArrayList {
    private int[] data;
    private int size;
    private int n = 10;

    public MyArrayList() {
        data = new int[n];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }


    public void add(int element) {
        ensureCapacity();
        data[size++] = element;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: index " + index + " không hợp lệ!");
            return;
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public void set(int index, int element) {
        if (checkIndex(index)) return;
        data[index] = element;
    }

    public int get(int index) {
        if (checkIndex(index)) {
            return -1;
        }
        return data[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (checkIndex(index)) return;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void removeElement(int element) {
        int i = 0;
        while (i < size) {
            if (data[i] == element) {
                remove(i);
            } else {
                i++;
            }
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Lỗi: index " + index + " không hợp lệ!");
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
