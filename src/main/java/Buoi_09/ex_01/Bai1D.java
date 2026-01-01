package Buoi_09.ex_01;

import java.util.*;

public class Bai1D {
    public static class MyArrayList {
        private static final ArrayList<Integer> nums = new ArrayList<>();

        public void nhap(Scanner sc) {
            System.out.print("Nhap so luong phan tu:");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.printf("nums[%d] = ", i);
                nums.add(Integer.parseInt(sc.nextLine()));
            }
        }

        public int max(){
            TreeSet<Integer> set = new TreeSet<>(nums);
            return set.last();
        }
    }

    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        Scanner sc = new Scanner(System.in);
        a.nhap(sc);
        System.out.println("phần tử lớn nhất trong mảng là: " + a.max());
    }
}
