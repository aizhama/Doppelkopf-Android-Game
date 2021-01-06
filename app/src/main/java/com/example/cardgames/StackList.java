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

        Card.Suits[]values= Card.Suits.values();

        for (int i = 0; i < size; i++) {
            //deck[i] = new Card( values[i%24]);
            // is equal to

            if(i<24)
                deck[i]=new Card(values[i]);
            else
                deck[i]=new Card(values[i-24]);

        }
       // System.out.println(deck.toString());
        return deck;
    }
    public void shuffleDeck(){
        /*
        int values=0;
        for (int values= 0; values < deck.length - 1; values++) {
            int index = (int)(Math.random() * deck.length);
            //**** deck[index] = new Card(values);
            Card temp = deck[values];
            deck[values] = deck[index];
            deck[index] = temp;
        }
        */
    }

    public StackList(Card[] deck) {
        this.deck = deck;
    }

    public Card[] getDeck() {
        return deck;
    }

    /***
     *     List<Card> deckOfCards = Arrays.asList(new Card[size]);
     *     List<Card> deckOne = deckOfCards.subList(0, 12);
     *     List<Card> deckTwo = deckOfCards.subList(12, 24);
     *     List<Card> deckTree = deckOfCards.subList(24, 36);
     *     List<Card> deckFour = deckOfCards.subList(36, 46);
     *     */

    public void dealCards(Player player1, Player player2, Player player3, Player player4) {
        if(deck==null) {
            System.out.println("Erst initialisieren!");
            return;
        }
        initializeDeck();
        int count = 1;
        for (int i = 0; i < deck.length; i++) {
            if ((count > 36)) {
                player1.playCards.add(deck[i]);
            } else if (count >24) {
                player2.playCards.add(deck[i]);
            } else if (count > 12) {
                player3.playCards.add(deck[i]);
            } else if (count <= 12) {
                player4.playCards.add(deck[i]);
            } else {
                System.out.println("Die Karten sind verteilt!");
            }
            count++;
        }
    }

    /***Также было бы неплохо иметь метод сравнения карт,
     * чтобы мы могли определить, выше или ниже одна карта
     * Reihenfolge von wichtigen Karten
     * compareeTo*************
     * public boolean equalsCard(Card that){
        return this.rank == that.rank
                && this.suit == that.suit;
    }*/

}
