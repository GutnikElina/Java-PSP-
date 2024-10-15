import javax.swing.*;
import java.awt.*;

/*Разработать приложение управления тремя списками, расположенными горизонтально.
Приложение должно обеспечивать перемещение выбранного элемента из первого во второй,
из второго в третий, из третьего в первый список и наоборот. Направление перемещения
элемента из списка в список должно определяться выбором из набора флажков (CheckboxGroup).
Элемент при перемещении должен исчезать из одного списка и появляться в другом. Помимо
этого, приложение должно обеспечивать управление всеми списками – добавление нового
элемента, редактирование, удаление.*/

public class ListManagementApp extends JFrame {
    private DefaultListModel<String> listModel1;
    private DefaultListModel<String> listModel2;
    private DefaultListModel<String> listModel3;
    private JList<String> list1, list2, list3;
    private JCheckBox checkBox12, checkBox23, checkBox31;
    private JTextField itemField;
    private JButton addButton, editButton, deleteButton, moveButton;

    public ListManagementApp() {
        super("List Management");

        // создание моделей списков
        listModel1 = new DefaultListModel<>();
        listModel2 = new DefaultListModel<>();
        listModel3 = new DefaultListModel<>();

        // добавление примеров элементов в первый список
        listModel1.addElement("Item 1");
        listModel1.addElement("Item 2");
        listModel1.addElement("Item 3");

        // создание JList для каждого списка
        list1 = new JList<>(listModel1);
        list2 = new JList<>(listModel2);
        list3 = new JList<>(listModel3);

        // панель с тремя списками
        JPanel listPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        listPanel.add(new JScrollPane(list1));
        listPanel.add(new JScrollPane(list2));
        listPanel.add(new JScrollPane(list3));

        // панель с флажками для выбора направления перемещения
        checkBox12 = new JCheckBox("1 -> 2");
        checkBox23 = new JCheckBox("2 -> 3");
        checkBox31 = new JCheckBox("3 -> 1");
        ButtonGroup group = new ButtonGroup();
        group.add(checkBox12);
        group.add(checkBox23);
        group.add(checkBox31);
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(checkBox12);
        checkBoxPanel.add(checkBox23);
        checkBoxPanel.add(checkBox31);

        // поле ввода для добавления/редактирования элементов
        itemField = new JTextField(10);

        // кнопки управления
        addButton = new JButton("Добавить");
        editButton = new JButton("Редактировать");
        deleteButton = new JButton("Удалить");
        moveButton = new JButton("Переместить");

        // панель для кнопок управления
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Элемент:"));
        controlPanel.add(itemField);
        controlPanel.add(addButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);
        controlPanel.add(moveButton);

        // добавление слушателей для кнопок
        addButton.addActionListener(e -> addItem());
        editButton.addActionListener(e -> editItem());
        deleteButton.addActionListener(e -> deleteItem());
        moveButton.addActionListener(e -> moveItem());

        // основная компоновка окна
        setLayout(new BorderLayout());
        add(listPanel, BorderLayout.CENTER);
        add(checkBoxPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        // настройки окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // метод для добавления элемента в список
    private void addItem() {
        String item = itemField.getText();
        if (!item.isEmpty()) {
            listModel1.addElement(item);
            itemField.setText("");
        }
    }

    // метод для редактирования выбранного элемента
    private void editItem() {
        JList<String> selectedList = getSelectedList();
        if (selectedList != null) {
            String selectedValue = selectedList.getSelectedValue();
            if (selectedValue != null) {
                String newItem = itemField.getText();
                if (!newItem.isEmpty()) {
                    int selectedIndex = selectedList.getSelectedIndex();
                    ((DefaultListModel<String>) selectedList.getModel()).set(selectedIndex, newItem);
                    itemField.setText("");
                }
            }
        }
    }

    // метод для удаления выбранного элемента
    private void deleteItem() {
        JList<String> selectedList = getSelectedList();
        if (selectedList != null) {
            int selectedIndex = selectedList.getSelectedIndex();
            if (selectedIndex != -1) {
                ((DefaultListModel<String>) selectedList.getModel()).remove(selectedIndex);
            }
        }
    }

    // метод для перемещения элемента между списками
    private void moveItem() {
        if (checkBox12.isSelected()) {
            moveBetweenLists(list1, list2);
        } else if (checkBox23.isSelected()) {
            moveBetweenLists(list2, list3);
        } else if (checkBox31.isSelected()) {
            moveBetweenLists(list3, list1);
        }
    }

    // метод для перемещения элемента из одного списка в другой
    private void moveBetweenLists(JList<String> fromList, JList<String> toList) {
        String selectedValue = fromList.getSelectedValue();
        if (selectedValue != null) {
            ((DefaultListModel<String>) fromList.getModel()).removeElement(selectedValue);
            ((DefaultListModel<String>) toList.getModel()).addElement(selectedValue);
        }
    }

    // метод для получения списка, в котором выбран элемент
    private JList<String> getSelectedList() {
        if (list1.getSelectedValue() != null) {
            return list1;
        } else if (list2.getSelectedValue() != null) {
            return list2;
        } else if (list3.getSelectedValue() != null) {
            return list3;
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListManagementApp::new);
    }
}
