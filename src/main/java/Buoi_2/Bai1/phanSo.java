package Buoi_2.Bai1;

public class phanSo {
    private int tuSo;
    private int mauSo;

    public phanSo() {
    }

    public phanSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public phanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public void xuatPhanSo() {
        if (mauSo == 0 && tuSo ==0) {
            System.out.println("Phan so la 0");
            return;
        }
        if(mauSo == 0){
            System.out.println("Phan so la :" + tuSo);
            return;
        }
        if (mauSo < 0) {
            mauSo = -mauSo;
            tuSo = -tuSo;
        }
        int ucln = timUCLN();
        tuSo /= ucln;
        mauSo /= ucln;
        if (mauSo != 1) {
            System.out.println("Phân số là: " + tuSo + "/" + mauSo);
        } else
            System.out.println("Phân số là: " + tuSo);
    }

    public void congPhanSo(int x) {
        tuSo = tuSo + x * mauSo;
    }

    public phanSo copy(){
        phanSo temp = new phanSo();
        temp.tuSo=getTuSo();
        temp.mauSo = getMauSo();
        return temp;
    }

    public int timUCLN() {
        int a = Math.abs(tuSo);
        int b = Math.abs(mauSo);
        if (a == 1 || b == 1) {
            return 1;
        }
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
