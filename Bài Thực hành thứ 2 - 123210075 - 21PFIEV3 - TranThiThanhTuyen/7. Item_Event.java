import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Item_Event implements ItemListener, ListSelectionListener {

    JLabel textLabel;
    JCheckBox maleCheckBox, femaleCheckBox;
    JComboBox<String> osComboBox;
    JList<String> listView;

    String[] listItems = {"Tiger", "Lion", "Elephant"};

    public Item_Event() {
        JFrame mainFrame = new JFrame("ItemEventTest");
        mainFrame.setLayout(new GridLayout(2, 1));
        JPanel mainPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JPanel textPanel = new JPanel(new FlowLayout());

        textLabel = new JLabel("The event is displayed here");

        maleCheckBox = new JCheckBox("Male");
        maleCheckBox.addItemListener(this);
        
        femaleCheckBox = new JCheckBox("Female");
        femaleCheckBox.addItemListener(this);

        String[] osNames = {"Windows", "macOS", "Linux", "Other"};
        osComboBox = new JComboBox<>(osNames);
        osComboBox.addItemListener(this);

        listView = new JList<>(listItems);
        listView.addListSelectionListener(this);

        mainPanel.add(maleCheckBox);
        mainPanel.add(femaleCheckBox);
        mainPanel.add(osComboBox);
        mainPanel.add(listView);

        textPanel.add(textLabel);

        mainFrame.add(mainPanel);
        mainFrame.add(textPanel);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Item_Event();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch (e.getItem().getClass().getSimpleName()) {
            case "JCheckBox":
                textLabel.setText(((JCheckBox) e.getItem()).getText() + " " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                break;
            case "String":
                textLabel.setText(e.getItem() + " selected");
                break;
            default:
                textLabel.setText("The event is displayed here");
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        textLabel.setText(listView.getSelectedValue() + " is selected");
    }
}
