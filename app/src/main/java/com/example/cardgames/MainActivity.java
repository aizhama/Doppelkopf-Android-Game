package com.example.cardgames;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private Player humanPlayer = new Player("Fabs");
    private Player playerL = new Player("Aida");
    private Player playerT = new Player("Aigul");
    private Player playerR = new Player("Guljan");
    private Card cardObject;
    private boolean isOnClicked = true;
    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4, imgOfTheHandCard_5,
            imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9, imgOfTheHandCard_10,
            imgOfTheHandCard_11, imgOfTheHandCard_12;
    ImageView startPlayer;

    Button start;
    List<Card> listFromHandCards;
    List<Card> listOf_UserTop, listOf_UserLeft, listOf_UserRight;
    TextView resultsFirstRound, playerLeft, playerTop, playerRight;
    GameManager gManager = new GameManager(humanPlayer, playerL, playerT, playerR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//SaveInstance State
        setContentView(R.layout.activity_main);
        startGame();
        playerone = (ImageView) findViewById(R.id.playerone);
        playertwo = (ImageView) findViewById(R.id.playertwo);
        playertree = (ImageView) findViewById(R.id.playertree);
        playerfour = (ImageView) findViewById(R.id.playerfour);
        startPlayer = (ImageView) findViewById(R.id.startPlayer);
        card_top = (ImageView) findViewById(R.id.card_top);
        card_right = (ImageView) findViewById(R.id.card_right);
        card_left = (ImageView) findViewById(R.id.card_left);
        card_bottom = (ImageView) findViewById(R.id.card_bottom);
        imgOfTheHandCard_1 = (ImageView) findViewById(R.id.handCard_1);
        imgOfTheHandCard_2 = (ImageView) findViewById(R.id.handCard_2);
        imgOfTheHandCard_3 = (ImageView) findViewById(R.id.handCard_3);
        imgOfTheHandCard_4 = (ImageView) findViewById(R.id.handCard_4);
        imgOfTheHandCard_5 = (ImageView) findViewById(R.id.handCard_5);
        imgOfTheHandCard_6 = (ImageView) findViewById(R.id.handCard_6);
        imgOfTheHandCard_7 = (ImageView) findViewById(R.id.handCard_7);
        imgOfTheHandCard_8 = (ImageView) findViewById(R.id.handCard_8);
        imgOfTheHandCard_9 = (ImageView) findViewById(R.id.handCard_9);
        imgOfTheHandCard_10 = (ImageView) findViewById(R.id.handCard_10);
        imgOfTheHandCard_11 = (ImageView) findViewById(R.id.handCard_11);
        imgOfTheHandCard_12 = (ImageView) findViewById(R.id.handCard_12);
        start = (Button) findViewById(R.id.start);
        playerLeft = (TextView) findViewById(R.id.playerLeft);
        playerTop = (TextView) findViewById(R.id.playerTop);
        playerRight = (TextView) findViewById(R.id.playerRight);


/*        Observable<String> obs=new Observable<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //es wird neuen Value gesetzt
            obs.setValue("Hallo");
        }
        System.out.println(obs.getValue());
    //Beobachter lamda Funktionen sind Beobachter
        obs.setOnChangeValue(l->{
            System.out.println("Neue Wert: " +l);
        });
        obs.setOnChangeValue(this::testLambda);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            obs.setValue("Zweite neuen Wert!");
        }*/


        HashMap<ImageView, Card> map = new HashMap<ImageView, Card>();
        map.put(imgOfTheHandCard_1, listFromHandCards.get(0));
        map.put(imgOfTheHandCard_2, listFromHandCards.get(1));
        map.put(imgOfTheHandCard_3, listFromHandCards.get(2));

        map.put(imgOfTheHandCard_4, listFromHandCards.get(3));
        map.put(imgOfTheHandCard_5, listFromHandCards.get(4));
        map.put(imgOfTheHandCard_6, listFromHandCards.get(5));
        map.put(imgOfTheHandCard_7, listFromHandCards.get(6));
        map.put(imgOfTheHandCard_8, listFromHandCards.get(7));
        map.put(imgOfTheHandCard_9, listFromHandCards.get(8));
        map.put(imgOfTheHandCard_10, listFromHandCards.get(9));
        map.put(imgOfTheHandCard_11, listFromHandCards.get(10));
        map.put(imgOfTheHandCard_12, listFromHandCards.get(11));
        ImageView[] playerListBtn = new ImageView[3];

        playCards();

        List<ImageView> listOfImagesFromCards = new LinkedList<>();
        Collections.addAll(listOfImagesFromCards, imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4,
                imgOfTheHandCard_5, imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9,
                imgOfTheHandCard_10, imgOfTheHandCard_11, imgOfTheHandCard_12);
        for (ImageView handCard : listOfImagesFromCards) {
            Card card = map.get(handCard);//var card hat key and value
            handCard.setImageResource(card.getResId());//zuordnung von image und suit
            //Card nUsers = new Card();
            //card_top.setImageResource(nUsers.getResId());
            handCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(card + "Image from Card------------------------");
                    card_bottom.setImageDrawable(handCard.getDrawable());
                    handCard.setEnabled(false);
                    handCard.setVisibility(View.INVISIBLE);
                    //var card= cardList.get(imageView);
                    //onCardPlayed(card);
                }
            });
        }
    }

/*    private void testLambda(String test)
    {
        System.out.println("TEST: "+test);
    }*/


    private void onCardPlayed(Card card) {
    }

    private void startGame() {
        final int size = 48;
        Card[] deckOfCards = new Card[size];
        StackList kartenStapel = new StackList(deckOfCards);
        kartenStapel.kartenAufteilen(humanPlayer, playerL, playerT, playerR);
        listFromHandCards = humanPlayer.getDeckOfPlayCards();
        listOf_UserTop = playerL.getDeckOfPlayCards();
        listOf_UserLeft = playerT.getDeckOfPlayCards();
        listOf_UserRight = playerR.getDeckOfPlayCards();
        System.out.println(humanPlayer.showPlayerCards() + humanPlayer.getGamerName());
        System.out.println(playerL.showPlayerCards() + playerL.getGamerName());
        System.out.println(playerT.showPlayerCards() + playerT.getGamerName());
        System.out.println(playerR.showPlayerCards() + playerR.getGamerName());
    }

    private void playCards() {
        List<ImageView> listOfplayerBtn = new LinkedList<>();
        Collections.addAll(listOfplayerBtn, card_left, card_top, card_right);

        System.out.println("PlayerBTN check!" + listOfplayerBtn);
        System.out.println("card_right check!" + card_right);
        System.out.println("card_right check!" + card_right);
        System.out.println("card_right check!" + card_right);

        for (ImageView playBtn : listOfplayerBtn) {
            if (playBtn != null) {
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.card_left:
                                if (gManager.getPlayerL().equals(playerL)) {    //wenn wirklich dieser spieler spielt gerade
                                    System.out.println("if currentPlayer is equals player2" + gManager.getPlayerL().equals(playerL));
                                    Card kartenWerdenAusgespieltPlayerL = playerL.bedienen();
                                    if (kartenWerdenAusgespieltPlayerL != null) {
                                        card_left.setImageResource(kartenWerdenAusgespieltPlayerL.getResId());
                                        gManager.playerPlayedACard(playerL, kartenWerdenAusgespieltPlayerL);
                                    } else {
                                        card_left.setVisibility(View.INVISIBLE);
                                    }
                                }
                                break;

                            case R.id.card_top:
                                if (gManager.getPlayerT().equals(playerT)) {
                                    System.out.println("if currentPlayer is equals player3" + gManager.getPlayerT().equals(playerT));
                                    Card kartenWerdenAusgespieltPlayerT = playerT.bedienen();
                                    if (kartenWerdenAusgespieltPlayerT != null) {
                                        card_top.setImageResource(kartenWerdenAusgespieltPlayerT.getResId());
                                        gManager.playerPlayedACard(playerT, kartenWerdenAusgespieltPlayerT);//nur Message bei jeden Raund!
                                    } else {
                                        card_top.setVisibility(View.INVISIBLE);
                                    }
                                }
                                break;
                            case R.id.card_right:
                                if (gManager.getPlayerR().equals(playerR)) {
                                    System.out.println("if currentPlayer is equals player4" + gManager.getPlayerR().equals(playerR));
                                    Card kartenWerdenAusgespieltPlayerR = playerR.bedienen();
                                    if (kartenWerdenAusgespieltPlayerR != null) {
                                        card_right.setImageResource(kartenWerdenAusgespieltPlayerR.getResId());
                                        gManager.playerPlayedACard(playerR, kartenWerdenAusgespieltPlayerR);
                                    } else {
                                        card_right.setVisibility(View.INVISIBLE);
                                    }
                                }else {

                                    card_right.setEnabled(false);
                                    System.out.println(" jetzt Player 1 ist drann");
                                }
                                break;
                        }
                    }
                });
            }
        }
    }

    public void MessageBox(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onSavedInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }
}