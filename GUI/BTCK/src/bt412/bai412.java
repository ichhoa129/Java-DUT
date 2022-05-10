package bt412;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bai412 extends JFrame implements ActionListener {

    JButton greenBtn, blueBtn, redBtn, exitBtn;
    JPanel panel, buttonPanel;

    public void GUI()
    {
        greenBtn = new JButton("Green");
        blueBtn = new JButton("Blue");
        redBtn = new JButton("Red");
        exitBtn = new JButton("Exit");


        panel = new JPanel(new BorderLayout(3,3));
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(greenBtn);
        buttonPanel.add(blueBtn);
        buttonPanel.add(redBtn);
        buttonPanel.add(exitBtn);

        panel.add(buttonPanel, BorderLayout.NORTH);

        add(panel);
        panel.setBackground(Color.GREEN);
        buttonPanel.setBackground(Color.GREEN);

        greenBtn.addActionListener(this);
        blueBtn.addActionListener(this);
        redBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setBounds(700, 300, 300, 300);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public bai412(String st) throws HeadlessException {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new bai412("Doi nen");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       if (actionEvent.getSource() == greenBtn)
       {
           panel.setBackground(Color.GREEN);
           buttonPanel.setBackground(Color.GREEN);
       }
       else if(actionEvent.getSource() == blueBtn)
       {
           panel.setBackground(Color.BLUE);
           buttonPanel.setBackground(Color.BLUE);
       }
       else if(actionEvent.getSource() == redBtn)
       {
           panel.setBackground(Color.RED);
           buttonPanel.setBackground(Color.RED);
       }
       else if (actionEvent.getSource() == exitBtn)
           System.exit(0);
    }
}

