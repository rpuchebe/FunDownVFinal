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

public class Maniqui extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{

    private static final String msg = "LogsAndroid";
    int hits = 0;
    Button boton;
    ImageView option1;
    ImageView option2;
    ImageView option3;
    ImageView maniqui;
    int prevX, prevY, firtsX, firtsY;
    //Variables Sonido
    ImageView home;
    MediaPlayer bgm;
    ImageView sonido;
    Bitmap soundOn;
    Bitmap soundOff;
    boolean toggle;
    //Fin variables sonido

    Random rand = new Random();
    int optionshirt = rand.nextInt(6);
    int optionshort = rand.nextInt(5);
    int optionshoes = rand.nextInt(5);
    private ImageView items[] = new ImageView[16];
    private Integer[] background = new Integer[16];
    private String[] valores = new String[32];
    int shirts = rand.nextInt(3);
    int shorts = rand.nextInt(3);

    private Integer[] shirtsm = { R.drawable.shirtm1, R.drawable.shirtm2,
            R.drawable.shirtm3, R.drawable.basketshirtm1, R.drawable.basketshirtm2,R.drawable.basketshirtm3, };

    private Integer[] shirtsw = { R.drawable.shirtw1, R.drawable.shirtw2,
            R.drawable.shirtw3, R.drawable.basketshirtw1, R.drawable.basketshirtw2,R.drawable.basketshirtw3, };

    private Integer[] shortsm = { R.drawable.shortm1,
            R.drawable.shortm3, R.drawable.basketshortm1, R.drawable.basketshortm2,R.drawable.basketshortm3, };

    private Integer[] shortsw = {  R.drawable.shortm1,
            R.drawable.shortm3, R.drawable.basketshortm1, R.drawable.basketshortm2,R.drawable.basketshortm3 };

    private Integer[] shoess = { R.drawable.shoes1, R.drawable.shoes2,
            R.drawable.shoes3, R.drawable.basketshoes2,R.drawable.basketshoes3 };

    private Integer[] men = { R.drawable.shirtm1, R.drawable.shirtm2,
            R.drawable.shirtm3, R.drawable.basketshirtm1, R.drawable.basketshirtm2,R.drawable.basketshirtm3,R.drawable.shortm1,
            R.drawable.shortm3, R.drawable.basketshortm1, R.drawable.basketshortm2,R.drawable.basketshortm3,R.drawable.shoes1, R.drawable.shoes2,
            R.drawable.shoes3, R.drawable.basketshoes2,R.drawable.basketshoes3 };

    private Integer[] women = { R.drawable.shirtw1, R.drawable.shirtw2,
            R.drawable.shirtw3, R.drawable.basketshirtw1, R.drawable.basketshirtw2,R.drawable.basketshirtw3, R.drawable.shortw1,
            R.drawable.shortw3, R.drawable.basketshortw1, R.drawable.basketshortw2,R.drawable.basketshortw3 ,R.drawable.shoes1, R.drawable.shoes2,
            R.drawable.shoes3, R.drawable.basketshoes2,R.drawable.basketshoes3 };




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
        items[0].setOnTouchListener(this);
        items[1].setOnTouchListener(this);
        items[2].setOnTouchListener(this);
        items[3].setOnTouchListener(this);
        items[4].setOnTouchListener(this);
        items[5].setOnTouchListener(this);
        items[6].setOnTouchListener(this);
        items[7].setOnTouchListener(this);
        items[8].setOnTouchListener(this);
        items[9].setOnTouchListener(this);
        items[10].setOnTouchListener(this);
        items[11].setOnTouchListener(this);
        items[12].setOnTouchListener(this);
        items[13].setOnTouchListener(this);
        items[14].setOnTouchListener(this);
        items[15].setOnTouchListener(this);

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

        items[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes1));
        items[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes2));
        items[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.shoes3));
        items[15].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes1));
        items[14].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshoes2));

        if(n == 0){

            maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquimw));

            option1.setBackgroundDrawable(getResources().getDrawable(shirtsm[optionshirt]));
            option2.setBackgroundDrawable(getResources().getDrawable(shortsm[optionshort]));
            option3.setBackgroundDrawable(getResources().getDrawable(shoess[optionshoes]));


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
            if(shorts == 0) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));

            }
            if(shorts == 1) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
            }
            if(shorts == 2) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
            }


        }else{

            if(n == 1){maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiwb));}
            if(n == 2){maniqui.setBackgroundDrawable(getResources().getDrawable(R.drawable.maniquiww));}

            option1.setBackgroundDrawable(getResources().getDrawable(shirtsw[optionshirt]));
            option2.setBackgroundDrawable(getResources().getDrawable(shortsw[optionshort]));
            option3.setBackgroundDrawable(getResources().getDrawable(shoess[optionshoes]));

            if(shirts == 0) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
            }
            if(shirts == 1) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shirts == 2) {
                items[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw3));
                items[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw2));
                items[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshirtw1));
                items[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw3));
                items[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw2));
                items[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.shirtw1));
            }
            if(shorts == 0) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));

            }
            if(shorts == 1) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
            }
            if(shorts == 2) {
                items[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm3));
                items[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.shortm1));
                items[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm1));
                items[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm2));
                items[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.basketshortm3));
            }

        }

    }


    private RelativeLayout.LayoutParams Verificar(View v, int prevX, int prevY, int firtsX, int firtsY, int temp1, RelativeLayout.LayoutParams par, String tipo){


        String opt1 = option1.getBackground().getConstantState().toString();
        String opt2 = option2.getBackground().getConstantState().toString();
        String opt3 = option3.getBackground().getConstantState().toString();
        String temporal = v.getBackground().getConstantState().toString();
        Log.d(msg, "top: " + par.topMargin +"");

        if(tipo == "shirt"){

            if (par.topMargin < 610) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0 ){

                if(temporal.equals(opt1)){

                    par.topMargin = 738;
                    par.leftMargin = 1068;
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            }

        }if(tipo == "shirtb"){

            if (par.topMargin < 610) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 800) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt1)){
                    par.topMargin = 738;
                    par.leftMargin = 1160;
                    v.setEnabled(false);
                    hits++;
                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            }
        }
        if(tipo == "short"){

            if (par.topMargin < 910) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1040) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){
                if(temporal.equals(opt2)){

                    par.topMargin = 985;
                    par.leftMargin = 1162;
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

                }
        }
        if(tipo == "shortb"){

            if (par.topMargin < 910) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1040) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt2)){

                    par.topMargin = 987;
                    par.leftMargin = 1138;
                    v.setEnabled(false);
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

                    par.topMargin = 1225;
                    par.leftMargin = 1140;
                    v.setEnabled(false);
                    hits++;

                }else{par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}

            }
        }
        if(tipo == "shoesb"){

            if (par.topMargin < 1000) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.topMargin > 1300) {par.topMargin = firtsX;par.leftMargin = firtsY;
                temp1=1;}
            if (par.leftMargin > 1400) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if (par.leftMargin < 820) {par.topMargin = firtsX;par.leftMargin = firtsY;temp1=1;}
            if(temp1==0){

                if(temporal.equals(opt3)){

                    par.topMargin = 1200;
                    par.leftMargin = 1140;
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
                if(v == items[1] || v==items[4] || v==items[5] ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoes");
                }
                if( v==items[14] || v==items[15] ) {
                    Verificar(v, prevX, prevY, firtsX, firtsY, 0, par, "shoesb");
                }
                if(v == items[2] || v==items[7] ) {
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

