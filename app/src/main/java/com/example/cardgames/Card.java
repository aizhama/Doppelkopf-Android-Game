package com.example.cardgames;

import androidx.annotation.DrawableRes;

import java.lang.reflect.Type;


public class Card {
    private String cardName;
    private int id;
    private int value;
    private @DrawableRes
    int resId;
    private int power;
    private boolean trump;

    public enum TypesOfCards {
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

    TypesOfCards typesOfCards;

    public enum Suits {
        Kreuz,
        Pik,
        Herz,
        Karo;
    }

    Suits suit;

    public Suits getSuit() {
        if (this.getTypesOfCards().equals(TypesOfCards.KreuzAss) || this.getTypesOfCards().equals(TypesOfCards.KreuzNeun) || this.getTypesOfCards().equals(TypesOfCards.KreuzZehn) ||
                this.getTypesOfCards().equals(TypesOfCards.KreuzKonig) || this.getTypesOfCards().equals(TypesOfCards.KreuzBube) || this.getTypesOfCards().equals(TypesOfCards.KreuzDame)) {
            return Suits.Kreuz;
        }
        else if (this.getTypesOfCards().equals(TypesOfCards.PikAss) || this.getTypesOfCards().equals(TypesOfCards.PikNeun) || this.getTypesOfCards().equals(TypesOfCards.PikZehn) ||
                this.getTypesOfCards().equals(TypesOfCards.PikKonig) || this.getTypesOfCards().equals(TypesOfCards.PikBube) || this.getTypesOfCards().equals(TypesOfCards.PikDame)) {
            return Suits.Pik;
        }
        else if (this.getTypesOfCards().equals(TypesOfCards.HerzAss) || this.getTypesOfCards().equals(TypesOfCards.HerzNeun) || this.getTypesOfCards().equals(TypesOfCards.HerzZehn) ||
                this.getTypesOfCards().equals(TypesOfCards.HerzKonig) || this.getTypesOfCards().equals(TypesOfCards.HerzBube) || this.getTypesOfCards().equals(TypesOfCards.HerzDame)) {
            return Suits.Herz;
        }
        else if (this.getTypesOfCards().equals(TypesOfCards.KaroAss) || this.getTypesOfCards().equals(TypesOfCards.KaroNeun) || this.getTypesOfCards().equals(TypesOfCards.KaroZehn) ||
                this.getTypesOfCards().equals(TypesOfCards.KaroKonig) || this.getTypesOfCards().equals(TypesOfCards.KaroBube) || this.getTypesOfCards().equals(TypesOfCards.KaroDame)) {
            return Suits.Karo;
        }else{
            return null;
        }
    }

    public Card(TypesOfCards typesOfCards, Suits suit, int value, @DrawableRes int resId, int power, boolean trump, boolean fehlFarbe) {
        this.typesOfCards = typesOfCards;
        this.suit=suit;
        this.cardName = typesOfCards.toString();
        this.value = value;
        this.resId = resId;
        this.power = power;
        this.trump = trump;
    }

    public String toString() {
        return "Card{" +
                "cardName='" + cardName + '\'' +
                ", id=" + id +
                ", value=" + value +
                ", resId=" + resId +
                ", power=" + power +
                ", trump=" + trump +
                ", typesOfCards=" + typesOfCards +
                ", suit=" + suit +
                '}';
    }
    public boolean isTrump() {
        return trump;
    }

    public boolean isFehlFarbe() {
        return !isTrump();
    }

    public String getCardName() {
        return cardName;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public int getResId() {
        return resId;
    }

    public int getPower() {
        return power;
    }

    public TypesOfCards getTypesOfCards() {
        return typesOfCards;
    }
}























































