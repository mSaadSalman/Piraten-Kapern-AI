package pk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class player_score {

    private static final Logger logger = LogManager.getLogger(test.class);

    public static int score(ArrayList <Faces> dices, fort_card card_type){
        int monkey_counter=0;
        int parrot_counter=0;
        int saber_counter=0;
        int gold_counter=0;
        int diamond_counter=0;
        int special_counter=0;
        int counter =1;
        int num =0;

        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i) == Faces.GOLD | dices.get(i) == Faces.DIAMOND) {
                num += 100;
            }
            if (dices.get(i)==Faces.MONKEY){
                monkey_counter++;
            }
            if (dices.get(i)==Faces.PARROT){
                parrot_counter++;
            }
            if (dices.get(i)==Faces.SABER){
                saber_counter++;
            }
            if (dices.get(i)==Faces.GOLD){
                gold_counter++;
            }
            if (dices.get(i)==Faces.DIAMOND){
                diamond_counter++;
            }
        }


        for (int j=3; j<=8;j++) {
            if(card_type==fort_card.MONKS){
                special_counter= monkey_counter+parrot_counter;
                if (special_counter == j){
                    if (j==3|j==4){
                        num=num+((j*100)-200);
                    }
                    else{
                        num=num+(500*counter);
                    }
                }
            }
            else{
                if (monkey_counter == j){
                    if (j==3|j==4){
                        num=num+((j*100)-200);
                    }
                    else{
                        num=num+(500*counter);
                    }
                }
                if (parrot_counter == j){
                    if (j==3|j==4){
                        num=num+((j*100)-200);
                    }
                    else{
                        num=num+(500*counter);
                    }
                }
            }

            if (saber_counter == j){
                if (j==3|j==4){
                    num=num+((j*100)-200);
                }
                else{
                    num=num+(500*counter);
                }
            }
            if (gold_counter == j){
                if (j==3|j==4){
                    num=num+((j*100)-200);
                }
                else{
                    num=num+(500*counter);
                }
            }
            if (diamond_counter == j){
                if (j==3|j==4){
                    num=num+((j*100)-200);
                }
                else{
                    num=num+(500*counter);
                }
            }
            if (monkey_counter == j | parrot_counter == j | saber_counter == j | gold_counter == j | diamond_counter == j) {
                if (j>=5){
                    counter=counter*2;
                }
            }
        }

        if (card_type == fort_card.SEA2){
            if (saber_counter>=2){
                num=num+300;
            }
            else {
                num=-300;
            }
        }
        if (card_type == fort_card.SEA3){
            if (saber_counter>=3){
                num=num+500;
            }
            else {
                num=-500;
            }
        }
        if (card_type == fort_card.SEA4){
            if (saber_counter>=4){
                num=num+1000;
            }
            else {
                num=-1000;
            }
        }


        return num;
    }

    public static Faces max_comb(ArrayList <Faces> vals){
        int monkey_counter=0;
        int parrot_counter=0;
        int saber_counter=0;
        int gold_counter=0;
        int diamond_counter=0;
        Faces highest= Faces.SABER;
        int max_counter=0;


        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i)==Faces.MONKEY){
                monkey_counter++;
            }
            if (vals.get(i)==Faces.PARROT){
                parrot_counter++;
            }
            if (vals.get(i)==Faces.SABER){
                saber_counter++;
            }
            if (vals.get(i)==Faces.GOLD){
                gold_counter++;
            }
            if (vals.get(i)==Faces.DIAMOND){
                diamond_counter++;
            }
        }

        if (monkey_counter> max_counter){
            highest = Faces.MONKEY;
            max_counter= monkey_counter;
        }
        if (parrot_counter> max_counter){
            highest = Faces.PARROT;
            max_counter=parrot_counter;
        }
        if (saber_counter> max_counter){
            highest = Faces.SABER;
            max_counter=saber_counter;
        }
        if (gold_counter> max_counter){
            highest = Faces.GOLD;
            max_counter=gold_counter;
        }
        if (diamond_counter> max_counter){
            highest = Faces.DIAMOND;
        }

        return highest;
    }

}