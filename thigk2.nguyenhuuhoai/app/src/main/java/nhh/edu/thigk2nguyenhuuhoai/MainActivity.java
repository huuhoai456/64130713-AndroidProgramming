package nhh.edu.thigk2nguyenhuuhoai;

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

    Button nutCau1;
    Button nutCau2;
    Button nutCau3;
    Button nutCau4;

    void TimDieuKhien(){
        nutCau1 = (Button) findViewById(R.id.btnCau1);
        nutCau2 = (Button) findViewById(R.id.btnCau2);
        nutCau3 = (Button) findViewById(R.id.btnCau3);
        nutCau4 = (Button) findViewById(R.id.btnCau4);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nutCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMH2 = new Intent(MainActivity.this, Activity_ChucNang2.class);
                startActivity(intentMH2);
            }
        });
    }
}