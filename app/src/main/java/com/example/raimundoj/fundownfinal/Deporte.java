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

public class Deporte extends AppCompatActivity implements View.OnClickListener{


    ImageButton box;
    ImageButton maniqui;
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte);
        startBackground();
        box=(ImageButton)findViewById(R.id.box);
        box.setOnClickListener(this);
        maniqui=(ImageButton)findViewById(R.id.maniqui);
        maniqui.setOnClickListener(this);
        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        toggle = true;
        sonido.setImageBitmap(soundOn);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);
        bgm = MediaPlayer.create(this,R.raw.background);
        bgm.start();
        bgm.setLooping(true);
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(10000)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(12000)
                .playOn(findViewById(R.id.maniqui));

    }

    public void onBackPressed() {

        Intent intent = new Intent(Deporte.this, MainActivity.class);
        startActivity(intent);

        super.onBackPressed();
    }


    public void toggleSound(View view){
        if(toggle){
            bgm.pause();
            toggle = false;
            sonido.setImageBitmap(soundOff);
        }else{
            bgm.start();
            toggle = true;
            sonido.setImageBitmap(soundOn);
        }
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.box:

                Intent intent = new Intent(Deporte.this, Box.class);
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
                startActivity(intent);

                break;

            case R.id.home:

                intent = new Intent(Deporte.this, MainActivity.class);
                startActivity(intent);

                break;

        }

    }
}
