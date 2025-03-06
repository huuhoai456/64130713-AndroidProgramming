package nhh.edu.ex7_intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Lấy Intent về
        Intent intentTuLogin = getIntent();

        // Lọc ra lấy dữ liệu chuỗi
        String tenDN_NhanDuoc = intentTuLogin.getStringExtra("ten_dang_nhap"); // Xóa "name: "

        // Gán vào điều khiển
        TextView tvTenDN = (TextView) findViewById(R.id.tvUserName);

        // Thêm kiểm tra null để tránh crash nếu không nhận được dữ liệu
        if (tenDN_NhanDuoc != null) {
            tvTenDN.setText(tenDN_NhanDuoc);
        } else {
            tvTenDN.setText("Không nhận được tên đăng nhập");
            Toast.makeText(this, "Không nhận được dữ liệu từ Login", Toast.LENGTH_SHORT).show();
        }
    }
}