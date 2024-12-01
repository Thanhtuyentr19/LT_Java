import java.awt.*;
import java.awt.event.*;

import javax.security.auth.callback.LanguageCallback;
import javax.swing.*;
public class pheptoansohoc extends Frame implements ActionListener {
    Label lb1, lb2, lb3, lb; 
    TextField txta,txtb, txtkq;
    Button cong, tru, nhan, chia, reset, thoat;
    Panel pn, pn1, pn2, pn3, pn4;

public void GUI(){
    lb = new Label("Basic Arithmetic Operations");
    lb1 = new Label("Number 1");
    lb2 = new Label("Number 2");
    lb3 = new Label("Result:");

    txta = new TextField(7);
    txtb = new TextField(7);
    txtkq = new TextField();

    cong = new Button("Addition");
    tru = new Button("Subtraction");
    nhan = new Button("Multiplication");
    chia = new Button("Division");
    reset = new Button("Reset");
    thoat = new Button("Exit");



    cong.addActionListener(this);
    tru.addActionListener(this);
    nhan.addActionListener(this);
    chia.addActionListener(this);
    reset.addActionListener(this);
    thoat.addActionListener(this);

    pn = new Panel(new GridLayout(4,1));
    pn1 = new Panel(new FlowLayout());
    pn2 = new Panel(new GridLayout(3,2));
    pn3 = new Panel(new GridLayout(1,3));
    pn4 = new Panel(new FlowLayout());

    pn1.add(lb);

    pn2.add(lb1);
    pn2.add(txta);
    pn2.add(lb2);
    pn2.add(txtb);
    pn2.add(lb3);
    pn2.add(txtkq);

    pn3.add(cong);
    pn3.add(tru);
    pn3.add(nhan);
    pn3.add(chia);

    pn4.add(reset);
    pn4.add(thoat);
    
    

    pn.add(pn1);
    pn.add(pn2);
    pn.add(pn3);
    pn.add(pn4);

    add(pn);
    setSize(400,300);
    show();
}
public void actionPerformed(ActionEvent e) {
    if (e.getSource()==cong){
        int a=Integer.parseInt(txta.getText());
        int b=Integer.parseInt(txtb.getText());
        if ((a!=0) && (b!=0))txtkq.setText(Float.toString(a+b));
        else
        if ((b==0)&&(a==0)) txtkq.setText(Float.toString(0));

    }
    if (e.getSource() == tru){
        int a=Integer.parseInt(txta.getText());
        int b=Integer.parseInt(txtb.getText());
        txtkq.setText(Float.toString(a-b));

    }
    if (e.getSource() == nhan){
        int a=Integer.parseInt(txta.getText());
        int b=Integer.parseInt(txtb.getText());
        txtkq.setText(Float.toString(a*b));

    }
    if (e.getSource() == chia){
        int a=Integer.parseInt(txta.getText());
        int b=Integer.parseInt(txtb.getText());
        txtkq.setText(Float.toString((float) a/b));
    }

    if (e.getSource()==reset){
        txta.setText("");
        txtb.setText("");
        txtkq.setText("");
    }
    if (e.getSource()==thoat) System.exit(0);

}
public pheptoansohoc(String st) {
    super(st);
    GUI();
    
}
public static void main(String[] arg) {
    new pheptoansohoc("Basic Arithmetic Operations");
    
}

}
