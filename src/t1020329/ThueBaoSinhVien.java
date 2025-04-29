package t1020329;

public class ThueBaoSinhVien extends ThueBao {

    public ThueBaoSinhVien(String soThueBao, double soDu) {
        super(soThueBao, soDu);
    }

    @Override
    public double getPhiThueBao() {
        return 5000;
    }

    @Override
    public int getSoPhutDuocGoiMienPhi() {
        return 10;
    }

    @Override
    public int getSoTinNhanDuocGuiMienPhi() {
        return 15;
    }

    @Override
    public double getGiaGoi() {
        return 10000;
    }

    @Override
    public double getGiaTinNhan() {
        return 2000;
    }

}
