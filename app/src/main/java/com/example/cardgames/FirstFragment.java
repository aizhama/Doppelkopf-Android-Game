package com.example.cardgames;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/*
ein Fragment ist ein Teil der Benutzeröberfläche oder des Verhaltens einer Anwendung, die in einer aktivität eingeführt werden kann
По своей сути, он представляет собой конкретную операцию или интерфейс, выполняемый в рамках более крупного Activity.
Фрагмент тесно связан с Activity, в котором он находится, и не может использоваться отдельно от него.
Хотя Fragment определяет свой собственный жизненный цикл, этот жизненный цикл зависит от его активности:
если действие остановлено, никакие фрагменты внутри него не могут быть запущены;
когда активность будет уничтожена, все фрагменты будут уничтожены.
Темы, затронутые здесь:
***Older Platforms-Старые платформы
***Lifecycle-Жизненный цикл
***Layout-Макет
***Back Stack-Задний стек
 */

public class FirstFragment extends AppCompatActivity {
    //Dieser Array enthält die Bilder, womit er den Aktivität UI aufbauen kann
    int [] imaArray = new int[]{R.drawable.playerfour, R.id.playerone, R.id.playertwo, R.id.playertree};
    ImageView img;
    int q=0;

    @Override
    //onCreate (Bundle) вызывается для первоначального создания фрагмента.
    //onCreate(Bundle) wird aufgerufen, um die anfängliche Erstellung des Fragments durchzuführen.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Макет устанавливается в активность обычным способом
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
