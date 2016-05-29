package com.example.raimundoj.fundownfinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class Maniqui extends Animaciones implements View.OnTouchListener,View.OnClickListener{

    private static final String msg = "LogsAndroid";
    int hits = 0;
    Button boton;
    ImageView option1;
    ImageView option2;
    ImageView option3;
    ImageView maniqui;
    int prevX, prevY, firtsX, firtsY;
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;
    Random rand = new Random();
    int optionshirt = rand.nextInt(6);
    int optionshort = rand.nextInt(6);
    int optionshoes = rand.nextInt(4);
    private ImageView items[] = new ImageView[16];
    private Integer[] background = new Integer[16];
    private String[] valores = new String[32];
    int shirts = rand.nextInt(3);
    int shorts = rand.nextInt(3);
    String opt1;
    String opt2;
    String opt3;

    private Integer[] shirtsm = { R.drawable.shirtm1, R.drawable.shirtm2,
            R.drawable.shirtm3, R.drawable.basketshirtm1, R.drawable.basketshirtm2,R.drawable.basketshirtm3, };

    private Integer[] bozshirtsm = { R.drawable.bozshirtm1, R.drawable.bozshirtm2,
            R.drawable.bozshirtm3, R.drawable.bozbasketshirtm1, R.drawable.bozbasketshirtm2,R.drawable.bozbasketshirtm3, };

    private Integer[] shirtsw = { R.drawable.shirtw1, R.drawable.shirtw2,
            R.drawable.shirtw3, R.drawable.basketshirtm1, R.drawable.basketshirtm2,R.drawable.basketshirtm3, };

    private Integer[] bozshirtsw = { R.drawable.bozshirtw1, R.drawable.bozshirtw2,
            R.drawable.bozshirtw3, R.drawable.bozbasketshirtm1, R.drawable.bozbasketshirtm2,R.drawable.bozbasketshirtm3, };

    private Integer[] shortsm = { R.drawable.shortm1,R.drawable.shortm2,
            R.drawable.shortm3, R.drawable.basketshortm1, R.drawable.basketshortm2,R.drawable.basketshortm3, };

    private Integer[] bozshortsm = { R.drawable.bozshortm1,R.drawable.bozshortm2,
            R.drawable.bozshortm3, R.drawable.bozbasketshortm1, R.drawable.bozbasketshortm2,R.drawable.bozbasketshortm3, };


    private Integer[] shoess = { R.drawable.shoes3, R.drawable.shoes2,R.drawable.basketshoes2,R.drawable.basketshoes1 };

    private Integer[] bozshoess = { R.drawable.bozshoes3, R.drawable.bozshoes2,R.drawable.bozbasketshoes2,R.drawable.bozbasketshoes1 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniqui);
        option1=(ImageView)findViewById(R.id.option1);
        option2=(ImageView)findViewById(R.id.option2);
        option3=(ImageView)findViewById(R.id.option3);
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
        maniqui=(ImageView)findViewById(R.id.maniqui);
        boton=(Button)findViewById(R.id.button2);
        SetManiqui();
        boton.setOnClickListener(this);
        for(int i=0;i <=15; i++){

            items[i].setOnTouchListener(this);

        }

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
        bgm = MediaPlayer.create(this, R.raw.background2);
        bgm.start();
        bgm.setLooping(true);
        //<------------------- Fin Sonido ------------------------->

    }

    protected void  onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
        bgm.release();
    }

    final void SetManiqui(){

        int n = 1;
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null){
            n = extras.getInt("variable");
        }

        items[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
        items[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
        items[15].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
        items[14].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));
        if(shorts == 0) {
            items[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
            items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
            items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
            items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
            items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
            items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));

        }
        if(shorts == 1) {
            items[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
            items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
            items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
            items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
            items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
            items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
        }
        if(shorts == 2) {
            items[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm2));
            items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
            items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
            items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
            items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
            items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
        }

        int ishirt =optionshirt;
        int ishort =optionshort;
        int ishoes =optionshoes;


        if(shirtsm[ishirt].equals(R.drawable.basketshirtm1) || shirtsm[ishirt].equals(R.drawable.basketshirtm2) || shirtsm[ishirt].equals(R.drawable.basketshirtm3) ){

            RelativeLayout.LayoutParams par1 = (RelativeLayout.LayoutParams) option1.getLayoutParams();
            par1.width=250;
            par1.height=300;
            option1.setLayoutParams(par1);

        }
        if(shortsm[ishort].equals(R.drawable.basketshortm1) || shortsm[ishort].equals(R.drawable.basketshortm2) || shortsm[ishort].equals(R.drawable.basketshortm3) ){

            RelativeLayout.LayoutParams par2 = (RelativeLayout.LayoutParams) option2.getLayoutParams();
            par2.width=250;
            par2.height=130;
            option2.setLayoutParams(par2);

        }
        if(shoess[ishoes].equals(R.drawable.basketshoes1) || shoess[ishoes].equals(R.drawable.basketshoes2) ){

            RelativeLayout.LayoutParams par3 = (RelativeLayout.LayoutParams) option3.getLayoutParams();
            par3.width=310;
            par3.topMargin=990;
            par3.height=110;
            option3.setLayoutParams(par3);

        }
        option2.setBackgroundDrawable(getResources().getDrawable(shortsm[ishort]));
        opt2 = option2.getBackground().getConstantState().toString();
        option2.setBackgroundDrawable(getResources().getDrawable(bozshortsm[ishort]));
        option3.setBackgroundDrawable(getResources().getDrawable(shoess[ishoes]));
        opt3 = option3.getBackground().getConstantState().toString();
        option3.setBackgroundDrawable(getResources().getDrawable(bozshoess[ishoes]));

        if(n == 0){

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquimw));

            option1.setBackgroundDrawable(getResources().getDrawable(shirtsm[ishirt]));
            opt1 = option1.getBackground().getConstantState().toString();
            option1.setBackgroundDrawable(getResources().getDrawable(bozshirtsm[ishirt]));


            if(shirts == 0) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
            }
            if(shirts == 1) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
            }
            if(shirts == 2) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm3));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtm1));
            }



        }else{

            if(n == 1){maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiwb));}
            if(n == 2){maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiww));}

            option1.setBackgroundDrawable(getResources().getDrawable(shirtsw[ishirt]));
            opt1 = option1.getBackground().getConstantState().toString();
            option1.setBackgroundDrawable(getResources().getDrawable(bozshirtsw[ishirt]));


            if(shirts == 0) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(shirts == 1) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shirts == 2) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm3));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtm1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }


        }

    }


    private RelativeLayout.LayoutParams Verificar(View v, int prevX, int prevY, int firtsX, int firtsY, int temp1, RelativeLayout.LayoutParams par, String tipo){



        String temporal = v.getBackground().getConstantState().toString();
        Log.d(msg, "temp: " + temporal +"");
        Log.d(msg, "opt1: " + opt1 +"");
        Log.d(msg, "opt2: " + opt2 +"");
        Log.d(msg, "opt3: " + opt3 +"");

        if(tipo == "shirt"){

            if (par.topMargin < 410) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0 ){

                if(temporal.equals(opt1)){

                    par.topMargin = 538;
                    par.leftMargin = 1068;
                    option1.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            }

        }if(tipo == "shirtb"){

            if (par.topMargin < 410) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 600) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt1)){
                    par.topMargin = 538;
                    par.leftMargin = 1160;
                    option1.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
                    hits++;
                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            }
        }
        if(tipo == "short"){

            if (par.topMargin < 710) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 840) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt2)){

                    par.topMargin = 785;
                    par.leftMargin = 1165;
                    option2.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

                }
        }
        if(tipo == "shortb"){

            if (par.topMargin < 710) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 840) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt2)){

                    par.topMargin = 787;
                    par.leftMargin = 1145;
                    option2.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}


            }
        }
        if(tipo == "shoes"){

            if (par.topMargin < 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1100) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt3)){

                    par.topMargin = 1025;
                    par.leftMargin = 1135;
                    option3.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

            }
        }
        if(tipo == "shoesb"){

            if (par.topMargin < 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1100) {par.topMargin = firtsX;par.leftMargin = firtsY;
                temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt3)){

                    par.topMargin = 995;
                    par.leftMargin = 1115;
                    option3.setVisibility(View.INVISIBLE);
                    v.setEnabled(false);
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
                if(v == items[0] || v==items[3] || v==items[6] ){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirt");
                }
                if(v == items[9] || v==items[11] || v==items[10]){
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shirtb");
                }
                if(v == items[1]  || v==items[5] ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoes");
                }
                if( v==items[14] || v==items[15] ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesb");
                }
                if(v == items[2] || v==items[7] || v==items[4]) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "short");
                }
                if(v == items[8] || v==items[12] || v==items[13]) {
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

