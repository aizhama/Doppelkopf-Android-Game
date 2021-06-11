/*
package com.example.cardgames;

import java.util.Comparator;
import java.util.function.Consumer;

import javax.xml.xpath.XPathExpression;

public class LambdaAndStream {
    public static void main(String[] args) {
        Comparator<Player> byName = new Comparator<Player>() {
            public int compare(Player pl1, Player pl2) {
                return pl1.getGamerName().compareTo(pl2.getGamerName());
            }
        };

        //mit Lambda es wird auch in eine var vergleicht, aber ohne anonyme Klasse-> anstatt mit lambda expression
        Comparator<Player> comparePlayer = (Player pl1, Player pl2) -> {
            return pl1.getGamerName().compareTo(pl2.getGamerName());
        };

        //1. mit lambda ohne Parameter Types
        Comparator<Player> comparePlayer2 = (pl1, pl2) -> {
            return pl1.getGamerName().compareTo(pl2.getGamerName());
        };

        //2. REMOVING BRACES!!! and 'return'
                // wenn es soll ohne geschweifte Klammern
                    // -> dann return soll auch weg!
        Comparator<Player> comparePlayer3 = (player1, player2) ->
                player1.getGamerName().compareTo(player2.getGamerName());

        //3. expression with no parameters
        Runnable r= ()-> {System.out.println("ohne parametern");};
        Thread thread1= new Thread(r);

        //4. NO NEED TO EVEN MENTION RUNNABLE
        Thread thread2= new Thread(() -> {System.out.println("ohne parametern");});

        //5. NO NEED BRACES HIER
        Thread thread3= new Thread(()-> System.out.println("...."));

        //6. expression with one Parameter
        Consumer<String> lengthPrinter=s->{ System.out.println(s.length()); };


        //TYPE INFERENCE AND ITS LIMITS
        //THE RECEIVING CONTEXT OF A LAMBDA EXPRESSION
        //THE FORMAL PARAMETERS OF A LAMBDA XPathExpression
        //Was ist TYPE INFERENCE?






































    }

}
*/
