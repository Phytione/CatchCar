package com.example.catchcar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    Button restartButton;
    Button extraTime;
    Button backButton;
    TextView highScore;
    int score;
    int hScore;
    SharedPreferences sharedPreferences;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[]imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText=findViewById(R.id.timeText);
        scoreText=findViewById(R.id.scoreText);
        restartButton=findViewById(R.id.restartButton);
        backButton=findViewById(R.id.backButton);
        extraTime=findViewById(R.id.extraTime);
        highScore=findViewById(R.id.highScore);
        sharedPreferences=this.getSharedPreferences("com.example.catchcar",Context.MODE_PRIVATE);
        int userScore1=sharedPreferences.getInt("userScore",0);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        imageArray=new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        restartButton.setVisibility(View.INVISIBLE);
        extraTime.setVisibility(View.INVISIBLE);
        highScore.setText("Your High Score:"+userScore1);




        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
               timeText.setText("Time:"+l/1000);
            }

            @Override
                public void onFinish() {
                timeText.setTextColor(Color.RED);
                timeText.setText("Time off!!!");
                restartButton.setVisibility(View.VISIBLE);
                //extraTime.setVisibility(View.VISIBLE);
                handler.removeCallbacks(runnable);
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                if(score>userScore1)
                {
                    highScore.setText("Your High Score:"+score);
                    sharedPreferences.edit().putInt("userScore",score).apply();

                }

            }
        }.start();
        HideImages();




    }



    public void skorArttir(View view){
       score++;
       scoreText.setText("Score:"+score);
        imageArray[0].setVisibility(View.INVISIBLE);
        imageArray[1].setVisibility(View.INVISIBLE);
        imageArray[2].setVisibility(View.INVISIBLE);
        imageArray[3].setVisibility(View.INVISIBLE);
        imageArray[4].setVisibility(View.INVISIBLE);
        imageArray[5].setVisibility(View.INVISIBLE);
        imageArray[6].setVisibility(View.INVISIBLE);
        imageArray[7].setVisibility(View.INVISIBLE);
        imageArray[8].setVisibility(View.INVISIBLE);



    }

    public void HideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random= new Random();
                int i=random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
    public void restartButton(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Restart?");
        alert.setMessage("Are you sure to restart game?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {



                Intent intent=getIntent();
                finish();
                startActivity(intent);

            }


        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Game Over!",Toast.LENGTH_SHORT).show();
            }
        });
            alert.show();




    }

    /*public void extraTime(View view){

        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Hi");
        alert.setMessage("Do you want to get extra time?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restartButton.setVisibility(View.INVISIBLE);
                extraTime.setVisibility(View.INVISIBLE);
                handler.post(runnable);
                new CountDownTimer(10000,1000){
                    @Override
                    public void onTick(long l){
                        timeText.setText("Time:"+l/1000);
                    }
                    @Override
                    public void onFinish(){

                        timeText.setText("Time off");
                        restartButton.setVisibility(View.VISIBLE);
                        handler.removeCallbacks(runnable);
                        for (ImageView image:imageArray){
                            image.setVisibility(View.INVISIBLE);
                        }
                        int userScore1;
                        if (score>userScore1){
                            highScore.setText("Your High Score:"+score);
                            sharedPreferences.edit().putInt("userScore",score).apply();
                        }


                    }
                }.start();




            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Game Over!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();



    }*/
    public void back(View view){
        Intent intent=new Intent(MainActivity.this,MainMenu.class);
        finish();
        startActivity(intent);
    }





}