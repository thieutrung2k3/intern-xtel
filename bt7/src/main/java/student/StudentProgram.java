package student;

import common.ConfigUtil;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

public class StudentProgram {
    public static void main(String[] args) {
        Map<String, String> mapConfig = ConfigUtil.readConfigFile();

        String url = mapConfig.get("url");
        String username = mapConfig.get("username");
        String password = mapConfig.get("password");

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nhập số lượng sinh viên: ");
            int n = Integer.parseInt(scanner.nextLine());

            String insertSQL = "INSERT INTO students(name, gender, hometown, age) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertSQL);

            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));

                System.out.print("Tên: ");
                String name = scanner.nextLine();

                System.out.print("Giới tính: ");
                String gender = scanner.nextLine();

                System.out.print("Quê quán: ");
                String hometown = scanner.nextLine();

                System.out.print("Tuổi: ");
                int age = Integer.parseInt(scanner.nextLine());

                try {
                    ps.setString(1, name);
                    ps.setString(2, gender);
                    ps.setString(3, hometown);
                    ps.setInt(4, age);

                    ps.executeUpdate();
                    System.out.println(">> Thêm thành công!\n");

                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(">> Lỗi: Tên bị trùng! Vui lòng nhập lại.");
                    i--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
