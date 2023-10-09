import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventCalendar extends JFrame {
    private JTextArea eventTextArea;
    private JTextField dateField;
    private JButton addButton;
    private Map<Date, String> events;

    public EventCalendar() {
        setTitle("Календарь событий");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        events = new HashMap<>();

        eventTextArea = new JTextArea();
        eventTextArea.setEditable(false);
        dateField = new JTextField(10);
        addButton = new JButton("Добавить событие");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Дата (dd-MM-yyyy):"));
        panel.add(dateField);
        panel.add(addButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(eventTextArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateString = dateField.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = dateFormat.parse(dateString);
                    String event = JOptionPane.showInputDialog("Введите событие для " + dateString);
                    if (event != null && !event.isEmpty()) {
                        events.put(date, event);
                        updateEventTextArea();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EventCalendar.this, "Неправильный формат даты.");
                }
            }
        });
    }

    private void updateEventTextArea() {
        StringBuilder text = new StringBuilder();
        for (Map.Entry<Date, String> entry : events.entrySet()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            text.append(dateFormat.format(entry.getKey())).append(": ").append(entry.getValue()).append("\n");
        }
        eventTextArea.setText(text.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventCalendar().setVisible(true);
            }
        });
    }
}
