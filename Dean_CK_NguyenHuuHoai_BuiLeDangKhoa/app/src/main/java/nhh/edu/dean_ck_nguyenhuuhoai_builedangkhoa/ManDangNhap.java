package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;

public class ManDangNhap extends AppCompatActivity {

    EditText edtTaiKhoan, edtMatKhau;
    Button btnDangNhap, btnDangKy;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_nhap);

        AnhXa();

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDangKy.setOnClickListener(v -> {
            Intent intent = new Intent(ManDangNhap.this, ManDangKy.class);
            startActivity(intent);
        });

        btnDangNhap.setOnClickListener(v -> {
            String email = edtTaiKhoan.getText().toString().trim();
            String matKhau = edtMatKhau.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(matKhau)) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, matKhau)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Lấy thông tin từ Firestore
                                db.collection("TaiKhoan").document(user.getUid())
                                        .get()
                                        .addOnSuccessListener(documentSnapshot -> {
                                            if (documentSnapshot.exists()) {
                                                TaiKhoan tk = documentSnapshot.toObject(TaiKhoan.class);
                                                Intent intent = new Intent(ManDangNhap.this, MainActivity.class);
                                                intent.putExtra("uid", user.getUid());
                                                intent.putExtra("tentaikhoan", tk.getTenTaiKhoan());
                                                intent.putExtra("email", tk.getEmail());
                                                intent.putExtra("phanq", tk.getPhanQuyen());
                                                startActivity(intent);
                                                finish(); // Đóng màn đăng nhập
                                            } else {
                                                Toast.makeText(this, "Không tìm thấy dữ liệu tài khoản!", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(e -> Toast.makeText(this, "Lỗi truy vấn dữ liệu", Toast.LENGTH_SHORT).show());
                            }
                        } else {
                            Toast.makeText(this, "Đăng nhập thất bại: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }

    private void AnhXa() {
        edtMatKhau = findViewById(R.id.matkhau);
        edtTaiKhoan = findViewById(R.id.taikhoan);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);
    }
}
