import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame implements ActionListener {

    JLabel title, inputLabel, binaryLabel, octLabel, hexLabel;
    JTextField inputT, binaryT, octT, hexT;
    JButton okBtn, resetBtn, exitBtn;
    JPanel panel, head, body, footer;

    public void GUI()
    {
        title = new JLabel("Xu Li Co So");
        inputLabel = new JLabel("Nhap so nguyen duong");
        binaryLabel = new JLabel("He nhi phan");
        octLabel = new JLabel("He bat phan");
        hexLabel = new JLabel("He thap luc phan");

        inputT = new JTextField();
        binaryT = new JTextField();
        octT = new JTextField();
        hexT = new JTextField();

        binaryT.setEnabled(false);
        octT.setEnabled(false);
        hexT.setEnabled(false);

        okBtn = new JButton("Ok");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");

        okBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        panel = new JPanel(new GridLayout(3, 1));
        head = new JPanel(new FlowLayout());
        body = new JPanel(new GridLayout(4, 2));
        footer = new JPanel(new GridLayout(1, 3));

        head.add(title);

        body.add(inputLabel);
        body.add(inputT);
        body.add(binaryLabel);
        body.add(binaryT);
        body.add(octLabel);
        body.add(octT);
        body.add(hexLabel);
        body.add(hexT);

        footer.add(okBtn);
        footer.add(resetBtn);
        footer.add(exitBtn);

        panel.add(head);
        panel.add(body);
        panel.add(footer);

        add(panel);
        setSize(400, 300);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public String convertBinary(int number)
    {
        StringBuilder binaryString = new StringBuilder();
        while (number>0)
        {
            int soDu = number%2;
            binaryString.append(Integer.toString(soDu));
            number = number/2;
        }
        StringBuilder str = new StringBuilder();
        for (int i = binaryString.length()-1; i >=0 ; i--) {
            str.append(binaryString.charAt(i));
        }
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 8-str.length() ; i++) {
            st.append("0");
        }
        StringBuilder ans = st.append(str.toString());

        return ans.toString();
    }

    public String convertOct(String binNum)
    {
        int b = Integer.parseInt(binNum);
        String octString = "";

        return octString;
    }

    public String convertHex(String binNum)
    {
        int b = Integer.parseInt(binNum);

        String hexString = "";

        return hexString;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if( actionEvent.getSource() == okBtn)
        {
            int inputNum = Integer.parseInt(inputT.getText());
            String bin = convertBinary(inputNum);
            String oct = convertOct(bin);
            String hex = convertHex(bin);
            binaryT.setText(bin);
            octT.setText(oct);
            hexT.setText(hex);
        }

        if(actionEvent.getSource() == resetBtn)
        {
            inputT.setText("");
            binaryT.setText("");
            octT.setText("");
            hexT.setText("");
        }

        if(actionEvent.getSource() == exitBtn) System.exit(0);
    }

    public Main(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Main("Xu li co so");
    }
}
