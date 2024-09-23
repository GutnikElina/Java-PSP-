package Client;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Socket clientSocket = new Socket("127.0.0.1", 2525);
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Server connecting....");
            System.out.println("Connection established, you can chat....");
            System.out.println("Enter any string to send to server \n\t('bye' − program terminate)");
            System.out.println("----------------------------------");

            String clientMessage;
            while (!(clientMessage = stdin.readLine()).equals("bye")) {
                String clientMessageWithTime = clientMessage + " [" + dtf.format(LocalDateTime.now()) + "]";
                System.out.println("~you~: " + clientMessageWithTime);

                oos.writeObject(clientMessage);

                String serverResponse = (String) ois.readObject();
                String serverFormattedResponse = "~server~: " + serverResponse;
                System.out.println(serverFormattedResponse);
            }

        } catch (EOFException e) {
            System.out.println("Connection closed by server.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
