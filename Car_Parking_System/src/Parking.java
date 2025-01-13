import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Parking extends JFrame implements ActionListener {
    private JComboBox<String> parkingComboBox;
    private JButton bookButton, releaseButton,back;
    private JTable statusTable;
    private DefaultTableModel tableModel;
    private Connection conn;
    private Statement stmt;
    private JDBC jdbc;

    public Parking() {
        setSize(400, 300);
        setBounds(300,30,500,500);
        setBackground(new Color(0,128,255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create the parking combo box
        parkingComboBox = new JComboBox<String>();
        for (int i = 1; i <= 5; i++) {
            parkingComboBox.addItem("Parking Slot " + i);
        }

        // Create the book button
        bookButton = new JButton("Book");
        bookButton.addActionListener(this);

        // Create the release button
        releaseButton = new JButton("Release");
        releaseButton.addActionListener(this);

        // Create the status table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Parking Slot");
        tableModel.addColumn("Status");
        statusTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(statusTable);

        // Add the components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(parkingComboBox);
        topPanel.add(bookButton);
        topPanel.add(releaseButton);
        contentPane.add(topPanel);
        contentPane.add(scrollPane);





        // Connect to the database and create the table
        try {
            jdbc = new JDBC();
            conn = jdbc.c;
            stmt = jdbc.s;
            String sql = "CREATE TABLE IF NOT EXISTS parking_slots (slots_id INT PRIMARY KEY, status VARCHAR(10))";
            stmt.executeUpdate(sql);
            for (int i = 1; i <= 5; i++) {
                sql = "INSERT INTO parking_slots (slots_id, status) VALUES (" + i + ", 'available')";
                stmt.executeUpdate(sql);
                tableModel.addRow(new String[]{"Parking Slot " + i, "available"});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        int slotId = parkingComboBox.getSelectedIndex() + 1;

        // Update the database and status table
        try {
            String sql = "";
            if (button == bookButton) {
                sql = "UPDATE parking_slots SET status = 'booked' WHERE slots_id = " + slotId + " AND status = 'available'";
                tableModel.setValueAt("booked", slotId - 1, 1);
            } else if (button == releaseButton) {
                sql = "UPDATE parking_slots SET status = 'available' WHERE slots_id = " + slotId + " AND status = 'booked'";
                tableModel.setValueAt("available", slotId - 1, 1);
            }
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Parking gui = new Parking();
    }
}
