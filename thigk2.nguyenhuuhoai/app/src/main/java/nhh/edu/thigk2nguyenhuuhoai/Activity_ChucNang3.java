package nhh.edu.thigk2nguyenhuuhoai;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Activity_ChucNang3 extends AppCompatActivity {

    ListView lvgK;
    ArrayList<String> dsGK;
    public void TimDieuKhien(){
        lvgK = findViewById(R.id.lvGK);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang3);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dsGK = new ArrayList<String>();
        dsGK.add("Tin Học Đại Cương");
        dsGK.add("Lập trình Java");
        dsGK.add("Phát triển Ứng dụng Web");
        dsGK.add("Khai phá dữ liệu lớn");
        dsGK.add("Kinh tế chính trị Mác-Lê nin");
        dsGK.add("...");

        ArrayAdapter<String> adapterGK = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, dsGK) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setGravity(Gravity.CENTER); // Căn giữa chữ
                return view;
            }
        };

        lvgK.setAdapter(adapterGK);

        lvgK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gtdc = dsGK.get(position);
                Toast.makeText(Activity_ChucNang3.this,gtdc,Toast.LENGTH_SHORT).show();
            }
        });
    }
}