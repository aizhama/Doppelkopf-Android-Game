package com.example.cardgames;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.util.LinkedList;
import java.util.List;

public class Stich {
    private Card cardFirst;
    private Card cardSecond;
    private Card cardThird;
    private Card cardFourth;

    public List<Card> getAllCards() {
        List<Card> stichList = new LinkedList<>();
        if (getCardFirst() != null) {
            stichList.add(getCardFirst());
        } else if (getCardSecond() != null) {
            stichList.add(getCardSecond());
        } else if (getCardThird() != null) {
            stichList.add(getCardThird());
        } else if (getCardFourth() != null) {
            stichList.add(getCardFourth());
        }else{
            System.out.println("Es wurde noch keinen Karten ausgespielt");
        }
        return stichList;
    }
    public Stich(){
    }

    public int getPoints() {
        return getCardFirst().getValue() + getCardSecond().getValue() + getCardThird().getValue() + getCardFourth().getValue();
    }

    public Card getCardFirst() {
        return cardFirst;
    }

    public void setCardFirst(Card cardFirst) {
        this.cardFirst = cardFirst;
    }

    public Card getCardSecond() {
        return cardSecond;
    }

    public void setCardSecond(Card cardSecond) {
        this.cardSecond = cardSecond;
    }

    public Card getCardThird() {
        return cardThird;
    }

    public void setCardThird(Card cardThird) {
        this.cardThird = cardThird;
    }

    public Card getCardFourth() {
        return cardFourth;
    }

    public void setCardFourth(Card cardFourth) {
        this.cardFourth = cardFourth;
    }
}
