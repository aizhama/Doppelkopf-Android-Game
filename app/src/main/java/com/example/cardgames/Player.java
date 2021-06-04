package com.example.cardgames;

import android.os.Build;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String gamerName;
    private List<Card> deckOfPlayCards = new LinkedList<Card>();
    Card nextCard;
    Card nächsteKarte;
    private Player nextPlayer;
    private List<Stich> listeDerGesamtStiche;
    private GameManager gameManager;
    Stich stich;
    private StackList stackList;


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
                card.getCardName();
                System.out.println(card.getCardName());
            }
        }
        return deckOfPlayCards;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Card> checkValidityOfTheCards(List<Card> anzahlDerAusgespieltenKartenInDerRunde) {
        List<Card> listWithAValidCards = new ArrayList<>();
        Card ersteAusgespielteKarte = anzahlDerAusgespieltenKartenInDerRunde.get(0);

        for (Card nCard : deckOfPlayCards) {
            if (anzahlDerAusgespieltenKartenInDerRunde.size() == 0) {
                System.out.println("Es wurde bis jetzt noch keine Karte ausgespielt!");
                listWithAValidCards.add(nCard);
            } else if (anzahlDerAusgespieltenKartenInDerRunde.size() > 3) {
                System.out.println("Error: In einer Runde können maximal 4 Karten ausgespielt werden.");
            }

            if ((ersteAusgespielteKarte.isTrump()) && (nCard.isTrump())) {
                listWithAValidCards.add(nCard);

            } else if (ersteAusgespielteKarte.isFehlFarbe() && nCard.isFehlFarbe()) {
                if (ersteAusgespielteKarte.getSuit() == nCard.getSuit()) {
                    listWithAValidCards.add(nCard);
                } else {
                    // die nCard ist trotzdem gültig, wenn der die ausgespielte Farbe nicht bedienen
                    List<Card> existFehlFarbe = deckOfPlayCards.stream().filter(Card::isFehlFarbe).
                            filter(suits -> suits.getSuit() == ersteAusgespielteKarte.getSuit()).collect(Collectors.toList());
                    if (existFehlFarbe.isEmpty()) {
                        listWithAValidCards.add(nCard);
                    }
                }
            } else if ((ersteAusgespielteKarte.isTrump()) && (nCard.isFehlFarbe())) {
                List<Card> trumpf = deckOfPlayCards.stream().filter(Card::isTrump).collect(Collectors.toList());
                if (!trumpf.isEmpty()) {
                    System.out.println("Das ist gerade keine gültige Karte, weil einen Trumpf Karte ist enthalten");
                } else {
                    //wenn Spieler keinen trumpf hat, kann er beliebiger Karte auspielen
                    listWithAValidCards.add(nCard);
                }
            } else if ((ersteAusgespielteKarte.isFehlFarbe()) && (nCard.isTrump())) {
                //nicht nur fehlfarbe sein, sondern auch die Farbe soll stimmen
                List<Card> fehlfarbe = deckOfPlayCards.stream().
                        filter(Card::isFehlFarbe).
                        filter(suits -> suits.getSuit() == ersteAusgespielteKarte.getSuit()).collect(Collectors.toList());
                if (!fehlfarbe.isEmpty()) {
                    System.out.println("Das ist gerade keine gültige Karte, weil einen Fehlfarbe Karte ist enthalten");
                } else {
                    listWithAValidCards.add(nCard);
                }
            }
        }
        return listWithAValidCards;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Card bedienen() {
        List<Card> stichList = stich.getAllCards();
        List<Card> listWithAValidCards = checkValidityOfTheCards(stichList);
        //nächsteKarte=listWithAValidCards.stream().findAny().orElse(null);
        for (Card iterACard : listWithAValidCards) {
            nächsteKarte = iterACard;
        }
        return nächsteKarte;
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

