package com.example.cardgames;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class StackList {
    int size = Card.TypesOfCards.values().length * 2;
    private Card[] doppelkopfblatt;

    private ArrayList<Card>deckList= new ArrayList();

    public StackList(Card[] doppelkopfblatt) {
        this.doppelkopfblatt = doppelkopfblatt;
    }

    public List<Card> initializeDeck() {
        doppelkopfblatt = new Card[size];
        doppelkopfblatt[0]=new Card(Card.TypesOfCards.HerzZehn, Card.Suits.Herz, 10, R.drawable.herzzehn,14,true, false);
        doppelkopfblatt[1]=new Card(Card.TypesOfCards.HerzZehn, Card.Suits.Herz,10, R.drawable.herzzehn,14,true, false);

        doppelkopfblatt[2]=new Card(Card.TypesOfCards.KreuzDame, Card.Suits.Kreuz, 3, R.drawable.kreuzdame,13,true, false);
        doppelkopfblatt[3]=new Card(Card.TypesOfCards.KreuzDame, Card.Suits.Kreuz, 3, R.drawable.kreuzdame,13,true, false);

        doppelkopfblatt[4]=new Card(Card.TypesOfCards.PikDame, Card.Suits.Pik, 3, R.drawable.pikdame,12,true, false);
        doppelkopfblatt[5]=new Card(Card.TypesOfCards.PikDame, Card.Suits.Pik,3, R.drawable.pikdame,12,true, false);

        doppelkopfblatt[6]=new Card(Card.TypesOfCards.HerzDame, Card.Suits.Herz, 3, R.drawable.herzdame,11,true, false);
        doppelkopfblatt[7]=new Card(Card.TypesOfCards.HerzDame, Card.Suits.Herz, 3, R.drawable.herzdame,11,true, false);

        doppelkopfblatt[8]=new Card(Card.TypesOfCards.KaroDame, Card.Suits.Karo, 3, R.drawable.karodame,10,true, false);
        doppelkopfblatt[9]=new Card(Card.TypesOfCards.KaroDame, Card.Suits.Karo, 3, R.drawable.karodame,10,true, false);

        doppelkopfblatt[10]=new Card(Card.TypesOfCards.KreuzBube, Card.Suits.Kreuz,2, R.drawable.kreuzbube,9,true, false);
        doppelkopfblatt[11]=new Card(Card.TypesOfCards.KreuzBube, Card.Suits.Kreuz,2, R.drawable.kreuzbube,9,true, false);

        doppelkopfblatt[12]=new Card(Card.TypesOfCards.PikBube, Card.Suits.Pik, 2, R.drawable.pikbube,8,true, false);
        doppelkopfblatt[13]=new Card(Card.TypesOfCards.PikBube, Card.Suits.Pik, 2, R.drawable.pikbube,8,true, false);

        doppelkopfblatt[14]=new Card(Card.TypesOfCards.HerzBube, Card.Suits.Herz, 2, R.drawable.herzbube,7,true, false);
        doppelkopfblatt[15]=new Card(Card.TypesOfCards.HerzBube, Card.Suits.Herz, 2, R.drawable.herzbube,7,true, false);

        doppelkopfblatt[16]=new Card(Card.TypesOfCards.KaroBube, Card.Suits.Karo, 2, R.drawable.karobube,6,true, false);
        doppelkopfblatt[17]=new Card(Card.TypesOfCards.KaroBube, Card.Suits.Karo, 2, R.drawable.karobube,6,true, false);

        doppelkopfblatt[18]=new Card(Card.TypesOfCards.KaroAss, Card.Suits.Karo, 11, R.drawable.karoass,5,true, false);
        doppelkopfblatt[19]=new Card(Card.TypesOfCards.KaroAss, Card.Suits.Karo, 11, R.drawable.karoass,5,true, false);

        doppelkopfblatt[20]=new Card(Card.TypesOfCards.KaroZehn, Card.Suits.Karo, 10, R.drawable.karozehn,4,true, false);
        doppelkopfblatt[21]=new Card(Card.TypesOfCards.KaroZehn, Card.Suits.Karo, 10, R.drawable.karozehn,4,true, false);

        doppelkopfblatt[22]=new Card(Card.TypesOfCards.KaroKonig, Card.Suits.Karo, 4, R.drawable.karokonig,3,true, false);
        doppelkopfblatt[23]=new Card(Card.TypesOfCards.KaroKonig, Card.Suits.Karo, 4, R.drawable.karokonig,3,true, false);

        doppelkopfblatt[24]=new Card(Card.TypesOfCards.KaroNeun, Card.Suits.Karo, 0, R.drawable.karoneun,2,true, false);
        doppelkopfblatt[25]=new Card(Card.TypesOfCards.KaroNeun, Card.Suits.Karo, 0, R.drawable.karoneun,2,true, false);

        doppelkopfblatt[26]=new Card(Card.TypesOfCards.KreuzAss, Card.Suits.Kreuz, 11, R.drawable.kreuzass,1,false, true);
        doppelkopfblatt[27]=new Card(Card.TypesOfCards.KreuzAss, Card.Suits.Kreuz, 11, R.drawable.kreuzass,1,false, true);

        doppelkopfblatt[28]=new Card(Card.TypesOfCards.PikAss, Card.Suits.Pik, 11, R.drawable.pikass,1,false, true);
        doppelkopfblatt[29]=new Card(Card.TypesOfCards.PikAss, Card.Suits.Pik, 11, R.drawable.pikass,1,false, true);

        doppelkopfblatt[30]=new Card(Card.TypesOfCards.HerzAss, Card.Suits.Herz,11, R.drawable.herzass,1,false, true);
        doppelkopfblatt[31]=new Card(Card.TypesOfCards.HerzAss, Card.Suits.Herz,11, R.drawable.herzass,1,false, true);

        doppelkopfblatt[32]=new Card(Card.TypesOfCards.KreuzZehn, Card.Suits.Kreuz, 10, R.drawable.kreuzzehn,1,false, true);
        doppelkopfblatt[33]=new Card(Card.TypesOfCards.KreuzZehn, Card.Suits.Kreuz,10, R.drawable.kreuzzehn,1,false, true);

        doppelkopfblatt[34]=new Card(Card.TypesOfCards.PikZehn, Card.Suits.Pik,10, R.drawable.pikzehn,1,false, true);
        doppelkopfblatt[35]=new Card(Card.TypesOfCards.PikZehn, Card.Suits.Pik, 10, R.drawable.pikzehn,1,false, true);


        doppelkopfblatt[36]=new Card(Card.TypesOfCards.KreuzKonig, Card.Suits.Kreuz, 4, R.drawable.kreuzkonig,1,false, true);
        doppelkopfblatt[37]=new Card(Card.TypesOfCards.KreuzKonig, Card.Suits.Kreuz, 4, R.drawable.kreuzkonig,1,false, true);

        doppelkopfblatt[38]=new Card(Card.TypesOfCards.PikKonig, Card.Suits.Pik, 4, R.drawable.pikkonig,1,false, true);
        doppelkopfblatt[39]=new Card(Card.TypesOfCards.PikKonig, Card.Suits.Pik, 4, R.drawable.pikkonig,1,false, true);

        doppelkopfblatt[40]=new Card(Card.TypesOfCards.HerzKonig, Card.Suits.Herz, 4, R.drawable.herzkonig,1,false, true);
        doppelkopfblatt[41]=new Card(Card.TypesOfCards.HerzKonig, Card.Suits.Herz, 4, R.drawable.herzkonig,1,false, true);


        doppelkopfblatt[42]=new Card(Card.TypesOfCards.KreuzNeun, Card.Suits.Kreuz,0, R.drawable.kreuzneun,1,false, true);
        doppelkopfblatt[43]=new Card(Card.TypesOfCards.KreuzNeun, Card.Suits.Kreuz,0, R.drawable.kreuzneun,1,false, true);

        doppelkopfblatt[44]=new Card(Card.TypesOfCards.PikNeun, Card.Suits.Pik, 0, R.drawable.pikneun,1,false, true);
        doppelkopfblatt[45]=new Card(Card.TypesOfCards.PikNeun, Card.Suits.Pik, 0, R.drawable.pikneun,1,false, true);

        doppelkopfblatt[46]=new Card(Card.TypesOfCards.HerzNeun, Card.Suits.Herz, 0, R.drawable.herzneun,1,false, true);
        doppelkopfblatt[47]=new Card(Card.TypesOfCards.HerzNeun, Card.Suits.Herz, 0, R.drawable.herzneun,1,false, true);
        deckList = new ArrayList<>(Arrays.asList(doppelkopfblatt));
        return deckList;
    }



    public void kartenAufteilen(Player player1, Player player2, Player player3, Player player4) {
        if(deckList==null) {
            System.out.println("Erst initialisieren!");
            return;
        }
        initializeDeck();
        Collections.shuffle(deckList);
        int count = 1;
        for (int i = 0; i < doppelkopfblatt.length; i++) {
            if ((count > 36)) {
                player1.getDeckOfPlayCards().add(doppelkopfblatt[i]);
            } else if (count >24) {
                player2.getDeckOfPlayCards().add(doppelkopfblatt[i]);
            } else if (count > 12) {
                player3.getDeckOfPlayCards().add(doppelkopfblatt[i]);
            } else if (count <= 12) {
                player4.getDeckOfPlayCards().add(doppelkopfblatt[i]);
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
        return doppelkopfblatt;
    }

    public void setDeck(Card[] deck) {
        this.doppelkopfblatt = deck;
    }
}
