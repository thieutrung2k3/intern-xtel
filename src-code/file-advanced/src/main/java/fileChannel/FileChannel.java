package fileChannel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel {
    public static void main(String[] args) {
        try {
            // Mở file ở chế độ đọc
            RandomAccessFile file = new RandomAccessFile("example.txt", "r");

            // Lấy FileChannel từ file
            FileChannel channel = file.getChannel();

            // Ánh xạ file vào bộ nhớ (từ vị trí 0 đến độ dài file)
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

            // Đọc dữ liệu từ buffer
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            // Đóng tài nguyên
            channel.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
