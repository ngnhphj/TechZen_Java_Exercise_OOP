package Buoi_10;

import Buoi_10.exception.EmptyFieldException;
import Buoi_10.exception.MinLengthException;
import Buoi_10.exception.NegativeNumberException;
import Buoi_10.exception.NumberOutOfRangeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhoneStore {

    private final List<Phone> phones = new ArrayList<>();
    private int oldCounter = 1;
    private int newCounter = 1;
    static double totalPhonePrice;

    public PhoneStore() {
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
        if (phones.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        for (Phone p : phones) {
            if(p instanceof OldPhone)
                System.out.println(p);
        }
    }

    public void showNew() {
        System.out.println("===== DANH SÁCH ĐIỆN THOẠI MỚI =====");
        if (phones.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }
        for (Phone p : phones) {
            if(p instanceof NewPhone)
                System.out.println(p);
        }
    }

    public void addOldPhone(Scanner sc) {
        String id = nextOldId();
        Phone p = new OldPhone();
        p.setId(id);

        try {
            p.input(sc);
            phones.add(p);
            System.out.println("Thêm điện thoại cũ thành công! ID=" + id);

        } catch (EmptyFieldException |
                 NumberOutOfRangeException |
                 MinLengthException e) {

            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Giá, bảo hành hoặc pin phải là số!");

        } catch (Exception e) {
            System.out.println(
                    "Ứng dụng gặp một số lỗi không mong muốn, xin vui lòng thử lại các chức năng."
            );
        }
    }


    public void addNewPhone(Scanner sc) {
        String id = nextNewId();
        Phone p = new NewPhone();
        p.setId(id);
        try {
            p.input(sc);
            for (Phone phone : phones) {
                if (phone instanceof NewPhone && phone.name.equalsIgnoreCase(p.name)) {
                    System.out.println("Tên điện thoại đã có sẵn trong kho!");
                    return;
                }
            }
            phones.add(p);
            System.out.println("Thêm điện thoại mới thành công! ID=" + id);
        } catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Giá, bảo hành hoặc số lượng phải là số!");
        } catch (Exception e) {
            System.out.println(
                    "Ứng dụng gặp một số lỗi không mong muốn, xin vui lòng thử lại các chức năng."
            );
        }
    }


    public void updateById(String id, Scanner sc) {
        id = (id == null) ? "" : id.trim();

        if (isValidId(id)) {
            System.out.println("ID sai format! (bắt đầu DTC/DTM + 3 số)");
            return;
        }

        Phone p = null;
        if (id.startsWith("DTC")) p = findOld(id);
        if (id.startsWith("DTM")) p = findNew(id);
        if (p == null) {
            System.out.println("ID không tồn tại!");
            return;
        }
        try {
            p.update(sc);
            System.out.println("Cập nhật thành công!");
        } catch (NumberOutOfRangeException |
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
    }


    public void deleteById(String id) {
        id = (id == null) ? "" : id.trim();

        if (isValidId(id)) {
            System.out.println("ID sai format! (bắt đầu DTC/DTM + 3 số)");
            return;
        }

        if (id.startsWith("DTC")) {
            for (int i = 0; i < phones.size(); i++) {
                if (phones.get(i).getId().equalsIgnoreCase(id)) {
                    phones.remove(i);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
            System.out.println("ID không tồn tại trong danh sách điện thoại cũ!");
            return;
        }

        if (id.startsWith("DTM")) {
            for (int i = 0; i < phones.size(); i++) {
                if (phones.get(i).getId().equalsIgnoreCase(id)) {
                    phones.remove(i);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
            System.out.println("ID không tồn tại trong danh sách điện thoại mới!");
        }
    }

    public void sortPrice() {
        Collections.sort(phones);
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
        try {
            double beginPrice = Phone.readDouble(sc, "Nhập giá bắt đầu: ");
            double endPrice;

            do {
                endPrice = Phone.readDouble(sc, "Nhập giá kết thúc: ");
                if (endPrice < beginPrice) {
                    System.out.println("Giá kết thúc không thể nhỏ hơn giá bắt đầu!");
                }
            } while (endPrice < beginPrice);

            System.out.printf(
                    "=== Các điện thoại có giá từ %.2f tới %.2f ===\n",
                    beginPrice, endPrice
            );

            for (Phone p : phones) {
                if (p.price >= beginPrice && p.price <= endPrice) {
                    System.out.println(p);
                }
            }

        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Giá phải là số!");

        } catch (Exception e) {
            System.out.println(
                    "Ứng dụng gặp một số lỗi không mong muốn, xin vui lòng thử lại các chức năng."
            );
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

    public double calculateTotalPhonePrice(){
        for(Phone p : phones){
            totalPhonePrice += p.calculatePhonePrice();
        }
        return totalPhonePrice;
    }

    public void saleOffOldPhones(double phanTram){
        for(Phone p : phones){
            if(p instanceof OldPhone){
                ((OldPhone) p).khuyenMai(phanTram);
            }
        }
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

    private Phone findOld(String id) {
        for (Phone p : phones) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    private Phone findNew(String id) {
        for (Phone p : phones) {
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