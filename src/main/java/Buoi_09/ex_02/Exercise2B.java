package Buoi_09.ex_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Exercise2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> names = new HashMap<>();
        String name;
        int time = 1;
        do {
            System.out.print("Nhập tên (Nhập 0 để thoát) : ");
            name = sc.nextLine();
            if (Objects.equals(name, "0"))
                break;
            if (!names.containsKey(name)) {
                names.put(name, 1);
            } else {
                names.put(name, names.get(name) + 1);
            }
        } while (true);

        names.forEach((key, value) -> {
            if(value == 1){
                System.out.println(key + " (xuất hiện 1 lần)");
            }
            else{
                System.out.println(key + " (xuất hiện nhiều hơn 1 lần)");
            }
        });
    }
}
