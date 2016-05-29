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

public class Box extends Animaciones implements View.OnTouchListener,View.OnClickListener {

    private static final String msg = "LogsAndroid";
    ImageButton box;
    private ImageView items[] = new ImageView[34];
    private Integer[] orden = new Integer[34];
    int prevX, prevY, firtsX, firtsY;
    Random rand = new Random();
    int rep = 0;
    int hits = 0;
    Button boton;

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
        boton=(Button)findViewById(R.id.button2);
        boton.setOnClickListener(this);
        box=(ImageButton)findViewById(R.id.box);
        box.setOnClickListener(this);
        boton.setVisibility(View.INVISIBLE);
        for(int i=0;i <=33; i++){

            items[i].setOnTouchListener(this);
            items[i].setVisibility(View.INVISIBLE);
            items[i].setEnabled(false);

        }
        for(int i=0;i <=33; i++){

            int random = rand.nextInt(34);
            if(orden[random]==null){
                orden[random]=i;
            }else{i--;}

        }

        //<---------------------Sonido------------------------>

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

        //Item1
        RelativeLayout.LayoutParams par1 = (RelativeLayout.LayoutParams) items[orden[0+rep]].getLayoutParams();
        items[orden[0+rep]].setVisibility(View.VISIBLE);
        items[orden[0+rep]].setEnabled(true);

        if(orden[0+rep]>19){par1.leftMargin=850;}
        else{par1.leftMargin=800;}

        par1.topMargin=1150;
        items[orden[0+rep]].setLayoutParams(par1);

        //Item2
        RelativeLayout.LayoutParams par2 = (RelativeLayout.LayoutParams) items[orden[1+rep]].getLayoutParams();
        items[orden[1+rep]].setVisibility(View.VISIBLE);
        items[orden[1+rep]].setEnabled(true);
        if(orden[1+rep]>19){

            par2.leftMargin=1200;

        }else{

            par2.leftMargin=1150;

        }

        par2.topMargin=1150;
        items[orden[1+rep]].setLayoutParams(par2);

        RelativeLayout.LayoutParams par3 = (RelativeLayout.LayoutParams) items[orden[2+rep]].getLayoutParams();
        items[orden[2+rep]].setVisibility(View.VISIBLE);
        items[orden[2+rep]].setEnabled(true);
        if(orden[2+rep]>19){

            par3.leftMargin=1550;

        }else{

            par3.leftMargin=1500;

        }

        par3.topMargin=1150;
        items[orden[2+rep]].setLayoutParams(par3);

        RelativeLayout.LayoutParams par4 = (RelativeLayout.LayoutParams) items[orden[3+rep]].getLayoutParams();
        items[orden[3+rep]].setVisibility(View.VISIBLE);
        items[orden[3+rep]].setEnabled(true);
        if(orden[3+rep]>19){

            par4.leftMargin=1850;

        }else{

            par4.leftMargin=1800;

        }

        par4.topMargin=1150;
        items[orden[3+rep]].setLayoutParams(par4);
        if(rep!=5){

            RelativeLayout.LayoutParams par5 = (RelativeLayout.LayoutParams) items[orden[4+rep]].getLayoutParams();
            items[orden[4 + rep]].setVisibility(View.VISIBLE);
            items[orden[4+rep]].setEnabled(true);
            if(orden[4+rep]>19){

                par5.leftMargin=2250;

            }else{

                par5.leftMargin=2200;

            }


            par5.topMargin=1150;

            items[orden[4+rep]].setLayoutParams(par5);

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

                if(v == items[0]  || v == items[1] || v == items[2] || v == items[9]  || v == items[10] || v == items[11] ){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirt");

                }
                if(v == items[3]  || v == items[4] || v == items[5] || v == items[12]  || v == items[13] || v == items[14]) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "short");

                }
                if(v == items[6]  || v == items[7] || v == items[8] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoes");

                }
                if(v == items[15]  || v == items[16] || v == items[17] || v == items[18]  ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshoes");

                }if(v == items[19]  || v == items[20] || v == items[21] || v == items[25]  || v == items[26] || v == items[27] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshirt");

                }if(v == items[22]  || v == items[23] || v == items[24] || v == items[28]  || v == items[29] || v == items[30] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "basketshort");

                }if(v == items[31] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "ball1");

                }if( v == items[32] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "ball2");

                }if(v == items[33] ) {

                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "ball3");

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

        if(tipo == "shirt"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 75) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 480) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 580;
                par.leftMargin = 150;
                v.setEnabled(false);
                hits++;

            }
        }
        if(tipo == "short"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 660) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 985) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 580;
                par.leftMargin = 800;
                v.setEnabled(false);
                hits++;}
        }

        if(tipo == "basketshirt"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1220) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1520) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 580;
                par.leftMargin = 1300;
                v.setEnabled(false);
                hits++;}

        }
        if(tipo == "basketshort"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1730) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 2070) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 580;
                par.leftMargin = 1810;
                v.setEnabled(false);
                hits++;}
        }
        if(tipo == "basketshoes"){

            if (par.topMargin < 100) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 520) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 120;
                par.leftMargin = 300;
                v.setEnabled(false);
                hits++;}
        }
        if(tipo == "shoes"){

            if (par.topMargin < 100) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 950) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 120;
                par.leftMargin = 820;
                v.setEnabled(false);
                hits++;
            }
        }

        if(tipo == "ball1"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1450) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 60;
                par.leftMargin = 1460;
                v.setEnabled(false);
                hits++;}
        }
        if(tipo == "ball2"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1050) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 55;
                par.leftMargin = 1160;
                v.setEnabled(false);
                hits++;}
        }
        if(tipo == "ball3"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1850) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                par.topMargin = 55;
                par.leftMargin = 1760;
                v.setEnabled(false);
                hits++;}
        }

        if(hits == 34){

            Toast.makeText(getApplicationContext(), "Felicitaciones Ganaste !",
                    Toast.LENGTH_LONG).show();
            boton.setVisibility(View.VISIBLE);
        }
        return par;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.home:

                Intent intent = new Intent(Box.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.box:

                rep=rep+5;
                SetImagenes();


                break;

            case R.id.button2:

                intent = new Intent(Box.this,Box.class);
                startActivity(intent);

                break;

        }


    }
}
