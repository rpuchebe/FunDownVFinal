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


    private boolean mSoundState = false;
    SharedPreferences appPreferences;

    public void onClickInfo(View view) {
        General.showInfo(this);
    }

    public void addButtons(Context context, RelativeLayout layout){
        Log.d(General.TAG,"addButtons");
        addSoundButton(context, layout);
        addInfodButton(context, layout);
        addHomedButton(context,layout);
    }

    private void addSoundButton(final Context context, RelativeLayout layout) {
        final ImageView ivSonido = new ImageView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.rightMargin = dpToPixel(context,20);;
        params.topMargin = dpToPixel(context,20);;
        params.width = dpToPixel(context,60);
        params.height = dpToPixel(context,60);

        appPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isSoundActive = appPreferences.getBoolean("isSoundActive", false);
        if (isSoundActive) {
            ivSonido.setImageResource(R.drawable.btnsonidoon);
        } else {
            ivSonido.setImageResource(R.drawable.btnsonidoff);
        }
        Log.d(General.TAG,"Getting  sound button "+isSoundActive);
        ivSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                boolean isSoundActive = appPreferences.getBoolean("isSoundActive", false);
                if (isSoundActive){
                    ivSonido.setImageResource(R.drawable.btnsonidoff);
                } else {
                    ivSonido.setImageResource(R.drawable.btnsonidoon);
                }
                isSoundActive = !isSoundActive;
                Log.d(General.TAG,"Changing sound button to "+isSoundActive);
                SharedPreferences.Editor editor = appPreferences.edit();
                editor.putBoolean("isSoundActive", isSoundActive);
                editor.commit();

                General.manageBackgroundMusic(isSoundActive);
            }
        });
        layout.addView(ivSonido, params);
    }

    private void addInfodButton(final Context context, RelativeLayout layout) {
        ImageView ivSonido = new ImageView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        params.rightMargin = dpToPixel(context,100);
        params.topMargin = dpToPixel(context,20);
        params.width = dpToPixel(context,60);
        params.height = dpToPixel(context,60);
        ivSonido.setImageResource(R.drawable.btninfo);
        ivSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.showInfo((Activity) context);
            }
        });
        layout.addView(ivSonido, params);
    }

    private void addHomedButton(final Context context, RelativeLayout layout) {
        ImageView ivSonido = new ImageView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

        params.leftMargin = dpToPixel(context,20);
        params.topMargin = dpToPixel(context,20);
        params.width = dpToPixel(context,60);
        params.height = dpToPixel(context,60);
        ivSonido.setImageResource(R.drawable.btnhome);
        ivSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.showInfo((Activity) context);
            }
        });
        layout.addView(ivSonido, params);
    }

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




}
