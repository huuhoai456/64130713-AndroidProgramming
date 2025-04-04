package nhh.edu.thigk2nguyenhuuhoai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_ChucNang2 extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutTinh;

    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSoA);
        editTextSo2 = findViewById(R.id.edtSoB);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutTinh = findViewById(R.id.btnKetQua);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang2);

        TimDieuKhien(); // Tìm các điều khiển trong giao diện

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Gán sự kiện nút tính
        nutTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhTB(v);
            }
        });
    }

    public void TinhTB(View v) {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        if (soThu1.isEmpty() || soThu2.isEmpty()) {
            editTextKQ.setText("Vui lòng nhập đủ số!");
            return;
        }

        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float TB = 0.5f * soA + 0.5f * soB;

        editTextKQ.setText(String.valueOf(TB));
    }
}
