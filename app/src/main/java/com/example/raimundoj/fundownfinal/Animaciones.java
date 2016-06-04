package com.example.raimundoj.fundownfinal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by RaimundoJ on 28/05/2016.
 */



public class Animaciones extends AppCompatActivity {

    private static final String msg = "LogsAndroid";
    //Puntaje
    int hits = 0;

    //Bozquejo y star
    ImageView option1,option2,option3;
    ImageView star1,star2,star3;
    ImageView back;
    ImageView again;
    ImageView popup;

    private boolean mSoundState = false;
    SharedPreferences appPreferences;

    private int dpToPixel(Context context,int dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void startTootipAnimation(View mTooltip) {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mTooltip, "scaleY", 0.8f);
        scaleY.setDuration(200);
        ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(mTooltip, "scaleY", 1f);
        scaleYBack.setDuration(500);
        scaleYBack.setInterpolator(new BounceInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(1000);
        animatorSet.playSequentially(scaleY, scaleYBack);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.setStartDelay(2000);
                animatorSet.start();
            }
        });
        animatorSet.start();
    }

    public void startLightsAnimation(View mStartButtonLights) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mStartButtonLights, "rotation", 0f, 360f);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        mStartButtonLights.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animator.start();
    }

    public void startAnimation(){


        // Animacion 1

        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(100)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(2000)
                .playOn(findViewById(R.id.maniqui));



        // Animacion 2

        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(6000)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(8000)
                .playOn(findViewById(R.id.maniqui));


        // Animacion 3


        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(12000)
                .playOn(findViewById(R.id.box));
        YoYo.with(Techniques.Flash)
                .duration(1700)
                .delay(14000);



    }

    public void gameWon(int hits){


        switch (hits) {
            case 1:
                star1.setVisibility(View.VISIBLE);
                star1.setAlpha(0f);
                animateStar(star1, 200);
                Sonidos(R.raw.star);
                break;
            case 2:
                star2.setVisibility(View.VISIBLE);
                star2.setAlpha(0f);
                animateStar(star2, 200);
                Sonidos(R.raw.star);
                break;
            case 3:
                star3.setVisibility(View.VISIBLE);
                star3.setAlpha(0f);
                animateStar(star3, 200);
                Sonidos(R.raw.star);
                popup.setVisibility(View.VISIBLE);
                popup.setAlpha(0f);
                animateStar(popup, 500);
                again.setVisibility(View.VISIBLE);
                again.setAlpha(0f);
                animateStar(again, 600);
                back.setVisibility(View.VISIBLE);
                back.setAlpha(0f);
                animateStar(back, 600);
                break;
            case 34:
                popup.setVisibility(View.VISIBLE);
                popup.bringToFront();
                popup.setAlpha(0f);
                animateStar(popup, 500);
                again.setVisibility(View.VISIBLE);
                again.bringToFront();
                again.setAlpha(0f);
                animateStar(again, 600);
                back.setVisibility(View.VISIBLE);
                back.bringToFront();
                back.setAlpha(0f);
                animateStar(back, 600);
                break;
        }

    }

    public void animateStar(final View view, int delay) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 1f);
        alpha.setDuration(100);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alpha, scaleX, scaleY);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.setStartDelay(delay);
        animatorSet.setDuration(600);
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();

    }

    public void Sonidos(int Sonido){

                MediaPlayer mp = MediaPlayer.create(this,Sonido);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.reset();
                        mp.release();
                        mp = null;
                    }

                });
                mp.start();

        }

    public boolean GetResolucion(boolean resolution){



        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        Log.d(msg,"---------------------Resolucion nada");

        float widthDpi = metrics.xdpi;
        float heightDpi = metrics.ydpi;
        float widthInches = widthPixels/widthDpi;
        float heightInches = heightPixels/heightDpi;
        //The size of the diagonal in inches is equal to the square root of the height in inches squared plus the width in inches squared.
        double diagonalInches = Math.sqrt(
                (widthInches * widthInches)
                        + (heightInches * heightInches));
        Log.d(msg,"Diagonal" + diagonalInches);
        if (diagonalInches > 9.9) {
            //Device is a 10" tablet
            Log.d(msg,"---------------------Resolucion2 10");
            resolution=false;
        }
        else if (diagonalInches > 6.9) {
            //Device is a 7" tablet
            resolution=true;
            Log.d(msg,"---------------------Resolucion2 7");
        }

        return resolution;


    }


    }



