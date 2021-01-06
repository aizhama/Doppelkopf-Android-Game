package com.example.cardgames;

public class CardFunction {
    /***
     * deal card()
     * public int getCardCount()
     * shuffleCard()
     * public void sortCard()
     * public int giveCard()
     * showHand()
     * flipCards()
     */
    Card[] cards= new Card[48];

    public String showHand() {
        //show cars and their totol points, but only show total points
        //if all cards are face up
        boolean allFaceUp =true;
        String str = "";
        for (Card c : cards) {
            str += c.toString() + "\n";
        }
        return str;
    }

    public void flipCards() {
    }
}

