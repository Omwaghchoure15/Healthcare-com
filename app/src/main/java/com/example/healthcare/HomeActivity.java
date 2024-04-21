package com.example.healthcare;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView1 = findViewById(R.id.navigationview);
        FrameLayout frameLayout = findViewById(R.id.framelayout);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id= menuItem.getItemId();

                if (id == R.id.mu_home){
                    loadFragment(new homeFragment(),false);
                }
                else if (id == R.id.mu_search) {
                    loadFragment(new profileFragment(),false);
                }
                else if (id == R.id.mu_appoint) {
                    loadFragment(new appoinmentFragment(),false);
                }
                else  {//profile
                    loadFragment(new profileFragment(),false);
                }
                return true;
            }
        });

        loadFragment(new homeFragment(),true);
    }

    public void loadFragment(Fragment fragment, boolean isAppInitialized){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.framelayout,fragment);
        }
        else {
            fragmentTransaction.replace(R.id.framelayout,fragment);
        }
        fragmentTransaction.commit();
    }
}