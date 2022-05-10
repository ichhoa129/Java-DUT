import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Cau1 {

    private JFrame frame;
    private JTextField nhapTxt;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cau1 window = new Cau1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Cau1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 541, 384);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Nhập chuỗi");
        lblNewLabel.setBounds(80, 43, 105, 15);
        frame.getContentPane().add(lblNewLabel);

        nhapTxt = new JTextField();
        nhapTxt.setBounds(203, 41, 248, 19);
        frame.getContentPane().add(nhapTxt);
        nhapTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Thực hiện");
        lblNewLabel_1.setBounds(80, 92, 70, 15);
        frame.getContentPane().add(lblNewLabel_1);

        Choice choice = new Choice();
        choice.addItem("Đếm từ");
        choice.addItem("Đếm từ trùng lặp");
        choice.addItem("Đảo chuỗi");
        choice.setBounds(203, 92, 106, 21);
        frame.getContentPane().add(choice);

        JLabel lblNewLabel_2 = new JLabel("Kết quả");
        lblNewLabel_2.setBounds(80, 141, 70, 15);
        frame.getContentPane().add(lblNewLabel_2);

        JTextArea ketQuaTxt = new JTextArea();
        ketQuaTxt.setRows(5);
        ketQuaTxt.setColumns(10);
        ketQuaTxt.setBounds(203, 141, 240, 100);
        ketQuaTxt.setEditable(false);
        frame.getContentPane().add(ketQuaTxt);

        JButton viewBtn = new JButton("View");
        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String inputText = nhapTxt.getText();
                int choiceIndex = choice.getSelectedIndex();
                /*
                *  index : 0 dem tu
                *          1 dem tu trung lap
                *          2 dao chuoi
                * */
                ketQuaTxt.setText("");
                switch (choiceIndex) {
                    case 0: {
                        int result = demTu(inputText);
                        ketQuaTxt.setText("Chuoi co tat ca " + result + " tu.");
                        break;
                    }
                    case 1: {
                        Map<String, Integer> result = demTuTrungLap(inputText);
                        for(Map.Entry<String,Integer> entry : result.entrySet())
                        {
                            ketQuaTxt.append(entry.getKey() + ": " + entry.getValue() + "\n");
                        }
                        break;
                    }
                    case 2: {
                        String result = daoChuoi(inputText);
                        ketQuaTxt.setText(result);
                        break;
                    }
                }

            }
        });
        viewBtn.setBounds(68, 289, 117, 25);
        frame.getContentPane().add(viewBtn);

        JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nhapTxt.setText("");
                ketQuaTxt.setText("");
            }
        });
        resetBtn.setBounds(223, 289, 117, 25);
        frame.getContentPane().add(resetBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               System.exit(0);
            }
        });
        exitBtn.setBounds(379, 289, 117, 25);
        frame.getContentPane().add(exitBtn);
    }

    private int demTu(String text) {
        String[] splitedString = text.split(" ");
        return splitedString.length;
    }

    private Map<String, Integer> demTuTrungLap(String text) {
        String[] splitedString = text.split(" ");

        Map<String,Integer> map = new HashMap<>();

        int sum = 0;

        for ( int i = 0; i < splitedString.length; ++i ) {
            if( map.containsKey(splitedString[i]) ) {
                sum = map.get( splitedString[i] );
                map.put( splitedString[i], ++sum );
            }
            else{
                map.put( splitedString[i], 1 );
            }
        }

        return map;
    }

    private String daoChuoi(String text) {
        String[] splitedString = text.split(" ");

        StringBuilder newString = new StringBuilder();

        for (int i = splitedString.length-1; i >=0 ; --i) {
            newString.append(splitedString[i] + " ");
        }

        return String.valueOf(newString);
    }
}
