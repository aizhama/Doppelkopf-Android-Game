package com.example.cardgames;

import androidx.annotation.DrawableRes;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String gamerName;
    private int id;
    private int cardIndex = 0;
    Card[] card = new Card[12];
    private List<Card> deckOfPlayCards = new LinkedList<Card>();
    private Player nextPlayer;
    private Player nPlayer;
    private boolean isPlayed=false;
    private Card nextPlayerCard = null;
    private GameManager gameManager;


    public Player(String gamerName){
        this.gamerName=gamerName;
    }
    public Player(Player nextPlayer, List<Card> playCards) {
        this.nextPlayer = nextPlayer;
        this.deckOfPlayCards=playCards;
    }
    public Player( String gamerName, boolean isPlayed) {
        this.gamerName = gamerName;
        this.isPlayed=isPlayed;
    }
    public List<Card> showPlayerCards() {
        for (Card card : deckOfPlayCards) {
            if (card != null) {
                System.out.println(card.getCardName());
            }
        }
        return deckOfPlayCards;
    }


    //Member variable GameManager um ausgespielte Karte zu holen
    public Card getNextCard() {
        //welcher Karte wurde vorher ausgespielt--- //gameManager.getNextCard_X();
        //richtig bedienen, karte an die Hand sortieren auf aufSteigend-> wenn T_Karte-> TrumpK wenn F_K-> F_K

        //gameManager.getNextCard_X();
        if ( cardIndex > -1 && cardIndex < deckOfPlayCards.size()) {
            nextPlayerCard = deckOfPlayCards.get(cardIndex);
            cardIndex++;
            isPlayed=true;
        }
        return nextPlayerCard;
    }

    public Card getNextPlayerCard() {
        return nextPlayerCard;
    }

    public void setNextPlayerCard(Card nextPlayerCard) {
        this.nextPlayerCard = nextPlayerCard;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    public Card[] getCard() {
        return card;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }

    public List<Card> getPlayCards() {
        return deckOfPlayCards;
    }

    public void setPlayCards(List<Card> playCards) {
        this.deckOfPlayCards = playCards;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }
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
