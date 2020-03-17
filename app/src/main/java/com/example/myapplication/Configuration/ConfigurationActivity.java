package com.example.myapplication.Configuration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
    public ArrayList<ItemSelectionEmployee> selectionEmployeeArraList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        //Enlever le titre à action bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        buttonSelectionEmployee=findViewById(R.id.button_ajouterEmployee);

        initRecyclerView();
        initBarreNavigation();
        initListenerButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_next,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.button_next){
            Intent intent=new Intent(this, SelectionDesPostesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initListenerButton() {
        buttonSelectionEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
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



    private void openDialog(){
        DialogAjouterEmployee dialog=new DialogAjouterEmployee(this);
        dialog.show(getSupportFragmentManager(),"dialog");
    }

    public void updateRecyclerView(String nom, String heuresTravail) {
        selectionEmployeeArraList.add(new ItemSelectionEmployee(R.drawable.ic_employee,nom,heuresTravail));
        adapter.notifyDataSetChanged();
    }

    public void initRecyclerView(){
        selectionEmployeeArraList=new ArrayList<>();
        recyclerViewSelectionEmployee=findViewById(R.id.recyclerView_quartsTravail);
        layoutManager=new LinearLayoutManager(this);
        adapter=new SelectionEmployeeAdapter(selectionEmployeeArraList);
        recyclerViewSelectionEmployee.setLayoutManager(layoutManager);
        recyclerViewSelectionEmployee.setAdapter(adapter);
    }
}
