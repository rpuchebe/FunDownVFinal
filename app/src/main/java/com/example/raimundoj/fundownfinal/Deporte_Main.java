package com.example.raimundoj.fundownfinal;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class Deporte_Main extends Animaciones implements View.OnClickListener{


    ImageButton box,maniqui;
    ImageView avatar,home,sonido;
    MediaPlayer bgm;
    ImageView mStartButtonLights1;
    ImageView mStartButtonLights2;
    Bitmap soundOn,soundOff;
    boolean toggle;
    Random rand = new Random();

    //N da un numero ramdom para definir el maniqui
    int n = rand.nextInt(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte);

        //ImageView
        sonido = (ImageView) findViewById(R.id.sonido);
        home = (ImageView) findViewById(R.id.home);
        avatar = (ImageView) findViewById(R.id.avatar);
        box=(ImageButton)findViewById(R.id.box);
        maniqui=(ImageButton)findViewById(R.id.maniqui);

        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoon);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btnsonidoff);
        mStartButtonLights1 = (ImageView) findViewById(R.id.start_game_button_lights1);
        mStartButtonLights2 = (ImageView) findViewById(R.id.start_game_button_lights2);


        //Onclick
        box.setOnClickListener(this);
        maniqui.setOnClickListener(this);
        sonido.setOnClickListener(this);
        home.setOnClickListener(this);

        toggle = true;
        sonido.setImageBitmap(soundOn);
        bgm = MediaPlayer.create(this,R.raw.background);
        bgm.start();
        bgm.setLooping(true);

        //Animacion para los botones
        startAnimation();
        startLightsAnimation(mStartButtonLights1);
        startLightsAnimation(mStartButtonLights2);

        //Muestra el avatar seleccionado
        startAvatar();

    }
    protected void  onResume(){
        super.onResume();
    }

    protected void onPause(){
        super.onPause();
        bgm.release();
    }

    public void onBackPressed() {

        Intent intent = new Intent(Deporte_Main.this, MainActivity.class);
        startActivity(intent);

        super.onBackPressed();
    }

    private void startAvatar(){
        int avatarn = 1;
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null){
            avatarn = extras.getInt("Avatar");
        }
        if(avatarn==2){avatar.setBackgroundDrawable(getResources().getDrawable(R.drawable.avatar1));}
        if(avatarn==1){avatar.setBackgroundDrawable(getResources().getDrawable(R.drawable.avatar2));}
        if(avatarn==3){avatar.setBackgroundDrawable(getResources().getDrawable(R.drawable.avatar3));}

    }

        @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.box:

                Intent intent = new Intent(Deporte_Main.this, Box_Main.class);
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

                intent = new Intent(Deporte_Main.this, Maniqui_Main.class);
                intent.putExtra("variable", n);
                startActivity(intent);
                break;

            case R.id.home:

                intent = new Intent(Deporte_Main.this, MainActivity.class);
                startActivity(intent);

                break;

        }

    }
}
