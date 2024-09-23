package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите x: ");
            double x = scanner.nextDouble();
            System.out.print("Введите y: ");
            double y = scanner.nextDouble();
            System.out.print("Введите z: ");
            double z = scanner.nextDouble();

            System.out.println("Отправляем значения на сервер: x = " + x + ", y = " + y + ", z = " + z);

            ByteBuffer buffer = ByteBuffer.allocate(24);
            buffer.putDouble(x);
            buffer.putDouble(y);
            buffer.putDouble(z);
            sendData = buffer.array();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2876);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Ожидаем получения результата от сервера...");
            clientSocket.receive(receivePacket);

            ByteBuffer resultBuffer = ByteBuffer.wrap(receivePacket.getData());
            double result = resultBuffer.getDouble();

            System.out.println("Результат вычислений: " + result);

        } catch (Exception e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

