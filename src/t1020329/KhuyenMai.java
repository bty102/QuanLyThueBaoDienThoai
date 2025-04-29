package t1020329;

import java.util.Date;

public abstract class KhuyenMai extends ThueBao {
    protected ThueBao thueBao;
    
    public ThueBao getThueBao() {
        return this.thueBao;
    }
    
    @Override
    public abstract double getGiaGoi();

    @Override
    public abstract double getGiaTinNhan();

    @Override
    public abstract double getPhiThueBao();

    @Override
    public abstract int getSoPhutDuocGoiMienPhi();

    @Override
    public abstract int getSoTinNhanDuocGuiMienPhi();
    
}
