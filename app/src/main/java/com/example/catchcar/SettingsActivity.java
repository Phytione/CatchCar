package com.example.catchcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button bckButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        bckButton=findViewById(R.id.bckButton);
    }

    public void back(View view){
        Intent intent=new Intent(SettingsActivity.this,MainMenu.class);
        finish();
        startActivity(intent);
    }
}