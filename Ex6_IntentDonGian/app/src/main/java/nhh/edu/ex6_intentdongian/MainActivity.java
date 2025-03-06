package nhh.edu.ex6_intentdongian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button nutMH2;
    Button nutMH3;
    void TimDieuKhien(){
        nutMH2 = (Button) findViewById(R.id.btnMH2);
        nutMH3 = (Button) findViewById(R.id.btnMH3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tìm điều khiển nút bấm
        TimDieuKhien();
        // Gắn bộ lắng nghe sự kiện
        nutMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lý chuyển màn hình
                //B1. Tạo intent 2 tham số (MH hiện tại.this> MH2.class)
                Intent intentMH2 = new Intent(MainActivity.this, MH2Activity.class);
                //B2 gửi:
                startActivity(intentMH2);
            }
        });
        nutMH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lý chuyển màn hình
                //B1. Tạo intent 2 tham số (MH hiện tại.this> MH3.class)
                Intent intentMH3 = new Intent(MainActivity.this, MH3Activity.class);
                //B2 gửi:
                startActivity(intentMH3);
            }
        });
    }

}