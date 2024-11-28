import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action_Event implements ActionListener, ListSelectionListener {

    private JLabel textLabel;
    private JButton ok;
    private JTextField txta; 
    private JList<String> listView;

    private String[] listItems = {"Tiger", "Lion", "Elephant"};

    public Action_Event() {
        JFrame mainFrame = new JFrame("ItemEventTest");
        mainFrame.setLayout(new GridLayout(2, 1));
        JPanel mainPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JPanel textPanel = new JPanel(new FlowLayout());

        textLabel = new JLabel("The event is displayed here");
        ok = new JButton("OK"); 
        txta = new JTextField(20);
        txta.addActionListener(this);

        listView = new JList<>(listItems);
        listView.addListSelectionListener(this);

        ok.addActionListener(this); 

        mainPanel.add(ok);
        mainPanel.add(txta);
        mainPanel.add(listView);

        textPanel.add(textLabel);

        mainFrame.add(mainPanel);
        mainFrame.add(textPanel);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Action_Event(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) { 
            textLabel.setText("OK button clicked"); 
        }

        if (e.getSource() == txta) {
            textLabel.setText("Enter perform in text field text is: " + e.getActionCommand()); 
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        textLabel.setText(listView.getSelectedValue() + " is selected");
    }
}
 