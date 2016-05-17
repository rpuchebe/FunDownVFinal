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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class Maniqui extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{

    private static final String msg = "LogsAndroid";
    int hits = 0;
    Button boton;
    ImageView option1;
    ImageView option2;
    ImageView option3;
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
    ImageView item12;
    ImageView item13;
    ImageView item14;
    ImageView item15;
    ImageView item16;
    ImageView maniqui;
    int prevX, prevY, firtsX, firtsY, temp1=0;
    //Variables Sonido
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;
    //Fin variables sonido

    Random rand = new Random();
    int n = rand.nextInt(3);
    int shirts = rand.nextInt(3);
    int shorts = rand.nextInt(3);
    int optionshirt = rand.nextInt(6);
    int optionshort = rand.nextInt(5);
    int optionshoes = rand.nextInt(5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniqui);
        option1=(ImageView)findViewById(R.id.option1);
        option2=(ImageView)findViewById(R.id.option2);
        option3=(ImageView)findViewById(R.id.option3);
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
        item12=(ImageView)findViewById(R.id.item12);
        item13=(ImageView)findViewById(R.id.item13);
        item14=(ImageView)findViewById(R.id.item14);
        item15=(ImageView)findViewById(R.id.item15);
        item16=(ImageView)findViewById(R.id.item16);
        maniqui=(ImageView)findViewById(R.id.maniqui);
        boton=(Button)findViewById(R.id.button2);
        SetManiqui();
        boton.setOnClickListener(this);
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
        item12.setOnTouchListener(this);
        item13.setOnTouchListener(this);
        item14.setOnTouchListener(this);
        item15.setOnTouchListener(this);
        item16.setOnTouchListener(this);
        boton.setVisibility(View.INVISIBLE);

        //<---------------------Sonido------------------------>
        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        toggle = true;
        sonido.setImageBitmap(soundOn);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);
        bgm = MediaPlayer.create(this,R.raw.background2);
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


    final void SetManiqui(){

         if(n == 0){

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquimw));
            if(optionshirt == 0){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
            }
            if(optionshirt == 1){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
            }
            if(optionshirt == 2){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
            }
            if(optionshirt == 3){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
            }
            if(optionshirt == 4){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
            }
            if(optionshirt == 5){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
            }
            if(optionshort == 0){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
            }
            if(optionshort == 1){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
            }
            if(optionshort == 2){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
            }
            if(optionshort == 3){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
            }
            if(optionshort == 4){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
            }
            if(optionshoes == 0){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
            }
            if(optionshoes == 1){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
            }
            if(optionshoes == 2){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
            }
            if(optionshoes == 3){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
            }
            if(optionshoes == 4){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
            }
             item5.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
             item2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
             item6.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
             item16.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
             item15.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
                if(shirts == 0) {
                    item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                    item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                    item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                    item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
                    item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                    item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
                }
                if(shirts == 1) {
                    item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                    item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                    item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                    item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                    item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
                    item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
                }
                if(shirts == 2) {
                    item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                    item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                    item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                    item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                    item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
                    item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
                }
                if(shorts == 0) {
                    item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
                    item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                    item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                    item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                    item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));

                }
                if(shorts == 1) {
                    item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
                    item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                    item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                    item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                    item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
                }
                if(shorts == 2) {
                    item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                    item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
                    item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
                    item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                    item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                }

        }
        if(n == 1){

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiwb));
            if(optionshirt == 0){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(optionshirt == 1){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
            }
            if(optionshirt == 2){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(optionshirt == 3){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
            }
            if(optionshirt == 4){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
            }
            if(optionshirt == 5){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
            }
            if(optionshort == 0){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
            }
            if(optionshort == 1){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
            }
            if(optionshort == 2){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
            }
            if(optionshort == 3){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
            }
            if(optionshort == 4){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
            }
            if(optionshoes == 0){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
            }
            if(optionshoes == 1){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
            }
            if(optionshoes == 2){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
            }
            if(optionshoes == 3){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
            }
            if(optionshoes == 4){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
            }
            item5.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
            item2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
            item6.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
            item16.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
            item15.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
            if(shirts == 0) {
                item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(shirts == 1) {
                item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shirts == 2) {
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shorts == 0) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));

            }
            if(shorts == 1) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
            }
            if(shorts == 2) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
            }

        }
        if(n == 2){

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiww));

            if(optionshirt == 0){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(optionshirt == 1){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
            }
            if(optionshirt == 2){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(optionshirt == 3){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
            }
            if(optionshirt == 4){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
            }
            if(optionshirt == 5){

                option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
            }
            if(optionshort == 0){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
            }
            if(optionshort == 1){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw1));
            }
            if(optionshort == 2){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
            }
            if(optionshort == 3){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
            }
            if(optionshort == 4){

                option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
            }
            if(optionshoes == 0){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
            }
            if(optionshoes == 1){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
            }
            if(optionshoes == 2){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
            }
            if(optionshoes == 3){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
            }
            if(optionshoes == 4){

                option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
            }
            item5.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
            item2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
            item6.setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
            item16.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
            item15.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
            if(shirts == 0) {
                item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(shirts == 1) {
                item11.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item12.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item10.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shirts == 2) {
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                item1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                item4.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                item7.setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shorts == 0) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));

            }
            if(shorts == 1) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
            }
            if(shorts == 2) {
                item8.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw3));
                item3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shortw2));
                item14.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw3));
                item13.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw2));
                item9.setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortw1));
            }

        }
    }


    private RelativeLayout.LayoutParams Verificar(View v, int prevX, int prevY, int firtsX, int firtsY, int temp1, RelativeLayout.LayoutParams par, String tipo){


        String opt1 = option1.getBackground().getConstantState().toString();
        String opt2 = option2.getBackground().getConstantState().toString();
        String opt3 = option3.getBackground().getConstantState().toString();
        String temporal = v.getBackground().getConstantState().toString();
        Log.d(msg, "" + hits +"");

        if(tipo == "shirt"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0 ){
                if(temporal.equals(opt1)){

                    par.topMargin = 649;
                    par.leftMargin = 1068;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            }

        }
        if(tipo == "short"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt2)){

                    par.topMargin = 885;
                    par.leftMargin = 1162;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

                }
        }
        if(tipo == "shoes"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt3)){

                    par.topMargin = 1093;
                    par.leftMargin = 1140;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

            }



        }if(tipo == "shirtb"){

            if (par.topMargin < 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt1)){

                    par.topMargin = 649;
                    par.leftMargin = 1160;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}


            }

        }
        if(tipo == "shortb"){

            if (par.topMargin < 870) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 980) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt2)){

                    par.topMargin = 887;
                    par.leftMargin = 1138;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}


            }
        }
        if(tipo == "shoesb"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt3)){

                    par.topMargin = 1093;
                    par.leftMargin = 1140;
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}


            }
        }
        if(hits == 3){

            Toast.makeText(getApplicationContext(), "Felicitaciones Ganaste !",
                    Toast.LENGTH_LONG).show();
            boton.setVisibility(View.VISIBLE);
        }
        return par;
    }


    public void onBackPressed() {

        Intent intent = new Intent(Maniqui.this, Deporte.class);
        startActivity(intent);

        super.onBackPressed();
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
                Log.d(msg, "" + par.topMargin + "," + par.leftMargin + "");
                if(v == item1 || v==item4 || v==item7 || v == item10 || v==item12 || v==item11){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirt");
                }
                if(v == item10 || v==item12 || v==item11){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtb");
                }
                if(v == item2 || v==item5 || v==item6 ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoes");
                }
                if( v==item15 || v==item16 ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesb");
                }
                if(v == item3 || v==item8 ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "short");
                }
                if(v == item9 || v==item13 || v==item14) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shortb");
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

                Intent intent = new Intent(Maniqui.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.button2:

                intent = new Intent(Maniqui.this, Maniqui.class);
                startActivity(intent);

                break;

        }


    }
}

