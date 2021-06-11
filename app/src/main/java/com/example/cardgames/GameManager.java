package com.example.cardgames;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
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
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class GameManager {

    private Player nPlayer;
    private Player currentPlayer;
    private Player humanPlayer;
    private Player playerL;
    private Player playerT;
    private Player playerR;
    private Player winPLayer;

    private List<Card> listDerStichen = new LinkedList<>();
    Stich stich= new Stich();
    private Card ausgespielteKarte;


    public GameManager(@NonNull Player humanPlayer, @NonNull Player player2, @NonNull Player player3, @NonNull Player player4) {
        this.humanPlayer = humanPlayer;
        this.playerL = player2;
        this.playerT = player3;
        this.playerR = player4;

        currentPlayer = this.humanPlayer;

        humanPlayer.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player4);
        player4.setNextPlayer(humanPlayer);
    }

    public Stich playerPlayedACard(Player nPlayer, Card ausgespielteKarte) {
        //mit Konstruktor ist festgelegt, dass ein spieler immer auf nächste zeigt
        //currentReference ist zeiger immer auf den gerade spielte Spieler
        //mit currentSpieler prüfen ob ist ein Player jetzt dran
        //im Ui prüfen ob gerade(currentPLayer ist dran) ->nur currentPlayer darf in der Zeit zu clicken
        //in classe Stich wenn 4 wurde ausgespielt packen
        //und zu dem wer hat die gr0ßte Karte ausgespielt hinzufügen

        if (stich.getCardFirst() != null)
            stich.setCardFirst(ausgespielteKarte);
        else if (stich.getCardSecond() != null)
            stich.setCardSecond(ausgespielteKarte);
        else if (stich.getCardThird() != null)
            stich.setCardThird(ausgespielteKarte);
        else if (stich.getCardFourth() != null) {
            stich.setCardFourth(ausgespielteKarte);
            winPLayer.addAStich(stich);
            System.out.println("The Round is finished!");
        }

        //soreThePoints();
        //sout("wer hat den Stich gwonnen!)
        //denStichinPlayerPointsTableEintragen();
        return stich;
    }

    public void notifyplayedCardToOtherPlayersTest(Card ausgespielteKarte) {
            System.out.println("TypeOfCards :" + ausgespielteKarte.getTypesOfCards() + ausgespielteKarte.getSuit() + "Suit :" + " ");
    }

    public void setListDerStichen(List<Card> listDerStichen) {
        this.listDerStichen = listDerStichen;
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

    public Player getPlayerL() {
        return playerL;
    }

    public void setPlayerL(Player playerL) {
        this.playerL = playerL;
    }

    public Player getPlayerT() {
        return playerT;
    }

    public void setPlayerT(Player playerT) {
        this.playerT = playerT;
    }

    public Player getPlayerR() {
        return playerR;
    }

    public void setPlayerR(Player playerR) {
        this.playerR = playerR;
    }

    public Player getWinPLayer() {
        return winPLayer;
    }

    public void setWinPLayer(Player winPLayer) {
        this.winPLayer = winPLayer;
    }

    public Card getAusgespielteKarte() {
        return ausgespielteKarte;
    }

    public void setAusgespielteKarte(Card ausgespielteKarte) {
        this.ausgespielteKarte = ausgespielteKarte;
    }

    public List<Card> getListDerStichen() {
        return listDerStichen;
    }

    public Stich getStich() {
        return stich;
    }

    public void setStich(Stich stich) {
        this.stich = stich;
    }
}





























