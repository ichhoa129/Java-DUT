package bt47;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai47 extends Frame implements ActionListener {

    Label lb1, lb2, lb3, lb;
    TextField txta, txtb, txtkq;
    Button tinh, reset, thoat;
    Panel pn, pn1, pn2, pn3;

    public void GUI()
    {
        lb = new Label("GIAI PHUONG TRINH BAC NHAT");
        lb1 = new Label("Nhap a:");
        lb2 = new Label("Nhap b:");
        lb3 = new Label("Ket qua:");

        txta = new TextField();
        txtb = new TextField();

        txtkq = new TextField();
        txtkq.setEnabled(false);
        tinh = new Button("Tinh");
        reset = new Button("Reset");
        thoat = new Button("Thoat");

        tinh.addActionListener(this);
        reset.addActionListener(this);
        thoat.addActionListener(this);

        pn = new Panel(new GridLayout(3,1));
        pn1 = new Panel(new FlowLayout());
        pn2 = new Panel(new GridLayout(3,2));
        pn3 = new Panel(new GridLayout(1,3));

        pn1.add(lb);

        pn2.add(lb1);
        pn2.add(txta);

        pn2.add(lb2);
        pn2.add(txtb);
        pn2.add(lb3);
        pn2.add(txtkq);

        pn3.add(tinh);
        pn3.add(reset);
        pn3.add(thoat);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        add(pn); // add to frame
        setSize(400, 300);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if( actionEvent.getSource() == tinh)
        {
            int a = Integer.parseInt(txta.getText());
            int b = Integer.parseInt(txtb.getText());
            if(a!=0) txtkq.setText(Float.toString((float)-b/a));
            else if(b==0) txtkq.setText("Phuong trinh vo so nghiem");
            else txtkq.setText("Phuong trinh vo nghiem");
        }

        if(actionEvent.getSource() == reset)
        {
            txta.setText("");
            txtb.setText("");
            txtkq.setText("");
        }

        if(actionEvent.getSource() == thoat) System.exit(0);
    }

    public bai47(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new bai47("Giai phuong trinh bac 1");
    }
}
