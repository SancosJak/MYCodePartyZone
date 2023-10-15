import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementApp {
    private List<Employee> employees;
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> employeeList;
    private JTextField nameField, positionField, salaryField;
    private JButton addButton, editButton, deleteButton, saveButton, loadButton;
    private JFileChooser fileChooser;

    public EmployeeManagementApp() {
        employees = new ArrayList<>();
        frame = new JFrame("Employee Management System");
        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        nameField = new JTextField(20);
        positionField = new JTextField(20);
        salaryField = new JTextField(20);

        addButton = new JButton("Add Employee");
        editButton = new JButton("Edit Employee");
        editButton.setEnabled(false);
        deleteButton = new JButton("Delete Employee");
        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Data");

        fileChooser = new JFileChooser();

        JPanel employeeDetailsPanel = new JPanel(new GridLayout(4, 2));
        employeeDetailsPanel.add(new JLabel("Name:"));
        employeeDetailsPanel.add(nameField);
        employeeDetailsPanel.add(new JLabel("Position:"));
        employeeDetailsPanel.add(positionField);
        employeeDetailsPanel.add(new JLabel("Salary:"));
        employeeDetailsPanel.add(salaryField);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new JScrollPane(employeeList), BorderLayout.CENTER);
        frame.getContentPane().add(employeeDetailsPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    loadEmployeesFromFile(file);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showSaveDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    saveEmployeesToFile(file);
                }
            }
        });

        employeeList.addListSelectionListener(e -> {
            int selectedIndex = employeeList.getSelectedIndex();
            if (selectedIndex >= 0) {
                Employee selectedEmployee = employees.get(selectedIndex);
                nameField.setText(selectedEmployee.getName());
                positionField.setText(selectedEmployee.getPosition());
                salaryField.setText(String.valueOf(selectedEmployee.getSalary()));
                editButton.setEnabled(true);
            } else {
                nameField.setText("");
                positionField.setText("");
                salaryField.setText("");
                editButton.setEnabled(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String position = positionField.getText();
                String salaryText = salaryField.getText();

                if (!name.isEmpty() && !position.isEmpty() && !salaryText.isEmpty()) {
                    try {
                        double salary = Double.parseDouble(salaryText);
                        Employee newEmployee = new Employee(name, position, salary);
                        employees.add(newEmployee);
                        listModel.addElement(newEmployee.getName());
                        nameField.setText("");
                        positionField.setText("");
                        salaryField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid salary. Please enter a valid number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Employee selectedEmployee = employees.get(selectedIndex);
                    selectedEmployee.setName(nameField.getText());
                    selectedEmployee.setPosition(positionField.getText());
                    selectedEmployee.setSalary(Double.parseDouble(salaryField.getText()));
                    listModel.set(selectedIndex, selectedEmployee.getName());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    employees.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });
    }

    private void loadEmployeesFromFile(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            employees = (List<Employee>) ois.readObject();
            refreshEmployeeList();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error loading data from the file.");
        }
    }

    private void saveEmployeesToFile(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(employees);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving data to the file.");
        }
    }

    private void refreshEmployeeList() {
        listModel.clear();
        for (Employee employee : employees) {
            listModel.addElement(employee.getName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementApp();
            }
        });
    }
}
