package cinema.access_forms;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaManagementSystem_by_Admin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cinema Management System for Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Menu");

        DefaultMutableTreeNode sessionHeader = new DefaultMutableTreeNode("Session");
        DefaultMutableTreeNode filmsHeader = new DefaultMutableTreeNode("Films");
        DefaultMutableTreeNode seatingHeader = new DefaultMutableTreeNode("Seating");
        DefaultMutableTreeNode ticketHeader = new DefaultMutableTreeNode("Ticket");

        root.add(sessionHeader);
        root.add(filmsHeader);
        root.add(seatingHeader);
        root.add(ticketHeader);

        DefaultMutableTreeNode createSession = new DefaultMutableTreeNode("Create a new session");
        DefaultMutableTreeNode deleteSession = new DefaultMutableTreeNode("Delete session");
        DefaultMutableTreeNode updateSession = new DefaultMutableTreeNode("Update session");
        DefaultMutableTreeNode viewAllSessions = new DefaultMutableTreeNode("View all sessions");

        sessionHeader.add(createSession);
        sessionHeader.add(deleteSession);
        sessionHeader.add(updateSession);
        sessionHeader.add(viewAllSessions);

        DefaultMutableTreeNode createFilm = new DefaultMutableTreeNode("Create a new film");
        DefaultMutableTreeNode deleteFilm = new DefaultMutableTreeNode("Delete film");
        DefaultMutableTreeNode updateFilm = new DefaultMutableTreeNode("Update film");
        DefaultMutableTreeNode viewAllFilms = new DefaultMutableTreeNode("View all films");

        filmsHeader.add(createFilm);
        filmsHeader.add(deleteFilm);
        filmsHeader.add(updateFilm);
        filmsHeader.add(viewAllFilms);

        DefaultMutableTreeNode createSeating = new DefaultMutableTreeNode("Create a new seating");
        DefaultMutableTreeNode deleteSeating = new DefaultMutableTreeNode("Delete seating");
        DefaultMutableTreeNode updateSeating = new DefaultMutableTreeNode("Update seating");
        DefaultMutableTreeNode viewAllSeating = new DefaultMutableTreeNode("View all seating");

        seatingHeader.add(createSeating);
        seatingHeader.add(deleteSeating);
        seatingHeader.add(updateSeating);
        seatingHeader.add(viewAllSeating);

        DefaultMutableTreeNode createTicket = new DefaultMutableTreeNode("Create a new ticket");
        DefaultMutableTreeNode deleteTicket = new DefaultMutableTreeNode("Delete ticket");
        DefaultMutableTreeNode updateTicket = new DefaultMutableTreeNode("Update ticket");
        DefaultMutableTreeNode viewAllTickets = new DefaultMutableTreeNode("View all tickets");

        ticketHeader.add(createTicket);
        ticketHeader.add(deleteTicket);
        ticketHeader.add(updateTicket);
        ticketHeader.add(viewAllTickets);

        JTree tree = new JTree(root);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(200, 400));

        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node != null && node.isLeaf()) {
                String selectedNode = node.getUserObject().toString();
                switch (selectedNode) {
                    case "Create a new session":
                        JTextField textField = new JTextField();
                        JButton addButton = new JButton("Add Data");

                        sidePanel.add(textField, BorderLayout.NORTH);
                        sidePanel.add(addButton, BorderLayout.SOUTH);

                        JPanel panel = new JPanel();
                        panel.setLayout(new BorderLayout());
                        panel.setPreferredSize(new Dimension(200, 400));

                        panel.add(new JScrollPane(tree));

                        frame.add(panel, BorderLayout.WEST);
                        frame.add(sidePanel, BorderLayout.EAST);
                        frame.setVisible(true);

                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String data = textField.getText();
                                JOptionPane.showMessageDialog(frame, "Added Data: " + data);
                                textField.setText("");
                            }
                        });

                        break;
                    case "Delete session":
                        JOptionPane.showMessageDialog(frame, "You clicked on 'Delete session'");
                        break;
                    case "Create a new film":
                        JOptionPane.showMessageDialog(frame, "You clicked on 'Create a new film'");
                        break;
                    case "Delete film":
                        JOptionPane.showMessageDialog(frame, "You clicked on 'Delete film'");
                        break;

                    default:
                        break;
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 400));
        panel.add(new JScrollPane(tree));

        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
    }
}
