package Buoi_04;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneStore store = new PhoneStore();
        while (true) {
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
                    String id = Phone.readNonEmpty(sc, "Nhập ID cần cập nhật (DTCxxx/DTMxxx): ");
                    store.updateById(id, sc);
                    break;
                }
                case 4: {
                    String id = Phone.readNonEmpty(sc, "Nhập ID cần xóa (DTCxxx/DTMxxx): ");
                    store.deleteById(id);
                    break;
                }
                case 5:
                    System.out.println("Xắp xếp giá: ");
                    store.sortPrice();
                    store.showAll();
                    break;
                case 6:
                    menuSearch(sc, store);
                    break;
                case 9: {
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    return;
                }
            }
            System.out.println();
        }
    }

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

    private static void menuView(Scanner sc, PhoneStore store) {
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
                case 4: {
                    return;
                }
            }
            System.out.println();
        }
    }

    private static void menuAdd(Scanner sc, PhoneStore store) {
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
                case 3: {
                    return;
                }
            }
            System.out.println();
        }
    }

    /// Menu tìm kiếm
    private static void menuSearch(Scanner sc, PhoneStore phoneStore){
        while (true){
            System.out.println("=== Tìm kiếm ===");
            System.out.println("1. Tìm theo loại điện thoại");
            System.out.println("2. Tìm theo mức giá");
            System.out.println("3. Tìm theo tên");
            System.out.println("4. Quay lại");
            int chon = Phone.readInt(sc, "Nhập lựa chọn: ", 1, 4);
            switch (chon){
                case 1:
                    menuFilterNewAndOld(sc,phoneStore);
                    break;
                case 2:
                    phoneStore.searchByPrice(sc);
                    break;
                case 3:
                    phoneStore.searchByName(sc);
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }

    /// Menu lọc  theo loại
    private static void menuFilterNewAndOld(Scanner sc, PhoneStore phoneStore){
        while(true){
            System.out.println("=== Lọc theo loại điện thoại ===");
            System.out.println("1. Điện thoại  mới");
            System.out.println("2. Điện thoại cũ");
            System.out.println("3. Quay về");
            int chon = Phone.readInt(sc, "Nhập lựa chọn: ", 1, 3);
            switch (chon){
                case 1:
                    phoneStore.sortNew();
                    break;
                case 2:
                    phoneStore.sortOld();
                    break;
                case 3:
                    return;
            }
            System.out.println();
        }

    }


}