import java.awt.*;

public class Menu_Event extends Frame {

    public void GUI() {
        setBounds(300, 200, 200, 200);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);

        Menu file = new Menu("File");
        file.add(new MenuItem("New"));
        file.add(new MenuItem("Open"));
        file.add(new MenuItem("Save"));
        file.add(new MenuItem("Exit"));
        mb.add(file);

        Menu edit = new Menu("Edit");
        edit.add(new MenuItem("Copy"));
        edit.add(new MenuItem("Cut"));
        edit.add(new MenuItem("Paste"));
        Menu sub = new Menu("Option");
        sub.add(new MenuItem("First"));
        sub.add(new MenuItem("Second"));
        sub.add(new MenuItem("Third"));
        edit.add(sub);
        edit.add(new CheckboxMenuItem("Protected"));
        mb.add(edit);

        setVisible(true);
    }

    public Menu_Event(String st) {
        super(st);
        GUI();
    }

    public static void main(String args[]) {
        new Menu_Event("Menu Demo");
    }
}
