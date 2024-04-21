package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashscActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spalsh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref= getSharedPreferences("shared",MODE_PRIVATE);
                boolean check = pref.getBoolean("flag",false);

                Intent iNext;
                if (check){
                    iNext = new Intent(SplashscActivity.this, HomeActivity.class);
                }else {
                    iNext = new Intent(SplashscActivity.this, SetupActivity.class);
                }

                startActivity(iNext);
                finish();
            }
        },4000);
    }
}