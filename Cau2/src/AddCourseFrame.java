import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCourseFrame extends JFrame implements ActionListener {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestJava";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    private JFrame frame;
    private JTextField codeTxt;
    private JTextField courseTxt;
    private JTextField creditTxt;

    public AddCourseFrame() {
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

        JLabel lblNewLabel = new JLabel("Code");
        lblNewLabel.setBounds(50, 51, 70, 15);
        frame.getContentPane().add(lblNewLabel);

        codeTxt = new JTextField();
        codeTxt.setBounds(181, 49, 114, 19);
        frame.getContentPane().add(codeTxt);
        codeTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Course Name");
        lblNewLabel_1.setBounds(50, 99, 103, 15);
        frame.getContentPane().add(lblNewLabel_1);

        courseTxt = new JTextField();
        courseTxt.setBounds(181, 97, 223, 19);
        frame.getContentPane().add(courseTxt);
        courseTxt.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Credit");
        lblNewLabel_2.setBounds(50, 146, 70, 15);
        frame.getContentPane().add(lblNewLabel_2);

        creditTxt = new JTextField();
        creditTxt.setBounds(181, 144, 114, 19);
        frame.getContentPane().add(creditTxt);
        creditTxt.setColumns(10);

        JButton addCourseBtn = new JButton("Add");
        addCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String code = codeTxt.getText();
                String name = courseTxt.getText();
                int credit = Integer.parseInt(creditTxt.getText());

                addCourse(code, name, credit);
            }
        });
        addCourseBtn.setBounds(36, 219, 117, 25);
        frame.getContentPane().add(addCourseBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        clearBtn.setBounds(204, 219, 117, 25);
        frame.getContentPane().add(clearBtn);
        frame.show();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    private void addCourse(String code, String name, int credit) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            String sql = "Insert into courses(code, name, credit) values (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, code);
            statement.setString(2, name);
            statement.setInt(3, credit);
            int rs = statement.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }

    }
}
