package com.example.cardgames;

import android.annotation.SuppressLint;
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
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final Player humanPlayer = new Player("Fabs");
    private final Player playerL = new Player("Aida");
    private final Player playerT = new Player("Aigul");
    private final Player playerR = new Player("Guljan");
    private final Stich stich = new Stich();

    //Maps for Player cards
    Map<ImageView, Card> mapForHumanPlayer = new HashMap<ImageView, Card>();
    Map<ImageView, Card> mapForPlayerL = new HashMap<ImageView, Card>();
    Map<ImageView, Card> mapForPlayerT = new HashMap<ImageView, Card>();
    Map<ImageView, Card> mapForPlayerR = new HashMap<ImageView, Card>();

    ImageView playerone, playertwo, playertree, playerfour,
            card_top, card_right, card_left, card_bottom;

    TextView playerBottom, playerLeft, playerTop, playerRight;

    List<Card> listHandCardsHumanPlayer, listHandCardsPlayerL,
            listHandCardsPlayerT, listHandCardsPlayerR;

    ImageView imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3,
            imgOfTheHandCard_4, imgOfTheHandCard_5, imgOfTheHandCard_6,
            imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9,
            imgOfTheHandCard_10, imgOfTheHandCard_11, imgOfTheHandCard_12;

    ImageView imgHandCardPlayerL_1, imgHandCardPlayerL_2, imgHandCardPlayerL_3,
            imgHandCardPlayerL_4, imgHandCardPlayerL_5, imgHandCardPlayerL_6,
            imgHandCardPlayerL_7, imgHandCardPlayerL_8, imgHandCardPlayerL_9,
            imgHandCardPlayerL_10, imgHandCardPlayerL_11, imgHandCardPlayerL_12;

    ImageView imgHandCardPlayerT_1, imgHandCardPlayerT_2, imgHandCardPlayerT_3,
            imgHandCardPlayerT_4, imgHandCardPlayerT_5, imgHandCardPlayerT_6,
            imgHandCardPlayerT_7, imgHandCardPlayerT_8, imgHandCardPlayerT_9,
            imgHandCardPlayerT_10, imgHandCardPlayerT_11, imgHandCardPlayerT_12;

    ImageView imgHandCardPlayerR_1, imgHandCardPlayerR_2, imgHandCardPlayerR_3,
            imgHandCardPlayerR_4, imgHandCardPlayerR_5, imgHandCardPlayerR_6,
            imgHandCardPlayerR_7, imgHandCardPlayerR_8, imgHandCardPlayerR_9,
            imgHandCardPlayerR_10, imgHandCardPlayerR_11, imgHandCardPlayerR_12;

    Button resultsFromPlayer;

    final GameManager gManager = new GameManager(humanPlayer, playerL, playerT, playerR);

    //@SuppressLint("CutPasteId")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame();

        //Image Player
        playerone = (ImageView) findViewById(R.id.playerone);
        playertwo = (ImageView) findViewById(R.id.playertwo);
        playertree = (ImageView) findViewById(R.id.playertree);
        playerfour = (ImageView) findViewById(R.id.playerfour);

        //Image for cards position
        card_top = (ImageView) findViewById(R.id.card_top);
        card_right = (ImageView) findViewById(R.id.card_right);
        card_left = (ImageView) findViewById(R.id.card_left);
        card_bottom = (ImageView) findViewById(R.id.card_bottom);

        //TextView
        playerLeft = (TextView) findViewById(R.id.playerLeftText);
        playerTop = (TextView) findViewById(R.id.playerTopText);
        playerRight = (TextView) findViewById(R.id.playerRightText);
        playerBottom = (TextView) findViewById(R.id.playerBottomText);

        //Buttons:
        resultsFromPlayer = (Button) findViewById(R.id.play);

        //Image for humanPlayer cards
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

        //Image for playerL cards
        imgHandCardPlayerL_1 = (ImageView) findViewById(R.id.handCardPlayerL_1);
        imgHandCardPlayerL_2 = (ImageView) findViewById(R.id.handCardPlayerL_2);
        imgHandCardPlayerL_3 = (ImageView) findViewById(R.id.handCardPlayerL_3);
        imgHandCardPlayerL_4 = (ImageView) findViewById(R.id.handCardPlayerL_4);
        imgHandCardPlayerL_5 = (ImageView) findViewById(R.id.handCardPlayerL_5);
        imgHandCardPlayerL_6 = (ImageView) findViewById(R.id.handCardPlayerL_6);
        imgHandCardPlayerL_7 = (ImageView) findViewById(R.id.handCardPlayerL_7);
        imgHandCardPlayerL_8 = (ImageView) findViewById(R.id.handCardPlayerL_8);
        imgHandCardPlayerL_9 = (ImageView) findViewById(R.id.handCardPlayerL_9);
        imgHandCardPlayerL_10 = (ImageView) findViewById(R.id.handCardPlayerL_10);
        imgHandCardPlayerL_11 = (ImageView) findViewById(R.id.handCardPlayerL_11);
        imgHandCardPlayerL_12 = (ImageView) findViewById(R.id.handCardPlayerL_12);

        //Image for playerT cards
        imgHandCardPlayerT_1 = (ImageView) findViewById(R.id.handCardPlayerT_1);
        imgHandCardPlayerT_2 = (ImageView) findViewById(R.id.handCardPlayerT_2);
        imgHandCardPlayerT_3 = (ImageView) findViewById(R.id.handCardPlayerT_3);
        imgHandCardPlayerT_4 = (ImageView) findViewById(R.id.handCardPlayerT_4);
        imgHandCardPlayerT_5 = (ImageView) findViewById(R.id.handCardPlayerT_5);
        imgHandCardPlayerT_6 = (ImageView) findViewById(R.id.handCardPlayerT_6);
        imgHandCardPlayerT_7 = (ImageView) findViewById(R.id.handCardPlayerT_7);
        imgHandCardPlayerT_8 = (ImageView) findViewById(R.id.handCardPlayerT_8);
        imgHandCardPlayerT_9 = (ImageView) findViewById(R.id.handCardPlayerT_9);
        imgHandCardPlayerT_10 = (ImageView) findViewById(R.id.handCardPlayerT_10);
        imgHandCardPlayerT_11 = (ImageView) findViewById(R.id.handCardPlayerT_11);
        imgHandCardPlayerT_12 = (ImageView) findViewById(R.id.handCardPlayerT_12);

        //Image for playerT cards
        imgHandCardPlayerR_1 = (ImageView) findViewById(R.id.handCardPlayerR_1);
        imgHandCardPlayerR_2 = (ImageView) findViewById(R.id.handCardPlayerR_2);
        imgHandCardPlayerR_3 = (ImageView) findViewById(R.id.handCardPlayerR_3);
        imgHandCardPlayerR_4 = (ImageView) findViewById(R.id.handCardPlayerR_4);
        imgHandCardPlayerR_5 = (ImageView) findViewById(R.id.handCardPlayerR_5);
        imgHandCardPlayerR_6 = (ImageView) findViewById(R.id.handCardPlayerR_6);
        imgHandCardPlayerR_7 = (ImageView) findViewById(R.id.handCardPlayerR_7);
        imgHandCardPlayerR_8 = (ImageView) findViewById(R.id.handCardPlayerR_8);
        imgHandCardPlayerR_9 = (ImageView) findViewById(R.id.handCardPlayerR_9);
        imgHandCardPlayerR_10 = (ImageView) findViewById(R.id.handCardPlayerR_10);
        imgHandCardPlayerR_11 = (ImageView) findViewById(R.id.handCardPlayerR_11);
        imgHandCardPlayerR_12 = (ImageView) findViewById(R.id.handCardPlayerR_12);

        //map for humanPlayer
        mapForHumanPlayer.put(imgOfTheHandCard_1, listHandCardsHumanPlayer.get(0));
        mapForHumanPlayer.put(imgOfTheHandCard_2, listHandCardsHumanPlayer.get(1));
        mapForHumanPlayer.put(imgOfTheHandCard_3, listHandCardsHumanPlayer.get(2));
        mapForHumanPlayer.put(imgOfTheHandCard_4, listHandCardsHumanPlayer.get(3));
        mapForHumanPlayer.put(imgOfTheHandCard_5, listHandCardsHumanPlayer.get(4));
        mapForHumanPlayer.put(imgOfTheHandCard_6, listHandCardsHumanPlayer.get(5));
        mapForHumanPlayer.put(imgOfTheHandCard_7, listHandCardsHumanPlayer.get(6));
        mapForHumanPlayer.put(imgOfTheHandCard_8, listHandCardsHumanPlayer.get(7));
        mapForHumanPlayer.put(imgOfTheHandCard_9, listHandCardsHumanPlayer.get(8));
        mapForHumanPlayer.put(imgOfTheHandCard_10, listHandCardsHumanPlayer.get(9));
        mapForHumanPlayer.put(imgOfTheHandCard_11, listHandCardsHumanPlayer.get(10));
        mapForHumanPlayer.put(imgOfTheHandCard_12, listHandCardsHumanPlayer.get(11));

        //Map for PlayerL
        mapForPlayerL.put(imgHandCardPlayerL_1, listHandCardsPlayerL.get(0));
        mapForPlayerL.put(imgHandCardPlayerL_2, listHandCardsPlayerL.get(1));
        mapForPlayerL.put(imgHandCardPlayerL_3, listHandCardsPlayerL.get(2));
        mapForPlayerL.put(imgHandCardPlayerL_4, listHandCardsPlayerL.get(3));
        mapForPlayerL.put(imgHandCardPlayerL_5, listHandCardsPlayerL.get(4));
        mapForPlayerL.put(imgHandCardPlayerL_6, listHandCardsPlayerL.get(5));
        mapForPlayerL.put(imgHandCardPlayerL_7, listHandCardsPlayerL.get(6));
        mapForPlayerL.put(imgHandCardPlayerL_8, listHandCardsPlayerL.get(7));
        mapForPlayerL.put(imgHandCardPlayerL_9, listHandCardsPlayerL.get(8));
        mapForPlayerL.put(imgHandCardPlayerL_10, listHandCardsPlayerL.get(9));
        mapForPlayerL.put(imgHandCardPlayerL_11, listHandCardsPlayerL.get(10));
        mapForPlayerL.put(imgHandCardPlayerL_12, listHandCardsPlayerL.get(11));

        //Map for PlayerT
        mapForPlayerT.put(imgHandCardPlayerT_1, listHandCardsPlayerT.get(0));
        mapForPlayerT.put(imgHandCardPlayerT_2, listHandCardsPlayerT.get(1));
        mapForPlayerT.put(imgHandCardPlayerT_3, listHandCardsPlayerT.get(2));
        mapForPlayerT.put(imgHandCardPlayerT_4, listHandCardsPlayerT.get(3));
        mapForPlayerT.put(imgHandCardPlayerT_5, listHandCardsPlayerT.get(4));
        mapForPlayerT.put(imgHandCardPlayerT_6, listHandCardsPlayerT.get(5));
        mapForPlayerT.put(imgHandCardPlayerT_7, listHandCardsPlayerT.get(6));
        mapForPlayerT.put(imgHandCardPlayerT_8, listHandCardsPlayerT.get(7));
        mapForPlayerT.put(imgHandCardPlayerT_9, listHandCardsPlayerT.get(8));
        mapForPlayerT.put(imgHandCardPlayerT_10, listHandCardsPlayerT.get(9));
        mapForPlayerT.put(imgHandCardPlayerT_11, listHandCardsPlayerT.get(10));
        mapForPlayerT.put(imgHandCardPlayerT_12, listHandCardsPlayerT.get(11));

        //Map for PlayerR
        mapForPlayerR.put(imgHandCardPlayerR_1, listHandCardsPlayerR.get(0));
        mapForPlayerR.put(imgHandCardPlayerR_2, listHandCardsPlayerR.get(1));
        mapForPlayerR.put(imgHandCardPlayerR_3, listHandCardsPlayerR.get(2));
        mapForPlayerR.put(imgHandCardPlayerR_4, listHandCardsPlayerR.get(3));
        mapForPlayerR.put(imgHandCardPlayerR_5, listHandCardsPlayerR.get(4));
        mapForPlayerR.put(imgHandCardPlayerR_6, listHandCardsPlayerR.get(5));
        mapForPlayerR.put(imgHandCardPlayerR_7, listHandCardsPlayerR.get(6));
        mapForPlayerR.put(imgHandCardPlayerR_8, listHandCardsPlayerR.get(7));
        mapForPlayerR.put(imgHandCardPlayerR_9, listHandCardsPlayerR.get(8));
        mapForPlayerR.put(imgHandCardPlayerR_10, listHandCardsPlayerR.get(9));
        mapForPlayerR.put(imgHandCardPlayerR_11, listHandCardsPlayerR.get(10));
        mapForPlayerR.put(imgHandCardPlayerR_12, listHandCardsPlayerR.get(11));

        playCards();

        //Initilize Cards for PlayerL
        List<ImageView> imgHandCardsPlayerL = new ArrayList<>();
        Collections.addAll(imgHandCardsPlayerL,
                imgHandCardPlayerL_1, imgHandCardPlayerL_2, imgHandCardPlayerL_3,
                imgHandCardPlayerL_4, imgHandCardPlayerL_5, imgHandCardPlayerL_6,
                imgHandCardPlayerL_7, imgHandCardPlayerL_8, imgHandCardPlayerL_9,
                imgHandCardPlayerL_10, imgHandCardPlayerL_11, imgHandCardPlayerL_12);
        for (ImageView imgCard : imgHandCardsPlayerL) {
            Card cardPlayerL = mapForPlayerL.get(imgCard);
            assert cardPlayerL != null;
            imgCard.setImageResource(cardPlayerL.getResId());
        }
        //Initilize Cards for PlayerT
        List<ImageView> imgHandCardsPlayerT = new ArrayList<>();
        Collections.addAll(imgHandCardsPlayerT,
                imgHandCardPlayerT_1, imgHandCardPlayerT_2, imgHandCardPlayerT_3,
                imgHandCardPlayerT_4, imgHandCardPlayerT_5, imgHandCardPlayerT_6,
                imgHandCardPlayerT_7, imgHandCardPlayerT_8, imgHandCardPlayerT_9,
                imgHandCardPlayerT_10, imgHandCardPlayerT_11, imgHandCardPlayerT_12);
        for (ImageView imgCard : imgHandCardsPlayerT) {
            Card cardPlayerT = mapForPlayerT.get(imgCard);
            assert cardPlayerT != null;
            imgCard.setImageResource(cardPlayerT.getResId());
        }
        //Initilize Cards for PlayerR
        List<ImageView> imgHandCardsPlayerR = new ArrayList<>();
        Collections.addAll(imgHandCardsPlayerR,
                imgHandCardPlayerR_1, imgHandCardPlayerR_2, imgHandCardPlayerR_3,
                imgHandCardPlayerR_4, imgHandCardPlayerR_5, imgHandCardPlayerR_6,
                imgHandCardPlayerR_7, imgHandCardPlayerR_8, imgHandCardPlayerR_9,
                imgHandCardPlayerR_10, imgHandCardPlayerR_11, imgHandCardPlayerR_12);
        for (ImageView imgCard : imgHandCardsPlayerR) {
            Card cardPlayerR = mapForPlayerR.get(imgCard);
            assert cardPlayerR != null;
            imgCard.setImageResource(cardPlayerR.getResId());
        }


        List<ImageView> listOfImagesFromCards = new LinkedList<>();
        Collections.addAll(listOfImagesFromCards, imgOfTheHandCard_1, imgOfTheHandCard_2, imgOfTheHandCard_3, imgOfTheHandCard_4,
                imgOfTheHandCard_5, imgOfTheHandCard_6, imgOfTheHandCard_7, imgOfTheHandCard_8, imgOfTheHandCard_9,
                imgOfTheHandCard_10, imgOfTheHandCard_11, imgOfTheHandCard_12);
        for (ImageView btnHandCard : listOfImagesFromCards) {
            Card cardHumanPlayer = mapForHumanPlayer.get(btnHandCard);
            assert  cardHumanPlayer !=null;
            btnHandCard.setImageResource(cardHumanPlayer.getResId());
            btnHandCard.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    if (gManager.getCurrentPlayer().equals(humanPlayer)) {
                        List<Card> validatedCardList = humanPlayer.checkValidityOfTheCards(stich.getAllCards());
                        if (validatedCardList.stream().anyMatch(c -> c == cardHumanPlayer)) {
                            card_bottom.setImageResource(cardHumanPlayer.getResId());
                            card_bottom.setVisibility(View.VISIBLE);
                            gManager.playerPlayedACard(humanPlayer, cardHumanPlayer);
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
        listHandCardsHumanPlayer = humanPlayer.getDeckOfPlayCards();
        listHandCardsPlayerL = playerL.getDeckOfPlayCards();
        listHandCardsPlayerT = playerT.getDeckOfPlayCards();
        listHandCardsPlayerR = playerR.getDeckOfPlayCards();
        System.out.println(listHandCardsHumanPlayer + "Die Karten vom HumnaPlayer" + humanPlayer.getGamerName());
        System.out.println(listHandCardsPlayerL + "Die Karten vom HumnaPlayer" + playerL.getGamerName());
        System.out.println(listHandCardsPlayerT + "Die Karten vom HumnaPlayer" + playerT.getGamerName());
        System.out.println(listHandCardsPlayerR + "Die Karten vom HumnaPlayer" + playerR.getGamerName());
        /*System.out.println(humanPlayer.getDeckOfPlayCards() + humanPlayer.getGamerName());
        System.out.println(playerL.getDeckOfPlayCards() + playerL.getGamerName());
        System.out.println(playerT.getDeckOfPlayCards() + playerT.getGamerName());
        System.out.println(playerR.getDeckOfPlayCards() + playerR.getGamerName());*/
    }

    private void playCards() {
        resultsFromPlayer.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                Stich stich = null;
                if (gManager.getCurrentPlayer().equals(playerL)) {
                    Card kartenWerdenAusgespieltPlayerL = playerL.bedienen();
                    card_left.setImageResource(kartenWerdenAusgespieltPlayerL.getResId());
                    card_left.setVisibility(View.VISIBLE);
                    stich = gManager.playerPlayedACard(playerL, kartenWerdenAusgespieltPlayerL);

                } else if (gManager.getCurrentPlayer().equals(playerT)) {
                    Card kartenWerdenAusgespieltPlayerT = playerT.bedienen();
                    card_top.setImageResource(kartenWerdenAusgespieltPlayerT.getResId());
                    card_top.setVisibility(View.VISIBLE);
                    stich = gManager.playerPlayedACard(playerT, kartenWerdenAusgespieltPlayerT);

                } else if (gManager.getCurrentPlayer().equals(playerR)) {
                    Card kartenWerdenAusgespieltPlayerR = playerR.bedienen();
                    card_right.setImageResource(kartenWerdenAusgespieltPlayerR.getResId());
                    card_right.setVisibility(View.VISIBLE);
                    stich = gManager.playerPlayedACard(playerR, kartenWerdenAusgespieltPlayerR);
                }

                if (stich != null && stich.complete()) {
                    Card hiddenPlayedCard_1 = stich.getCardFirst();
                    // Der Stich ist vollständig!!! alle Karten abräumen?
                    // Timer starten, zum wegräumen?
                }
            }
        });
    }
}
