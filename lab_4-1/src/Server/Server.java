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

            System.out.println("Server starting....");
            System.out.println("Connection established, you can chat....");
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
            System.out.println("Connection closed by client.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
