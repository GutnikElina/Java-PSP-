package Server;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (ServerSocket serverSocket = new ServerSocket(2525);
             Socket clientSocket = serverSocket.accept();
             ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
            /*Создает поток для чтения данных с клавиатуры (System.in).
              Преобразует этот байтовый поток в символьный поток (InputStreamReader).
              Добавляет буфер для ускорения работы с вводом (BufferedReader),
              чтобы данные можно было удобно читать построчно или посимвольно.*/


            System.out.println("Произведено соединение....");
            System.out.println("----------------------------------");

            String clientMessage;
            while (!(clientMessage = (String) ois.readObject()).equals("bye")) {
                String clientMessageWithTime = "~client~: '" + clientMessage + "' [" + dtf.format(LocalDateTime.now()) + "]";
                System.out.println(clientMessageWithTime);

                String serverMessage = stdin.readLine();
                String serverMessageWithTime = serverMessage + "' [" + dtf.format(LocalDateTime.now()) + "]";
                String serverFormattedMessageWithTime = "~you~: '" + serverMessage + "' [" + dtf.format(LocalDateTime.now()) + "]";
                System.out.println(serverFormattedMessageWithTime);

                oos.writeObject(serverMessageWithTime);
            }
        } catch (EOFException e) {
            System.out.println("Соединение прервано клиентом.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
