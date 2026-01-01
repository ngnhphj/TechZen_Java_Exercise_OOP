package Buoi_09.ex_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai1B {
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

        public HashSet<Integer> loaiBoTrungLap() {
            HashSet<Integer> set = new HashSet<Integer>(nums.size());
            set.addAll(nums);
            return set;
        }

        public int tong(){
            Set<Integer> tong = loaiBoTrungLap();
            int result = 0;
            for(Integer i : tong){
                result += i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        Scanner sc = new Scanner(System.in);
        myArrayList.nhap(sc);
        System.out.println("Tong cac phan tu khong trung lap la: " + myArrayList.tong());
    }
}
