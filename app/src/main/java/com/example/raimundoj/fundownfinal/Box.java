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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Box extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener {

    private static final String msg = "LogsAndroid";
    ImageButton box;
    private ImageView items[] = new ImageView[35];
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
        items[0]=(ImageView)findViewById(R.id.item1);
        items[1]=(ImageView)findViewById(R.id.item2);
        items[2]=(ImageView)findViewById(R.id.item3);
        items[3]=(ImageView)findViewById(R.id.item4);
        items[4]=(ImageView)findViewById(R.id.item5);
        items[5]=(ImageView)findViewById(R.id.item6);
        items[6]=(ImageView)findViewById(R.id.item7);
        items[7]=(ImageView)findViewById(R.id.item8);
        items[8]=(ImageView)findViewById(R.id.item9);
        items[9]=(ImageView)findViewById(R.id.item10);
        items[10]=(ImageView)findViewById(R.id.item11);
        items[11]=(ImageView)findViewById(R.id.item12);
        items[12]=(ImageView)findViewById(R.id.item13);
        items[13]=(ImageView)findViewById(R.id.item14);
        items[14]=(ImageView)findViewById(R.id.item15);
        items[15]=(ImageView)findViewById(R.id.item16);
        items[16]=(ImageView)findViewById(R.id.item17);
        items[17]=(ImageView)findViewById(R.id.item18);
        items[18]=(ImageView)findViewById(R.id.item19);
        items[19]=(ImageView)findViewById(R.id.item20);
        items[20]=(ImageView)findViewById(R.id.item21);
        items[21]=(ImageView)findViewById(R.id.item22);
        items[22]=(ImageView)findViewById(R.id.item23);
        items[23]=(ImageView)findViewById(R.id.item24);
        items[24]=(ImageView)findViewById(R.id.item25);
        items[25]=(ImageView)findViewById(R.id.item26);
        items[26]=(ImageView)findViewById(R.id.item27);
        items[27]=(ImageView)findViewById(R.id.item28);
        items[28]=(ImageView)findViewById(R.id.item29);
        items[29]=(ImageView)findViewById(R.id.item30);
        items[30]=(ImageView)findViewById(R.id.item31);
        items[31]=(ImageView)findViewById(R.id.item32);
        items[32]=(ImageView)findViewById(R.id.item33);
        items[33]=(ImageView)findViewById(R.id.item34);
        items[34]=(ImageView)findViewById(R.id.item35);

        box=(ImageButton)findViewById(R.id.box);
        box.setOnClickListener(this);
        for(int i=0;i <=34; i++){

            items[i].setOnTouchListener(this);
            items[i].setVisibility(View.INVISIBLE);
            items[i].setEnabled(false);

        }
        SetImagenes();


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

    final void SetImagenes(){






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

                if(v == items[0]  || v == items[1] || v == items[2] ){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtmen");

                }
                if(v == items[3]  || v == items[4] || v == items[5] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shortmen");

                }
                if(v == items[6]  || v == items[7] || v == items[8] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesmen");

                }
                if(v == items[9]  || v == items[10] || v == items[11] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtw");

                }if(v == items[12]  || v == items[13] || v == items[14] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shortw");

                }if(v == items[15]  || v == items[16] || v == items[17] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesw");

                }if(v == items[18]  || v == items[19] || v == items[20] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirtm");

                }if(v == items[21]  || v == items[22] || v == items[23] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshortm");

                }if(v == items[24]  || v == items[25] || v == items[26] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirtw");

                }if(v == items[27]  || v == items[28] || v == items[29] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshortw");

                }if(v == items[30]  || v == items[31] || v == items[32] ) {

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
                par.leftMargin = 640;
                v.setEnabled(false);}
        }
        if(tipo == "shoesmen"){

            if (par.topMargin < 190) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1710) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1850) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 320;
                par.leftMargin = 1820;
                v.setEnabled(false);
            }
        }
        if(tipo == "basketshirtm"){

            if (par.topMargin < 225) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 450) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 890) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1090) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 317;
                par.leftMargin = 1050;
                v.setEnabled(false);}

        }
        if(tipo == "basketshortm"){

            if (par.topMargin < 260) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 430) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 320;
                par.leftMargin = 1410;
                v.setEnabled(false);}
        }
        if(tipo == "shoesw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1680) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1880) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 1775;
                v.setEnabled(false);}
        }
        if(tipo == "shirtw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 150;
                v.setEnabled(false);}

        }
        if(tipo == "shortw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 460) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 685) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 640;
                v.setEnabled(false);}
        }

        if(tipo == "basketshirtw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 890) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1090) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 715;
                par.leftMargin = 1050;
                v.setEnabled(false);}

        }
        if(tipo == "basketshortw"){

            if (par.topMargin < 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 690;
                par.leftMargin = 1445;
                v.setEnabled(false);}
        }

        if(tipo == "ball"){

            if (par.topMargin < 380) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 635) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 2020) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 2280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 500;
                par.leftMargin = 2160;
                v.setEnabled(false);}
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
