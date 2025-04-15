package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        int port = 9876;

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server is listening on port: " + port);

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            while (true) {
                // Nhận dữ liệu từ client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + msg);

                // Gửi phản hồi lại
                String reply = "You sent: " + msg;
                sendBuffer = reply.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                // Nếu client gửi "exit", dừng server
                if ("exit".equalsIgnoreCase(msg.trim())) {
                    System.out.println("Client requested to close connection. Server stopping...");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
