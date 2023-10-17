package cinema.users;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserType {
    public static void main(String[] args) {
        JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true);
        splashFrame.setSize(600, 600);

        try {
            BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\AIT TR Student\\IdeaProjects\\untitled\\Pet_Projects\\CinemaApp\\res\\image\\wallpaper.jpeg"));
            ImageIcon splashImage = new ImageIcon(scaleImage(backgroundImage, splashFrame.getWidth(), splashFrame.getHeight()));
            JLabel splashLabel = new JLabel(splashImage);

            JPanel splashPanel = new JPanel();
            splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.PAGE_AXIS));
            splashPanel.add(Box.createVerticalGlue());
            splashPanel.add(splashLabel);
            splashPanel.add(Box.createVerticalGlue());

            splashFrame.getContentPane().add(splashPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        splashFrame.setLocationRelativeTo(null);
        splashFrame.setVisible(true);

        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                splashFrame.dispose();
                showUserTypeSelection();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    private static Image scaleImage(Image img, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(img, 0, 0, width, height, null);
        graphics2D.dispose();
        return scaledImage;
    }
    private static void showUserTypeSelection() {
        JFrame userTypeFrame = new JFrame("Choose User Type");
        userTypeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userTypeFrame.setSize(300, 150);
        userTypeFrame.setLayout(new GridLayout(4, 2));

        JLabel userTypeLabel = new JLabel("Выберите тип пользователя:");
        String[] userTypes = {"Администратор", "Сотрудник", "Клиент"};
        JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);

        JButton selectUserTypeButton = new JButton("Выбрать");

        userTypeFrame.add(userTypeLabel);
        userTypeFrame.add(userTypeComboBox);
        userTypeFrame.add(new JLabel());
        userTypeFrame.add(selectUserTypeButton);

        selectUserTypeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedUserType = (String) userTypeComboBox.getSelectedItem();
                userTypeFrame.dispose();

                if (selectedUserType.equals("Администратор")) {
                    openAuthenticationFormWithFullAccess();
                } else if (selectedUserType.equals("Сотрудник")) {
                    openAuthenticationForm();
                } else if (selectedUserType.equals("Клиент")) {
                    openRegistrationForm();
                }
            }
        });

        userTypeFrame.setLocationRelativeTo(null);
        userTypeFrame.setVisible(true);
    }

    private static void openAuthenticationFormWithFullAccess() {
        AuthenticationForm.main(null);
    }

    private static void openAuthenticationForm() {
        AuthenticationForm.main(null);
    }

    private static void openRegistrationForm() {
        AuthenticationForm.main(null);
    }
}
