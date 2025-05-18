package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;

public class ManDangKy extends AppCompatActivity {

    EditText edtDKTaiKhoan, edtDKMatKhau, edtDKEmail;
    Button btnDKDangNhap, btnDKDangKy;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky);

        AnhXa();

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDKDangKy.setOnClickListener(v -> {
            String tenTaiKhoan = edtDKTaiKhoan.getText().toString().trim();
            String matKhau = edtDKMatKhau.getText().toString().trim();
            String email = edtDKEmail.getText().toString().trim();

            if (TextUtils.isEmpty(tenTaiKhoan) || TextUtils.isEmpty(matKhau) || TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, matKhau)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Lấy UID của người dùng mới
                            String uid = mAuth.getCurrentUser().getUid();

                            // Tạo tài khoản mới để lưu vào Firestore
                            TaiKhoan taiKhoan = new TaiKhoan(tenTaiKhoan, "", email, 1); // mật khẩu không nên lưu, phân quyền mặc định = 1

                            // Ghi vào Firestore (collection TaiKhoan)
                            db.collection("TaiKhoan").document(uid)
                                    .set(taiKhoan)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                        // Chuyển về màn đăng nhập
                                        Intent intent = new Intent(ManDangKy.this, ManDangNhap.class);
                                        startActivity(intent);
                                        finish();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(this, "Lỗi lưu dữ liệu: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    });
                        } else {
                            Toast.makeText(this, "Đăng ký thất bại: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        btnDKDangNhap.setOnClickListener(v -> finish());
    }

    private void AnhXa() {
        edtDKMatKhau = findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan = findViewById(R.id.dktaikhoan);
        edtDKEmail = findViewById(R.id.dkemail);
        btnDKDangKy = findViewById(R.id.dkdangky);
        btnDKDangNhap = findViewById(R.id.dkdangnhap);
    }
}
