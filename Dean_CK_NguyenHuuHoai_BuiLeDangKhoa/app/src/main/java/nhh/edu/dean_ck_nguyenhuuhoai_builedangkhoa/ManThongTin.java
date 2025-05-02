package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManThongTin extends AppCompatActivity {

    TextView txtThongtinapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_tin);

        txtThongtinapp = findViewById(R.id.textviewthongtin);

        String thongtin = "Ứng dụng được thiết kế bới 'Hoài và Khoa'\n"+
                "Ứng dụng được tham khảo từ các nguồn link trên mạng\n"+
                "Cảm ơn mọi người đã sử dụng app";

        txtThongtinapp.setText(thongtin);
    }
}