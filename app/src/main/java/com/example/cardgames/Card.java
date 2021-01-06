package com.example.cardgames;


import android.graphics.PointF;
import android.media.Image;

import androidx.annotation.DrawableRes;


public class Card {
    private String cardName;
    private Image cardImage;
    private int id;
    private PointF location;
    private float mX;
    private float mY;
    private boolean isUp;
    private boolean isInvisible;
    private static final int STATE_FACED_DOWN = 0;
    public static final int STATE_FACED_UP = 1;
    public static final int STATE_INVISIBLE = 2;

    public Card() {

    }

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

    Suits suit;     //varible suit

    //Contructor
    public Card( Suits suit) {

        this.suit = suit;
        this.cardName=suit.toString();
    }

    //Contructor
    public Suits getSuit() {
        return suit;
    }

    //Contructor
    public Card (PointF location, float mX, float mY){
        mX = 1;
        mY = 1;
    }

    public String getCardName() {
        return cardName;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        int value = 0;
        switch (getSuit()) {
            case KreuzDame:
            case PikDame:
            case HerzDame:
            case KaroDame:
                value = 3;
                break;
            case KreuzBube:
            case PikBube:
            case HerzBube:
            case KaroBube:
                value = 2;
                break;
            case KreuzAss:
            case PikAss:
            case HerzAss:
            case KaroAss:
                value = 11;
                break;
            case KreuzZehn:
            case PikZehn:
            case HerzZehn:
            case KaroZehn:
                value = 10;
                break;
            case KreuzKonig:
            case PikKonig:
            case HerzKonig:
            case KaroKonig:
                value=4;
                break;
            case KreuzNeun:
            case PikNeun:
            case HerzNeun:
            case KaroNeun:
                value = 0;
                break;
            default:
                break;
        }
        return value;
    }

    public @DrawableRes int getResId() {
        switch (getSuit()){
            case KreuzDame:
                return R.drawable.kreuzdame;
            case PikDame:
                return R.drawable.pikdame;
            case HerzDame:
                return R.drawable.herzdame;
            case KaroDame:
                return R.drawable.karodame;
            case KreuzBube:
                return R.drawable.kreuzbube;
            case PikBube:
                return R.drawable.pikbube;
            case HerzBube:
                return R.drawable.herzbube;
            case KaroBube:
                return R.drawable.karobube;
            case KreuzAss:
                return R.drawable.kreuzass;
            case PikAss:
                return R.drawable.pikass;
            case HerzAss:
                return R.drawable.herzass;
            case KaroAss:
                return R.drawable.karoass;
            case KreuzZehn:
                return R.drawable.kreuzzehn;
            case PikZehn:
                return R.drawable.pikzehn;
            case HerzZehn:
                return R.drawable.herzzehn;
            case KaroZehn:
                return R.drawable.karozehn;
            case KreuzKonig:
                return R.drawable.kreuzkonig;
            case PikKonig:
                return R.drawable.pikkonig;
            case HerzKonig:
                return R.drawable.herzkonig;
            case KaroKonig:
                return R.drawable.karokonig;
            case KreuzNeun:
                return R.drawable.kreuzneun;
            case PikNeun:
                return R.drawable.pikneun;
            case HerzNeun:
                return R.drawable.herzneun;
            case KaroNeun:
                return R.drawable.karoneun;
        }

        System.out.println("ERROR: This should never happen!");
        return R.drawable.end;
    }
    public void setLocation(float x, float y){
        mX= x;
        mY=y;
    }

    public String toString() {
        return cardName + getSuit();
        //getSuit() + " " +
        //                "cardName: " +
    }
}























































