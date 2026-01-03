package Buoi_10;

import Buoi_10.exception.EmptyFieldException;
import Buoi_10.exception.MinLengthException;
import Buoi_10.exception.NegativeNumberException;
import Buoi_10.exception.NumberOutOfRangeException;

import java.util.Scanner;

public abstract class Phone implements Comparable<Phone> {
    protected String id;
    protected String name;
    protected double price;
    protected int warrantyMonths;
    protected String brand;

    public Phone() {
    }

//    public Phone(String id, ) {
//        this.brand = brand;
//        this.warrantyMonths = warrantyMonths;
//        this.price = price;
//        this.name = name;
//        this.id = id;
//    }

    public Phone(String id, String name, double price, int warrantyMonths, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected void inputCommon(Scanner sc) throws EmptyFieldException, NumberFormatException, NegativeNumberException {
        this.name = readNonEmpty(sc, "Nhập tên điện thoại: ");
        this.price = readDouble(sc, "Nhập giá bán: ");
        this.warrantyMonths = readInt(sc, "Nhập thời gian bảo hành (tháng): ");
        this.brand = readNonEmpty(sc, "Nhập hãng sản xuất: ");
    }

    protected void updateCommon(Scanner sc)
            throws EmptyFieldException,
            NumberFormatException,
            NegativeNumberException {

        System.out.println("=== Cập nhật thông tin chung (Enter để giữ nguyên) ===");

        String newName = readLine(sc, "Tên (" + name + "): ").trim();
        if (!newName.isEmpty()) {
            this.name = newName;
        }

        String newPrice = readLine(sc, "Giá (" + price + "): ").trim();
        if (!newPrice.isEmpty()) {
            double p = Double.parseDouble(newPrice);
            if (p < 0) throw new NegativeNumberException("Giá không được âm!");
            this.price = p;
        }

        String newW = readLine(sc, "BH (" + warrantyMonths + "): ").trim();
        if (!newW.isEmpty()) {
            int w = Integer.parseInt(newW);
            if (w < 0) throw new NegativeNumberException("Bảo hành không được âm!");
            this.warrantyMonths = w;
        }

        String newBrand = readLine(sc, "Hãng (" + brand + "): ").trim();
        if (!newBrand.isEmpty()) {
            this.brand = newBrand;
        }
    }


    public abstract void input(Scanner sc) throws EmptyFieldException, NumberOutOfRangeException, MinLengthException, NegativeNumberException;

    public abstract void update(Scanner sc) throws NumberOutOfRangeException, MinLengthException, NegativeNumberException, EmptyFieldException;

    public abstract double calculatePhonePrice();

    @Override
    public String toString() {
        return "ID=" + id +
                ", Tên=" + name +
                ", Giá=" + price +
                ", BH=" + warrantyMonths + " tháng" +
                ", Hãng=" + brand;
    }

    @Override
    public int compareTo(Phone o) {
        return Double.compare(this.price, o.price);
    }

    public static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static String readNonEmpty(Scanner sc, String prompt)
            throws EmptyFieldException {

        String s = readLine(sc, prompt).trim();
        if (s.isEmpty()) {
            throw new EmptyFieldException("Không được để trống trường dữ liệu!");
        }
        return s;
    }

    public static int readInt(Scanner sc, String prompt)
            throws NumberFormatException, NegativeNumberException {

        String s = readLine(sc, prompt).trim();
        int val = Integer.parseInt(s); // b. NumberFormatException

        if (val < 0) {
            throw new NegativeNumberException("Giá trị không được là số âm!");
        }
        return val;
    }


    public static int readInt(Scanner sc, String prompt, int min, int max)
            throws NumberFormatException, NumberOutOfRangeException {

        String s = readLine(sc, prompt).trim();
        int val = Integer.parseInt(s);

        if (val < min || val > max) {
            throw new NumberOutOfRangeException(
                    "Giá trị phải nằm trong khoảng " + min + " - " + max
            );
        }
        return val;
    }


    public static double readDouble(Scanner sc, String prompt)
            throws NumberFormatException, NegativeNumberException {

        String s = readLine(sc, prompt).trim();
        double val = Double.parseDouble(s); // b

        if (val < 0) {
            throw new NegativeNumberException("Giá không được là số âm!");
        }
        return val;
    }


    public static Integer tryParseInt(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return null; }
    }

    public static Double tryParseDouble(String s) {
        try { return Double.parseDouble(s.trim()); }
        catch (Exception e) { return null; }
    }


}