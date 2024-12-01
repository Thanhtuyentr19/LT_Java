import java.awt.*;
import java.awt.event.*;

public class xulichuoikitu extends Frame implements ActionListener {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    Label inputLabel, toUpperLabel, toLoweLabel, toUpLowLabel, wordNumLabel;
    TextField txtstr, txtupper, txtlower, txtupperlower, txtnumber;
    Button ok, reset, exit;
    Panel parentPanel, buttonsPanel, textsPanel;

    public void GUI(){
        toUpLowLabel = new Label("To Lower Upper");
        inputLabel = new Label("Enter a string");
        toUpperLabel = new Label("To UpperCase");
        toLoweLabel = new Label("To LowerCase");
        wordNumLabel = new Label("Number of Word");

        txtstr = new TextField();
        txtupper = new TextField();
        txtupper.setEditable(false);
        txtlower = new TextField();
        txtlower.setEditable(false);
        txtupperlower = new TextField();
        txtupperlower.setEditable(false);
        txtnumber = new TextField();
        txtnumber.setEditable(false);

        ok = new Button("OK");
        reset = new Button("Reset");
        exit = new Button("Exit");

        ok.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        parentPanel = new Panel(new GridLayout(2,1));
        buttonsPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setSize(WIDTH, HEIGHT / 4);
        textsPanel = new Panel(new GridLayout(5,2));

        textsPanel.add(inputLabel);
        textsPanel.add(txtstr);
        textsPanel.add(toUpperLabel);
        textsPanel.add(txtupper);
        textsPanel.add(toLoweLabel);
        textsPanel.add(txtlower);
        textsPanel.add(toUpLowLabel);
        textsPanel.add(txtupperlower);
        textsPanel.add(wordNumLabel);
        textsPanel.add(txtnumber);

        buttonsPanel.add(ok);
        buttonsPanel.add(reset);
        buttonsPanel.add(exit);

        parentPanel.add(textsPanel);
        parentPanel.add(buttonsPanel);

        add(parentPanel);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            System.out.println("OK pressed");
            String inputString = txtstr.getText();

            txtupper.setText(inputString.toUpperCase());
            txtlower.setText(inputString.toLowerCase());
            txtupperlower.setText(revertUpperLower(inputString));
            txtnumber.setText(Integer.toString(countWordsUsingRegex(inputString)));
        }
        if (e.getSource() == reset) {
            System.out.println("Reset pressed");
            txtstr.setText("");
            txtupper.setText("");
            txtlower.setText("");
            txtupperlower.setText("");
            txtnumber.setText("");
        }
        if (e.getSource() == exit) {
            System.out.println("Exit pressed");
            System.exit(0);
        }
    }
    
    public xulichuoikitu(String str) {
        super(str);
        GUI();
    }

    public static void main(String[] args) {
        new xulichuoikitu("Xu ly chuoi ki tu");
    }

    static String revertUpperLower (String originalString) {
        StringBuilder buf = new StringBuilder(originalString.length());
        for (int i = 0; i < originalString.length(); i++) {
            char c = originalString.charAt(i);

            if (Character.isUpperCase(c)) {
                buf.append(Character.toLowerCase(c));

            }
            else if (Character.isLowerCase(c)) {
                buf.append(Character.toUpperCase(c));

            }
            // Account for case: neither upper nor lower
            else {
                buf.append(c);
            }

        }
        return buf.toString();
    }

    static int countWordsUsingRegex(String arg) {
        if (arg == null || arg.isEmpty()) {
            return 0;
        }
        final String[] words = arg.split("[\\p{P}\\s&&[^']]+");
        return words.length;
    }
}