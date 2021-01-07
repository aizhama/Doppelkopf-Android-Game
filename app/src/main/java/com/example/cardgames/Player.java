package com.example.cardgames;

import androidx.annotation.DrawableRes;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String gamerName;
    private int id;
    private int cardIndex = 0;
    Card[] card = new Card[12];
    private List<Card> playCards = new LinkedList<Card>();

    public Player(String gamerName) {
        this.gamerName = gamerName;
    }

    public List<Card> showPlayerCards() {
        for (Card card : playCards) {
            if (card != null) {
                System.out.println(card.getCardName());
            }
        }
        return playCards;
    }

    public List<Card> getPlayCards() {
        return playCards;
    }

    public Card getNextCard() {
        Card nextCard = null;
        if ( cardIndex >-1 && cardIndex <= 12 && cardIndex < playCards.size()) {
            nextCard = playCards.get(cardIndex);
            cardIndex++;    //so index nur bis bereich size wird hoch gezählt
        }
        return nextCard;
    }
    public String getGamerName() {
        return gamerName;
    }
    public int getCardIndex(){
        return cardIndex;
    }
/***
    public @DrawableRes int dealScoreCount(Player card1, Player card2, Player card3 , Player card4){
        //po cahsovoi strelke go
        //stop wenn alle ein Mal karte geworfen haben
        //berechnen > with switch cards from players to compare
        // use getsuit() find
        int returnValue=0;
        Card cardValue;
        switch (cardValue.getValue())

        }

        return returnValue;
    }
 */

    /***
     * getCardCount(){}
     * sortCard(){}
     */


}


/***
 * sortCard(){
 * unterscheiden();
 * return sortedKarte;
 * }
 *
 * bedienen(){
 * sortCard();
 * unterscheiden();
 * checkChance();
 * findPair();
 * return
 * stichen( die kleinste F or T);
 * }
 *
 *
 * getCard(){
 * entscheidenObKarteBehältenWill();
 * return ------
 * }
 *
 * findPair(){}
 *
 *
 * gameEnd(){}
 *
 *
 * showCards(){}
 *
 *
 * getValueOfHands(int){}
 *
 */
