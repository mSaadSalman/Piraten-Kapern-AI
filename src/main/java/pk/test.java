package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    private static final Logger logger = LogManager.getLogger(test.class);
    
    public void main(String p1,String p2, String tracings) {
        //System.out.println(p1);
        int score1=0;
        int score2=0;
        int counter=0;
        double wins1=0;
        double wins2=0;
        double draw=0;
        int total_cards= 35;
        int games=42;
        int score_val= 6000;
        winings win = new winings();


        for (int j=0;j<=games-1; j++) {
            score1 = 0;
            score2 = 0;
            int total_score1=0;
            int total_score2=0;
            ArrayList<fort_card> new_cards = new ArrayList();
            Cards fort= new Cards();
            new_cards= fort.run2();
            if (tracings.equals("trace")){logger.trace("-------------NEW GAME---------------------");}

            while (total_score1 < score_val & total_score2 < score_val) {
                rollings dice_roll= new rollings();
                player_score points = new player_score();

                if (tracings.equals("trace")){logger.trace("");}
                if (tracings.equals("trace")){logger.trace("Player 1 rolling....");}
                fort_card card = fort.typeofcard(new_cards,counter);
                if (tracings.equals("trace")){logger.trace("Player 1 card type: "+card);}
                if (p1.equals("random")){
                    Players.p1 = dice_roll.roll_one();
                }
                else {
                    if (card==fort_card.SEA2|card==fort_card.SEA3|card==fort_card.SEA4) {
                        Players.p1 = dice_roll.card_strat(card,tracings);
                    }
                    else{
                        Players.p1 = dice_roll.smart_roll(card,tracings);
                    }
                }
                //System.out.println("card 1: "+card);
                //System.out.println("Player 1 dices: "+Players.p1);
                if (tracings.equals("trace")){logger.trace("Player 1 final dices rolled plus ordered: "+Players.p1);}
                if (tracings.equals("trace")){logger.trace("Player 2 rolling ....");}

                counter++;
                if (counter>=total_cards){
                    counter=0;
                }

                fort_card card2 = fort.typeofcard(new_cards,counter);
                counter++;
                if (counter>=total_cards){
                    counter=0;
                }
                if (tracings.equals("trace")){logger.trace("Player 2 card type: "+card2);}

                if (p2.equals("random")){
                    Players.p2 = dice_roll.roll_one();
                }
                else{
                    if (card2==fort_card.SEA2|card2==fort_card.SEA3|card2==fort_card.SEA4) {
                        Players.p2 = dice_roll.card_strat(card2,tracings);
                    }
                    else{
                        Players.p2 = dice_roll.smart_roll(card2,tracings);
                    }
                }
                if (tracings.equals("trace")){logger.trace("Player 2 final dices rolled + ordered: "+Players.p2);}
                //System.out.println("cards of 2: "+card2);
                //System.out.println("Player 2 dices: "+Players.p2);

                score1= points.score(Players.p1,card);
                score2= points.score(Players.p2,card2);
                total_score1=total_score1+score1;
                total_score2=total_score2+score2;
                if (tracings.equals("trace")){logger.trace("Current round score of P1: " + score1);}
                if (tracings.equals("trace")){logger.trace("Current round score of P2:" + score2);}
                if (tracings.equals("trace")){logger.trace("");}
                score1=0;
                score2=0;


                if (total_score1 >= score_val & total_score1> total_score2) {
                    if (tracings.equals("trace")){logger.trace("Player 1 Won!");}
                    wins1=wins1+1;
                }
                if (total_score2 >= score_val & total_score2> total_score1) {
                    if (tracings.equals("trace")){logger.trace("Player 2 Won!");}
                    wins2=wins2+1;
                }
                else if (total_score1 >= score_val & total_score2 >= score_val & total_score1==total_score2){
                    if (tracings.equals("trace")){logger.trace("Draw");}
                    draw++;
                }
            }
            //System.out.println("Player 1 total score: "+total_score1);
            //System.out.println("Player 2 total socre: "+ total_score2);
            if (tracings.equals("trace")){
                logger.trace("Player 1's final score for this round: " + total_score1);
                logger.trace("Player 2's final score for this round: " + total_score2);
                System.out.println();
            }
            counter=0;

        }
        win.total_win(wins1,wins2,games,draw);


        /*rollings dice_roll= new rollings();
        player_score points = new player_score();
        ArrayList<Faces> new_cards = new ArrayList();
        new_cards=dice_roll.smart_roll(fort_card.MONKS);

        System.out.println("FINALLllllllll"+new_cards);
        int score= points.score(new_cards,fort_card.MONKS);
        System.out.println("SCOREEEEE: "+score);*/



    }
}
