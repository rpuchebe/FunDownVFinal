package com.example.raimundoj.fundownfinal;

/**
 * Created by RaimundoJ on 28/05/2016.
 */


import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RemoteViews;

public class General {
    static String TAG = "KidsMallDebug";
    public static MediaPlayer bgm;
    public static PopupWindow pw;

    static void d (String text){
        Log.d(TAG,text);
    }

    static void  initialize(Context context){
        bgm = MediaPlayer.create(context,R.raw.background);
        bgm.setLooping(true);
        bgm.start();
    }

    static void  manageBackgroundMusic(boolean state){
        if (state){
            bgm.start();
        } else {
            bgm.pause();
        }
    }

    static void showInfo(Activity context){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pw = new PopupWindow(
                inflater.inflate(R.layout.info, null, false),
                900,
                900,
                true);
        pw.showAtLocation(new LinearLayout(context), Gravity.CENTER, 0, 0);

        ImageView imageView = (ImageView) pw.getContentView().findViewById(R.id.imageView13);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
    }
}