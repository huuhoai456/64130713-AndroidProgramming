package nhh.edu.bottomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    Fragment selectedFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tim Dieu Khien
        bottomNav = findViewById(R.id.bot_nav);
        // Lang nghe su kien
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int mnuItemDuocChonID = item.getItemId();
                if(mnuItemDuocChonID == R.id.nav_home)
                {
                    // Thay fragment Home
                    //Toast.makeText(MainActivity.this, "Thay HOME", Toast.LENGTH_LONG).show();
                    selectedFragment = new HomeFragment();
                }else
                if (mnuItemDuocChonID == R.id.nav_search)
                {
                    //Toast.makeText(MainActivity.this, "Thay SEARCH", Toast.LENGTH_LONG).show();
                    selectedFragment = new SearchFragment();
                }else
                if (mnuItemDuocChonID == R.id.nav_profile)
                {
                    //Toast.makeText(MainActivity.this, "Thay PROFILE", Toast.LENGTH_LONG).show();
                    selectedFragment = new ProfileFragment();
                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, selectedFragment)
                            .commit();
                    return true;
                }
                return false;
            }
        });

    }
}