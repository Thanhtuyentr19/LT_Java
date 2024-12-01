import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class change_color extends JFrame {
    JButton red, blue, green, thoat;
    JPanel pn; // Change Panel to JPanel

    public change_color(String st) {
        super(st);
        GUI(); // Move GUI setup to the constructor
    }

    public void GUI() {
        setTitle("Color Change Buttons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pn = new JPanel(); // Initialize the JPanel
        pn.setLayout(new FlowLayout()); // Set the layout manager

        red = new JButton("Red");
        blue = new JButton("Blue");
        green = new JButton("Green");
        thoat = new JButton("Thoat");

        red.addActionListener(new ButtonClickListener());
        blue.addActionListener(new ButtonClickListener());
        green.addActionListener(new ButtonClickListener());
        thoat.addActionListener(new ButtonClickListener());

        pn.add(blue);
        pn.add(red);
        pn.add(green);
        pn.add(thoat);

        add(pn);
        setSize(400, 300);
        setVisible(true); // Use setVisible instead of show()
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();

            if (sourceButton == red) {
                pn.setBackground(Color.RED); // Use pn instead of getContentPane()
            } else if (sourceButton == green) {
                pn.setBackground(Color.GREEN); // Use pn instead of getContentPane()
            } else if (sourceButton == blue) {
                pn.setBackground(Color.BLUE); // Use pn instead of getContentPane()
            } else if (e.getSource() == thoat) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] arg) {
        new change_color("Doi mau nen");
    }
}
