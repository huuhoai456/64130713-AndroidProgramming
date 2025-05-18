package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model;

public class Truyen {

    // Các trường dữ liệu sẽ được lưu trong Realtime Database
    private String tenTruyen;
    private String noiDung;
    private String anh;
    private String idTaiKhoan;

    // Trường này KHÔNG lưu trong database — chỉ dùng để giữ key (ID) của node nếu cần
    private transient String ID;

    // Bắt buộc có constructor rỗng để Firebase đọc dữ liệu
    public Truyen() {}

    public Truyen(String tenTruyen, String noiDung, String anh, String idTaiKhoan) {
        this.tenTruyen = tenTruyen;
        this.noiDung = noiDung;
        this.anh = anh;
        this.idTaiKhoan = idTaiKhoan;
    }

    // Getter & Setter
    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    // ID là key của node, không được Firebase lưu nên đánh dấu là transient
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
