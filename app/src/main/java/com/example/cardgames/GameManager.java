package com.example.cardgames;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameManager {
    private String gameName;
    private boolean isOnClicked = false;
    private boolean isPlayedCard = false;
    private ImageButton start, end;
    private List<ImageView> menuButtons;
    private int countOfPoints = 0;
    HashMap<ImageView, Card> isPlayedCardsMap = new HashMap<ImageView, Card>();
    List<ImageView> playerBtn = new LinkedList<>();
    Player player = new Player("Test Player");

    ImageView key;
    private ImageView card_left;
    private ImageView card_top;
    private ImageView card_right;
    private ImageView card_bottom;

    public GameManager(ImageView card_left, ImageView card_top, ImageView card_right, ImageView card_bottom){
        this.card_left= card_left;
        this.card_top= card_top;
        this.card_right= card_right;
        this.card_bottom= card_bottom;

    }

    public int firstRound(ImageView v, ImageView v2, ImageView v3, ImageView v4) {
        isOnClicked = false;
        switch (v.getId()) {
            case R.id.card_left:
                v = card_left;
                if (v.isPressed()) {
                    countOfPoints++;
                    System.out.println("Counter from Button card_left" + v);
                    v.setImageResource(R.drawable.end);
                    isOnClicked = true;
                }
                break;

            case R.id.card_top:
                v2 = card_top;
                //if (key.equals(R.id.card_top)) {
                if (v2.isPressed()) {
                    countOfPoints++;
                    System.out.println("Counter from Button card_top" + v2);
                    v2.setImageResource(R.drawable.end);
                    isOnClicked = true;
                }
                //}
                break;

            case R.id.card_right:
                v3 = card_right;
                //if (key.equals(R.id.card_right)) {
                if (v3.isPressed()) {
                    countOfPoints++;
                    System.out.println("Counter from Button card_right" + v3);
                    v3.setImageResource(R.drawable.end);
                    isOnClicked = true;
                }
                break;

            case R.id.card_bottom:
                v4 = card_bottom;
                //if (key.equals(R.id.card_right)) {
                if (v4.isPressed()) {
                    countOfPoints++;
                    System.out.println("Counter from Button card_right" + v4);
                    v4.setImageResource(R.drawable.end);
                    isOnClicked = true;
                }
                if (countOfPoints == 4) {

                    System.out.println("First Round is finished!");

                    //onPuase()

                    //score count
                    //message player winn
                    //write in hashmaps the isPlayed card with key playerName and value cardValue
                    //butons activate(){}
                    //}
                }
                break;
        }
        return countOfPoints;
    }

    public boolean isOnClicked() {
        return isOnClicked;
    }

    public void setOnClicked(boolean onClicked) {
        isOnClicked = onClicked;
    }

    public int getCountOfPoints() {
        return countOfPoints;
    }

    public void setCountOfPoints(int countOfPoints) {
        this.countOfPoints = countOfPoints;
    }
}


/***
 * public int getCardCount()
 * dealerScoreCount
 * findGewinner(){}
 * void updateScores(){}
 * public boolean playTurn(Player p1, Card c){}
 * public boolean isTurnOf(Player p)
 * public boolean isGameOver()
 * public Player[] getWinners()
 *
 final int calculateScore() {
 int score = hand.stream().mapToInt(card -> card.getRank().getValue()).sum();
 return score > WINNING_NUMBER && containsAce() ?
 score - 10 : //Takes care of ace being either 1 or 11
 score;
 }
 */




























