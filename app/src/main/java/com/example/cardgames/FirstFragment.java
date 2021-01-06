package com.example.cardgames;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstFragment extends AppCompatActivity {
    int [] imaArray = new int[]{R.drawable.playerfour, R.id.playerone, R.id.playertwo, R.id.playertree};
    ImageView img;
    int q=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.playerone);
    }
    protected void next(View view) {
        img.setImageResource(imaArray[q]);
        img.setImageBitmap(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.playerfour));
        if(q<2)
            q++;
    }
    protected void back(View view) {
        img.setImageResource(imaArray[q]);
        if(q>0)
            q--;
    }
    public void process(View v){
        //Intent Visual Indicator of progress in some operation
        Intent intent= null, chooser=null;

    }
}
