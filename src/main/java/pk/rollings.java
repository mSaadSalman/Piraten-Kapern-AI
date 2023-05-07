package pk;

import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class rollings {
    private static final Logger logger = LogManager.getLogger(test.class);

    public static ArrayList<Faces> roll_one() {
        int skull_counter = 0;
        ArrayList test1 = new ArrayList();
        Dice myDice = new Dice();

        for (int i = 0; i < 8; i++) {
            test1.add(myDice.roll());
        }

        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }
        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }

        while (skull_counter < 3) {
            Random val = new Random();
            if (val.nextBoolean() == true) {
                Random rnnd = new Random();
                for (int j = 0; j < test1.size(); j = j + 1) {
                    if (rnnd.nextInt(2) == 0 && test1.get(j) != Faces.SKULL) {
                        test1.set(j, myDice.roll());
                    }
                }

                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == Faces.SKULL) {
                        skull_counter = skull_counter + 1;
                        //System.out.println("Rerolled and has skulls: " + test1);
                        test1.remove(y);
                    }
                }
            }
            else{

                break;
            }
        }
        if (skull_counter>=3){
            test1.clear();
        }

        return test1;
    }

    public static ArrayList<Faces> smart_roll(fort_card current_card,String tracings) {

        int skull_counter = 0;
        ArrayList test1 = new ArrayList();
        ArrayList temp = new ArrayList();
        Dice myDice = new Dice();
        Dice new_dice = new Dice();

        for (int i = 0; i < 8; i++) {
            test1.add(myDice.roll());
        }
        if (tracings.equals("trace")){logger.trace("Original: " + test1);}

        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }
        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }
        if (tracings.equals("trace")){logger.trace("Original removed skulls: " + test1);}

        int start= number_combos(test1,current_card);

        while (skull_counter<2 & start<4) {
            player_score points = new player_score();
            Faces rep = points.max_comb(test1);

            if (current_card ==fort_card.MONKS &&(rep==Faces.PARROT||rep==Faces.MONKEY)){
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == Faces.PARROT) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == Faces.PARROT) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == Faces.MONKEY) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == Faces.MONKEY) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
            }

            else {
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == rep) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
                for (int y = 0; y < test1.size(); y++) {
                    if (test1.get(y) == rep) {
                        temp.add(test1.get(y));
                        test1.remove(y);
                    }
                }
            }
            for (int y = 0; y < test1.size(); y++) {
                if (test1.get(y) == Faces.GOLD | test1.get(y) == Faces.DIAMOND) {
                    temp.add(test1.get(y));
                    test1.remove(y);
                }
            }
            for (int y = 0; y < test1.size(); y++) {
                if (test1.get(y) == Faces.GOLD | test1.get(y) == Faces.DIAMOND) {
                    temp.add(test1.get(y));
                    test1.remove(y);
                }
            }
            for (int y = 0; y < test1.size(); y++) {
                if (test1.get(y) == Faces.GOLD | test1.get(y) == Faces.DIAMOND) {
                    temp.add(test1.get(y));
                    test1.remove(y);
                }
            }
            if (tracings.equals("trace")){logger.trace("Dices to be rerolled "+test1);}
            if (tracings.equals("trace")){logger.trace("Dices kept same: "+temp);}

            int size_test1 = test1.size();
            if (size_test1<2){
                for (int i=0;i< temp.size();i++){
                    test1.add(temp.get(i));
                }
                break;
            }
            test1.clear();

            for (int i = 0; i < size_test1; i++) {
                test1.add(new_dice.roll());
            }
            if (tracings.equals("trace")){logger.trace("New rerolls with potential skulls: "+test1);}

            for (int y = 0; y < test1.size(); y++) {
                if (test1.get(y) == Faces.SKULL) {
                    skull_counter = skull_counter + 1;
                    test1.remove(y);
                }
            }
            for (int y = 0; y < test1.size(); y++) {
                if (test1.get(y) == Faces.SKULL) {
                    skull_counter = skull_counter + 1;
                    test1.remove(y);
                }
            }

            for (int y = 0; y < temp.size(); y++) {
                test1.add(temp.get(y));
            }
            temp.clear();
            start= number_combos(test1,current_card);
            if (tracings.equals("trace")){logger.trace("New rolled removed with the skulls " + test1);}
        }
        if (skull_counter >= 3) {
            test1.clear();
        }

        return test1;
    }

    public static ArrayList<Faces> card_strat(fort_card type_card, String tracings) {
        int skull_counter = 0;
        ArrayList test1 = new ArrayList();
        ArrayList temp = new ArrayList();
        Dice myDice = new Dice();
        Cards facee = new Cards();

        for (int i = 0; i < 8; i++) {
            test1.add(myDice.roll());
        }
        if (tracings.equals("trace")){logger.trace("Original: "+test1);}

        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }
        for (int y = 0; y < test1.size(); y++) {
            if (test1.get(y) == Faces.SKULL) {
                skull_counter = skull_counter + 1;
                test1.remove(y);
            }
        }
        if (tracings.equals("trace")){logger.trace("Original removed skulls: "+test1);}
        if (type_card == fort_card.SEA2){
            temp =facee.sea_battle(test1,2,skull_counter,tracings);
        }
        if (type_card == fort_card.SEA3){
            temp =facee.sea_battle(test1,3,skull_counter,tracings);
        }
        if (type_card == fort_card.SEA4){
            temp =facee.sea_battle(test1,4,skull_counter,tracings);
        }

        if (skull_counter >= 3) {
            temp.clear();
        }
        return temp;
    }



    public static int number_combos(ArrayList <Faces> die,fort_card current_card){
        int monkey_counter=0;
        int parrot_counter=0;
        int saber_counter=0;
        int gold_counter=0;
        int diamond_counter=0;
        int special_counter=0;
        int max_counter=0;

        for (int i = 0; i < die.size(); i++) {
            if (die.get(i)==Faces.MONKEY){
                monkey_counter++;
            }
            if (die.get(i)==Faces.PARROT){
                parrot_counter++;
            }
            if (die.get(i)==Faces.SABER){
                saber_counter++;
            }
            if (die.get(i)==Faces.GOLD){
                gold_counter++;
            }
            if (die.get(i)==Faces.DIAMOND){
                diamond_counter++;
            }
        }

        if (current_card == fort_card.MONKS){
            special_counter = monkey_counter+parrot_counter;
            if (special_counter> max_counter){
                max_counter= special_counter;
            }
            if (saber_counter> max_counter){
                max_counter=saber_counter;
            }
            if (gold_counter> max_counter){
                max_counter=gold_counter;
            }
            if (diamond_counter> max_counter){
                max_counter=diamond_counter;
            }
        }

        else {
            if (monkey_counter > max_counter) {
                max_counter = monkey_counter;
            }
            if (parrot_counter > max_counter) {
                max_counter = parrot_counter;
            }
            if (saber_counter > max_counter) {
                max_counter = saber_counter;
            }
            if (gold_counter > max_counter) {
                max_counter = gold_counter;
            }
            if (diamond_counter > max_counter) {
                max_counter = diamond_counter;
            }
        }

        return max_counter;
    }

}
