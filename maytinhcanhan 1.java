import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class maytinhcanhan implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] buttons;
    String[] buttonValues = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "C", "+"};
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    List<String> numbers = new ArrayList<>();
    List<String> operators = new ArrayList<>();

    public maytinhcanhan() {
        frame = new JFrame("Calculator");
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false); 
        buttons = new JButton[buttonValues.length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonValues[i]);
            buttons[i].addActionListener(this);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < buttons.length; i++) {
            panel.add(buttons[i]);
        }

        JPanel equalPanel = new JPanel();
        equalPanel.setLayout(new GridLayout(1, 1));
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(this);
        equalPanel.add(equalButton);

        GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
        buttonPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        buttonPanel.add(panel);
        
        GridBagConstraints equalButtonnConstraints = new GridBagConstraints();
        equalButtonnConstraints.fill = GridBagConstraints.VERTICAL;
        equalButtonnConstraints.ipadx = 5;
        buttonPanel.add(equalPanel, equalButtonnConstraints);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonText = clickedButton.getText();

        if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            num1 = Double.parseDouble(textField.getText());
            operator = buttonText.charAt(0);
            textField.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    public static void main(String[] args) {
        new maytinhcanhan();
    }
}