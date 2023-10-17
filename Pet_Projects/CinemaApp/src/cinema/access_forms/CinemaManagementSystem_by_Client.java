package cinema.access_forms;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class CinemaManagementSystem_by_Client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cinema Management System for Client");
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

        DefaultMutableTreeNode viewAllSessions = new DefaultMutableTreeNode("View all sessions");
        sessionHeader.add(viewAllSessions);

        DefaultMutableTreeNode viewAllFilms = new DefaultMutableTreeNode("View all films");
        filmsHeader.add(viewAllFilms);

        DefaultMutableTreeNode viewAllSeating = new DefaultMutableTreeNode("View all seating");
        seatingHeader.add(viewAllSeating);
        DefaultMutableTreeNode buySeatPlace = new DefaultMutableTreeNode("Buy the seating place");
        seatingHeader.add(buySeatPlace);

        DefaultMutableTreeNode buyTicket = new DefaultMutableTreeNode("Buy ticket(s)");
        ticketHeader.add(buyTicket);

        JTree tree = new JTree(root);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(200, 400));

        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node != null && node.isLeaf()) {
                String selectedNode = node.getUserObject().toString();
                switch (selectedNode) {
                    case "View all sessions":
                        JOptionPane.showMessageDialog(frame, "View all sessions for Client");
                        break;
                    case "View all films":
                        JOptionPane.showMessageDialog(frame, "View all films for Client");
                        break;
                    case "View all seating":
                        JOptionPane.showMessageDialog(frame, "View all seating for Client");
                        break;
                    case "View all tickets":
                        JOptionPane.showMessageDialog(frame, "View all tickets for Client");
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
