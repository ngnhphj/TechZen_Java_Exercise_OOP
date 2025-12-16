package Buoi_2.Bai1;

public class PhanSoController {
    public static void main(String[] args) {
        phanSo a = new phanSo();
        a.xuatPhanSo();
        phanSo b = new phanSo(1,2);
        b.xuatPhanSo();
        phanSo c = new phanSo(3);
        c.xuatPhanSo();
        phanSo d = new phanSo(-6,-2);
        d.xuatPhanSo();
        phanSo e = new phanSo(3,-1);
        e.xuatPhanSo();
        phanSo f = e.copy();
        f.congPhanSo(100);
        e.xuatPhanSo();
        f.xuatPhanSo();
    }
}