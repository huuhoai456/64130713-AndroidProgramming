package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.database.databasedoctruyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;

public class ManDangKy extends AppCompatActivity {
    EditText edtDKTaiKhoan,edtDKMatKhau,edtDKEmail;
    Button btnDKDangNhap,btnDKDangKy;

    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_dang_ky);
        databasedoctruyen = new databasedoctruyen(this);
        AnhXa();
        //Click cho button Đăng ký
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtDKTaiKhoan.getText().toString();
                String matkhau = edtDKMatKhau.getText().toString();
                String email = edtDKEmail.getText().toString();

                TaiKhoan taiKhoan1 = CreateTaikhoan();
                if (taikhoan.equals("") || matkhau.equals("") || email.equals("")) {
                    Log.e("Thông báo : ","Chưa nhập đầy đủ thông tin");
                }
                //Nếu đã nhập đầy đủ các thông tin thì add tài khoản vào database
                else {
                    databasedoctruyen.AddTaiKhoan(taiKhoan1);
                    Toast.makeText(ManDangKy.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
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