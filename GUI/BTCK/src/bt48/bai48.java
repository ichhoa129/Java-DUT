package bt48;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai48 extends Frame implements ActionListener {

    Label headerLb, inputALb, inputBLb, resultLb;
    TextField inputATxt, inputBTxt, resultTxt;
    Button addBtn, subBtn, mulBtn, divideBtn, exitBtn, resetBtn;
    Panel panel, headerPn, bodyPn, buttonPn, systemPn;

    public void GUI()
    {
        headerLb = new Label("calculator");

        inputALb = new Label("Number a");
        inputBLb = new Label("Number b");
        resultLb = new Label("Result");
        inputATxt = new TextField();
        inputBTxt = new TextField();
        resultTxt = new TextField();
        resultTxt.setEnabled(false);

        addBtn = new Button("Add");
        subBtn = new Button("Sub");
        mulBtn = new Button("Mul");
        divideBtn = new Button("Divide");

        exitBtn = new Button("Exit");
        resetBtn = new Button("Reset");


        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divideBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        headerPn = new Panel(new FlowLayout());
        headerPn.add(headerLb);

        bodyPn = new Panel(new GridLayout(3, 2));

        bodyPn.add(inputALb);
        bodyPn.add(inputATxt);
        bodyPn.add(inputBLb);
        bodyPn.add(inputBTxt);
        bodyPn.add(resultLb);
        bodyPn.add(resultTxt);

        buttonPn = new Panel(new FlowLayout());
        buttonPn.add(addBtn);
        buttonPn.add(subBtn);
        buttonPn.add(mulBtn);
        buttonPn.add(divideBtn);

        systemPn = new Panel(new GridBagLayout());
        systemPn.add(exitBtn);
        systemPn.add(resetBtn);

        add(headerPn);
        add(bodyPn);
        add(buttonPn);
        add(systemPn);


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(400, 200);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);

    }
    public bai48(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
    new bai48("Minh hoa cac phep toan");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == addBtn)
        {
            int a = Integer.parseInt(inputATxt.getText());
            int b = Integer.parseInt(inputBTxt.getText());
            resultTxt.setText(Integer.toString(a+b));
        } else if (actionEvent.getSource() == subBtn)
        {
            int a = Integer.parseInt(inputATxt.getText());
            int b = Integer.parseInt(inputBTxt.getText());
            resultTxt.setText(Integer.toString(a-b));
        } else if(actionEvent.getSource() == divideBtn)
        {
            int a = Integer.parseInt(inputATxt.getText());
            int b = Integer.parseInt(inputBTxt.getText());
            resultTxt.setText(Float.toString(a/b));
        } else if (actionEvent.getSource() == mulBtn)
        {
            int a = Integer.parseInt(inputATxt.getText());
            int b = Integer.parseInt(inputBTxt.getText());
            resultTxt.setText(Integer.toString(a*b));
        } else if (actionEvent.getSource() == resetBtn)
        {
            inputATxt.setText("");
            inputBTxt.setText("");
            resultTxt.setText("");
        } else if (actionEvent.getSource() == exitBtn)
        {
            System.exit(0);
        }
    }
}
