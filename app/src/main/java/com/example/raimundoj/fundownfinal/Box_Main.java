package com.example.raimundoj.fundownfinal;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Box_Main extends Animaciones implements View.OnTouchListener,View.OnClickListener {

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
    ImageView ejemplo1;
    ImageView ejemplo2;
    ImageView ejemplo3;
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
        popup=(ImageView)findViewById(R.id.popup);
        res=(TextView)findViewById(R.id.res);
        box=(ImageButton)findViewById(R.id.box);
        again=(ImageView)findViewById(R.id.again);
        back=(ImageView)findViewById(R.id.back);
        ejemplo1=(ImageView)findViewById(R.id.ejemplo1);
        ejemplo2=(ImageView)findViewById(R.id.ejemplo2);
        ejemplo3=(ImageView)findViewById(R.id.ejemplo3);
        again.setOnClickListener(this);
        back.setOnClickListener(this);
        box.setOnClickListener(this);
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

        BoxAnimation(ejemplo1,200);
        BoxAnimation(ejemplo2,1200);
        BoxAnimation(ejemplo3,2200);
    }

    public void BoxAnimation(View item,int delay) {
        int deltaX = item.getLeft();
        int deltaY = item.getTop();
        ObjectAnimator translateX = ObjectAnimator.ofFloat(item, "translationX", deltaX,-1100);
        ObjectAnimator translateY = ObjectAnimator.ofFloat(item, "translationY", deltaY,-1100);
        translateX.setDuration(1500);
        translateY.setDuration(1500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateX, translateY);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.setStartDelay(delay);
        animatorSet.setDuration(600);
        item.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();

    }

    final void SetImagenes(){

        for(int k = 0;k<5;k++){

            if((rep+k)!=34) {
                RelativeLayout.LayoutParams par1 = (RelativeLayout.LayoutParams) items[orden[k + rep]].getLayoutParams();
                items[orden[k + rep]].setVisibility(View.VISIBLE);
                items[orden[k + rep]].setAlpha(0f);
                items[orden[k + rep]].setEnabled(true);
                if (orden[k + rep] > 19) {
                    par1.leftMargin = 725 + (k * 350);
                } else {

                    par1.leftMargin = 650 + (k * 350);
                }
                par1.topMargin = 1150;
                items[orden[k + rep]].setLayoutParams(par1);
                animateStar(items[orden[k + rep]], 200);
            }

        }
        rep=rep+5;

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
                    Verificar(v, firtsX, firtsY, 0, par, "shirt");
                }if(v == items[3]  || v == items[4] || v == items[5] || v == items[12]  || v == items[13] || v == items[14]) {
                    Verificar(v, firtsX, firtsY, 0, par, "short");
                }if(v == items[6]  || v == items[7] || v == items[8] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "shoes");
                }if(v == items[15]  || v == items[16] || v == items[17] || v == items[18]  ) {
                    Verificar(v, firtsX, firtsY, 0, par, "basketshoes");
                }if(v == items[19]  || v == items[20] || v == items[21] || v == items[25]  || v == items[26] || v == items[27] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "basketshirt");
                }if(v == items[22]  || v == items[23] || v == items[24] || v == items[28]  || v == items[29] || v == items[30] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "basketshort");
                }if(v == items[31] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "ball1");
                }if( v == items[32] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "ball2");
                }if(v == items[33] ) {
                    Verificar(v, firtsX, firtsY, 0, par, "ball3");
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

        Intent intent = new Intent(Box_Main.this, Deporte_Main.class);
        startActivity(intent);

        super.onBackPressed();
    }

    private RelativeLayout.LayoutParams Verificar(View v, int firtsX, int firtsY, int temp1, RelativeLayout.LayoutParams par, String tipo){

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
        if(hits!=0) {
            if ((hits % 5) == 0) {

                SetImagenes();
            }
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

                Intent intent = new Intent(Box_Main.this, MainActivity.class);
                startActivity(intent);

                break;

            case R.id.box:

                SetImagenes();
                box.setEnabled(false);

                break;

            case R.id.again:

                intent = new Intent(Box_Main.this,Box_Main.class);
                startActivity(intent);
                break;

            case R.id.back:

                intent = new Intent(Box_Main.this, Deporte_Main.class);
                startActivity(intent);

                break;

        }


    }
}
