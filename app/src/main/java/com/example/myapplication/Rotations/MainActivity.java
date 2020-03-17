package com.example.myapplication.Rotations;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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
        initViewPagerRotations();
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

    private void initViewPagerRotations(){
        ViewPager viewPagerRotations=(ViewPager)findViewById(R.id.viewPage_rotations);
        viewPagerRotations.setOffscreenPageLimit(1);
        SwipeRotationsAdapter swipeRotationsAdapter=new SwipeRotationsAdapter(getSupportFragmentManager());
        viewPagerRotations.setAdapter(swipeRotationsAdapter);
        viewPagerRotations.setCurrentItem(0);
    }
}
