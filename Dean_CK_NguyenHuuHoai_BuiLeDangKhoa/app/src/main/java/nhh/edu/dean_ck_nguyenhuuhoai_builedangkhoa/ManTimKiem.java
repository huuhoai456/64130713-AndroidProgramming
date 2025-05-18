package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter.adapterTruyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;

public class ManTimKiem extends AppCompatActivity {

    ListView listView;
    EditText edt;
    ArrayList<Truyen> TruyenArrayList;
    ArrayList<Truyen> arrayList;
    adapterTruyen adapterTruyen;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem);

        listView = findViewById(R.id.listviewTimKiem);
        edt = findViewById(R.id.timkiem);

        TruyenArrayList = new ArrayList<>();
        arrayList = new ArrayList<>();
        adapterTruyen = new adapterTruyen(getApplicationContext(), TruyenArrayList);
        listView.setAdapter(adapterTruyen);

        db = FirebaseFirestore.getInstance();

        loadTruyen();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ManTimKiem.this, ManNoiDung.class);
            String tent = arrayList.get(position).getTenTruyen();
            String noidungt = arrayList.get(position).getNoiDung();
            intent.putExtra("tentruyen", tent);
            intent.putExtra("noidung", noidungt);
            startActivity(intent);
        });

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void loadTruyen() {
        db.collection("Truyen").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                TruyenArrayList.clear();
                arrayList.clear();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Truyen truyen = document.toObject(Truyen.class);
                    truyen.setID(document.getId()); // Nếu bạn dùng ID document làm String
                    TruyenArrayList.add(truyen);
                    arrayList.add(truyen);
                }
                adapterTruyen.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Không tải được truyện", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filter(String text) {
        arrayList.clear();

        ArrayList<Truyen> filteredList = new ArrayList<>();

        for (Truyen item : TruyenArrayList) {
            if (item.getTenTruyen().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
                arrayList.add(item);
            }
        }
        adapterTruyen.filterList(filteredList);
    }
}
