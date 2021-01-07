package com.example.cardgames;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Utils extends AppCompatActivity {
    private GameManager gameDoppelkopf;
    private Card card;
    private List<ImageView> menuButtons;
    private List<ImageView> gameOverButtons;

    private Player player1 = new Player("Fabs");
    private Player player2 = new Player("Aida");
    private Player player3 = new Player("Aigul");
    private Player player4 = new Player("Guljan");
    private Card cardObject;
    private boolean isOnClicked= false;
    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView handCard_1, handCard_2, handCard_3, handCard_4, handCard_5, handCard_6, handCard_7, handCard_8, handCard_9, handCard_10, handCard_11, handCard_12;
    ImageView startPlayer;
    Button start;
    List<Card> handCards;
    List<Card> nUserTop, nUserLeft, nUserRight;
    TextView resultsFirstRound, playerLeft, playerTop, playerRight;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
