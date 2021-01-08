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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameManager {
    private boolean isClicked = false;
    private int cardCounter = 0;
    private Card nextCard_X;
    private int countOfPoints = 0;
    private Player nPlayer;
    private Player currentPlayer;
    private Player humanPlayer;
    private Player player2;
    private Player player3;
    private Player player4;
    HashMap<ImageView, Card> isPlayedCardsMap = new HashMap<ImageView, Card>();

    public GameManager(@NonNull Player humanPlayer, @NonNull Player player2, @NonNull Player player3, @NonNull Player player4) {
        this.humanPlayer = humanPlayer;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;

        currentPlayer = this.humanPlayer;
        humanPlayer.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player4);
        player4.setNextPlayer(humanPlayer);


    }

    public void playerPlayedACard(Player nPlayer, Card nextCard_X) {
        //mit Konstruktor ist festgelegt, dass ein spieler immer auf nächste zeigt
        //currentReference ist zeiger immer auf den gerade spielte Spieler
        //mit currentSpieler prüfen ob ist ein Player jetzt dran

        //im Ui prüfen ob gerade(currentPLayer ist dran) ->nur currentPlayer darf in der Zeit zu clicken

        cardCounter++;
        if (cardCounter > 3) {
            System.out.println("The Round is finished!");
        }
        //soreThePoints();
        //sout("wer hat den Stich gwonnen!)
        //denStichinPlayerPointsTableEintragen();
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public int getCardCounter() {
        return cardCounter;
    }

    public void setCardCounter(int cardCounter) {
        this.cardCounter = cardCounter;
    }

    public Card getNextCard_X() {
        return nextCard_X;
    }

    public void setNextCard_X(Card nextCard_X) {
        this.nextCard_X = nextCard_X;
    }

    public int getCountOfPoints() {
        return countOfPoints;
    }

    public void setCountOfPoints(int countOfPoints) {
        this.countOfPoints = countOfPoints;
    }

    public Player getnPlayer() {
        return nPlayer;
    }

    public void setnPlayer(Player nPlayer) {
        this.nPlayer = nPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(Player humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public HashMap<ImageView, Card> getIsPlayedCardsMap() {
        return isPlayedCardsMap;
    }

    public void setIsPlayedCardsMap(HashMap<ImageView, Card> isPlayedCardsMap) {
        this.isPlayedCardsMap = isPlayedCardsMap;
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




























