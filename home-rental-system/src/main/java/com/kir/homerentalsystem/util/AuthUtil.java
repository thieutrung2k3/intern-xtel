package com.kir.homerentalsystem.util;

import java.util.Random;

/**
 * Lớp tiện ích cung cấp các phương thức hỗ trợ cho xác thực.
 */
public class AuthUtil {
    /**
     * Tạo mật khẩu ngẫu nhiên với độ dài 10 ký tự.
     * 
     * Mật khẩu được tạo bao gồm chữ cái in hoa, chữ cái thường, 
     * chữ số và các ký tự đặc biệt như: !@#$%^&*
     * 
     * @return Chuỗi mật khẩu ngẫu nhiên với độ dài 10 ký tự
     */
    public static String generateRandomPassword() {
        // Tập hợp các ký tự có thể sử dụng cho mật khẩu
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Tạo mật khẩu có độ dài 10 ký tự
        for (int i = 0; i < 10; i++) {
            // Chọn ngẫu nhiên một ký tự từ tập ký tự cho phép
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static String generateRandomCode() {
        // Tập hợp các ký tự có thể sử dụng cho mật khẩu
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Tạo mật khẩu có độ dài 10 ký tự
        for (int i = 0; i < 10; i++) {
            // Chọn ngẫu nhiên một ký tự từ tập ký tự cho phép
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}