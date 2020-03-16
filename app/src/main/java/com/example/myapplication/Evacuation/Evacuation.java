package com.example.myapplication.Evacuation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.Configuration.ConfigurationActivity;
import com.example.myapplication.R;
import com.example.myapplication.Rotations.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Evacuation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evacuation);

        initialisationBarreNavigation();

    }

    private void initialisationBarreNavigation() {
        //initialisationd de la vue
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //sélection des navigateurs
        bottomNavigationView.setSelectedItemId(R.id.evacuation);

        //Itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.configurations:
                        startActivity(new Intent(getApplicationContext(), ConfigurationActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.rotations:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.evacuation:
                        return true;
                }
                return false;

            }
        });
    }
}
