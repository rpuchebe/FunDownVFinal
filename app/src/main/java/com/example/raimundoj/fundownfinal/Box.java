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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Box extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener {

    private static final String msg = "LogsAndroid";
    ImageView item1;
    ImageView item2;
    ImageView item3;
    ImageView item4;
    ImageView item5;
    ImageView item6;
    ImageView item7;
    ImageView item8;
    ImageView item9;
    ImageView item10;
    ImageView item11;
    int prevX, prevY, firtsX, firtsY, temp1=0;
    //Variables Sonido
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;
    //Fin variables sonido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        item1=(ImageView)findViewById(R.id.item1);
        item2=(ImageView)findViewById(R.id.item2);
        item3=(ImageView)findViewById(R.id.item3);
        item4=(ImageView)findViewById(R.id.item4);
        item5=(ImageView)findViewById(R.id.item5);
        item6=(ImageView)findViewById(R.id.item6);
        item7=(ImageView)findViewById(R.id.item7);
        item8=(ImageView)findViewById(R.id.item8);
        item9=(ImageView)findViewById(R.id.item9);
        item10=(ImageView)findViewById(R.id.item10);
        item11=(ImageView)findViewById(R.id.item11);
        item1.setOnTouchListener(this);
        item2.setOnTouchListener(this);
        item3.setOnTouchListener(this);
        item4.setOnTouchListener(this);
        item5.setOnTouchListener(this);
        item6.setOnTouchListener(this);
        item7.setOnTouchListener(this);
        item8.setOnTouchListener(this);
        item9.setOnTouchListener(this);
        item10.setOnTouchListener(this);
        item11.setOnTouchListener(this);

        //<---------------------Sonido------------------------>
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();
        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        toggle = true;
        sonido.setImageBitmap(soundOn);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);
        bgm = MediaPlayer.create(this, R.raw.background2);
        bgm.start();
        bgm.setLooping(true);

        //<------------------- Fin Sonido ------------------------->

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams) v.getLayoutParams();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                par.topMargin += (int) event.getRawY() - prevY;
                prevY = (int) event.getRawY();
                par.leftMargin += (int) event.getRawX() - prevX;
                prevX = (int) event.getRawX();
                v.setLayoutParams(par);
                return true;
            }
            case MotionEvent.ACTION_UP: {
                par.topMargin += (int) event.getRawY() - prevY;
                par.leftMargin += (int) event.getRawX() - prevX;

                if(v == item1 ){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtmen");

                }
                if(v == item2 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shortmen");

                }
                if(v == item3 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesmen");

                }
                if(v == item4 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtw");

                }if(v == item5 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shortw");

                }if(v == item6 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesw");

                }if(v == item7 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirtm");

                }if(v == item8 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshortm");

                }if(v == item9 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirtw");

                }if(v == item10 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshortw");

                }if(v == item11 ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "ball");

                }

                v.setLayoutParams(par);
                return true;
            }
            case MotionEvent.ACTION_DOWN: {
                firtsX = par.topMargin;
                firtsY = par.leftMargin;
                prevX = (int) event.getRawX();
                prevY = (int) event.getRawY();
                par.bottomMargin = -2 * v.getHeight();
                par.rightMargin = -2 * v.getWidth();
                v.setLayoutParams(par);
                return true;
            }
        }


        return false;
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Box.this, Deporte.class);
        startActivity(intent);

        super.onBackPressed();
    }

    private RelativeLayout.LayoutParams Verificar(View v, int prevX, int prevY, int firtsX, int firtsY, int temp1, RelativeLayout.LayoutParams par, String tipo){



        Log.d(msg,"Item:"+ tipo + "____Top:" + par.topMargin + "____Left :"+ par.leftMargin);

        if(tipo == "shirtmen"){

            if (par.topMargin < 180) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 430) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 320;
                par.leftMargin = 150;

            }

        }
        if(tipo == "shortmen"){

            if (par.topMargin < 240) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 440) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 460) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 685) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 360;
                par.leftMargin = 640;}
        }
        if(tipo == "shoesmen"){

            if (par.topMargin < 190) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1710) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1850) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 320;
                par.leftMargin = 1820;}
        }
        if(tipo == "basketshirtm"){

            if (par.topMargin < 225) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 450) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 890) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1090) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 317;
                par.leftMargin = 1050;}

        }
        if(tipo == "basketshortm"){

            if (par.topMargin < 260) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 430) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 320;
                par.leftMargin = 1410;}
        }
        if(tipo == "shoesw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1680) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1880) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 1775;}
        }
        if(tipo == "shirtw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 150;}

        }
        if(tipo == "shortw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 460) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 685) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 640;}
        }

        if(tipo == "basketshirtw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 890) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1090) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 1050;}

        }
        if(tipo == "basketshortw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 690;
                par.leftMargin = 1445;}
        }

        if(tipo == "ball"){

            if (par.topMargin < 380) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 635) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 2020) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 2280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 500;
                par.leftMargin = 2160;}
        }
        return par;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

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


            case R.id.home:

                Intent intent = new Intent(Box.this, MainActivity.class);
                startActivity(intent);

                break;

        }


    }
}
