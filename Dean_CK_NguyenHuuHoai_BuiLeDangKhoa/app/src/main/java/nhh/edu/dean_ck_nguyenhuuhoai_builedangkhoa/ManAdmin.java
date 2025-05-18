package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter.adapterTruyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;

public class ManAdmin extends AppCompatActivity {

    ListView listView;
    Button buttonThem;

    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;

    FirebaseFirestore db;
    CollectionReference truyenRef;

    String uid; // UID người đăng nhập

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);

        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.buttonThemtruyen);

        db = FirebaseFirestore.getInstance();
        truyenRef = db.collection("Truyen");

        uid = getIntent().getStringExtra("uid");

        TruyenArrayList = new ArrayList<>();
        adapterTruyen = new adapterTruyen(getApplicationContext(), TruyenArrayList);
        listView.setAdapter(adapterTruyen);

        loadTruyen();

        buttonThem.setOnClickListener(v -> {
            Intent intent = new Intent(ManAdmin.this, ManDangBai.class);
            intent.putExtra("uid", uid);
            startActivity(intent);
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            DialogDelete(position);
            return false;
        });
    }

    private void loadTruyen() {
        truyenRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                TruyenArrayList.clear();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Truyen truyen = document.toObject(Truyen.class);
                    truyen.setID(document.getId()); // gán ID Firestore làm ID truyện
                    TruyenArrayList.add(truyen);
                }
                adapterTruyen.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Không tải được truyện từ Firestore", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DialogDelete(int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(v -> {
            String docId = TruyenArrayList.get(position).getID(); // document ID từ Firestore

            truyenRef.document(docId).delete()
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(ManAdmin.this, "Xoá truyện thành công", Toast.LENGTH_SHORT).show();
                        loadTruyen(); // cập nhật danh sách
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(ManAdmin.this, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                    });

            dialog.dismiss();
        });

        btnNo.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}
