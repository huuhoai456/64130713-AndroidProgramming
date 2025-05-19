package nhh.edu.dean_ck;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import nhh.edu.dean_ck.database.databasedoctruyen;
import nhh.edu.dean_ck.model.TaiKhoan;

public class ManDangKy extends AppCompatActivity {
    EditText edtDKTaiKhoan,edtDKMatKhau,edtDKEmail;
    Button btnDKDangNhap,btnDKDangKy;

    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky);
        databasedoctruyen = new databasedoctruyen(this);
        AnhXa();
        //Click cho button Đăng ký
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtDKTaiKhoan.getText().toString().trim();
                String matkhau = edtDKMatKhau.getText().toString().trim();
                String email = edtDKEmail.getText().toString().trim();

                if (taikhoan.isEmpty() || matkhau.isEmpty() || email.isEmpty()) {
                    Toast.makeText(ManDangKy.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    TaiKhoan taiKhoan1 = CreateTaikhoan();
                    databasedoctruyen.AddTaiKhoan(taiKhoan1);
                    Toast.makeText(ManDangKy.this, "Đăng ký thành công! Đang chuyển về màn hình đăng nhập...", Toast.LENGTH_LONG).show();

                    // Trở lại màn hình đăng nhập sau 2 giây
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    finish(); // kết thúc activity hiện tại -> trở về màn hình đăng nhập
                                }
                            },
                            2000); // 2000 milliseconds = 2 seconds
                }
            }
        });

        //Trở về Đăng nhập
        btnDKDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //Phương thức tạo tài khoản
    private TaiKhoan CreateTaikhoan() {
        String taikhoan = edtDKTaiKhoan.getText().toString();
        String matkhau = edtDKMatKhau.getText().toString();
        String email = edtDKEmail.getText().toString();
        int phanquyen = 1;

        TaiKhoan tk = new TaiKhoan(taikhoan, matkhau, email, phanquyen);
        return tk;
    }
    private void AnhXa() {
        edtDKMatKhau = findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan = findViewById(R.id.dktaikhoan);
        edtDKEmail = findViewById(R.id.dkemail);
        btnDKDangKy = findViewById(R.id.dkdangky);
        btnDKDangNhap = findViewById(R.id.dkdangnhap);
    }
}