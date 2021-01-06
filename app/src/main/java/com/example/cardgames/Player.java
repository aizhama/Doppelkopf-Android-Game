package com.example.cardgames;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String gamerName;
    private int id;
    private int cardIndex=0;
    Card[] card = new Card[12];
    List<Card> playCards = new LinkedList<Card>();

    public Player(String gamerName) {
        this.gamerName = gamerName;
    }

    public List<Card> showPlayerCards() {
        for (Card card : playCards) {
            if (card != null) {
                System.out.println(card.getCardName());
            }
            //System.out.println("Player Cards: " + card);
        }
        return playCards;
    }

    public String getGamerName() {
        return gamerName;
    }

    public List<Card> getPlayCards() {
        return playCards;
    }

    //public Card getNextCard() {
    public void getNextCard() {
        Card nextCard;
        while (cardIndex < playCards.size()) {
            playCards.get(cardIndex);
            cardIndex++;
        }

        // return nextCard;
    }
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
