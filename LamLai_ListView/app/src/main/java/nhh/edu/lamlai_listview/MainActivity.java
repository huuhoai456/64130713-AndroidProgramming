package nhh.edu.lamlai_listview;

import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {
    ListView lvontap;
    ArrayList<String> dsOnTap;
    public void TimDieuKhien(){
        lvontap = findViewById(R.id.LVOnTap);
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
        //B1
        dsOnTap = new ArrayList<String>();
        dsOnTap.add("LTTBDD");
        dsOnTap.add("Linux");
        dsOnTap.add("TRR");
        //B2
        ArrayAdapter<String> adpterOnTap;
        adpterOnTap = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,dsOnTap
        );
        //B3
        lvontap.setAdapter(adpterOnTap);
        //B4
        lvontap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giatrduocchon = dsOnTap.get(position);
                Toast.makeText(MainActivity.this,giatrduocchon,Toast.LENGTH_SHORT).show();
            }
        });
    }
}