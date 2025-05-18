package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model;

public class chuyenmuc {

    private String tenchuyenmuc;
    private String hinhanhchuyenmuc;

    // Constructor không tham số bắt buộc cho Firebase
    public chuyenmuc() {
    }

    // Constructor có tham số
    public chuyenmuc(String tenchuyenmuc, String hinhanhchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }

    public String getTenchuyenmuc() {
        return tenchuyenmuc;
    }

    public void setTenchuyenmuc(String tenchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
    }

    public String getHinhanhchuyenmuc() {
        return hinhanhchuyenmuc;
    }

    public void setHinhanhchuyenmuc(String hinhanhchuyenmuc) {
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }
}
