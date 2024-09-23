package Server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("The server is running. Waiting for connection...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected.");

                    // чтение слова от клиента
                    String word = in.readLine();
                    System.out.println("Received from client: " + word);

                    // переворачиваем слово
                    String reversedWord = new StringBuilder(word).reverse().toString();

                    // отправляем перевернутое слово обратно клиенту
                    out.println(reversedWord);
                    System.out.println("Sent to client: " + reversedWord);
                    System.out.println("The connection with the client has ended.");
                    System.out.println("-----------------------------------------");
                } catch (IOException e) {
                    System.out.println("Error processing connection with client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server startup error: " + e.getMessage());
        }
    }
}

