package nhh.edu.vd1_chuvidientichhcn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextChieuDai;
    EditText editTextChieuRong;
    EditText editTextKetQua;
    Button nutChuVi, nutDienTich;

    void TimDieuKhien() {
        editTextChieuDai = findViewById(R.id.edtChieuDai);
        editTextChieuRong = findViewById(R.id.edtChieuRong);
        editTextKetQua = findViewById(R.id.edtKetQua);
        nutChuVi = findViewById(R.id.btnChuVi);
        nutDienTich = findViewById(R.id.btnDienTich);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }

    public void TinhChuVi(View v) {
        String chieuDaiStr = editTextChieuDai.getText().toString();
        String chieuRongStr = editTextChieuRong.getText().toString();

        if (chieuDaiStr.isEmpty() || chieuRongStr.isEmpty()) {
            editTextKetQua.setText("Vui lòng nhập đủ dữ liệu!");
            return;
        }

        float chieuDai = Float.parseFloat(chieuDaiStr);
        float chieuRong = Float.parseFloat(chieuRongStr);
        float chuVi = (chieuDai + chieuRong) * 2;
        String ketQua = String.valueOf(chuVi);
        editTextKetQua.setText(ketQua);
    }

    public void TinhDienTich(View v) {
        String chieuDaiStr = editTextChieuDai.getText().toString();
        String chieuRongStr = editTextChieuRong.getText().toString();

        if (chieuDaiStr.isEmpty() || chieuRongStr.isEmpty()) {
            editTextKetQua.setText("Vui lòng nhập đủ dữ liệu!");
            return;
        }

        float chieuDai = Float.parseFloat(chieuDaiStr);
        float chieuRong = Float.parseFloat(chieuRongStr);
        float dienTich = chieuDai * chieuRong;
        String ketQua = String.valueOf(dienTich);
        editTextKetQua.setText(ketQua);
    }
}