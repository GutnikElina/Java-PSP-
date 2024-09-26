package Server;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2525)) {
            System.out.println("Сервер запущен, ожидание подключений...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое соединение с клиентом: " + clientSocket.getInetAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Соединение установлено с клиентом: " + clientSocket.getInetAddress());
            System.out.println("-----------------------------------------------------");

            String clientMessage;
            while (!(clientMessage = (String) ois.readObject()).equals("bye")) {
                System.out.println(clientMessage);

                String serverMessage = stdin.readLine();
                String serverMessageWithTime = serverMessage + " [" + dtf.format(LocalDateTime.now()) + "]";
                String serverFormattedMessageWithTime = "~you~: '" + serverMessage + "' [" + dtf.format(LocalDateTime.now()) + "]";
                System.out.println(serverFormattedMessageWithTime);

                oos.writeObject(serverMessageWithTime);
            }
        } catch (EOFException e) {
            System.out.println("Соединение с клиентом прервано.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Не удалось закрыть соединение: " + e.getMessage());
            }
        }
    }
}

