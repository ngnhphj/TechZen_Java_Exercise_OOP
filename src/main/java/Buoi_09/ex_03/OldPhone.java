package Buoi_09.ex_03;

import Buoi_05.KhuyenMai;

import java.util.Comparator;
import java.util.Scanner;

public class OldPhone extends Phone implements KhuyenMai, Comparator<OldPhone> {
    private int batteryPercent;
    private String description;

    public OldPhone() {}

//    public OldPhone(String id, String name, double price, int warrantyMonths, String brand,
//                    int batteryPercent, String description) {
//        super(id, name, price, warrantyMonths, brand);
//        this.batteryPercent = batteryPercent;
//        this.description = description;
//    }


    public OldPhone(String id, String name, double price, int warrantyMonths, String brand, int batteryPercent, String description) {
        super(id, name, price, warrantyMonths, brand);
        this.batteryPercent = batteryPercent;
        this.description = description;
    }

    @Override
    public void input(Scanner sc) {
        inputCommon(sc);
        this.batteryPercent = readInt(sc, "Nhập tình trạng pin (0-100): ", 0, 100);
        this.description = readNonEmpty(sc, "Nhập mô tả thêm: ");
    }

    @Override
    public void update(Scanner sc) {
        updateCommon(sc);
        System.out.println("=== Cập nhật thông tin riêng (Enter để giữ nguyên) ===");

        String bStr = readLine(sc, "Pin % (" + batteryPercent + "): ").trim();
        if (!bStr.isEmpty()) {
            Integer b = tryParseInt(bStr);
            if (b != null && b >= 0 && b <= 100) this.batteryPercent = b;
            else System.out.println("Pin % không hợp lệ -> giữ nguyên.");
        }

        String dStr = readLine(sc, "Mô tả (" + description + "): ").trim();
        if (!dStr.isEmpty()) this.description = dStr;
    }

    @Override
    public double calculatePhonePrice() {
        return price + ( (double) batteryPercent / 100);
    }

    @Override
    public String toString() {
        return super.toString() + ", Pin=" + batteryPercent + "%, Mô tả=" + description;
    }



    @Override
    public void khuyenMai(double phanTram) {
        setPrice(this.price * (1 - phanTram / 100));
    }


    @Override
    public int compare(OldPhone o1, OldPhone o2) {
        return Double.compare(o1.calculatePhonePrice(),o2.calculatePhonePrice());
    }
}