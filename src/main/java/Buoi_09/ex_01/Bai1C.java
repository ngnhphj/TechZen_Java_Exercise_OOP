package Buoi_09.ex_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai1C {
    public static class MyArrayList {
        private  final ArrayList<Integer> nums = new ArrayList<>();

        public void nhap(Scanner sc) {
            System.out.print("Nhập số lượng phần tử:");
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

        public void phanTuChung(MyArrayList b){
            Set<?> set1 = loaiBoTrungLap();
            Set<?> set2 = b.loaiBoTrungLap();
            System.out.print("Các phần tử chung của 2 mảng là: ");
            for(Object i : set1){
                if(set2.contains(i)){
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        MyArrayList b = new MyArrayList();
        Scanner sc = new Scanner(System.in);
        a.nhap(sc);
        b.nhap(sc);
        a.phanTuChung(b);
    }
}
