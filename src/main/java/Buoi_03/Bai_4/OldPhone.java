package Buoi_03.Bai_4;

import java.util.Scanner;

public class OldPhone extends Phone {
    private int batteryPercent;
    private String description;

    public OldPhone() {}

    public OldPhone(String id, String name, double price, int warrantyMonths, String brand,
                    int batteryPercent, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
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
    public String toString() {
        return super.toString() + ", Pin=" + batteryPercent + "%, Mô tả=" + description;
    }
}