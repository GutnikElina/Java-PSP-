package Client;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client1 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Socket clientSocket = new Socket("127.0.0.1", 2525);
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Соединено с сервером....");
            System.out.println("Напишите сообщение серверу \n\t('bye' − закрытие программы)");
            System.out.println("----------------------------------");

            String clientMessage;
            while (!(clientMessage = stdin.readLine()).equals("bye")) {
                String clientMessageWithTime = clientMessage + " [" + dtf.format(LocalDateTime.now()) + "]";
                System.out.println("~you~: " + clientMessageWithTime);

                oos.writeObject("~client1~: " + clientMessageWithTime);

                String serverResponse = (String) ois.readObject();
                String serverFormattedResponse = "~server~: " + serverResponse;
                System.out.println(serverFormattedResponse);
            }

        } catch (EOFException e) {
            System.out.println("Соединение прервано сервером.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
