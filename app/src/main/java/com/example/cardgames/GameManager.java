package com.example.cardgames;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GameManager {

    private Player currentPlayer;
    private Player humanPlayer;
    private Player playerL;
    private Player playerT;
    private Player playerR;
    private List<Card> listeDerStichen = new LinkedList<>();
    Stich stich = new Stich();
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Stich playerPlayedACard(Player nPlayer, Card ausgespielteKarte) {
        if (stich.getCardFirst() == null)
            stich.setCardFirst(ausgespielteKarte);
        else if (stich.getCardSecond() == null)
            stich.setCardSecond(ausgespielteKarte);
        else if (stich.getCardThird() == null)
            stich.setCardThird(ausgespielteKarte);
        else if (stich.getCardFourth() == null)
            stich.setCardFourth(ausgespielteKarte);

        if (stich.complete()) {
            Player winnerPlayer = scoreThePoints(stich);
            currentPlayer = winnerPlayer;
            currentPlayer.addAStich(stich);
            System.out.println("The Round is finished!");
        } else {
            currentPlayer = currentPlayer.getNextPlayer();
        }
        return stich;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private Player scoreThePoints(Stich nStich) {
        //ToDo: das fehlt noch!!! Wenn in eine Runde wurden zwei gleiche Karten ausgespielt, die erste Karte soll gewinnen
        //toDo: //trumpfCard= nStich.getAllCards().stream().filter(c-> c.getCardName()== trumpfCard.getCardName())

        Player nPlayer = null;
        Card trumpfCard = nStich.getAllCards().stream()
                .filter(Card::isTrump)
                .max(Comparator.comparing(Card::getPower)).get();

        Card fehlFarbe = nStich.getAllCards().stream()
                .filter(Card::isFehlFarbe)
                .max(Comparator.comparing(Card::getPower)).get();

        Card cardOfHumanPlayer = nStich.getCardFirst();
        Card cardOfPlayerL = nStich.getCardSecond();
        Card cardOfPlayerT = nStich.getCardThird();
        Card cardOfPlayerR = nStich.getCardFourth();

        //wenn erste Karte trumpf-> ermitteln größte trumpf und stich zu ihm zuweisen
        if (nStich.getCardFirst().isTrump()) {
            //wenn die Karten erstens Players auf der höchsten Karte gleich ist, dann diesen stich hat er gewonnen
            if (cardOfHumanPlayer.equals(trumpfCard)) {
                nPlayer = humanPlayer;
            } else if (cardOfPlayerL.equals(trumpfCard)) {
                nPlayer = playerL;
            } else if (cardOfPlayerT.equals(trumpfCard)) {
                nPlayer = playerT;
            } else if (cardOfPlayerR.equals(trumpfCard)) {
                nPlayer = playerR;
            }
            //wenn erste Karte farbe ist-> die größte Farbe ermitteln und ihm den stich zuweisen
        } else if (nStich.getCardFirst().isFehlFarbe() && trumpfCard == null) {
            if (cardOfHumanPlayer.equals(fehlFarbe)) {
                nPlayer = humanPlayer;
            } else if (cardOfPlayerL.equals(fehlFarbe)) {
                nPlayer = playerL;
            } else if (cardOfPlayerT.equals(fehlFarbe)) {
                nPlayer = playerT;
            } else if (cardOfPlayerR.equals(fehlFarbe)) {
                nPlayer = playerR;
            }

            //wenn in eine Farbe Runde, jemand einen Trumpf ausgespielt hat, dann soll er den Stich gewinnen
        } else if (nStich.getCardFirst().isFehlFarbe() && trumpfCard != null) {
            if (cardOfHumanPlayer.equals(trumpfCard)) {
                nPlayer = humanPlayer;
            } else if (cardOfPlayerL.equals(trumpfCard)) {
                nPlayer = playerL;
            } else if (cardOfPlayerT.equals(trumpfCard)) {
                nPlayer = playerT;
            } else if (cardOfPlayerR.equals(trumpfCard)) {
                nPlayer = playerR;
            }
        }
        if (nPlayer == null) {
            System.out.println("ERROR: This is not allowed!");
        }
        return nPlayer;
    }


    public void setListDerStichen(List<Card> listDerStichen) {
        this.listeDerStichen = listDerStichen;
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

    public Card getAusgespielteKarte() {
        return ausgespielteKarte;
    }

    public void setAusgespielteKarte(Card ausgespielteKarte) {
        this.ausgespielteKarte = ausgespielteKarte;
    }

    public List<Card> getListDerStichen() {
        return listeDerStichen;
    }

    public Stich getStich() {
        return stich;
    }

    public void setStich(Stich stich) {
        this.stich = stich;
    }
}





























