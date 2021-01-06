package com.example.cardgames;

import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    //private Player player1, player2, player3;
    private Card cardObject;
    ImageView playerone, playertwo, playertree, playerfour, card_top, card_right, card_left, card_bottom;
    ImageView handCard_1, handCard_2, handCard_3, handCard_4, handCard_5, handCard_6, handCard_7, handCard_8, handCard_9, handCard_10, handCard_11, handCard_12;
    ImageView startPlayer;
    Button start;
    List<Card> handCards;
    List<Card> nUserTop, nUserLeft, nUserRight;
    int cardIndex = 0;

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

        playGamerOne();
        playGamerTwo();
        playGamerThree();

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

    private void playGamerOne() {
        ImageView card_image = card_top;
        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardIndex > 11) {
                    card_image.setVisibility(View.INVISIBLE);
                } else {
                    Card card = nUserTop.get(cardIndex);//
                    card_image.setImageResource(card.getResId());
                }
                cardIndex++;
            }
        });

    }
/***
    private void playGamerTwo_EXAPLE() {
        ImageView card_image = card_left;

        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card c;
                Player player1= new Player("Fabian");
                List<Card> cardList = player1.getNextCard();
                if(cardList!=null){
                    card_image.setImageResource(cardList.getResId());
                }else{
                    card_image.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
 */

    private void playGamerTwo() {
        ImageView card_image = card_left;

        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardIndex > 11) {
                    card_image.setVisibility(View.INVISIBLE);
                } else {
                    Card card = nUserLeft.get(cardIndex);//
                    card_image.setImageResource(card.getResId());
                }
                cardIndex++;
            }
        });

    }
    private void playGamerThree() {
        ImageView card_image = card_right;

        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardIndex > 11) {
                    card_image.setVisibility(View.INVISIBLE);
                } else {
                    Card card = nUserRight.get(cardIndex);//
                    card_image.setImageResource(card.getResId());
                }
                cardIndex++;
            }
        });

    }

    private void startGame() {
        final int size = 48;
        Card[] deckOfCards = new Card[size];
        StackList deck = new StackList(deckOfCards);

        Player player1 = new Player("Nick");
        Player player2 = new Player("Pit");
        Player player3 = new Player("Oli");
        Player player4 = new Player("Olga");
        // Arrays.toString(deck.initializeDeck());
        deck.dealCards(player1, player2, player3, player4);
        handCards = player1.playCards;
        nUserTop = player2.playCards;
        nUserLeft = player3.playCards;
        nUserRight = player4.playCards;

        System.out.println(player1.showPlayerCards() + player1.getGamerName());
        System.out.println(player2.showPlayerCards() + player2.getGamerName());
        System.out.println(player3.showPlayerCards() + player3.getGamerName());
        System.out.println(player4.showPlayerCards() + player4.getGamerName());
    }

}