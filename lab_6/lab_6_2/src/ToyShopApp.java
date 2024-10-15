import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ToyShopApp extends JFrame {
    private JTextField toyNameField;
    private JComboBox<String> toyTypeComboBox;
    private JList<String> toyList;
    private DefaultListModel<String> toyListModel;
    private JTextArea infoArea;
    private JCheckBox isPopularCheckBox;
    private JRadioButton smallSizeRadio;
    private JRadioButton mediumSizeRadio;
    private JRadioButton largeSizeRadio;
    private JButton addButton;
    private JButton saveButton;

    private final String filePath = "toys.txt";

    public ToyShopApp() {
        // настройка окна
        setTitle("Регистрация поступлений в магазин игрушек");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // панель ввода данных
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));

        // метки и текстовые поля
        inputPanel.add(new JLabel("Название игрушки:"));
        toyNameField = new JTextField();
        inputPanel.add(toyNameField);

        inputPanel.add(new JLabel("Тип игрушки:"));
        toyTypeComboBox = new JComboBox<>(new String[]{"Мягкая игрушка", "Конструктор", "Кукла", "Машинка"});
        inputPanel.add(toyTypeComboBox);

        inputPanel.add(new JLabel("Размер:"));
        smallSizeRadio = new JRadioButton("Маленький");
        mediumSizeRadio = new JRadioButton("Средний");
        largeSizeRadio = new JRadioButton("Большой");

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallSizeRadio);
        sizeGroup.add(mediumSizeRadio);
        sizeGroup.add(largeSizeRadio);
        smallSizeRadio.setSelected(true);

        JPanel sizePanel = new JPanel(new FlowLayout());
        sizePanel.add(smallSizeRadio);
        sizePanel.add(mediumSizeRadio);
        sizePanel.add(largeSizeRadio);
        inputPanel.add(sizePanel);

        inputPanel.add(new JLabel("Популярная игрушка:"));
        isPopularCheckBox = new JCheckBox();
        inputPanel.add(isPopularCheckBox);

        addButton = new JButton("Добавить игрушку");
        inputPanel.add(addButton);

        saveButton = new JButton("Сохранить в файл");
        inputPanel.add(saveButton);

        // панель для списка игрушек
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JLabel("Список поступивших игрушек:"), BorderLayout.NORTH);

        toyListModel = new DefaultListModel<>();
        toyList = new JList<>(toyListModel);
        JScrollPane listScrollPane = new JScrollPane(toyList);
        listPanel.add(listScrollPane, BorderLayout.CENTER);

        // панель информации
        infoArea = new JTextArea(5, 20);
        infoArea.setEditable(false);
        JScrollPane infoScrollPane = new JScrollPane(infoArea);

        // добавление панелей на основное окно
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(infoScrollPane, BorderLayout.SOUTH);

        // загрузка данных из файла
        loadToysFromFile();

        // обработчик кнопки "Добавить"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToy();
            }
        });

        // обработчик кнопки "Сохранить"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToysToFile();
            }
        });
    }

    // метод для добавления игрушки
    private void addToy() {
        String toyName = toyNameField.getText();
        String toyType = (String) toyTypeComboBox.getSelectedItem();
        String size = smallSizeRadio.isSelected() ? "Маленький" :
                mediumSizeRadio.isSelected() ? "Средний" : "Большой";
        boolean isPopular = isPopularCheckBox.isSelected();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        if (!toyName.isEmpty()) {
            String toyInfo = String.format("%s (%s) - Размер: %s, Популярная: %s, Дата: %s",
                    toyName, toyType, size, isPopular ? "Да" : "Нет", date);
            toyListModel.addElement(toyInfo);
            infoArea.append("Добавлена игрушка: " + toyInfo + "\n");
            toyNameField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Введите название игрушки.");
        }
    }

    // метод для сохранения игрушек в файл
    private void saveToysToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < toyListModel.getSize(); i++) {
                writer.write(toyListModel.getElementAt(i));
                writer.newLine();
            }
            infoArea.append("Данные сохранены в файл.\n");
        } catch (IOException e) {
            infoArea.append("Ошибка при сохранении в файл.\n");
        }
    }

    // метод для загрузки игрушек из файла
    private void loadToysFromFile() {
        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    toyListModel.addElement(line);
                }
                infoArea.append("Данные загружены из файла.\n");
            } catch (IOException e) {
                infoArea.append("Ошибка при загрузке из файла.\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToyShopApp().setVisible(true);
            }
        });
    }
}
