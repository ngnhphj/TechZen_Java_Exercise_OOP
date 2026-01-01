package Buoi_09.ex_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi văn bản: ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        String[] words = s.split(" ");
        Map<String, Integer> soLuongTu = new HashMap<>();
        for (String word : words) {
            if (soLuongTu.containsKey(word)) {
                int count = soLuongTu.get(word);
                soLuongTu.put(word, count + 1);
            } else {
                soLuongTu.put(word, 1);
            }
        }

        System.out.println("Số lần xuất hiện của từng từ:");
        for (Map.Entry<String, Integer> entry : soLuongTu.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
