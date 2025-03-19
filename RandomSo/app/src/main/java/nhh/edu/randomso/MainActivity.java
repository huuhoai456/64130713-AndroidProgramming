package nhh.edu.randomso;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtsoA;
    EditText edtsoB;
    EditText editTextKQ;
    Button nutKT;
    int kqDung;
    public void TimDieuKhien(){
        edtsoA = findViewById(R.id.SoA);
        edtsoB = findViewById(R.id.SoB);
        editTextKQ = findViewById(R.id.KQ);
        nutKT = findViewById(R.id.check);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        SinhSoNgauNhien();
        nutKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KTKetQua();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Sinh số ngẫu nhiên
    void SinhSoNgauNhien(){
        int a = (int) (Math.random()*5);
        int b = (int) (Math.random()*5);
        kqDung = a + b;
        edtsoA.setText(String.valueOf(a));
        edtsoB.setText(String.valueOf(b));
    }
    void KTKetQua(){
        String kqNhap = editTextKQ.getText().toString();
        int chuoiKQ = Integer.parseInt(kqNhap);
        if (chuoiKQ == kqDung){
            Toast.makeText(MainActivity.this,"Đúng KQ", LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"KQ Sai, Ket qua dung la" + kqDung,LENGTH_SHORT).show();
        }
    }
}