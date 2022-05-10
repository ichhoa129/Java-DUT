package bt410;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai410 extends JFrame implements ActionListener {

    JLabel lbHeader, lbNhap, lbKq;
    JTextField txtNhap, txtKq;
    JButton okBtn, resetBtn, exitBtn;
    JPanel header, input, buttons, panel;

    public void GUI()
    {
        lbHeader = new JLabel("Kiem tra co thuoc Fibonacci");

        lbNhap = new JLabel("Nhap a");
        lbKq = new JLabel("KQ");

        txtNhap = new JTextField();
        txtKq = new JTextField();

        txtKq.setEnabled(false);

        okBtn = new JButton("Ok");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");

        header = new JPanel(new FlowLayout());
        input = new JPanel(new GridLayout(2, 2));
        buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel = new JPanel(new GridLayout(3,1));


        header.add(lbHeader);

        input.add(lbNhap);
        input.add(txtNhap);
        input.add(lbKq);
        input.add(txtKq);

        buttons.add(okBtn);
        buttons.add(resetBtn);
        buttons.add(exitBtn);

        panel = new JPanel(new GridLayout(3,1));
        panel.add(header);
        panel.add(input);
        panel.add(buttons);
        add(panel);

        okBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setBounds(700, 300, 400, 200);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public bai410(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static boolean isFibonaci(int n) {
        int a = 0, a1 = 0, a2 = 1;
        while (a < n) {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
        }
        return a == n;
    }

    public static void main(String[] args) {
        new bai410("kiem tra fibonacci");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == okBtn)
        {
            String inputString = txtNhap.getText();
            if(!inputString.isBlank())
            {
                String result = Boolean.toString(isFibonaci(Integer.parseInt(inputString)));
                System.out.println(result);
                txtKq.setText(result);
            }
        } else if (actionEvent.getSource() == resetBtn)
        {
            txtNhap.setText("");
            txtKq.setText("");
        } else if(actionEvent.getSource() == exitBtn)
        {
            System.exit(0);
        }
    }
}
