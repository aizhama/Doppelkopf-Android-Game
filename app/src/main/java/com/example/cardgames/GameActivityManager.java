package com.example.cardgames;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

public class GameActivityManager extends AppCompatActivity implements Observer {

     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
     }

     protected void onStart() {
          super.onStart();
     }

     protected void onRestart() {
          super.onRestart();
     }

     protected void onResume() {
          super.onResume();
     }

     protected void onPause() {
          super.onPause();
     }

     protected void onStop() {
          super.onStop();
     }

     protected void onDestroy() {
          super.onDestroy();
     }

     @Override
     public void update(Observable o, Object arg) {

     }
}
