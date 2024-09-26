package Server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Начало работы сервера. Ожидание соединения...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Клиент подключен");

                    String word = in.readLine();
                    System.out.println("Получено от клиента: " + word);

                    String reversedWord = new StringBuilder(word).reverse().toString();

                    out.println(reversedWord);
                    System.out.println("Отправлено клиенту: " + reversedWord);
                    System.out.println("Соединение с клиентом закончено");
                    System.out.println("-----------------------------------------");
                } catch (IOException e) {
                    System.out.println("Ошибка соединения с клиентом: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

