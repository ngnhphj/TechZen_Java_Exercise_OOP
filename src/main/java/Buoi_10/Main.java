package Buoi_10;

import Buoi_10.exception.EmptyFieldException;
import Buoi_10.exception.MinLengthException;
import Buoi_10.exception.NegativeNumberException;
import Buoi_10.exception.NumberOutOfRangeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PhoneStore store = new PhoneStore();

        while (true) {
            try {
                showMainMenu();
                int choice = Phone.readInt(sc, "Chọn: ", 1, 9);

                switch (choice) {
                    case 1:
                        menuView(sc, store);
                        break;

                    case 2:
                        menuAdd(sc, store);
                        break;

                    case 3: {
                        String id = Phone.readNonEmpty(
                                sc,
                                "Nhập ID cần cập nhật (DTCxxx/DTMxxx): "
                        );
                        store.updateById(id, sc);
                        break;
                    }

                    case 4: {
                        String id = Phone.readNonEmpty(
                                sc,
                                "Nhập ID cần xóa (DTCxxx/DTMxxx): "
                        );
                        store.deleteById(id);
                        break;
                    }

                    case 5:
                        System.out.println("Sắp xếp theo giá:");
                        store.sortPrice();
                        store.showAll();
                        break;

                    case 6:
                        menuSearch(sc, store);
                        break;

                    case 7:
                        System.out.printf(
                                "Tổng giá trị tất cả điện thoại: %.2f vnd\n",
                                store.calculateTotalPhonePrice()
                        );
                        break;

                    case 8: {
                        double phanTram = Phone.readDouble(
                                sc,
                                "Nhập phần trăm khuyến mãi cho điện thoại cũ: "
                        );
                        store.saleOffOldPhones(phanTram);
                        store.showOld();
                        break;
                    }

                    case 9:
                        System.out.println("Thoát chương trình!");
                        sc.close();
                        return;
                }

            } catch (EmptyFieldException |
                     NumberOutOfRangeException |
                     MinLengthException |
                     NegativeNumberException e) {

                System.out.println(e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println("Dữ liệu nhập phải là số hợp lệ!");

            } catch (Exception e) {

                System.out.println(
                        "Ứng dụng gặp một số lỗi không mong muốn, xin vui lòng thử lại các chức năng."
                );
            }

            System.out.println();
        }
    }

    // ================= MENU =================

    private static void showMainMenu() {
        System.out.println("-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI --");
        System.out.println("1. Xem danh sách điện thoại");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp theo giá");
        System.out.println("6. Tìm kiếm");
        System.out.println("7. Tính tổng tiền");
        System.out.println("8. Giảm giá cho điện thoại cũ");
        System.out.println("9. Thoát");
    }

    private static void menuView(Scanner sc, PhoneStore store)
            throws Exception {

        while (true) {
            System.out.println("=== XEM DANH SÁCH ===");
            System.out.println("1. Xem tất cả");
            System.out.println("2. Xem điện thoại cũ");
            System.out.println("3. Xem điện thoại mới");
            System.out.println("4. Trở về menu chính");

            int sub = Phone.readInt(sc, "Chọn: ", 1, 4);
            switch (sub) {
                case 1:
                    store.showAll();
                    break;
                case 2:
                    store.showOld();
                    break;
                case 3:
                    store.showNew();
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }

    private static void menuAdd(Scanner sc, PhoneStore store)
            throws Exception {

        while (true) {
            System.out.println("=== THÊM MỚI ===");
            System.out.println("1. Thêm mới điện thoại cũ");
            System.out.println("2. Thêm mới điện thoại mới");
            System.out.println("3. Trở về menu chính");

            int sub = Phone.readInt(sc, "Chọn: ", 1, 3);
            switch (sub) {
                case 1:
                    store.addOldPhone(sc);
                    break;
                case 2:
                    store.addNewPhone(sc);
                    break;
                case 3:
                    return;
            }
            System.out.println();
        }
    }

    private static void menuSearch(Scanner sc, PhoneStore store)
            throws Exception {

        while (true) {
            System.out.println("=== TÌM KIẾM ===");
            System.out.println("1. Tìm theo loại điện thoại");
            System.out.println("2. Tìm theo mức giá");
            System.out.println("3. Tìm theo tên");
            System.out.println("4. Quay lại");

            int chon = Phone.readInt(sc, "Nhập lựa chọn: ", 1, 4);
            switch (chon) {
                case 1:
                    menuFilterNewAndOld(sc, store);
                    break;
                case 2:
                    store.searchByPrice(sc);
                    break;
                case 3:
                    store.searchByName(sc);
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }

    private static void menuFilterNewAndOld(Scanner sc, PhoneStore store)
            throws Exception {

        while (true) {
            System.out.println("=== LỌC THEO LOẠI ===");
            System.out.println("1. Điện thoại mới");
            System.out.println("2. Điện thoại cũ");
            System.out.println("3. Quay về");

            int chon = Phone.readInt(sc, "Nhập lựa chọn: ", 1, 3);
            switch (chon) {
                case 1:
                    store.sortNew();
                    break;
                case 2:
                    store.sortOld();
                    break;
                case 3:
                    return;
            }
            System.out.println();
        }
    }
}
