package nhh.edu.dean_ck;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import nhh.edu.dean_ck.adapter.adapterTruyen;
import nhh.edu.dean_ck.database.databasedoctruyen;
import nhh.edu.dean_ck.model.Truyen;

public class ManAdmin extends AppCompatActivity {

    ListView listView;
    Button buttonThem;

    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;

    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);

        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.buttonThemtruyen);
        
        initList();

        Button buttonQuayLai = findViewById(R.id.buttonQuayLai);
        buttonQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Trở về màn hình trước (MainActivity)
            }
        });

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lấy id tài khoản để biết tài khoản admin nào đã vào chỉnh sửa
                Intent intent1 = getIntent();
                int id = intent1.getIntExtra("Id",0);
                //Tiếp tục gửi id qua màn hình thêm truyện
                Intent intent = new Intent(ManAdmin.this, ManDangBai.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
        //click item long sẽ xóa item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                DialogDelete(position);

                return false;
            }
        });
    }
    //Phương thức Dialog hiển thị cửa sổ xóa
    private void DialogDelete(int position){
        //Tạo đối tượng dialog
        Dialog dialog = new Dialog(this);
        //Nạp layout vào dialog
        dialog.setContentView(R.layout.dialogdelete);
        //Tắt click ra ngoài là đóng, chỉ click no mới đúng
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idtruyen = TruyenArrayList.get(position).getID();
                //Xóa dữ liệu
                databasedoctruyen.Delete(idtruyen);
                //Cập nhật lại Activity
                Intent intent = new Intent(ManAdmin.this,ManAdmin.class);
                finish();
                startActivity(intent);
                Toast.makeText(ManAdmin.this,"Xóa truyện thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thực hiện đóng dialog
                dialog.cancel();
            }
        });
        //run dialog
        dialog.show();
    }
    //Gắn dữ liệu cho listview
    private void initList() {
        TruyenArrayList = new ArrayList<>();

        databasedoctruyen = new databasedoctruyen(this);

        Cursor cursor1 = databasedoctruyen.getData2();

        while (cursor1.moveToNext()){
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArrayList);

            listView.setAdapter(adapterTruyen);

        }
        cursor1.moveToFirst();
        cursor1.close();
    }
}