package cinema.users;

import cinema.access_forms.CinemaManagementSystem_by_Admin;
import cinema.access_forms.CinemaManagementSystem_by_Client;
import cinema.access_forms.CinemaManagementSystem_by_Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationForm {
    public static void main(String[] args) {
        JFrame authFrame = new JFrame("Authentication");
        authFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authFrame.setSize(300, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);

        JLabel userTypeLabel = new JLabel("User Type:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(userTypeLabel, gbc);

        String[] userTypes = {"Администратор", "Сотрудник", "Клиент"};
        JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(userTypeComboBox, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);

        authFrame.getContentPane().add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String selectedUserType = (String) userTypeComboBox.getSelectedItem();

                if (isValidLogin(username, password, selectedUserType)) {
                    authFrame.dispose();
                    openCinemaManagementSystem(selectedUserType);
                } else {
                    JOptionPane.showMessageDialog(authFrame, "Неверные учетные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        authFrame.setLocationRelativeTo(null);
        authFrame.setVisible(true);
    }

    private static boolean isValidLogin(String username, char[] password, String userType) {
        if ("Администратор".equals(userType)) {
            return "admin".equals(username) && new String(password).equals("admin");
        } else if ("Сотрудник".equals(userType)) {
            return "employee".equals(username) && new String(password).equals("password");
        } else if ("Клиент".equals(userType)) {
            return "client".equals(username) && new String(password).equals("client");
        }
        return false;
    }

    private static void openCinemaManagementSystem(String userType) {
        if ("Администратор".equals(userType)) {
            CinemaManagementSystem_by_Admin.main(null);
        } else if ("Сотрудник".equals(userType)) {
            CinemaManagementSystem_by_Employee.main(null);
        } else if ("Клиент".equals(userType)) {
            CinemaManagementSystem_by_Client.main(null);
        }
    }
}
