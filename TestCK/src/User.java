import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {

    private String MaHocVien;
    private String TenHocVien;
    private Date NgaySinh;
    private String GioiTinh;
    private Float DiemThi;

    private final String dateFormat = "dd/MM/YYYY";

    @Override
    public String toString() {
        return "User{" +
                "MaHocVien='" + MaHocVien + '\'' +
                ", TenHocVien='" + TenHocVien + '\'' +
                ", NgaySinh='" + NgaySinh + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", DiemThi=" + DiemThi +
                '}';
    }

    public User() {

    }

    public String getMaHocVien() {
        return MaHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        MaHocVien = maHocVien;
    }

    public String getTenHocVien() {
        return TenHocVien;
    }

    public void setTenHocVien(String tenHocVien) {
        TenHocVien = tenHocVien;
    }

    public java.sql.Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date parsed = format.parse(ngaySinh);
            NgaySinh = new java.sql.Date(parsed.getTime());
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Float getDiemThi() {
        return DiemThi;
    }

    public void setDiemThi(Float diemThi) {
        DiemThi = diemThi;
    }
}
