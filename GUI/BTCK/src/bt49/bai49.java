package bt49;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai49 extends Frame implements ActionListener {

    Label headerLb, nhapLb, kqLb;
    TextField nhapTxt, kqTxt;
    Button timBtn, resetBtn, exitBtn;
    Panel header, body, footer, pn;

    public void GUI()
    {
        headerLb = new Label("Cac so nguyen to <= n");
        nhapLb = new Label("Nhap n");
        kqLb = new Label("KQ");

        nhapTxt = new TextField();
        kqTxt = new TextField();

        kqTxt.setEnabled(false);

        timBtn = new Button("Tim");
        resetBtn = new Button("Reset");
        exitBtn = new Button("Exit");

        timBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        header = new Panel(new FlowLayout());
        body = new Panel(new GridLayout(2,2));
        footer = new Panel(new FlowLayout());
        pn = new Panel(new GridLayout(3, 1));

        header.add(headerLb);

        body.add(nhapLb);
        body.add(nhapTxt);
        body.add(kqLb);
        body.add(kqTxt);

        footer.add(timBtn);
        footer.add(resetBtn);
        footer.add(exitBtn);

        pn.add(header);
        pn.add(body);
        pn.add(footer);

        add(pn);
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
        if(actionEvent.getSource() == timBtn)
        {
            Calculate(Integer.parseInt(nhapTxt.getText()));
        } else if(actionEvent.getSource() == resetBtn)
        {
            nhapTxt.setText("");
            kqTxt.setText("");
        } else {
            System.exit(0);
        }
    }

    public void Calculate(int n)
    {
        if(n <2)
        {
            kqTxt.setText("Khong co so nguyen to");
            return;
        }
        for(int i = 2; i<=n; ++i)
        {
            int dem = 0;
            int half = i/2;
            for(int j =2; j<= half; ++j)
            {
                if(i%j==0)
                    ++dem;
            }
            if(dem == 0)
            {
                String currentText = kqTxt.getText();
                kqTxt.setText(currentText + " " + i);
            }
        }
    }

    public bai49(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new bai49("Tim so nguyen to");
    }
}
