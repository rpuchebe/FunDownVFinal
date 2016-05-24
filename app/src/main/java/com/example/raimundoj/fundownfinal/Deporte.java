package com.example.raimundoj.fundownfinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class Deporte extends AppCompatActivity implements View.OnClickListener{


    ImageButton box;
    ImageButton maniqui;
    ImageView camisa;
    ImageView pantalon;
    ImageView zapato;
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;
    Random rand = new Random();
    int n = rand.nextInt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte);


        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        box=(ImageButton)findViewById(R.id.box);
        maniqui=(ImageButton)findViewById(R.id.maniqui);

        box.setOnClickListener(this);
        maniqui.setOnClickListener(this);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);

        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        toggle = true;
        sonido.setImageBitmap(soundOn);

        bgm = MediaPlayer.create(this,R.raw.background);
        bgm.start();
        bgm.setLooping(true);
        startBackground();
        startAnimation();
        starManiqui();
        if(n == 0) {

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquimw));
        }


    }

    public void onBackPressed() {

        Intent intent = new Intent(Deporte.this, MainActivity.class);
        startActivity(intent);

        super.onBackPressed();
    }

    protected void  onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
        bgm.release();
    }

    private void startBackground(){

        ImageView fondo = (ImageView)findViewById(R.id.fondo);
        Glide.with(this).load(R.drawable.fondo6).into(fondo);
    }

    private void startAnimation(){


        // Animacion 1

        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(100)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(2000)
                .playOn(findViewById(R.id.maniqui));



        // Animacion 2

        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(6000)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(8000)
                .playOn(findViewById(R.id.maniqui));


        // Animacion 3


        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(12000)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(14000);



    }

    private void starManiqui(){

        if(n == 0) {

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquimw));

        }
        if(n == 1) {

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiwb));

        }
        if(n == 2) {

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiww));

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.box:

                Intent intent = new Intent(Deporte.this, Box.class);
                intent.putExtra("Son", toggle);

                startActivity(intent);

                break;
            case R.id.sonido:

                if(toggle){
                    bgm.pause();
                    toggle = false;
                    sonido.setImageBitmap(soundOff);
                }else{
                    bgm.start();
                    toggle = true;
                    sonido.setImageBitmap(soundOn);
                }

                break;
            case R.id.maniqui:

                intent = new Intent(Deporte.this, Maniqui.class);
                intent.putExtra("variable", n);

                startActivity(intent);

                break;

            case R.id.home:

                intent = new Intent(Deporte.this, MainActivity.class);
                startActivity(intent);

                break;

        }

    }
}
