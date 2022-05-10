import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cau2 {
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cau2 window = new Cau2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Cau2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 549, 354);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Course Management");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel.setBounds(189, 35, 200, 30);
        frame.getContentPane().add(lblNewLabel);

        JButton addBtn = new JButton("Add a new Course");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
               new AddCourseFrame();
            }
        });
        addBtn.setBounds(148, 92, 270, 25);
        frame.getContentPane().add(addBtn);

        JButton displayBtn = new JButton("Display all Courses");
        displayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        displayBtn.setBounds(148, 147, 270, 25);
        frame.getContentPane().add(displayBtn);

        JButton searchBtn = new JButton("Search Course by Course Code");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        searchBtn.setBounds(148, 204, 270, 25);
        frame.getContentPane().add(searchBtn);

        JButton exitBtn = new JButton("Exit Application");
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        exitBtn.setBounds(148, 258, 270, 25);
        frame.getContentPane().add(exitBtn);
    }
}
