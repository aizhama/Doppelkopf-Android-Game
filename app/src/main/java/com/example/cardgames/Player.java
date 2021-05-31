package com.example.cardgames;

import androidx.annotation.DrawableRes;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String gamerName;
    private List<Card> deckOfPlayCards = new LinkedList<Card>();
    Card nextCard;
    private Player nextPlayer;
    private List<Stich> listeDerGesamtStiche;
    private GameManager gameManager;
    Stich ausgespielteKarte;

    public Player(String gamerName) {
        this.gamerName = gamerName;
    }

    public Player(Player nextPlayer, List<Card> playCards) {
        this.nextPlayer = nextPlayer;
        this.deckOfPlayCards = playCards;
    }

    public List<Card> showPlayerCards() {
        for (Card card : deckOfPlayCards) {
            if (card != null) {
                System.out.println(card.getCardName());
            }
        }
        return deckOfPlayCards;
    }

    public Card getNextCard() {
        //welcher Karte wurde vorher ausgespielt
        //richtig bedienen, wenn T_Karte-> TrumpK wenn F_K-> F_K
        int indexOfCards = 0;
        Stich ausgespieltenKartenTest = gameManager.getnPlayer().ausgespielteKarte;
        System.out.println("Ausgespielten Karten" + ausgespieltenKartenTest +"Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeest");
        if (gameManager.stich.getCardFirst() != null) {

            if (gameManager.stich.getCardFirst().isTrump() == true) {
                System.out.println("Is trumpf" + gameManager.stich.getCardFirst());
                nextCard = deckOfPlayCards.get(4);
                indexOfCards++;

            } else if (gameManager.stich.getCardSecond().isTrump() == true) {
                System.out.println("Is trumpf" + gameManager.stich.getCardSecond());
                nextCard = deckOfPlayCards.get(4);
                indexOfCards++;
            }
        }
        return nextCard;
    }

    public void addAStich(Stich stich) {
        listeDerGesamtStiche.add(stich);
    }





    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public List<Card> getDeckOfPlayCards() {
        return deckOfPlayCards;
    }

    public void setDeckOfPlayCards(List<Card> deckOfPlayCards) {
        this.deckOfPlayCards = deckOfPlayCards;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public List<Stich> getListeDerGesamtStiche() {
        return listeDerGesamtStiche;
    }

    public void setListeDerGesamtStiche(List<Stich> listeDerGesamtStiche) {
        this.listeDerGesamtStiche = listeDerGesamtStiche;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}

