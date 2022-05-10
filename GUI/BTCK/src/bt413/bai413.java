package bt413;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai413 extends JFrame implements ActionListener {

    JButton exitBtn;
    JPanel panel, genderPn, listPn, choicePn, resultPn;
    JLabel resultLb;

    JCheckBox cbMale, cbFemale;

    public void GUI()
    {
        exitBtn = new JButton("EXIT");
        resultLb = new JLabel("Item is displayed here");

        panel = new JPanel(new GridLayout(4,1));
        genderPn = new JPanel();
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox cbMale = new Checkbox("Male", false, cbg);
        Checkbox cbFemale = new Checkbox("Female", false, cbg);
        genderPn.add(cbMale);
        genderPn.add(cbFemale);

        cbMale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbMale.getState()) {
                    resultLb.setText("Male is checked");
                }
            }
        });
        cbFemale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbFemale.getState()) {
                    resultLb.setText("Female is checked");
                }
            }
        });



        listPn = new JPanel();
        List list = new List(3);
        list.add("MS DOS");
        list.add("WINDOWS");
        list.add("LINUX");
        list.add("CHROME");
        list.add("MACOS");
        list.add("ANDROID");
        listPn.add(list);

        list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                resultLb.setText("Item " + list.getSelectedItem() + " is selected");
            }
        });

        choicePn = new JPanel();
        Choice choice = new Choice();
        choice.addItem("Tiger");
        choice.addItem("Cat");
        choice.addItem("Zebra");
        choice.addItem("Chicken");
        choice.addItem("Monkey");
        choicePn.add(choice);

        choice.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                resultLb.setText("Item " + choice.getSelectedItem() + " is selected");
            }
        });

        resultPn = new JPanel();
        resultPn.add(resultLb);
        resultPn.add(exitBtn);

        exitBtn.addActionListener(this);

        panel.add(genderPn);
        panel.add(listPn);
        panel.add(choicePn);
        panel.add(resultPn);

        add(panel);

        setBounds(700, 300, 300, 300);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public bai413(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new bai413("Item event");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == exitBtn)
            System.exit(0);
    }
}
