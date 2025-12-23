package Buoi_04;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneStore {
    private final List<OldPhone> oldPhones = new ArrayList<>();
    private final List<NewPhone> newPhones = new ArrayList<>();
    private final List<Phone> phones = new ArrayList<>();
    private int oldCounter = 1;
    private int newCounter = 1;

    public PhoneStore() {
        oldPhones.add(new OldPhone("DTC001", "iPhone 11 64GB", 6500000, 3, "Apple", 85, "Máy đẹp, ít trầy"));
        oldPhones.add(new OldPhone("DTC002", "Samsung S10", 4500000, 2, "Samsung", 78, "Màn ok"));
        newPhones.add(new NewPhone("DTM001", "iPhone 15 Pro", 2850000, 12, "Apple", 10));
        newPhones.add(new NewPhone("DTM002", "Xiaomi 14", 1750000, 12, "Xiaomi", 20));
        phones.add(new OldPhone("DTC001", "iPhone 11 64GB", 6500000, 3, "Apple", 85, "Máy đẹp, ít trầy"));
        phones.add(new OldPhone("DTC002", "Samsung S10", 4500000, 2, "Samsung", 78, "Màn ok"));
        phones.add(new NewPhone("DTM001", "iPhone 15 Pro", 2850000, 12, "Apple", 10));
        phones.add(new NewPhone("DTM002", "Xiaomi 14", 1750000, 12, "Xiaomi", 20));
        oldCounter = 3;
        newCounter = 3;
    }

    public void showAll() {
        System.out.println("===== DANH SÁCH TẤT CẢ ĐIỆN THOẠI =====");
        if (phones.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        for (Phone p : phones) System.out.println(p);
    }

    public void showOld() {
        System.out.println("===== DANH SÁCH ĐIỆN THOẠI CŨ =====");
        if (oldPhones.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        for (OldPhone p : oldPhones) System.out.println(p);
    }

    public void showNew() {
        System.out.println("===== DANH SÁCH ĐIỆN THOẠI MỚI =====");
        if (newPhones.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        for (NewPhone p : newPhones) System.out.println(p);
    }

    public void addOldPhone(Scanner sc) {
        String id = nextOldId();
        OldPhone p = new OldPhone();
        p.setId(id);
        p.input(sc);
        oldPhones.add(p);
        phones.add(p);
        System.out.println("Thêm điện thoại cũ thành công! ID=" + id);
    }

    public void addNewPhone(Scanner sc) {
        String id = nextNewId();
        NewPhone p = new NewPhone();
        p.setId(id);
        p.input(sc);
        newPhones.add(p);
        phones.add(p);
        System.out.println("Thêm điện thoại mới thành công! ID=" + id);
    }

    public void updateById(String id, Scanner sc) {
        id = (id == null) ? "" : id.trim();

        if (isValidId(id)) {
            System.out.println("ID sai format! (bắt đầu DTC/DTM + 3 số)");
            return;
        }

        if (id.startsWith("DTC")) {
            OldPhone p = findOld(id);
            if (p == null) {
                System.out.println("ID không tồn tại trong danh sách điện thoại cũ!");
                return;
            }
            p.update(sc);
            System.out.println("Cập nhật thành công!");
            return;
        }

        if (id.startsWith("DTM")) {
            NewPhone p = findNew(id);
            if (p == null) {
                System.out.println("ID không tồn tại trong danh sách điện thoại mới!");
                return;
            }
            p.update(sc);
            System.out.println("Cập nhật thành công!");
        }
    }

    public void deleteById(String id) {
        id = (id == null) ? "" : id.trim();

        if (isValidId(id)) {
            System.out.println("ID sai format! (bắt đầu DTC/DTM + 3 số)");
            return;
        }

        if (id.startsWith("DTC")) {
            for (int i = 0; i < oldPhones.size(); i++) {
                if (oldPhones.get(i).getId().equalsIgnoreCase(id)) {
                    oldPhones.remove(i);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
            System.out.println("ID không tồn tại trong danh sách điện thoại cũ!");
            return;
        }

        if (id.startsWith("DTM")) {
            for (int i = 0; i < newPhones.size(); i++) {
                if (newPhones.get(i).getId().equalsIgnoreCase(id)) {
                    newPhones.remove(i);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
            System.out.println("ID không tồn tại trong danh sách điện thoại mới!");
        }
    }

    public void sortPrice() {
        for (int i = 0; i < phones.size() - 1; i++) {
            if (phones.get(i).price > phones.get(i + 1).price) {
                Phone temp = phones.get(i);
                phones.set(i, phones.get(i + 1));
                phones.set(i, temp);
            }
        }
    }

    public void sortNew() {
        for (int i = 0; i < phones.size(); i++) {
            if (ktPhone(i) == 2) {
                continue;
            }
            System.out.println(phones.get(i));
        }
    }

    public void sortOld() {
        for (int i = 0; i < phones.size(); i++) {
            if (ktPhone(i) == 1) {
                continue;
            }
            System.out.println(phones.get(i));
        }
    }

    public void searchByPrice(Scanner sc) {
        double beginPrice;
        double endPrice;
        beginPrice = Phone.readDouble(sc, "Nhập giá bắt đầu:", Double.MIN_VALUE);
        do {
            endPrice = Phone.readDouble(sc, "Nhập giá kết thúc:", Double.MIN_VALUE);
            if (endPrice > beginPrice) {
                System.out.println("Giá kết thúc không thể nhỏ hơn giá bắt đầu! Mời nhập lại");
            }
        } while (endPrice <= beginPrice);
        System.out.printf("=== Các điện thoại có giá từ %f tới %f ===\n", beginPrice, endPrice);
        for (Phone p : phones) {
            if (p.price > beginPrice && p.price < endPrice) {
                System.out.println(p);
            }
        }
    }

    public void searchByName(Scanner sc) {
        String input;
        input = Phone.readLine(sc, "Nhập tên điện thoại cần tìm: ");
        boolean found =  false;
        for (Phone p : phones) {
            if (p.name.toLowerCase().contains(input.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if(!found)
            System.out.println("Không có điện thoại khớp!");
    }

    private String nextOldId() {
        return "DTC" + String.format("%03d", oldCounter++);
    }

    private String nextNewId() {
        return "DTM" + String.format("%03d", newCounter++);
    }

    private boolean isValidId(String id) {
        if (id.length() != 6)
            return true;
        if (!(id.startsWith("DTC") || id.startsWith("DTM")))
            return true;
        return !id.substring(3).matches("\\d{3}");
    }

    private OldPhone findOld(String id) {
        for (OldPhone p : oldPhones) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    private NewPhone findNew(String id) {
        for (NewPhone p : newPhones) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    private int ktPhone(int index) {
        if (phones.get(index) instanceof NewPhone) {
            return 1;
        } else if (phones.get(index) instanceof OldPhone) {
            return 2;
        }
        return 0;
    }
}