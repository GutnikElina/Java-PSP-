package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Server {
    public static void main(String[] args) {
        System.out.println("Сервер запущен и ожидает данные...");
        try (DatagramSocket serverSocket = new DatagramSocket(2876)) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                ByteBuffer buffer = ByteBuffer.wrap(receivePacket.getData());
                double x = buffer.getDouble();
                double y = buffer.getDouble();
                double z = buffer.getDouble();

                System.out.println("Полученные значения: x = " + x + ", y = " + y + ", z = " + z);

                double result = calculateFormula(x, y, z);
                System.out.println("Результат вычислений: " + result);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                sendData = ByteBuffer.allocate(8).putDouble(result).array();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Результат отправлен.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Метод для вычисления формулы
    private static double calculateFormula(double x, double y, double z) {
        return Math.sqrt(10 * (Math.sqrt(x) + Math.pow(x, y * z)) *
                (Math.pow(Math.sin(z), 2) + Math.abs(x + y)) * Math.exp(z));
    }
}
