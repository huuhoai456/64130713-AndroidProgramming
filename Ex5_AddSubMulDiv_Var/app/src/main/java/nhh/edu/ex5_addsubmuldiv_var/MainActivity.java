package nhh.edu.ex5_addsubmuldiv_var;

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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tìm view
        TimView();
        // Gắn các bộ lắng nghe
        nutCong.setOnClickListener(boLangNghe_XuLyCong);
        nutTru.setOnClickListener(boLangNghe_XuLyTru);
        nutNhan.setOnClickListener(boLangNghe_XuLyNhan);
        //nutChia.setOnClickListener(boLangNghe_XuLyChia);
        //Ví dụ bộ lắng nghe ẩn danh
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code xử lý chia ở đây
                //1. Lấy số 1
                String strSo1 = edtSoA.getText().toString();
                String strSo2 = edtSoB.getText().toString();
                //b2. Chuyển thành số để tính toán
                double soA = Double.parseDouble(strSo1);
                double soB = Double.parseDouble(strSo2);
                // b3. Tính toán
                double thuong = soA / soB;
                // b4. Xuất
                String strKQ = String.valueOf(thuong);
                tvKQ.setText(strKQ);
            }
        });
    }
    //----------------------------------------------
    // Tạo các bộ lắng nghe và xử lý sự kiện
    View.OnClickListener boLangNghe_XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Code xử lý cộng ở đây
            //1. Lấy số 1
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //b2. Chuyển thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            // b3. Tính toán
            double tong = soA + soB;
            // b4. Xuất
            String strKQ = String.valueOf(tong);
            tvKQ.setText(strKQ);

        }
    };
    //----------------------------------------------
    // Tạo các bộ lắng nghe và xử lý sự kiện
    View.OnClickListener boLangNghe_XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Code xử lý nhân ở đây
            //1. Lấy số 1
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //b2. Chuyển thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            // b3. Tính toán
            double hieu = soA - soB;
            // b4. Xuất
            String strKQ = String.valueOf(hieu);
            tvKQ.setText(strKQ);

        }
    };
    //----------------------------------------------
    // Tạo các bộ lắng nghe và xử lý sự kiện
    View.OnClickListener boLangNghe_XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Code xử lý nhân ở đây
            //1. Lấy số 1
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //b2. Chuyển thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            // b3. Tính toán
            double tich = soA * soB;
            // b4. Xuất
            String strKQ = String.valueOf(tich);
            tvKQ.setText(strKQ);

        }
    };
    //----------------------------------------------
    public void TimView() {
        edtSoA =  findViewById(R.id.edtSo1);
        edtSoB =  findViewById(R.id.edtSo2);
        nutCong =  findViewById(R.id.btnCong);
        nutTru =  findViewById(R.id.btnTru);
        nutNhan =  findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
        tvKQ = findViewById(R.id.tvKetQua);
    }
    //khai báo các đối tượng tương ứng với các điều khiển (view) cần thao tác
    EditText edtSoA;
    EditText edtSoB;
    Button nutCong, nutTru, nutNhan, nutChia;
    TextView tvKQ;
}