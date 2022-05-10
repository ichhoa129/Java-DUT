import javax.swing.*;
import java.awt.*;

public class Frame1 extends JFrame {
    public static void main(String[] args) {
        Frame1 f = new Frame1();
        f.setTitle("Hello");
        f.setBounds(200, 500, 700, 300);
        f.setLayout(new FlowLayout());
        f.add(new JButton("OK"));
        f.add(new JButton("Cancel"));

        f.add(new JLabel("This is label"));
        f.add(new JTextField("Type input"));
        f.add(new JTextArea(5, 30));

        f.add(new Checkbox("Sport"));
        f.add(new Checkbox("Music"));
        f.add(new Checkbox("Travel"));

        CheckboxGroup cgr = new CheckboxGroup();

        f.add(new Checkbox("Male",cgr, true));
        f.add(new Checkbox("Female",cgr, false));

        Choice ch = new Choice();
        ch.addItem("Sport");
        ch.addItem("Music");
        ch.addItem("Travel");
        f.add(ch);

        List list = new java.awt.List(2, false);
        list.add("Music");
        list.add("Travel");
        list.add("Game");
        list.add("Telen");
        f.add(list);
        f.setVisible(true);

    }
}
