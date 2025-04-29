package t1020329;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThueBaoService {

    private String DBUrl;
    private Connection connection = null;
    
    public ThueBaoService(String DBUrl) {
        this.DBUrl = DBUrl;
    }
    
    private Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(DBUrl);
        }

        return connection;
    }
    
    public List<ThueBao> getAllThueBao() throws Exception {
        List<ThueBao> dsThueBao = new ArrayList<ThueBao>();
        String sql = "select * from ThueBao";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String soThueBao = resultSet.getString("SoThueBao");
            double soDu = resultSet.getDouble("SoDu");
            int Loai = resultSet.getInt("Loai"); 
            ThueBao thueBao = null;
            if(Loai == 1) {
                thueBao = new ThueBaoBasic(soThueBao, soDu);
            }
            else if(Loai == 2) {
                thueBao = new ThueBaoSinhVien(soThueBao, soDu);
            }
            else if(Loai == 3) {
                thueBao = new ThueBaoVIP(soThueBao, soDu);
            }
            sql = "select * from ThueBao_KhuyenMai where SoThueBao = ? order by ThoiDiemApDung";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, soThueBao);
            ResultSet dsKM = preparedStatement.executeQuery();
            while (dsKM.next()) {
                String khuyenMai = dsKM.getString("KhuyenMai");
                if(khuyenMai.equals("ABC")) {
                    thueBao = new KhuyenMaiABC(thueBao);
                }
                else if(khuyenMai.equals("XYZ")) {
                    thueBao = new KhuyenMaiXYZ(thueBao);
                }
                else if(khuyenMai.equals("JKL")) {
                    thueBao = new KhuyenMaiJKL(thueBao);
                }
            }
            dsThueBao.add(thueBao);

        }
        return dsThueBao;
    }
    
    public void showThueBao(ThueBao thueBao) {
        System.out.println("Số thuê bao: " + thueBao.getSoThueBao());
        System.out.println("Số dư: " + thueBao.getSoDu() + " (đồng)");
        System.out.println("Phí thuê bao (tháng): " + thueBao.getPhiThueBao() + " (đồng)");
        System.out.println("Số phút được gọi miễn phí: " + thueBao.getSoPhutDuocGoiMienPhi() + " (phút)");
        System.out.println("số tin nhắn được gửi miễn phí: " + thueBao.getSoTinNhanDuocGuiMienPhi() + " (tin)");
        System.out.println("Mức phí gọi điện thoại/phút: " + thueBao.getGiaGoi() + " (đồng)");
        System.out.println("Mức phí gửi tin nhắn: " + thueBao.getGiaTinNhan() + " (đồng)");
    }

    public boolean themKhuyenMai(String soThueBao, String khuyenMai) throws SQLException {
        if(khuyenMai.equals("JKL")) {
            String sql = "select count(*) as SoDong from ThueBao_KhuyenMai where SoThueBao = ? and KhuyenMai in ('ABC', 'XYZ')";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, soThueBao);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int soDong = resultSet.getInt("SoDong");
            boolean daCoKhuyenMaiABCHoacXYZ = (soDong != 0);
            if(daCoKhuyenMaiABCHoacXYZ) return false;
        }

        String sql = "insert into ThueBao_KhuyenMai(SoThueBao, KhuyenMai) values(?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, soThueBao);
        preparedStatement.setString(2, khuyenMai);
        if(preparedStatement.executeUpdate() == 0) return false;
        return true;
    }
}
