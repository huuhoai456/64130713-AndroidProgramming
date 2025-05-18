package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.database.databasedoctruyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;

public class ManDangBai extends AppCompatActivity {

    EditText edtTenTruyen,edtNoiDung,edtAnh;
    Button btnDangBai;
    databasedoctruyen databasedoctruyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);

        edtAnh = findViewById(R.id.dbimg);
        edtTenTruyen = findViewById(R.id.dbTenTruyen);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btnDangBai = findViewById(R.id.dbdangbai);

        databasedoctruyen = new databasedoctruyen(this);
        //button đăng bài
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tentruyen = edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();
                
                Truyen truyen = CreateTruyen();
                
                if (tentruyen.equals("") || noidung.equals("") || img.equals("")){
                    Toast.makeText(ManDangBai.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("ERR :"," Nhập đầy đủ thông tin");
                }
                //Nếu nhập đầy đủ thông tin thì thực hiện thêm dữ liệu
                else {
                    databasedoctruyen.AddTruyen(truyen);
                    //Chuyển qua màn hình admin và cập nhật lại dữ liệu
                    Intent intent = new Intent(ManDangBai.this,ManAdmin.class);
                    finish();
                    startActivity(intent);
                }
            }
        });


    }
    private Truyen CreateTruyen(){

        String tentruyen = edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();

        Intent intent= getIntent();

        int id = intent.getIntExtra("Id",0);

        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return truyen;

    }
}