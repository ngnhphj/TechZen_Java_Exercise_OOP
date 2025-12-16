package Buoi_2.Bai2;

public class ThoiGian {
    private int gio;
    private int phut;
    private int giay;

    public ThoiGian() {
        this(0, 0, 0);
    }

    public ThoiGian(int gio) {
        this(gio, 0, 0);
    }

    public ThoiGian(int gio, int phut) {
        this(gio, phut, 0);
    }

    public ThoiGian(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    public ThoiGian(ThoiGian other) {
        this(other.gio, other.phut, other.giay);
    }

    public void xuat() {
        System.out.println(gio + ":" + phut + ":" + giay);
    }
}
