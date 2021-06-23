package com.example.cardgames;

import android.app.Notification;
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
import java.util.Observable;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private Player humanPlayer = new Player("Fabs");
    private Player playerL = new Player("Aida");
    private Player playerT = new Player("Aigul");
    private Player playerR = new Player("Guljan");
    private Stich stich = new Stich();

    private StackList stackList;
    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4, imgOfTheHandCard_5,
            imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9, imgOfTheHandCard_10,
            imgOfTheHandCard_11, imgOfTheHandCard_12;
    ImageView startPlayer;
    List<Card> listFromHandCards, listOf_UserTop, listOf_UserLeft, listOf_UserRight;
    final GameManager gManager = new GameManager(humanPlayer, playerL, playerT, playerR);


    TextView resultsFirstRound, playerLeft, playerTop, playerRight;

    /*das soll gelöscht werden
    Button start;
TEST TEST TEST
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        //ToDo: warum hier findViewBy? das ist Falsch
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
        playerLeft = (TextView) findViewById(R.id.playerLeft);
        playerTop = (TextView) findViewById(R.id.playerTop);
        playerRight = (TextView) findViewById(R.id.playerRight);

        /*Das soll gelöscht werden
        start = (Button) findViewById(R.id.start);

         */

/*
        Observable<String> obs = new Observable<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //es wird neuen Value gesetzt
            obs.setValue("Hallo");
        }
        System.out.println(obs.getValue());
        //Beobachter lamda Funktionen sind Beobachter
        obs.setOnChangeValue(l -> {
            System.out.println("Neue Wert: " + l);
        });
        obs.setOnChangeValue(this::testLambda);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            obs.setValue("Zweite neuen Wert!");
        }
*/
        HashMap<ImageView, Card> mapForHumanPlayerCards = new HashMap<ImageView, Card>();
        mapForHumanPlayerCards.put(imgOfTheHandCard_1, listFromHandCards.get(0));
        mapForHumanPlayerCards.put(imgOfTheHandCard_2, listFromHandCards.get(1));
        mapForHumanPlayerCards.put(imgOfTheHandCard_3, listFromHandCards.get(2));
        mapForHumanPlayerCards.put(imgOfTheHandCard_4, listFromHandCards.get(3));
        mapForHumanPlayerCards.put(imgOfTheHandCard_5, listFromHandCards.get(4));
        mapForHumanPlayerCards.put(imgOfTheHandCard_6, listFromHandCards.get(5));
        mapForHumanPlayerCards.put(imgOfTheHandCard_7, listFromHandCards.get(6));
        mapForHumanPlayerCards.put(imgOfTheHandCard_8, listFromHandCards.get(7));
        mapForHumanPlayerCards.put(imgOfTheHandCard_9, listFromHandCards.get(8));
        mapForHumanPlayerCards.put(imgOfTheHandCard_10, listFromHandCards.get(9));
        mapForHumanPlayerCards.put(imgOfTheHandCard_11, listFromHandCards.get(10));
        mapForHumanPlayerCards.put(imgOfTheHandCard_12, listFromHandCards.get(11));
        ImageView[] playerListBtn = new ImageView[3];

        playCards();

        List<ImageView> listOfImagesFromCards = new LinkedList<>();
        Collections.addAll(listOfImagesFromCards, imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4,
                imgOfTheHandCard_5, imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9,
                imgOfTheHandCard_10, imgOfTheHandCard_11, imgOfTheHandCard_12);

        for (ImageView btnHandCard : listOfImagesFromCards) {
            Card card = mapForHumanPlayerCards.get(btnHandCard);
            btnHandCard.setImageResource(card.getResId());
            btnHandCard.setOnClickListener(new View.OnClickListener() {
                //ToDo: wenn die Spieler nur dran sind, sollen die spielen    //also in gManager -> currentReferences->die auf currentplayer zeigt und diesen currRef compare mit Humanplayer
                //toDo: wenn spieler dran ist, dann prüfen ob die Karte valide ist?
                //toDo: wenn player hat eine karte ausgespielt ->notify es im UI
                //toDo: -> put card in stich!
                //ToDo: Comp sp sollen autom mit Timer -> dass nach dem
                //

                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    if (gManager.getCurrentPlayer().equals(humanPlayer)) {
                        List<Card> validatedCardList = humanPlayer.checkValidityOfTheCards(stich.getAllCards());
                        if (validatedCardList.stream().anyMatch(c -> c == card)) {
                            card_bottom.setImageResource(card.getResId());
                            card_bottom.setVisibility(View.VISIBLE);
                            btnHandCard.setEnabled(false);
                            btnHandCard.setVisibility(View.INVISIBLE);
                            gManager.playerPlayedACard(humanPlayer, card);

                            // -> notifiy gamemanager
                        }
                    }
                }
            });
        }
    }

/*

   @RequiresApi(api = Build.VERSION_CODES.N)
    private ImageView assignCorrectIdToTheCard() {
       //imgOfTheHandCard_12 = (ImageView) findViewById(R.id.handCard_12);

       List<Card> img = stackList.initializeDeck();
       ImageView imgage = img.stream().allMatch(cardView -> cardView.getResId())
       List<Card> validatedCardList = humanPlayer.checkValidityOfTheCards(stich.getAllCards());
       ImageView imgage = img.stream()
   }*/
/*
    private void testLambda(String test) {
        System.out.println("TEST: " + test);
    }
*/


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
/*        System.out.println("PlayerBTN check!" + listOfplayerBtn);
        System.out.println("card_left check!" + card_left);*/

        for (ImageView playBtn : listOfplayerBtn) {
            if (playBtn != null) {
                playBtn.setOnClickListener(new View.OnClickListener() {


                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.card_left:
                                if (gManager.getCurrentPlayer().equals(playerL)) {    //wenn wirklich dieser spieler spielt gerade
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
                                if (gManager.getCurrentPlayer().equals(playerT)) {
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
                                if (gManager.getCurrentPlayer().equals(playerR)) {
                                    System.out.println("if currentPlayer is equals player4" + gManager.getPlayerR().equals(playerR));
                                    Card kartenWerdenAusgespieltPlayerR = playerR.bedienen();
                                    if (kartenWerdenAusgespieltPlayerR != null) {
                                        card_right.setImageResource(kartenWerdenAusgespieltPlayerR.getResId());
                                        gManager.playerPlayedACard(playerR, kartenWerdenAusgespieltPlayerR);
                                    } else {
                                        card_right.setVisibility(View.INVISIBLE);
                                    }
                                } else {

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

/*    public void onSavedInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }*/

}