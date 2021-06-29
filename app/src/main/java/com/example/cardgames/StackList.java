package com.example.cardgames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StackList {
    private Card[] doppelkopfblatt;
    private List<Card>deckList= new ArrayList();

    public StackList(List<Card>deckList) {
        this.deckList = deckList;
    }

    public List<Card> initializeDeck() {
        doppelkopfblatt = new Card[48];

        // TRÜMPFE
        doppelkopfblatt[0]=new Card(Card.TypesOfCards.HerzZehn, Card.Suits.Herz, 10, R.drawable.herzzehn,17,true);
        doppelkopfblatt[1]=new Card(Card.TypesOfCards.HerzZehn, Card.Suits.Herz,10, R.drawable.herzzehn,17,true);

        doppelkopfblatt[2]=new Card(Card.TypesOfCards.KreuzDame, Card.Suits.Kreuz, 3, R.drawable.kreuzdame,16,true);
        doppelkopfblatt[3]=new Card(Card.TypesOfCards.KreuzDame, Card.Suits.Kreuz, 3, R.drawable.kreuzdame,16,true);

        doppelkopfblatt[4]=new Card(Card.TypesOfCards.PikDame, Card.Suits.Pik, 3, R.drawable.pikdame,15,true);
        doppelkopfblatt[5]=new Card(Card.TypesOfCards.PikDame, Card.Suits.Pik,3, R.drawable.pikdame,15,true);

        doppelkopfblatt[6]=new Card(Card.TypesOfCards.HerzDame, Card.Suits.Herz, 3, R.drawable.herzdame,14,true);
        doppelkopfblatt[7]=new Card(Card.TypesOfCards.HerzDame, Card.Suits.Herz, 3, R.drawable.herzdame,14,true);

        doppelkopfblatt[8]=new Card(Card.TypesOfCards.KaroDame, Card.Suits.Karo, 3, R.drawable.karodame,13,true);
        doppelkopfblatt[9]=new Card(Card.TypesOfCards.KaroDame, Card.Suits.Karo, 3, R.drawable.karodame,13,true);

        doppelkopfblatt[10]=new Card(Card.TypesOfCards.KreuzBube, Card.Suits.Kreuz,2, R.drawable.kreuzbube,12,true);
        doppelkopfblatt[11]=new Card(Card.TypesOfCards.KreuzBube, Card.Suits.Kreuz,2, R.drawable.kreuzbube,12,true);

        doppelkopfblatt[12]=new Card(Card.TypesOfCards.PikBube, Card.Suits.Pik, 2, R.drawable.pikbube,11,true);
        doppelkopfblatt[13]=new Card(Card.TypesOfCards.PikBube, Card.Suits.Pik, 2, R.drawable.pikbube,11,true);

        doppelkopfblatt[14]=new Card(Card.TypesOfCards.HerzBube, Card.Suits.Herz, 2, R.drawable.herzbube,10,true);
        doppelkopfblatt[15]=new Card(Card.TypesOfCards.HerzBube, Card.Suits.Herz, 2, R.drawable.herzbube,10,true);

        doppelkopfblatt[16]=new Card(Card.TypesOfCards.KaroBube, Card.Suits.Karo, 2, R.drawable.karobube,9,true);
        doppelkopfblatt[17]=new Card(Card.TypesOfCards.KaroBube, Card.Suits.Karo, 2, R.drawable.karobube,9,true);

        doppelkopfblatt[18]=new Card(Card.TypesOfCards.KaroAss, Card.Suits.Karo, 11, R.drawable.karoass,8,true);
        doppelkopfblatt[19]=new Card(Card.TypesOfCards.KaroAss, Card.Suits.Karo, 11, R.drawable.karoass,8,true);

        doppelkopfblatt[20]=new Card(Card.TypesOfCards.KaroZehn, Card.Suits.Karo, 10, R.drawable.karozehn,7,true);
        doppelkopfblatt[21]=new Card(Card.TypesOfCards.KaroZehn, Card.Suits.Karo, 10, R.drawable.karozehn,7,true);

        doppelkopfblatt[22]=new Card(Card.TypesOfCards.KaroKonig, Card.Suits.Karo, 4, R.drawable.karokonig,6,true);
        doppelkopfblatt[23]=new Card(Card.TypesOfCards.KaroKonig, Card.Suits.Karo, 4, R.drawable.karokonig,6,true);

        doppelkopfblatt[24]=new Card(Card.TypesOfCards.KaroNeun, Card.Suits.Karo, 0, R.drawable.karoneun,5,true);
        doppelkopfblatt[25]=new Card(Card.TypesOfCards.KaroNeun, Card.Suits.Karo, 0, R.drawable.karoneun,5,true);

        // FARBEN:
        doppelkopfblatt[26]=new Card(Card.TypesOfCards.KreuzAss, Card.Suits.Kreuz, 11, R.drawable.kreuzass,4,false);
        doppelkopfblatt[27]=new Card(Card.TypesOfCards.KreuzAss, Card.Suits.Kreuz, 11, R.drawable.kreuzass,4,false);

        doppelkopfblatt[28]=new Card(Card.TypesOfCards.PikAss, Card.Suits.Pik, 11, R.drawable.pikass,4,false);
        doppelkopfblatt[29]=new Card(Card.TypesOfCards.PikAss, Card.Suits.Pik, 11, R.drawable.pikass,4,false);

        doppelkopfblatt[30]=new Card(Card.TypesOfCards.HerzAss, Card.Suits.Herz,11, R.drawable.herzass,4,false);
        doppelkopfblatt[31]=new Card(Card.TypesOfCards.HerzAss, Card.Suits.Herz,11, R.drawable.herzass,4,false);

        doppelkopfblatt[32]=new Card(Card.TypesOfCards.KreuzZehn, Card.Suits.Kreuz, 10, R.drawable.kreuzzehn,3,false);
        doppelkopfblatt[33]=new Card(Card.TypesOfCards.KreuzZehn, Card.Suits.Kreuz,10, R.drawable.kreuzzehn,3,false);

        doppelkopfblatt[34]=new Card(Card.TypesOfCards.PikZehn, Card.Suits.Pik,10, R.drawable.pikzehn,3,false);
        doppelkopfblatt[35]=new Card(Card.TypesOfCards.PikZehn, Card.Suits.Pik, 10, R.drawable.pikzehn,3,false);


        doppelkopfblatt[36]=new Card(Card.TypesOfCards.KreuzKonig, Card.Suits.Kreuz, 4, R.drawable.kreuzkonig,2,false);
        doppelkopfblatt[37]=new Card(Card.TypesOfCards.KreuzKonig, Card.Suits.Kreuz, 4, R.drawable.kreuzkonig,2,false);

        doppelkopfblatt[38]=new Card(Card.TypesOfCards.PikKonig, Card.Suits.Pik, 4, R.drawable.pikkonig,2,false);
        doppelkopfblatt[39]=new Card(Card.TypesOfCards.PikKonig, Card.Suits.Pik, 4, R.drawable.pikkonig,2,false);

        doppelkopfblatt[40]=new Card(Card.TypesOfCards.HerzKonig, Card.Suits.Herz, 4, R.drawable.herzkonig,2,false);
        doppelkopfblatt[41]=new Card(Card.TypesOfCards.HerzKonig, Card.Suits.Herz, 4, R.drawable.herzkonig,2,false);


        doppelkopfblatt[42]=new Card(Card.TypesOfCards.KreuzNeun, Card.Suits.Kreuz,0, R.drawable.kreuzneun,1,false);
        doppelkopfblatt[43]=new Card(Card.TypesOfCards.KreuzNeun, Card.Suits.Kreuz,0, R.drawable.kreuzneun,1,false);

        doppelkopfblatt[44]=new Card(Card.TypesOfCards.PikNeun, Card.Suits.Pik, 0, R.drawable.pikneun,1,false);
        doppelkopfblatt[45]=new Card(Card.TypesOfCards.PikNeun, Card.Suits.Pik, 0, R.drawable.pikneun,1,false);

        doppelkopfblatt[46]=new Card(Card.TypesOfCards.HerzNeun, Card.Suits.Herz, 0, R.drawable.herzneun,1,false);
        doppelkopfblatt[47]=new Card(Card.TypesOfCards.HerzNeun, Card.Suits.Herz, 0, R.drawable.herzneun,1,false);
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
        for (int i = 0; i < deckList.size(); i++) {
            if (count <= 12) {
                player1.getDeckOfPlayCards().add(deckList.get(i));
            } else if (count > 12 && count <= 24) {
                player2.getDeckOfPlayCards().add(deckList.get(i));
            } else if (count > 24 && count <= 36) {
                player3.getDeckOfPlayCards().add(deckList.get(i));
            } else if (count > 36 && count <= 48) {
                player4.getDeckOfPlayCards().add(deckList.get(i));
            } else {
                System.out.println("Die Karten sind verteilt!");
            }
            count++;
            //ToDo: prüfen ob jeder Player hat 12 Karten
            //ToDo: Die Karten nach richtigen Reihelfolge anzeigen, also sortiert anzeigen

            boolean hasCard=false;
            if(player1.completeDeckOfPlayCards() && player2.completeDeckOfPlayCards() && player3.completeDeckOfPlayCards() && player4.completeDeckOfPlayCards()){
                hasCard=true;
                System.out.println("Jeder spieler hat 12 Karten bekommen");
            }else{
                hasCard=false;
                System.out.println("Die Spielerkarten wurden wahrscheinlich nicht vollständig geteilt!");
            }
        }
    }
}
