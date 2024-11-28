import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyevent implements KeyListener {
    private JLabel label;

    public keyevent() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("KeyBoardEventTest");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout()); 

        label = new JLabel("Press any key...");
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        mainFrame.add(label);
        mainFrame.add(label, BorderLayout.CENTER);

        mainFrame.addKeyListener(this);
        mainFrame.setFocusable(true);

        mainFrame.setSize(300, 200);
        mainFrame.setVisible(true);
        label.setHorizontalAlignment(JLabel.CENTER);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);

        label.setText(" " + keyText);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[]args) {
        new keyevent();
    }
}
