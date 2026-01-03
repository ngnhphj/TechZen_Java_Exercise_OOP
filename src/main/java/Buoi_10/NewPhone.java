package Buoi_10;

import Buoi_10.exception.EmptyFieldException;
import Buoi_10.exception.NegativeNumberException;

import java.util.Comparator;
import java.util.Scanner;

public class NewPhone extends Phone implements Comparator<NewPhone> {
    private int quantity;

    public NewPhone() {
    }

    public NewPhone(String id, String name, double price,
                    int warrantyMonths, String brand, int quantity) {
        super(id, name, price, warrantyMonths, brand);
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void input(Scanner sc)
            throws EmptyFieldException,
            NumberFormatException, NegativeNumberException {
        inputCommon(sc);
        this.quantity = readInt(sc, "Nhập số lượng: ");
    }

    @Override
    public void update(Scanner sc)
            throws NumberFormatException,
            NegativeNumberException, EmptyFieldException {

        updateCommon(sc);
        System.out.println("=== Cập nhật thông tin riêng (Enter để giữ nguyên) ===");

        String qStr = readLine(sc, "Số lượng (" + quantity + "): ").trim();
        if (!qStr.isEmpty()) {
            int q = Integer.parseInt(qStr); // NumberFormatException
            if (q < 0) {
                throw new NegativeNumberException("Số lượng không được là số âm!");
            }
            this.quantity = q;
        }
    }

    @Override
    public double calculatePhonePrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return super.toString() + ", SL=" + quantity;
    }

    @Override
    public int compare(NewPhone o1, NewPhone o2) {
        return Double.compare(
                o1.calculatePhonePrice(),
                o2.calculatePhonePrice()
        );
    }
}
