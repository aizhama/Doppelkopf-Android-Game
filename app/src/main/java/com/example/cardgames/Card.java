package com.example.cardgames;


import android.graphics.PointF;
import android.media.Image;

import androidx.annotation.DrawableRes;


public class Card {
    private String cardName;
    private Image cardImage;
    private int id;
    private int value;
    private @DrawableRes int resId;
    private int power;
    private boolean trump;

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

    //Contructor 1
    public Card( Suits suit, int value, @DrawableRes int  resId, int power, boolean trump) {
        this.suit = suit;
        this.cardName=suit.toString();
        this.value =value;
        this.resId=resId;
        this.power=power;
        this.trump=trump;
    }

    //Contructor 2
    public Suits getSuit() {
        return suit;
    }

    //Contructor 3
    public Card (PointF location, float mX, float mY){
        mX = 1;
        mY = 1;
    }
    public int getValue() {
        int value = 0;
        switch (getSuit()) {
            case KreuzNeun:
            case PikNeun:
            case HerzNeun:
            case KaroNeun:
                value = 0;
                break;

            case KreuzBube:
            case PikBube:
            case HerzBube:
            case KaroBube:
                value = 2;
                break;

            case KreuzDame:
            case PikDame:
            case HerzDame:
            case KaroDame:
                value = 3;
                break;

            case KreuzKonig:
            case PikKonig:
            case HerzKonig:
            case KaroKonig:
                value=4;
                break;

            case KreuzZehn:
            case PikZehn:
            case HerzZehn:
            case KaroZehn:
                value = 10;
                break;

            case KreuzAss:
            case PikAss:
            case HerzAss:
            case KaroAss:
                value = 11;
                break;

            default:
                break;
        }
        return value;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
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

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    /*
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
    */
    public enum CardsPower{
    }



    public String toString() {
        return cardName + getSuit();
        //getSuit() + " " +
        //                "cardName: " +
    }

}























































