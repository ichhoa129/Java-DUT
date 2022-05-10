package bt411;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai411 extends JFrame implements ActionListener {

    JTextField txtOutput;
    String[] numberBtn = {
                            "", "", "", "Backspace", "C",
                            "7", "8", "9", "/", "sqrt",
                            "4", "5", "6", "*",  "%",
                            "1", "2", "3", "-", "1/x",
                            "0", "+/-", ".", "+", "="
    };
    JPanel screenPn, mainPn, numberPn;
    String ansTxt = "";
    double numA, numB;
    int operator;
    public void GUI()
    {
        txtOutput = new JTextField();
        txtOutput.setDisabledTextColor(Color.RED);
        txtOutput.setEnabled(false);

        screenPn = new JPanel(new GridLayout(1,1));
        numberPn = new JPanel(new GridLayout(5, 5));
        mainPn = new JPanel(new GridLayout(2,1));


        screenPn.add(txtOutput);

        for (String s : numberBtn) {
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            numberPn.add(btn);
        }

        mainPn.add(screenPn);
        mainPn.add(numberPn);
        add(mainPn);

        setBounds(700, 300, 350, 400);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public bai411(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new bai411("Calculator");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand())
        {
            case "0": ansTxt += "0";
                break;
            case "1": ansTxt += "1";
                break;
            case "2": ansTxt += "2";
                break;
            case "3": ansTxt += "3";
                break;
            case "4": ansTxt += "4";
                break;
            case "5": ansTxt += "5";
                break;
            case "6": ansTxt += "6";
                break;
            case "7": ansTxt += "7";
                break;
            case "8": ansTxt += "8";
                break;
            case "9": ansTxt += "9";
                break;
            case ".":
            {
                boolean check = false;
                for (int i = 0; i < ansTxt.length(); i++) {
                    if (ansTxt.charAt(i) == '.') {
                        check = true;
                        break;
                    }
                }
                if (!check)
                    ansTxt += ".";
                break;
            }
            case "C": ansTxt = "";
                break;
            case "Backspace":
            {
                if (ansTxt != null && ansTxt.length() > 0) {
                    ansTxt = ansTxt.substring(0, ansTxt.length() - 1);
                }
                break;
            }
            case "+/-": {
                double textValue = Double.parseDouble(txtOutput.getText());
                ansTxt = String.valueOf(0 - textValue);
                break;
            }
            case "sqrt": {
                double textValue = Double.parseDouble(txtOutput.getText());
                ansTxt = String.valueOf(Math.sqrt(textValue));
                break;
            }
            case "%": {
                double textValue = Double.parseDouble(txtOutput.getText());
                ansTxt = String.valueOf(textValue/100);
                break;
            }
            case "1/x": {
                double textValue = Double.parseDouble(txtOutput.getText());
                ansTxt = String.valueOf(1/textValue);
                break;
            }
            case "+": {
                numA = Double.parseDouble(txtOutput.getText());
                operator = 1;
                ansTxt = "";
                break;
            }
            case "-": {
                numA = Double.parseDouble(txtOutput.getText());
                operator = 2;
                ansTxt = "";
                break;
            }
            case "*": {
                numA = Double.parseDouble(txtOutput.getText());
                operator = 3;
                ansTxt = "";
                break;
            }
            case "/": {
                numA = Double.parseDouble(txtOutput.getText());
                operator = 4;
                ansTxt = "";
                break;
            }
            case "=": {
                numB = Double.parseDouble(txtOutput.getText());
                switch (operator)
                {
                    case 1: ansTxt = "" + (numA + numB);
                        break;
                    case 2: ansTxt = "" + (numA - numB);
                        break;
                    case 3: ansTxt = "" + (numA * numB);
                        break;
                    case 4: ansTxt = "" + (numA / numB);
                        break;
                    default: ansTxt = "0";
                }
                break;
            }
        }
        txtOutput.setText(ansTxt);

    }
}
