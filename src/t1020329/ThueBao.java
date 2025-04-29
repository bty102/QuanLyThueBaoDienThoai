package t1020329;

public abstract class ThueBao {
    private String soThueBao;
    private double soDu;

    public ThueBao(String soThueBao, double soDu) {
        this.soThueBao = soThueBao;
        this.soDu = soDu;
    }
    
    public ThueBao() {}
    
    public String getSoThueBao() {
        return this.soThueBao;
    }

    public double getSoDu() {
        return this.soDu;
    }

    public void setSoThueBao(String soThueBao) {
        this.soThueBao = soThueBao;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public abstract double getPhiThueBao();
    public abstract int getSoPhutDuocGoiMienPhi();
    public abstract int getSoTinNhanDuocGuiMienPhi();
    public abstract double getGiaGoi();
    public abstract double getGiaTinNhan();
}
