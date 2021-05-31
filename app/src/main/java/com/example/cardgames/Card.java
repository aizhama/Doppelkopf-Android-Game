package com.example.cardgames;
import androidx.annotation.DrawableRes;


public class Card {
    private String cardName;
    private int id;
    private int value;
    private @DrawableRes int resId;
    private int power;
    private boolean trump;

    public enum Suits {
        KreuzDame,
        PikDame,
        HerzDame,
        KaroDame,

        KreuzBube,
        PikBube,
        HerzBube,
        KaroBube,

        KreuzAss,
        PikAss,
        HerzAss,
        KaroAss,

        KreuzKonig,
        PikKonig,
        HerzKonig,
        KaroKonig,

        KreuzZehn,
        PikZehn,
        HerzZehn,
        KaroZehn,

        KreuzNeun,
        PikNeun,
        HerzNeun,
        KaroNeun;
    }
    Suits suit;


    public Card( Suits suit, int value, @DrawableRes int  resId, int power, boolean trump) {
        this.suit = suit;
        this.cardName=suit.toString();
        this.value =value;
        this.resId=resId;
        this.power=power;
        this.trump=trump;
    }

    public String toString() {
        return cardName + getSuit();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isTrump() {
        return trump;
    }

    public void setTrump(boolean trump) {
        this.trump = trump;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }
}























































