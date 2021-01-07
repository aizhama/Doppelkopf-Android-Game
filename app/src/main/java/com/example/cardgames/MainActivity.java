package com.example.cardgames;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Player player1 = new Player("Fabs");
    private Player player2 = new Player("Aida");
    private Player player3 = new Player("Aigul");
    private Player player4 = new Player("Guljan");
    private Card cardObject;
    private boolean isOnClicked = true;
    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView handCard_1, handCard_2, handCard_3, handCard_4, handCard_5, handCard_6, handCard_7, handCard_8, handCard_9, handCard_10, handCard_11, handCard_12;
    ImageView startPlayer;

    Button start;
    List<Card> handCards;
    List<Card> nUserTop, nUserLeft, nUserRight;
    TextView resultsFirstRound, playerLeft, playerTop, playerRight;
    GameManager gManager = new GameManager(card_left, card_top, card_right, card_bottom);

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
        handCard_1 = (ImageView) findViewById(R.id.handCard_1);
        handCard_2 = (ImageView) findViewById(R.id.handCard_2);
        handCard_3 = (ImageView) findViewById(R.id.handCard_3);
        handCard_4 = (ImageView) findViewById(R.id.handCard_4);
        handCard_5 = (ImageView) findViewById(R.id.handCard_5);
        handCard_6 = (ImageView) findViewById(R.id.handCard_6);
        handCard_7 = (ImageView) findViewById(R.id.handCard_7);
        handCard_8 = (ImageView) findViewById(R.id.handCard_8);
        handCard_9 = (ImageView) findViewById(R.id.handCard_9);
        handCard_10 = (ImageView) findViewById(R.id.handCard_10);
        handCard_11 = (ImageView) findViewById(R.id.handCard_11);
        handCard_12 = (ImageView) findViewById(R.id.handCard_12);
        start = (Button) findViewById(R.id.start);
        playerLeft = (TextView) findViewById(R.id.playerLeft);
        playerTop = (TextView) findViewById(R.id.playerTop);
        playerRight = (TextView) findViewById(R.id.playerRight);



        HashMap<ImageView, Card> map = new HashMap<ImageView, Card>();
        map.put(handCard_1, handCards.get(0));
        map.put(handCard_2, handCards.get(1));
        map.put(handCard_3, handCards.get(2));
        map.put(handCard_4, handCards.get(3));
        map.put(handCard_5, handCards.get(4));
        map.put(handCard_6, handCards.get(5));
        map.put(handCard_7, handCards.get(6));
        map.put(handCard_8, handCards.get(7));
        map.put(handCard_9, handCards.get(8));
        map.put(handCard_10, handCards.get(9));
        map.put(handCard_11, handCards.get(10));
        map.put(handCard_12, handCards.get(11));
        ImageView[] playerListBtn = new ImageView[3];//List from player buttons
        playerListBtn[0] = (ImageView) findViewById(R.id.card_top);
        playerListBtn[1] = (ImageView) findViewById(R.id.card_left);
        playerListBtn[2] = (ImageView) findViewById(R.id.card_right);


        playCards();
        gManager.firstRound(card_bottom, card_top, card_left, card_right);

        List<ImageView> cardList = new LinkedList<>();
        Collections.addAll(cardList, handCard_1, handCard_2, handCard_3, handCard_4, handCard_5, handCard_6, handCard_7, handCard_8, handCard_9, handCard_10, handCard_11, handCard_12);
        for (ImageView handCard : cardList) {
            Card card = map.get(handCard);//var card hat key and value
            handCard.setImageResource(card.getResId());//zuordnung von image und suit
            //Card nUsers = new Card();
            //card_top.setImageResource(nUsers.getResId());
            handCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(card + "Image from Card++++++++++++++++++");
                    card_bottom.setImageDrawable(handCard.getDrawable());
                    handCard.setEnabled(false);
                    handCard.setVisibility(View.INVISIBLE);
                    //var card= cardList.get(imageView);
                    //onCardPlayed(card);
                }
            });
        }
    }

    private void onCardPlayed(Card card) {
    }

    private void startGame() {
        final int size = 48;
        Card[] deckOfCards = new Card[size];
        StackList deck = new StackList(deckOfCards);
        deck.dealCards(player1, player2, player3, player4);
        handCards = player1.getPlayCards();
        nUserTop = player2.getPlayCards();
        nUserLeft = player3.getPlayCards();
        nUserRight = player4.getPlayCards();

        System.out.println(player1.showPlayerCards() + player1.getGamerName());
        System.out.println(player2.showPlayerCards() + player2.getGamerName());
        System.out.println(player3.showPlayerCards() + player3.getGamerName());
        System.out.println(player4.showPlayerCards() + player4.getGamerName());
    }

    private void playCards() {
        List<ImageView> playerBtn = new LinkedList<>();
        Collections.addAll(playerBtn, card_left, card_top, card_right);
        System.out.println("PlayerBTN check!" + playerBtn);
        System.out.println("card_right check!" + card_right);
        System.out.println("card_right check!" + card_right);
        System.out.println("card_right check!" + card_right);

        for (ImageView playBtn : playerBtn) {
            if (playBtn != null) {
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.card_left:
                                Card nextCardL = player1.getNextCard();
                                if (nextCardL != null) {
                                    card_left.setImageResource(nextCardL.getResId());
                                    //gManager.PlayerPlayedACard(player1, nextCardL);

                                } else {
                                    card_left.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case R.id.card_top:
                                Card nextCardT = player2.getNextCard();
                                if (nextCardT != null) {
                                    card_top.setImageResource(nextCardT.getResId());
                                    if (v.getId() == R.id.card_top) {
                                        if (isOnClicked) {
                                            MessageBox("Spieler 3 hat schon seine Karte ausgespielt");
                                            isOnClicked = false;
                                        }
                                    }
                                } else {
                                    card_top.setVisibility(View.INVISIBLE);
                                }
                                break;
                            case R.id.card_right:
                                Card nextCardR = player3.getNextCard();
                                if (nextCardR != null) {
                                    card_right.setImageResource(nextCardR.getResId());
                                    if (v.getId() == R.id.card_right) {
                                        if (isOnClicked) {
                                            MessageBox("Spieler 4 hat schon seine Karte ausgespielt");
                                            isOnClicked = false;
                                        }
                                    }
                                } else {
                                    card_right.setVisibility(View.INVISIBLE);
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

    public void onSavedInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

    }

    private void playCardTest() {
        //boolean isCliked=false;
        ImageView card_image = card_left;
        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card nextCard = player1.getNextCard();
                if (nextCard != null) {
                    card_image.setImageResource(nextCard.getResId());
                } else {
                    card_image.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


}