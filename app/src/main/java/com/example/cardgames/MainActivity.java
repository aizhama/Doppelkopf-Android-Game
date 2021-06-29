package com.example.cardgames;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final Player humanPlayer = new Player("Fabs");
    private final Player playerL = new Player("Aida");
    private final Player playerT = new Player("Aigul");
    private final Player playerR = new Player("Guljan");
    private final Stich stich = new Stich();

    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4, imgOfTheHandCard_5,
            imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9, imgOfTheHandCard_10,
            imgOfTheHandCard_11, imgOfTheHandCard_12;

    ImageView imgHandCardPlayerL_1, imgHandCardPlayerL_2, imgHandCardPlayerL_3, imgHandCardPlayerL_4, imgHandCardPlayerL_5,
            imgHandCardPlayerL_6, imgHandCardPlayerL_7, imgHandCardPlayerL_8, imgHandCardPlayerL_9, imgHandCardPlayerL_10,
            imgHandCardPlayerL_11, imgHandCardPlayerL_12;


    Button resultsFromPlayer;
    TextView startGame;
    List<Card> listFromHandCards, listOf_UserTop, listOf_UserLeft, listOf_UserRight;
    final GameManager gManager = new GameManager(humanPlayer, playerL, playerT, playerR);
    TextView playerLeft, playerTop, playerRight;


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

        //imgHandCardPlayerL_1=(ImageView)findViewById(R.id.handCardPlayerL_1);
        resultsFromPlayer = (Button) findViewById(R.id.pcPlayer);

        startGame = (TextView) findViewById(R.id.start);
        playerLeft = (TextView) findViewById(R.id.playerLeft);
        playerTop = (TextView) findViewById(R.id.playerTop);
        playerRight = (TextView) findViewById(R.id.playerRight);

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
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    if (gManager.getCurrentPlayer().equals(humanPlayer)) {
                        List<Card> validatedCardList = humanPlayer.checkValidityOfTheCards(stich.getAllCards());
                        if (validatedCardList.stream().anyMatch(c -> c == card)) {
                            card_bottom.setImageResource(card.getResId());
                            card_bottom.setVisibility(View.VISIBLE);
                            gManager.playerPlayedACard(humanPlayer, card);
                            //die ausgespielten Karten werden ausgeblendet
                            btnHandCard.setEnabled(false);
                            btnHandCard.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            });
        }
    }

    private void startGame() {
        List<Card> deckList = new ArrayList<>();
        StackList deckOfBlatt = new StackList(deckList);
        deckOfBlatt.kartenAufteilen(humanPlayer, playerL, playerT, playerR);
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
        resultsFromPlayer.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                Stich stich=null;
                if (gManager.getCurrentPlayer().equals(playerL)) {
                    Card kartenWerdenAusgespieltPlayerL = playerL.bedienen();
                    card_left.setImageResource(kartenWerdenAusgespieltPlayerL.getResId());
                    card_left.setVisibility(View.VISIBLE);
                    stich=gManager.playerPlayedACard(playerL, kartenWerdenAusgespieltPlayerL);

                } else if (gManager.getCurrentPlayer().equals(playerT)) {
                    Card kartenWerdenAusgespieltPlayerT = playerT.bedienen();
                    card_top.setImageResource(kartenWerdenAusgespieltPlayerT.getResId());
                    card_top.setVisibility(View.VISIBLE);
                    stich=gManager.playerPlayedACard(playerT, kartenWerdenAusgespieltPlayerT);
                } else if (gManager.getCurrentPlayer().equals(playerR)) {
                    Card kartenWerdenAusgespieltPlayerR = playerR.bedienen();
                    card_right.setImageResource(kartenWerdenAusgespieltPlayerR.getResId());
                    card_right.setVisibility(View.VISIBLE);
                    stich=gManager.playerPlayedACard(playerR, kartenWerdenAusgespieltPlayerR);
                }

                if(stich!=null && stich.complete()){
                    Card hiddenPlayedCard_1= stich.getCardFirst();

                    // Der Stich ist vollständig!!! alle Karten abräumen?
                    // Timer starten, zum wegräumen?
                }
            }
        });
    }
}
