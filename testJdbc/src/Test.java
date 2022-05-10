import java.sql.*;

public class Test {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Data";
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

    public static void main(String[] args) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from Table1");

            while (rs.next()) {
                System.out.println("ID=" + rs.getInt(1) + "  " + "Name=" + rs.getString(2)
                        + " Address: " + rs.getString(3) + " Total: " + rs.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
