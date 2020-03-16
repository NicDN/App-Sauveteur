package com.example.myapplication.Configuration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Evacuation.Evacuation;
import com.example.myapplication.R;
import com.example.myapplication.Rotations.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ConfigurationActivity extends AppCompatActivity {

    private FloatingActionButton buttonSelectionEmployee;
    private RecyclerView recyclerViewSelectionEmployee;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        buttonSelectionEmployee=findViewById(R.id.button_ajouterEmployee);


        initBarreNavigation();
        initListenerButton();
        recyclerView();
    }

    private void initListenerButton() {
        buttonSelectionEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void recyclerView() {
        ArrayList<ItemSelectionEmployee> selectionEmployeeArraList=new ArrayList<>();

        //C'est ici qu'on ajoute les employées à la journée
        selectionEmployeeArraList.add(new ItemSelectionEmployee(R.drawable.ic_employee,"Nicolas","10:00 à 18:30"));
        selectionEmployeeArraList.add(new ItemSelectionEmployee(R.drawable.ic_employee,"Andrew","10:00 à 20:15"));
        selectionEmployeeArraList.add(new ItemSelectionEmployee(R.drawable.ic_employee,"Pierre","10:00 à 18:30"));

        recyclerViewSelectionEmployee=findViewById(R.id.recyclerView_quartsTravail);
        layoutManager=new LinearLayoutManager(this);
        adapter=new SelectionEmployeeAdapter(selectionEmployeeArraList);

        recyclerViewSelectionEmployee.setLayoutManager(layoutManager);
        recyclerViewSelectionEmployee.setAdapter(adapter);
    }


    private void initBarreNavigation() {
        //initialisationd de la vue
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        //sélection des navigateurs
        bottomNavigationView.setSelectedItemId(R.id.configurations);

        //Itemselectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.configurations:
                        return true;
                    case R.id.rotations:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
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

    private void ouvrirSelectionDesPostesActivity(){
        Intent intent=new Intent(this, SelectionDesPostesActivity.class);
        startActivity(intent);
    }

    private void openDialog(){
        DialogAjouterEmployee dialog=new DialogAjouterEmployee(this);
        dialog.show(getSupportFragmentManager(),"dialog");
    }
}
