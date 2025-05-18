package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;

public class ManDangBai extends AppCompatActivity {

    EditText edtTenTruyen, edtNoiDung, edtAnh;
    Button btnDangBai;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh = findViewById(R.id.dbimg);
        edtTenTruyen = findViewById(R.id.dbTenTruyen);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btnDangBai = findViewById(R.id.dbdangbai);

        db = FirebaseFirestore.getInstance();

        btnDangBai.setOnClickListener(v -> {
            String tentruyen = edtTenTruyen.getText().toString().trim();
            String noidung = edtNoiDung.getText().toString().trim();
            String img = edtAnh.getText().toString().trim();

            if (tentruyen.isEmpty() || noidung.isEmpty() || img.isEmpty()) {
                Toast.makeText(ManDangBai.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            String rawUid = getIntent().getStringExtra("uid");
            final String uid = (rawUid != null) ? rawUid : "unknown";

            Truyen truyen = new Truyen(tentruyen, noidung, img, uid);

            db.collection("Truyen")
                    .add(truyen)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(ManDangBai.this, "Đăng bài thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManDangBai.this, ManAdmin.class);
                        intent.putExtra("uid", uid);
                        finish();
                        startActivity(intent);
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(ManDangBai.this, "Đăng bài thất bại", Toast.LENGTH_SHORT).show();
                    });
        });
    }
}
