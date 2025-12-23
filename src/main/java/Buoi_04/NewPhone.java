package Buoi_04;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
    }

    public NewPhone(String id, String name, double price, int warrantyMonths, String brand, int quantity) {
        super(id, name, price, warrantyMonths, brand);
        this.quantity = quantity;
    }

    @Override
    public void input(Scanner sc) {
        inputCommon(sc);
        this.quantity = readInt(sc, "Nhập số lượng: ", 0);
    }

    @Override
    public void update(Scanner sc) {
        updateCommon(sc);
        System.out.println("=== Cập nhật thông tin riêng (Enter để giữ nguyên) ===");

        String qStr = readLine(sc, "Số lượng (" + quantity + "): ").trim();
        if (!qStr.isEmpty()) {
            Integer q = tryParseInt(qStr);
            if (q != null && q >= 0) this.quantity = q;
            else System.out.println("Số lượng không hợp lệ -> giữ nguyên.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", SL=" + quantity;
    }
}
