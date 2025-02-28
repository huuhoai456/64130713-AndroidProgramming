package nhh.edu.vd2_chuvidientichhv;

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
    EditText editTextCanh;
    EditText editTextKetQua;
    Button nutChuVi, nutDienTich;

    void TimDieuKhien() {
        editTextCanh = findViewById(R.id.edtCanh);
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
        String canhStr = editTextCanh.getText().toString();

        if (canhStr.isEmpty()) {
            editTextKetQua.setText("Vui lòng nhập độ dài cạnh!");
            return;
        }

        float canh = Float.parseFloat(canhStr);
        float chuVi = canh * 4;
        String ketQua = String.valueOf(chuVi);
        editTextKetQua.setText(ketQua);
    }

    public void TinhDienTich(View v) {
        String canhStr = editTextCanh.getText().toString();

        if (canhStr.isEmpty()) {
            editTextKetQua.setText("Vui lòng nhập độ dài cạnh!");
            return;
        }

        float canh = Float.parseFloat(canhStr);
        float dienTich = canh * canh;
        String ketQua = String.valueOf(dienTich);
        editTextKetQua.setText(ketQua);
    }
}