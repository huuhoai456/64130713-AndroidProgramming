package nhh.edu.ex5_addsubmuldiv_activityaslistener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Khai báo thành phần
    private EditText edtSo1, edtSo2;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView KetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        KetQua = findViewById(R.id.KetQua);

        // Đăng ký sự kiện OnClickListener cho các nút
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        // Đặt giá trị mặc định cho TextView kết quả
        KetQua.setText("Kết quả: ");
    }

    @Override
    public void onClick(View v) {
        // Lấy dữ liệu từ EditText
        String strSo1 = edtSo1.getText().toString();
        String strSo2 = edtSo2.getText().toString();

        // Kiểm tra xem người dùng đã nhập đủ dữ liệu chưa
        if (strSo1.isEmpty() || strSo2.isEmpty()) {
            KetQua.setText("Lỗi: Vui lòng nhập đầy đủ hai số!");
            return;
        }

        // Chuyển đổi dữ liệu thành số
        double so1, so2, ketQua = 0;
        try {
            so1 = Double.parseDouble(strSo1);
            so2 = Double.parseDouble(strSo2);
        } catch (NumberFormatException e) {
            KetQua.setText("Lỗi: Vui lòng nhập số hợp lệ!");
            return;
        }

        // Xử lý tính toán dựa trên nút được nhấn
        if (v.getId() == R.id.btnCong) {
            ketQua = so1 + so2;
            KetQua.setText("Kết quả: " + ketQua);
        } else if (v.getId() == R.id.btnTru) {
            ketQua = so1 - so2;
            KetQua.setText("Kết quả: " + ketQua);
        } else if (v.getId() == R.id.btnNhan) {
            ketQua = so1 * so2;
            KetQua.setText("Kết quả: " + ketQua);
        } else if (v.getId() == R.id.btnChia) {
            // Kiểm tra chia cho 0
            if (so2 == 0) {
                KetQua.setText("Lỗi: Không thể chia cho 0!");
                return;
            }
            ketQua = so1 / so2;
            KetQua.setText("Kết quả: " + ketQua);
        }
    }
}