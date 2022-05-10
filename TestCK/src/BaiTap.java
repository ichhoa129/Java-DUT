import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BaiTap {
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

    public static List<String> readFile() throws FileNotFoundException {

        List<String> result = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/mnt/study/DUT/HK4/JAVA/TestCK/src/input.txt"));
            String line = reader.readLine();
            while(line != null) {

                result.add(line);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void writeFile() {
        int i = 1;
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("/mnt/study/DUT/HK4/JAVA/TestCK/src/output.txt"));
            while(i < 10) {
                writer.write("hehe\n");
                ++i;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToDb(List<User> HocViens) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            String sql = "Insert into HOCVIEN(MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) values (?,?,?,?,?)";
            for (int i = 0; i < HocViens.size() ; i++) {
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, HocViens.get(i).getMaHocVien());
                statement.setString(2, HocViens.get(i).getTenHocVien());
                statement.setDate(3, HocViens.get(i).getNgaySinh());
                statement.setString(4, HocViens.get(i).getGioiTinh());
                statement.setFloat(5, HocViens.get(i).getDiemThi());
                int rs = statement.executeUpdate();
                System.out.println(rs);
            }
            conn.close();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }

    }

    public static void logError(List<String> listError) {
        String errorStr = "";

        for (int i = 0; i < listError.size(); i++) {
            errorStr += listError.get(i) + "\n";
        }

        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("/mnt/study/DUT/HK4/JAVA/TestCK/src/error.txt"));
            writer.write(errorStr + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
//            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//
//            Statement stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from HOCVIEN");
//
//            while (rs.next()) {
//                System.out.println("ID= " + rs.getString("MaHocVien") + " Name=" + rs.getString("TenHocVien")
//                        + " NSinh: " + rs.getDate("NgaySinh") + " Gioi Tinh: " + rs.getString("GioiTinh") + "Diem Thi: " + rs.getFloat("DiemThi"));
//            }

            List<String> result = readFile();
            List<User> formated = new ArrayList<>();
            List<String> listError = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                try {
                    String MaHocVien = result.get(i).substring(0, 10);
                    String TenHocVien = result.get(i).substring(10, 60);
                    String NgaySinh = result.get(i).substring(60, 70);
                    String GioiTinh = result.get(i).substring(70, 73);
                    Float DiemThi = Float.valueOf(result.get(i).substring(73));

                    User newUser = new User();
                    newUser.setMaHocVien(MaHocVien);
                    newUser.setTenHocVien(TenHocVien);
                    newUser.setNgaySinh(NgaySinh);
                    newUser.setGioiTinh(GioiTinh);
                    newUser.setDiemThi(DiemThi);

                    formated.add(newUser);
                } catch (ParseException e) {
                    listError.add("Dong " + (i + 1) + ": Sai dinh dang ngay");
                    continue;
                } catch (NumberFormatException error) {
                    listError.add("Dong " + (i + 1) + ": Sai dinh dang diem thi");
                    continue;
                } catch (Exception error) {
                    System.out.println("dm");
                    listError.add("Dong " + (i + 1) + ": " + error.getMessage());
                    continue;
                }
            }
            logError(listError);
            addToDb(formated);

        } catch ( FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
