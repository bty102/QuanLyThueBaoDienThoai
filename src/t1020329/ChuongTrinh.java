package t1020329;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ChuongTrinh {

    public static void main(String[] args) {
        String DBUrl = "jdbc:sqlserver://BTYLAP:1433;encrypt=true;databaseName=QLThueBaoDB;user=sa;password=123;TrustServerCertificate=true";
        ThueBaoService thueBaoService = new ThueBaoService(DBUrl);
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showOptions();
            System.out.print("Nhập tùy chọn: ");
            int option = Integer.parseInt(scanner.nextLine());
            if(option == 1) {
                try {
                    List<ThueBao> dsThueBao = thueBaoService.getAllThueBao();
                    for (ThueBao thueBao : dsThueBao) {
                        System.out.println("-".repeat(50));
                        thueBaoService.showThueBao(thueBao);
                        System.out.println("-".repeat(50));
                    }
                    System.out.print("Nhấn Enter để tiếp tục...");
                    var pause = scanner.nextLine();
    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(option == 2) {
                System.out.print("Nhập số thuê bao: ");
                String soThueBao = scanner.nextLine();
                System.out.println("Chọn khuyến mãi:");
                System.out.println("- Khuyến mãi ABC: Số phút được gọi miễn phí được tăng lên 20 p");
                System.out.println("- Khuyến mãi XYZ: Số tin nhắn được gửi miễn phí tăng thêm 30 tin");
                System.out.println("- Khuyến mãi JKL:\n" 
                		+ "+ Giảm 20% mức phí gọi điện thoại/phút\r\n"
                		+ "+ Giảm 10% mức phí gửi tin nhắn\r\n"
                		+ "+ NOTE: KHÔNG ÁP DỤNG khuyến mãi này cho thuê bao đã được áp dụng khuyến mãi ABC hoặc XYZ trước đó");
                System.out.print(">>>>>> ");
                String khuyenMai = scanner.nextLine();
                try {
                    if(thueBaoService.themKhuyenMai(soThueBao, khuyenMai)) {
                        System.out.println("Đã thêm khuyến mãi " + khuyenMai + " cho thuê bao " + soThueBao);
                    }
                    else {
                        System.out.println("Thêm thất bại");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(option == 3) {
                return;
            }
            else {
            	System.out.print("Tùy chọn không hợp lệ! nhấn Enter để tiếp tục");
            	var pause = scanner.nextLine();
            }
        }
    }
    
    private static void showOptions() {
        System.out.println("[1] Xem danh sách thuê bao");
        System.out.println("[2] Thêm khuyến mãi");
        System.out.println("[3] Thoát");
    }
}
