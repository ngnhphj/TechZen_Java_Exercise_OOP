package Buoi_10;

import Buoi_05.KhuyenMai;
import Buoi_10.exception.EmptyFieldException;
import Buoi_10.exception.MinLengthException;
import Buoi_10.exception.NegativeNumberException;
import Buoi_10.exception.NumberOutOfRangeException;

import java.util.Comparator;
import java.util.Scanner;

public class OldPhone extends Phone implements KhuyenMai, Comparator<OldPhone> {
    private int batteryPercent;
    private String description;

    public OldPhone() {}

    public OldPhone(String id, String name, double price,
                    int warrantyMonths, String brand,
                    int batteryPercent, String description) {
        super(id, name, price, warrantyMonths, brand);
        this.batteryPercent = batteryPercent;
        this.description = description;
    }

    @Override
    public void input(Scanner sc)
            throws
            NumberFormatException, EmptyFieldException, NumberOutOfRangeException, MinLengthException, NegativeNumberException {

        // nhập phần chung (đã có exception)
        inputCommon(sc);

        // b + c
        this.batteryPercent =
                readInt(sc, "Nhập tình trạng pin (0-100): ", 0, 100);

        // a + d
        this.description = readLine(sc, "Nhập mô tả thêm: ").trim();
        if (description.isEmpty()) {
            throw new EmptyFieldException("Mô tả không được để trống!");
        }
        if (description.length() < 10) {
            throw new MinLengthException("Mô tả phải có ít nhất 10 ký tự!");
        }
    }

    @Override
    public void update(Scanner sc)
            throws NumberFormatException, NumberOutOfRangeException, MinLengthException, NegativeNumberException, EmptyFieldException {

        updateCommon(sc);
        System.out.println("=== Cập nhật thông tin riêng (Enter để giữ nguyên) ===");

        // pin
        String bStr = readLine(sc, "Pin % (" + batteryPercent + "): ").trim();
        if (!bStr.isEmpty()) {
            int b = Integer.parseInt(bStr); // NumberFormatException
            if (b < 0 || b > 100) {
                throw new NumberOutOfRangeException("Pin phải trong khoảng 0–100%");
            }
            this.batteryPercent = b;
        }

        // mô tả
        String dStr = readLine(sc, "Mô tả (" + description + "): ").trim();
        if (!dStr.isEmpty()) {
            if (dStr.length() < 10) {
                throw new MinLengthException("Mô tả phải có ít nhất 10 ký tự!");
            }
            this.description = dStr;
        }
    }

    @Override
    public double calculatePhonePrice() {
        return price + ((double) batteryPercent / 100);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Pin=" + batteryPercent + "%"
                + ", Mô tả=" + description;
    }

    @Override
    public void khuyenMai(double phanTram) {
        setPrice(this.price * (1 - phanTram / 100));
    }

    @Override
    public int compare(OldPhone o1, OldPhone o2) {
        return Double.compare(
                o1.calculatePhonePrice(),
                o2.calculatePhonePrice()
        );
    }
}
