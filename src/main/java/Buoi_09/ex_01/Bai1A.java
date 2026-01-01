package Buoi_09.ex_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bai1A {
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

        public HashSet<?> loaiBoTrungLap() {
            HashSet<Integer> set = new HashSet<Integer>(nums.size());
            set.addAll(nums);
            return set;
        }
    }

    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        Scanner sc = new Scanner(System.in);
        a.nhap(sc);
        System.out.println(a.loaiBoTrungLap());
    }
}
