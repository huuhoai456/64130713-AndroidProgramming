package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.database.databasedoctruyen;

public class ManDangNhap extends AppCompatActivity {
    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap,btnDangKy;
    //Tạo đối tượng cho databasedoctruyen
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_nhap);

        AnhXa();
        //Đối tượng database đọc truyện
        databasedoctruyen = new databasedoctruyen(this);
        //Tạo sự kiện click button chuyển sang màn hình đăng ký với Intent
        btnDangKy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(ManDangNhap.this,ManDangKy.class);
                 startActivity(intent);
             }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gắn cho các biến là giá trị nhập vào từ editText
                String tentaikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();

                //Sử dụng con trỏ để lấy dữ liệu, gọi tới getData để lấy tất cả tài khoản ở trong database
                Cursor cursor = databasedoctruyen.getData();

                //Thực hiện vòng lặp để lấy dữ liệu từ cursor với moveToNext() di chuyển tiếp
                while (cursor.moveToNext()) {
                    //Lấy dữ liệu và gắn vào biến, dữ liệu tải khoản ở ô 1 và mật khẩu ở ô 2, ô 0 là idtaikhoan, ô 3 là email và 4 là phân quyền
                    String datatentaikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);

                    //Nếu tài khoản và mật khẩu người dùng nhập vào khớp với dữ liệu trong database
                    if (datatentaikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)) {
                        //Lấy dữ liệu phân quyền và id
                        int phanquyen = cursor.getInt(cursor.getInt(4));
                        int idd = cursor.getInt(cursor.getInt(0));
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);
                        //Chuyển sang màn hình MainActivity
                        Intent intent = new Intent(ManDangNhap.this, MainActivity.class);
                        //Gửi dữ liệu qua Activity tức MainActivity
                        intent.putExtra("phanq", phanquyen);
                        intent.putExtra("idd", idd);
                        intent.putExtra("email", email);
                        intent.putExtra("tentaikhoan", tentk);
                        startActivity(intent);
                    }
                }
                //Thực hiện trả curson về đầu
                cursor.moveToFirst();
                //đóng khi không dùng
                cursor.close();
            }
        });
    }

    private void AnhXa() {
        edtMatKhau = findViewById(R.id.matkhau);
        edtTaiKhoan = findViewById(R.id.taikhoan);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);
    }
}