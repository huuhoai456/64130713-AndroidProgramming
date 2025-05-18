package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter.adapterTruyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter.adapterchuyenmuc;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter.adapterthongtin;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.chuyenmuc;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView, listViewNew, listViewThongTin;
    DrawerLayout drawerLayout;

    ArrayList<Truyen> TruyenArraylist;
    ArrayList<chuyenmuc> chuyenmucArrayList;
    ArrayList<TaiKhoan> taiKhoanArrayList;

    adapterTruyen adapterTruyen;
    adapterchuyenmuc adapterchuyenmuc;
    adapterthongtin adapterthongtin;

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference taiKhoanRef, truyenRef;

    private int phanQuyen = 1;
    private String uid;
    private String email;
    private String tentaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            Toast.makeText(this, "Không tìm thấy người dùng", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        uid = user.getUid();

        AnhXa();
        ActionBar();
        ActionViewFlipper();

        taiKhoanRef = firebaseDatabase.getReference("TaiKhoan").child(uid);
        truyenRef = firebaseDatabase.getReference("Truyen");

        // Lấy thông tin tài khoản từ Realtime Database
        taiKhoanRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    TaiKhoan taiKhoan = snapshot.getValue(TaiKhoan.class);
                    if (taiKhoan != null) {
                        tentaikhoan = taiKhoan.getTenTaiKhoan();
                        email = taiKhoan.getEmail();
                        phanQuyen = taiKhoan.getPhanQuyen();

                        taiKhoanArrayList.add(new TaiKhoan(tentaikhoan, email));
                        adapterthongtin.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Lỗi tải thông tin tài khoản", Toast.LENGTH_SHORT).show();
            }
        });

        // Lấy danh sách truyện từ Realtime Database
        truyenRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TruyenArraylist.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    Truyen truyen = data.getValue(Truyen.class);
                    if (truyen != null) {
                        TruyenArraylist.add(truyen);
                    }
                }
                adapterTruyen.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Lỗi tải truyện", Toast.LENGTH_SHORT).show();
            }
        });

        listViewNew.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ManNoiDung.class);
            Truyen truyen = TruyenArraylist.get(position);
            intent.putExtra("tentruyen", truyen.getTenTruyen());
            intent.putExtra("noidung", truyen.getNoiDung());
            startActivity(intent);
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                if (phanQuyen == 2) {
                    Intent intent = new Intent(MainActivity.this, ManAdmin.class);
                    intent.putExtra("uid", uid);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Bạn không có quyền đăng bài", Toast.LENGTH_SHORT).show();
                }
            } else if (position == 1) {
                startActivity(new Intent(MainActivity.this, ManThongTin.class));
            } else if (position == 2) {
                mAuth.signOut();
                finish();
            }
        });
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://toplist.vn/images/800px/rua-va-tho-230179.jpg");
        mangquangcao.add("https://toplist.vn/images/800px/deo-chuong-cho-meo-230180.jpg");
        mangquangcao.add("https://toplist.vn/images/800px/cu-cai-trang-230181.jpg");
        mangquangcao.add("https://toplist.vn/images/800px/de-den-va-de-trang-230182.jpg");

        for (String link : mangquangcao) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(link).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        Animation animationIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animationIn);
        viewFlipper.setOutAnimation(animationOut);
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper);
        listViewNew = findViewById(R.id.listviewNew);
        listView = findViewById(R.id.listviewmanhinhchinh);
        listViewThongTin = findViewById(R.id.listviewthongtin);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerlayout);

        TruyenArraylist = new ArrayList<>();
        adapterTruyen = new adapterTruyen(getApplicationContext(), TruyenArraylist);
        listViewNew.setAdapter(adapterTruyen);

        taiKhoanArrayList = new ArrayList<>();
        adapterthongtin = new adapterthongtin(this, R.layout.navigation_thongtin, taiKhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);

        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài", "https://png.pngtree.com/png-vector/20190806/ourlarge/pngtree-pencil-write-text-school-flat-color-icon-vector-icon-png-image_1651242.jpg"));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin", "https://png.pngtree.com/png-clipart/20190705/original/pngtree-info-vector-icon-png-image_4279574.jpg"));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất", "https://static.vecteezy.com/system/resources/previews/000/423/979/original/sign-in-icon-vector-illustration.jpg"));

        adapterchuyenmuc = new adapterchuyenmuc(this, R.layout.chuyenmuc, chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            startActivity(new Intent(MainActivity.this, ManTimKiem.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
