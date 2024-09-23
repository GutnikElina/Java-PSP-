package Client;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client {

    private JFrame frame;
    private JTextField ipField, portField, inputField1;
    private JTextArea resultArea;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client() {
        frame = new JFrame("Клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel ipLabel = new JLabel("IP address:");
        ipLabel.setBounds(10, 10, 100, 20);
        frame.add(ipLabel);

        ipField = new JTextField("127.0.0.1");
        ipField.setBounds(110, 10, 100, 20);
        frame.add(ipField);

        JLabel portLabel = new JLabel("Port:");
        portLabel.setBounds(220, 10, 50, 20);
        frame.add(portLabel);

        portField = new JTextField("1234");
        portField.setBounds(270, 10, 100, 20);
        frame.add(portField);

        JButton connectButton = new JButton("Connect");
        connectButton.setBounds(150, 40, 100, 30);
        frame.add(connectButton);

        JLabel inputLabel1 = new JLabel("Sending data:");
        inputLabel1.setBounds(10, 80, 100, 20);
        frame.add(inputLabel1);

        inputField1 = new JTextField("Hello World");
        inputField1.setBounds(110, 80, 200, 20);
        frame.add(inputField1);

        JButton sendButton = new JButton("Send");
        sendButton.setBounds(150, 110, 100, 30);
        frame.add(sendButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 150, 100, 20);
        frame.add(resultLabel);

        resultArea = new JTextArea();
        resultArea.setBounds(110, 150, 200, 100);
        frame.add(resultArea);

        connectButton.addActionListener(e -> connectToServer());
        sendButton.addActionListener(e -> sendData());

        frame.setVisible(true);
    }

    private void connectToServer() {
        try {
            String ipAddress = ipField.getText();
            int port = Integer.parseInt(portField.getText());

            socket = new Socket(ipAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            JOptionPane.showMessageDialog(frame, "Connected to server!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Connection failed: " + e.getMessage());
        }
    }

    private void sendData() {
        try {
            String word1 = inputField1.getText();
            String dataToSend = word1;

            out.println(dataToSend); // отправка данных на сервер

            // получение ответа от сервера
            String serverResponse = in.readLine();
            resultArea.setText(serverResponse);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error sending data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }
}


