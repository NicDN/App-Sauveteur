package com.example.myapplication.Configuration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.Rotations.MainActivity;

public class SelectionDesPostesActivity extends AppCompatActivity {
private Button buttonToRotations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_des_postes);

        initListenerButton();
    }

    private void initListenerButton() {
        buttonToRotations =(Button)findViewById(R.id.toRotations_id);
        buttonToRotations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retourMainActivity();
            }
        });
    }

    private void retourMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
