package t1020329;

public class KhuyenMaiXYZ extends KhuyenMai {

    public KhuyenMaiXYZ(ThueBao thueBao) {
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
        return getThueBao().getSoPhutDuocGoiMienPhi();
    }

    @Override
    public int getSoTinNhanDuocGuiMienPhi() {
        return getThueBao().getSoTinNhanDuocGuiMienPhi() + 30;
    }
}
