package t1020329;

public class KhuyenMaiABC extends KhuyenMai {
    
    public KhuyenMaiABC(ThueBao thueBao) {
        this.thueBao = thueBao;
        setSoThueBao(thueBao.getSoThueBao());
        setSoDu(thueBao.getSoDu());
    }

    @Override
    public double getGiaGoi() {
        return getThueBao().getGiaGoi();
    }

    @Override
    public double getGiaTinNhan() {
        return getThueBao().getGiaTinNhan();
    }

    @Override
    public double getPhiThueBao() {
        return getThueBao().getPhiThueBao();
    }

    @Override
    public int getSoPhutDuocGoiMienPhi() {
        return getThueBao().getSoPhutDuocGoiMienPhi() + 20;
    }

    @Override
    public int getSoTinNhanDuocGuiMienPhi() {
        return getThueBao().getSoTinNhanDuocGuiMienPhi();
    }

}
