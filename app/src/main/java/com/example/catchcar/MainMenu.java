package com.example.catchcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    Button playButton;
    Button setButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        playButton=findViewById(R.id.playButton);
        setButton=findViewById(R.id.setButton);
        quitButton=findViewById(R.id.quitButton);
    }


    public void start (View view){
        Intent intent=new Intent(MainMenu.this,MainActivity.class);
        finish();
        startActivity(intent);

    }
    public void setting(View view){
        Toast.makeText(MainMenu.this,"Daha kodlanmadı girmeyiniz :))",Toast.LENGTH_SHORT).show();
        //Intent intent=new Intent(MainMenu.this,SettingsActivity.class);
        //finish();
        //startActivity(intent);

    }

    public void quit(View view){
        Toast.makeText(MainMenu.this,"Press again to exit",Toast.LENGTH_LONG).show();
        onDestroy();

    }

}