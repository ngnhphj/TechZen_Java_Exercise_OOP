package Buoi_2.Bai2;

public class ThoiGianController {
    public static void main(String[] args) {
        ThoiGian a = new ThoiGian();
        a.xuat();                       // 00:00:00

        ThoiGian b = new ThoiGian(7);
        b.xuat();                       // 07:00:00

        ThoiGian c = new ThoiGian(7, 30);
        c.xuat();                       // 07:30:00

        ThoiGian d = new ThoiGian(7, 30, 50);
        d.xuat();                       // 07:30:50

        ThoiGian f = new ThoiGian(d);
        f.xuat();                       // 07:30:50
    }
}
