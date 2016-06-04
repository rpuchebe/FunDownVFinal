package com.example.raimundoj.fundownfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Animaciones implements View.OnClickListener {

    ImageButton avatar1;
    ImageButton avatar2;
    ImageButton avatar3;
    ImageView mTooltip1;
    ImageView mTooltip2;
    ImageView mTooltip3;
    ImageView mStartButtonLights1;
    ImageView mStartButtonLights2;
    ImageView mStartButtonLights3;
    boolean resolution;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetResolucion(resolution);
        //ImageButton
        avatar1 =(ImageButton)findViewById(R.id.avatar1);
        avatar2 =(ImageButton)findViewById(R.id.avatar2);
        avatar3 =(ImageButton)findViewById(R.id.avatar3);

        //ImageView
        mTooltip1 =(ImageView)findViewById(R.id.tooltip1);
        mTooltip2 =(ImageView)findViewById(R.id.tooltip2);
        mTooltip3 =(ImageView)findViewById(R.id.tooltip3);

        //Referenciando
        mStartButtonLights1 = (ImageView) findViewById(R.id.start_game_button_lights1);
        mStartButtonLights2 = (ImageView) findViewById(R.id.start_game_button_lights2);
        mStartButtonLights3 = (ImageView) findViewById(R.id.start_game_button_lights3);

        //Onclick
        avatar1.setOnClickListener(this);
        avatar2.setOnClickListener(this);
        avatar3.setOnClickListener(this);

        //Animacion de Play
        startTootipAnimation(mTooltip1);
        startTootipAnimation(mTooltip2);
        startTootipAnimation(mTooltip3);

        //Animacion de estrella
        startLightsAnimation(mStartButtonLights1);
        startLightsAnimation(mStartButtonLights2);
        startLightsAnimation(mStartButtonLights3);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.avatar1:

                Intent intent = new Intent(MainActivity.this, Deporte_Main.class);
                int avatar = 1;
                intent.putExtra("Avatar", avatar);
                startActivity(intent);

                break;

            case R.id.avatar2:

                intent = new Intent(MainActivity.this, Deporte_Main.class);
                avatar = 2;
                intent.putExtra("Avatar", avatar);
                startActivity(intent);

                break;

            case R.id.avatar3:

                intent = new Intent(MainActivity.this, Deporte_Main.class);
                avatar = 3;
                intent.putExtra("Avatar", avatar);
                startActivity(intent);

                break;


        }


    }
}
