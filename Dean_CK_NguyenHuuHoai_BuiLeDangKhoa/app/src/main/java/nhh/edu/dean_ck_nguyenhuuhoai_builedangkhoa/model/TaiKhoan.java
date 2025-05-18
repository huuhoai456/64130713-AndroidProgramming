package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model;

public class TaiKhoan {
    private String tenTaiKhoan;
    private String matKhau;
    private String email;
    private int phanQuyen;

    // Bắt buộc có constructor rỗng để Firebase đọc dữ liệu
    public TaiKhoan() {}

    public TaiKhoan(String tenTaiKhoan, String matKhau, String email, int phanQuyen) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.phanQuyen = phanQuyen;
    }

    public TaiKhoan(String tenTaiKhoan, String email) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.email = email;
    }

    // Getters & Setters
    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(int phanQuyen) {
        this.phanQuyen = phanQuyen;
    }
}
