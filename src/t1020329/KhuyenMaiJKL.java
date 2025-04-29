package t1020329;

public class KhuyenMaiJKL extends KhuyenMai {

    public KhuyenMaiJKL(ThueBao thueBao) throws Exception {
        boolean daCoKhuyenMaiABCHoacXYZ = false;
        
        if(thueBao instanceof KhuyenMai) {
            ThueBao tmp = thueBao;
            while (true) {
                if (tmp instanceof KhuyenMaiABC || tmp instanceof KhuyenMaiXYZ) {
                    daCoKhuyenMaiABCHoacXYZ = true;
                    break;
                }
                else tmp = ((KhuyenMai) tmp).getThueBao();
            }
        }

        if(daCoKhuyenMaiABCHoacXYZ) throw new Exception("Không thể áp dụng khuyến mãi này vì thuê bao đã được áp dụng khuyến mãi ABC hoặc XYZ rồi!");
        
        this.thueBao = thueBao;
        setSoThueBao(thueBao.getSoThueBao());
        setSoDu(thueBao.getSoDu());
    }

    @Override
    public double getGiaGoi() {
        return getThueBao().getGiaGoi()*(1-0.2);
    }

    @Override
    public double getGiaTinNhan() {
        return getThueBao().getGiaTinNhan()*(1-0.1);
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
        return getThueBao().getSoTinNhanDuocGuiMienPhi();
    }
}
