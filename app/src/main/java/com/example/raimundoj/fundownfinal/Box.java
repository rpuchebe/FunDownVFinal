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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Box extends Animaciones implements View.OnTouchListener,View.OnClickListener {

    private static final String msg = "LogsAndroid";
    ImageButton box;
    private ImageView items[] = new ImageView[34];
    private ImageView ganchos[] = new ImageView[24];
    private Integer[] orden = new Integer[34];
    int prevX, prevY, firtsX, firtsY;
    Random rand = new Random();
    int rep = 0;
    int hits = 0;
    Button boton;
    int shirt = 0;
    int shorts=0;
    int shoes=0;
    int bshirt = 0;
    int bshorts=0;
    int bshoes=0;
    String ini1;
    String ini2;
    ImageView bozshirt,bozshort,bozshoes,bozbasketshirt,bozbasketshort,bozbasketshoes,bozball1,bozball2,bozball3;
    TextView res;
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


        bozshirt=(ImageView)findViewById(R.id.bozshirt);
        bozshort=(ImageView)findViewById(R.id.bozshort);
        bozshoes=(ImageView)findViewById(R.id.bozshoes);
        bozbasketshirt=(ImageView)findViewById(R.id.bozbasketshirt);
        bozbasketshort=(ImageView)findViewById(R.id.bozbasketshort);
        bozbasketshoes=(ImageView)findViewById(R.id.bozbasketshoes);
        bozball1=(ImageView)findViewById(R.id.bozsballbasket);
        bozball2=(ImageView)findViewById(R.id.bozsball1);
        bozball3=(ImageView)findViewById(R.id.bozsballfutbol);
        res=(TextView)findViewById(R.id.res);
        boton=(Button)findViewById(R.id.button2);
        boton.setOnClickListener(this);
        box=(ImageButton)findViewById(R.id.box);
        box.setOnClickListener(this);
        again.setOnClickListener(this);
        back.setOnClickListener(this);
        again=(ImageView)findViewById(R.id.again);
        back=(ImageView)findViewById(R.id.back);
        popup=(ImageView)findViewById(R.id.popup);
        boton.setVisibility(View.INVISIBLE);
        again.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        popup.setVisibility(View.GONE);

        for(int i=0;i <=23; i++){

            int j =i+1;
            ini2 ="gancho" +j;

            try {
                int resourceId = R.id.class.getField(ini2).getInt(null);
                ganchos[i]=(ImageView)findViewById(resourceId);
                ganchos[i].setVisibility(View.INVISIBLE);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        }
        for(int i=0;i <=33; i++){

            int j =i+1;
            ini1 ="item" +j;
            try {
                int resourceId = R.id.class.getField(ini1).getInt(null);
                items[i]=(ImageView)findViewById(resourceId);
                items[i].setOnTouchListener(this);
                items[i].setVisibility(View.INVISIBLE);
                items[i].setEnabled(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

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
        Log.d(msg,"rep:" + (rep+0) );
        if(orden[0+rep]>19){par1.leftMargin=850;}
        else{par1.leftMargin=800;}

        par1.topMargin=1150;
        items[orden[0+rep]].setLayoutParams(par1);

        //Item2
        RelativeLayout.LayoutParams par2 = (RelativeLayout.LayoutParams) items[orden[1+rep]].getLayoutParams();
        items[orden[1+rep]].setVisibility(View.VISIBLE);
        items[orden[1+rep]].setEnabled(true);
        Log.d(msg,"rep:" + (rep+1) );
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
        Log.d(msg,"rep:" + rep );
        if(rep!=30){

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
            rep=rep+5;


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
            if (par.leftMargin < 70) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 580+(shirt/5);
                par.leftMargin = 150+shirt;
                int gancho = shirt/50;
                ganchos[gancho].setVisibility(View.VISIBLE);
                ganchos[gancho].bringToFront();
                v.setEnabled(false);
                v.bringToFront();
                shirt = shirt+50;
                bozshirt.setVisibility(View.INVISIBLE);

            }
        }
        if(tipo == "short"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 660) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1105) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 620+(shorts/5);
                par.leftMargin = 850+shorts;
                int gancho = (shorts/50)+6;
                ganchos[gancho].setVisibility(View.VISIBLE);
                ganchos[gancho].bringToFront();
                v.setEnabled(false);
                v.bringToFront();
                shorts = shorts+50;
                bozshort.setVisibility(View.INVISIBLE);
                }
        }

        if(tipo == "basketshirt"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1150) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1520) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 580+(bshirt/5);
                par.leftMargin = 1380+bshirt;
                int gancho = (bshirt/50)+12;
                ganchos[gancho].setVisibility(View.VISIBLE);
                ganchos[gancho].bringToFront();
                v.setEnabled(false);
                v.bringToFront();
                bshirt = bshirt+50;
                bozbasketshirt.setVisibility(View.INVISIBLE);
                }

        }
        if(tipo == "basketshort"){

            if (par.topMargin < 350) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 700) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1730) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 2170) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 613+(bshorts/5);
                par.leftMargin = 1950+bshorts;
                int gancho = (bshorts/50)+18;
                ganchos[gancho].setVisibility(View.VISIBLE);
                ganchos[gancho].bringToFront();
                v.setEnabled(false);
                v.bringToFront();
                bshorts = bshorts+50;
                bozbasketshort.setVisibility(View.INVISIBLE);
                }
        }
        if(tipo == "basketshoes"){

            if (par.topMargin < 100) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 500) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 200;
                par.leftMargin = 280+bshoes;
                v.setEnabled(false);
                v.bringToFront();
                bshoes = bshoes+50;
                bozbasketshoes.setVisibility(View.INVISIBLE);
                }
        }
        if(tipo == "shoes"){

            if (par.topMargin < 100) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 280) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 630) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 900) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 200;
                par.leftMargin = 790+shoes;
                v.setEnabled(false);
                v.bringToFront();
                shoes = shoes+50;
                bozshoes.setVisibility(View.INVISIBLE);

            }
        }

        if(tipo == "ball1"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1550) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 60;
                par.leftMargin = 1490;
                v.setEnabled(false);
                v.bringToFront();
                bozball1.setVisibility(View.INVISIBLE);
                }
        }
        if(tipo == "ball2"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1250) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 55;
                par.leftMargin = 1180;
                v.setEnabled(false);
                bozball2.setVisibility(View.INVISIBLE);
                }
        }
        if(tipo == "ball3"){

            if (par.topMargin < 0) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 160) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 1600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1850) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                hits++;
                Sonidos(R.raw.star);
                res.setText(""+hits);
                par.topMargin = 55;
                par.leftMargin = 1760;
                v.setEnabled(false);
                bozball3.setVisibility(View.INVISIBLE);
                }
        }

        if((hits%5)==0){

            box.setEnabled(true);
        }

        if(hits == 34){

            gameWon(34);
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

            case R.id.box:


                SetImagenes();
                box.setEnabled(false);


                break;

            case R.id.again:

                intent = new Intent(Box.this,Box.class);
                startActivity(intent);
                break;

            case R.id.back:

                intent = new Intent(Box.this, Deporte.class);
                startActivity(intent);

                break;

        }


    }
}
