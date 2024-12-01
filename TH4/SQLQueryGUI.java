import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SQLQueryGUI extends JFrame implements ActionListener {

    private JLabel label1, label2;
    private JTextField textField1, textField2;
    private JTable table;
    private DefaultTableModel tableModel;
    JButton submitButton, resetButton, cancelButton;

    String mConnectionString, mSQLCommand;

    public SQLQueryGUI() {
        super("SQLQueryGUI");
        setLayout(new GridBagLayout());

        // Create labels and text fields
        label1 = new JLabel("Connection string:");
        textField1 = new JTextField(15);
        // textField1.setText("jdbc:mysql://localhost:3306/DATA");
        label2 = new JLabel("Query command:");
        textField2 = new JTextField(15);
        // textField2.setText("SELECT * FROM Table1");

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Address", "Total"}, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(10); // ID column with a weight of 1
        table.getColumnModel().getColumn(1).setPreferredWidth(40); // Name column with a weight of 4
        table.getColumnModel().getColumn(2).setPreferredWidth(30); // Address column with a weight of 3
        table.getColumnModel().getColumn(3).setPreferredWidth(20); // Total column with a weight of 2

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(label1, constraints);
        constraints.gridx = 1;
        add(textField1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(label2, constraints);
        constraints.gridx = 1;
        add(textField2, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        add(scrollPane, constraints);

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        cancelButton = new JButton("Cancel");
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        cancelButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(cancelButton);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 3;
        buttonConstraints.gridwidth = 2;
        buttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, buttonConstraints);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SQLQueryGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            loadRecordFromDatabase();
        }

        if (e.getSource() == resetButton) {
            textField1.setText("");
            textField2.setText("");
            removeAllTableRow();
        }

        if (e.getSource() == cancelButton) System.exit(0);
    }

    private void removeAllTableRow() {
        if (tableModel.getRowCount() < 1) {
            return;
        }
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void loadRecordFromDatabase() {
        String url = textField1.getText();
        // "jdbc:mysql://localhost:3306/DATA";
        String sqlCommand = textField2.getText();
            // "SELECT * FROM Table1";
        if (url.equals(mConnectionString) && sqlCommand.equals(mSQLCommand)) {
            System.out.println("Already performed");
            return;
        }
        mConnectionString = url;
        mSQLCommand = sqlCommand;
        String username = "root";
        String password = "HoaiLuong@123";

 
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công!");
            
            Statement getAllStatement = connection.createStatement();
            
            ResultSet resultSet = getAllStatement.executeQuery(sqlCommand);

            ResultSetMetaData metaData = resultSet.getMetaData();

            while(resultSet.next()) {
                String[] rowData = new String[metaData.getColumnCount()];
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    rowData[i-1] = resultSet.getObject(i).toString();
                }
                tableModel.addRow(rowData);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại. Lỗi: " + e.getMessage());
        } finally {
            //TODO
        }
    }
}