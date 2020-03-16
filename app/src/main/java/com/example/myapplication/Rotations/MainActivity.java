package com.example.myapplication.Rotations;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Configuration.ConfigurationActivity;
import com.example.myapplication.Evacuation.Evacuation;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisationBarreNavigation();

    }

    private void initialisationBarreNavigation() {
        //initialisationd de la vue
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //sélection des navigateurs
        bottomNavigationView.setSelectedItemId(R.id.rotations);

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
                        return true;
                    case R.id.evacuation:
                        startActivity(new Intent(getApplicationContext(), Evacuation.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;

            }
        });
    }
}
