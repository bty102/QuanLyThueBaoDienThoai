package t1020329;

public class ThueBaoVIP extends ThueBao {
    
    public ThueBaoVIP(String soThueBao, double soDu) {
        super(soThueBao, soDu);
    }

    @Override
    public double getPhiThueBao() {
        return 1000;
    }

    @Override
    public int getSoPhutDuocGoiMienPhi() {
        return 20;
    }

    @Override
    public int getSoTinNhanDuocGuiMienPhi() {
        return 30;
    }

    @Override
    public double getGiaGoi() {
        return 200;
    }

    @Override
    public double getGiaTinNhan() {
        return 500;
    }

}
