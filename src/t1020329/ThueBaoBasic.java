package t1020329;

public class ThueBaoBasic extends ThueBao {
    
    public ThueBaoBasic(String soThueBao, double soDu) {
        super(soThueBao, soDu);
    }

    @Override
    public double getPhiThueBao() {
        return 10000;
    }

    @Override
    public int getSoPhutDuocGoiMienPhi() {
        return 5;
    }

    @Override
    public int getSoTinNhanDuocGuiMienPhi() {
        return 10;
    }

    @Override
    public double getGiaGoi() {
        return 2000;
    }

    @Override
    public double getGiaTinNhan() {
        return 3000;
    }

}
