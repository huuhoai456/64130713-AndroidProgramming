package nhh.edu.ex4_addsubmuldiv_onclick;

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
    //khai báo các đối tượng gắn với điều khiển tương ứng ở đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }

    //Xử lý cộng
    public void XuLyCong(View v) {
        //Code xử lý cộng ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1 tìm edittext số 1 và số 2

        // b1.2 Lấy dữ liệu từ 2 điều khiển trên
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3 Chuyển từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2. Tính toán
        float Tong = soA + soB;
        // b3. Hiện kết quả
        // b3.1

        // b3.2 Chuẩn bị dữ liệu xuất , biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tong);
        // b3.3 gán kết quả lên diều khiển
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyTru(View v) {
        //Code xử lý trừ ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1 tìm edittext số 1 và số 2

        // b1.2 Lấy dữ liệu từ 2 điều khiển trên
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3 Chuyển từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2. Tính toán
        float Hieu = soA - soB;
        // b3. Hiện kết quả
        // b3.1

        // b3.2 Chuẩn bị dữ liệu xuất , biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Hieu);
        // b3.3 gán kết quả lên diều khiển
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyNhan(View v) {
        //Code xử lý nhân ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1 tìm edittext số 1 và số 2

        // b1.2 Lấy dữ liệu từ 2 điều khiển trên
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3 Chuyển từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2. Tính toán
        float Tich = soA * soB;
        // b3. Hiện kết quả
        // b3.1

        // b3.2 Chuẩn bị dữ liệu xuất , biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tich);
        // b3.3 gán kết quả lên diều khiển
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyChia(View v) {
        //Code xử lý chia ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1 tìm edittext số 1 và số 2

        // b1.2 Lấy dữ liệu từ 2 điều khiển trên
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3 Chuyển từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        // b2. Tính toán
        float Thuong = soA / soB;
        // b3. Hiện kết quả
        // b3.1

        // b3.2 Chuẩn bị dữ liệu xuất , biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Thuong);
        // b3.3 gán kết quả lên diều khiển
        editTextKQ.setText(chuoiKQ);
    }
}