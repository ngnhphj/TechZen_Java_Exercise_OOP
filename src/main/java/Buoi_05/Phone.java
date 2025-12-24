package Buoi_05;

import java.util.Scanner;

public abstract class Phone {
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

    protected void inputCommon(Scanner sc) {
        this.name = readNonEmpty(sc, "Nhập tên điện thoại: ");
        this.price = readDouble(sc, "Nhập giá bán: ", 0);
        this.warrantyMonths = readInt(sc, "Nhập thời gian bảo hành (tháng): ", 0);
        this.brand = readNonEmpty(sc, "Nhập hãng sản xuất: ");
    }

    protected void updateCommon(Scanner sc) {
        System.out.println("=== Cập nhật thông tin chung (Enter để giữ nguyên) ===");

        String newName = readLine(sc, "Tên (" + name + "): ").trim();
        if (!newName.isEmpty()) this.name = newName;

        String newPrice = readLine(sc, "Giá (" + price + "): ").trim();
        if (!newPrice.isEmpty()) {
            Double p = tryParseDouble(newPrice);
            if (p != null && p >= 0) this.price = p;
            else System.out.println("Giá không hợp lệ -> giữ nguyên.");
        }

        String newW = readLine(sc, "Bảo hành tháng (" + warrantyMonths + "): ").trim();
        if (!newW.isEmpty()) {
            Integer w = tryParseInt(newW);
            if (w != null && w >= 0) this.warrantyMonths = w;
            else System.out.println("Bảo hành không hợp lệ -> giữ nguyên.");
        }

        String newBrand = readLine(sc, "Hãng (" + brand + "): ").trim();
        if (!newBrand.isEmpty()) this.brand = newBrand;
    }

    public abstract void input(Scanner sc);

    public abstract void update(Scanner sc);

    public abstract double calculatePhonePrice();

    @Override
    public String toString() {
        return "ID=" + id +
                ", Tên=" + name +
                ", Giá=" + price +
                ", BH=" + warrantyMonths + " tháng" +
                ", Hãng=" + brand;
    }

    public static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            String s = readLine(sc, prompt).trim();
            if (!s.isEmpty()) return s;
            System.out.println("Không được để trống. Nhập lại!");
        }
    }

    public static int readInt(Scanner sc, String prompt, int min) {
        while (true) {
            String s = readLine(sc, prompt).trim();
            Integer val = tryParseInt(s);
            if (val != null && val >= min) return val;
            System.out.println("Số không hợp lệ (>= " + min + "). Nhập lại!");
        }
    }

    public static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            String s = readLine(sc, prompt).trim();
            Integer val = tryParseInt(s);
            if (val != null && val >= min && val <= max) return val;
            System.out.println("Số không hợp lệ (" + min + "-" + max + "). Nhập lại!");
        }
    }

    public static double readDouble(Scanner sc, String prompt, double min) {
        while (true) {
            String s = readLine(sc, prompt).trim();
            Double val = tryParseDouble(s);
            if (val != null && val >= min) return val;
            System.out.println("Số không hợp lệ (>= " + min + "). Nhập lại!");
        }
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