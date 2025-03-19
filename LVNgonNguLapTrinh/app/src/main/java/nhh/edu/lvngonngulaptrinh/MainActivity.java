package nhh.edu.lvngonngulaptrinh;

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
    ListView listViewNNLT;
    ArrayList<String> dsNNLT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listViewNNLT = findViewById(R.id.LVNNLT);
        //B1 : Chuan bi du lieu hard-core
        dsNNLT = new ArrayList<String>();
        dsNNLT.add("Python");
        dsNNLT.add("Java");
        dsNNLT.add("Php");
        //B2
        ArrayAdapter<String> adapterNNLT;
        adapterNNLT = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, dsNNLT
        );
        //B3 Gan Adapter
        listViewNNLT.setAdapter(adapterNNLT);
        
        //B4 Gan bo lang nghe va xu ly su kien
        listViewNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Code xu ly truc tiep o day
                //Chu y : Bien position chua vi tri cua item duoc click
                String giatriduocchon = dsNNLT.get(position);
                //Lam gi voi gia tri nay thi tuy
                //Don gian, ta toast len
                Toast.makeText(MainActivity.this,giatriduocchon,Toast.LENGTH_SHORT).show();
            }
        });
    }
}