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
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Box extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener {


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
        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        toggle = true;
        sonido.setImageBitmap(soundOn);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);
        bgm = MediaPlayer.create(this,R.raw.background1);
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

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirtw");

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


        if(tipo == "shirtmen"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 649;
                par.leftMargin = 1068;}

        }
        if(tipo == "shortmen"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 885;
                par.leftMargin = 1163;}
        }
        if(tipo == "shoesmen"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 1093;
                par.leftMargin = 1140;}
        }
        if(tipo == "basketshirtmen"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 649;
                par.leftMargin = 1068;}

        }
        if(tipo == "basketshortmen"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 885;
                par.leftMargin = 1163;}
        }
        if(tipo == "basketshoesmen"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 1093;
                par.leftMargin = 1140;}
        }
        if(tipo == "shirtw"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 649;
                par.leftMargin = 1068;}

        }
        if(tipo == "shortw"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 885;
                par.leftMargin = 1163;}
        }
        if(tipo == "shoesw"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 1093;
                par.leftMargin = 1140;}
        }
        if(tipo == "basketshirtw"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 649;
                par.leftMargin = 1068;}

        }
        if(tipo == "basketshortw"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 885;
                par.leftMargin = 1163;}
        }
        if(tipo == "basketshoesw"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 1093;
                par.leftMargin = 1140;}
        }
        if(tipo == "ball"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 1093;
                par.leftMargin = 1140;}
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
