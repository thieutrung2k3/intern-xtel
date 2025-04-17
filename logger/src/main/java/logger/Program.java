package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
    private static final Logger logger = LoggerFactory.getLogger(Program.class);

    public static void main(String[] args) {
        logger.info("Đây là thông báo info");
        logger.warn("Đây là cảnh báo");
        logger.error("Đây là lỗi");
        logger.debug("Thông tin debug");

        // Logging với tham số
        String userName = "admin";
        logger.info("Người dùng {} đã đăng nhập", userName);

        // Logging với exception
        try {
            // code có thể ném ngoại lệ
        } catch (Exception e) {
            logger.error("Đã xảy ra lỗi", e);
        }

    }
}
