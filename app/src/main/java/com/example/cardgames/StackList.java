package com.example.cardgames;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class StackList {
    int size = Card.Suits.values().length * 2;
    private Card[] deck;

    public Card[] initializeDeck() {
        deck = new Card[size];
        /*
        Card.Suits[]values= Card.Suits.values();
        for (int i = 0; i < size; i++) {
            if(i<24)
                deck[i]=new Card(values[i]);
            else
                deck[i]=new Card(values[i-24]);
        }
        */
       // System.out.println(deck.toString());

        deck[0]=new Card(Card.Suits.HerzZehn,10, R.drawable.herzzehn,14,true);
        deck[1]=new Card(Card.Suits.HerzZehn,10, R.drawable.herzzehn,14,true);

        deck[2]=new Card(Card.Suits.KreuzDame,3, R.drawable.kreuzdame,13,true);
        deck[3]=new Card(Card.Suits.KreuzDame,3, R.drawable.kreuzdame,13,true);
        deck[4]=new Card(Card.Suits.PikDame,3, R.drawable.pikdame,12,true);
        deck[5]=new Card(Card.Suits.PikDame,3, R.drawable.pikdame,12,true);
        deck[6]=new Card(Card.Suits.HerzDame,3, R.drawable.herzdame,11,true);
        deck[7]=new Card(Card.Suits.HerzDame,3, R.drawable.herzdame,11,true);
        deck[8]=new Card(Card.Suits.KaroDame,3, R.drawable.karodame,10,true);
        deck[9]=new Card(Card.Suits.KaroDame,3, R.drawable.karodame,10,true);

        deck[10]=new Card(Card.Suits.KreuzBube,2, R.drawable.kreuzbube,9,true);
        deck[11]=new Card(Card.Suits.KreuzBube,2, R.drawable.kreuzbube,9,true);
        deck[12]=new Card(Card.Suits.PikBube,2, R.drawable.pikbube,8,true);
        deck[13]=new Card(Card.Suits.PikBube,2, R.drawable.pikbube,8,true);
        deck[14]=new Card(Card.Suits.HerzBube,2, R.drawable.herzbube,7,true);
        deck[15]=new Card(Card.Suits.HerzBube,2, R.drawable.herzbube,7,true);
        deck[16]=new Card(Card.Suits.KaroBube,2, R.drawable.karobube,6,true);
        deck[17]=new Card(Card.Suits.KaroBube,2, R.drawable.karobube,6,true);

        deck[18]=new Card(Card.Suits.KaroAss,11, R.drawable.karoass,5,true);
        deck[19]=new Card(Card.Suits.KaroAss,11, R.drawable.karoass,5,true);
        deck[20]=new Card(Card.Suits.KaroZehn,10, R.drawable.karozehn,4,true);
        deck[21]=new Card(Card.Suits.KaroZehn,10, R.drawable.karozehn,4,true);
        deck[22]=new Card(Card.Suits.KaroKonig,4, R.drawable.karokonig,3,true);
        deck[23]=new Card(Card.Suits.KaroKonig,4, R.drawable.karokonig,3,true);
        deck[24]=new Card(Card.Suits.KaroNeun,0, R.drawable.karoneun,2,true);
        deck[25]=new Card(Card.Suits.KaroNeun,0, R.drawable.karoneun,2,true);

        deck[26]=new Card(Card.Suits.KreuzAss,11, R.drawable.kreuzass,1,false);
        deck[27]=new Card(Card.Suits.KreuzAss,11, R.drawable.kreuzass,1,false);
        deck[28]=new Card(Card.Suits.PikAss,11, R.drawable.pikass,1,false);
        deck[29]=new Card(Card.Suits.PikAss,11, R.drawable.pikass,1,false);
        deck[30]=new Card(Card.Suits.HerzAss,11, R.drawable.herzass,1,false);
        deck[31]=new Card(Card.Suits.HerzAss,11, R.drawable.herzass,1,false);

        deck[32]=new Card(Card.Suits.KreuzZehn,10, R.drawable.kreuzzehn,1,false);
        deck[33]=new Card(Card.Suits.KreuzZehn,10, R.drawable.kreuzzehn,1,false);
        deck[34]=new Card(Card.Suits.PikZehn,10, R.drawable.pikzehn,1,false);
        deck[35]=new Card(Card.Suits.PikZehn,10, R.drawable.pikzehn,1,false);

        deck[36]=new Card(Card.Suits.KreuzKonig,4, R.drawable.kreuzkonig,1,false);
        deck[37]=new Card(Card.Suits.KreuzKonig,4, R.drawable.kreuzkonig,1,false);
        deck[38]=new Card(Card.Suits.PikKonig,4, R.drawable.pikkonig,1,false);
        deck[39]=new Card(Card.Suits.PikKonig,4, R.drawable.pikkonig,1,false);
        deck[40]=new Card(Card.Suits.HerzKonig,4, R.drawable.herzkonig,1,false);
        deck[41]=new Card(Card.Suits.HerzKonig,4, R.drawable.herzkonig,1,false);

        deck[42]=new Card(Card.Suits.KreuzNeun,0, R.drawable.kreuzneun,1,false);
        deck[43]=new Card(Card.Suits.KreuzNeun,0, R.drawable.kreuzneun,1,false);
        deck[44]=new Card(Card.Suits.PikNeun,0, R.drawable.pikneun,1,false);
        deck[45]=new Card(Card.Suits.PikNeun,0, R.drawable.pikneun,1,false);
        deck[46]=new Card(Card.Suits.HerzNeun,0, R.drawable.herzneun,1,false);
        deck[47]=new Card(Card.Suits.HerzNeun,0, R.drawable.herzneun,1,false);
        return deck;
    }

    public StackList(Card[] deck) {
        this.deck = deck;
    }
    public void dealCards(Player player1, Player player2, Player player3, Player player4) {
        if(deck==null) {
            System.out.println("Erst initialisieren!");
            return;
        }
        initializeDeck();
        int count = 1;
        for (int i = 0; i < deck.length; i++) {
            if ((count > 36)) {
                player1.getPlayCards().add(deck[i]);
            } else if (count >24) {
                player2.getPlayCards().add(deck[i]);
            } else if (count > 12) {
                player3.getPlayCards().add(deck[i]);
            } else if (count <= 12) {
                player4.getPlayCards().add(deck[i]);
            } else {
                System.out.println("Die Karten sind verteilt!");
            }
            count++;
        }
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
}
