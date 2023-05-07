package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cards {
    private static final Logger logger = LogManager.getLogger(test.class);
    public ArrayList<fort_card> carded(){
        ArrayList <fort_card> card = new ArrayList();

        card.add(fort_card.SEA2);
        card.add(fort_card.SEA2);
        card.add(fort_card.SEA3);
        card.add(fort_card.SEA3);
        card.add(fort_card.SEA4);
        card.add(fort_card.SEA4);
        for (int j=0; j<4;j++){
            card.add(fort_card.MONKS);
        }
        for (int i=0; i<25; i++){
            card.add(fort_card.NOP);
        }


        return card;

    }
    public ArrayList<fort_card> run2(){
        ArrayList<fort_card> tempp;
        tempp= carded();
        Collections.shuffle(tempp);

        return tempp;
    }

    public static fort_card typeofcard(ArrayList <fort_card> typee,int count){
        return typee.get(count);
    }




    public static ArrayList<Faces> sea_battle(ArrayList <Faces> set, int val,int skull_counter, String tracings){
        int saber_counter=0;
        ArrayList <Faces> temp = new ArrayList();
        Dice myDice = new Dice();

        for (int i=0;i<set.size();i++){
            if (set.get(i)==Faces.SABER){
                saber_counter++;
            }
        }

        while (saber_counter< val && skull_counter<3){
            saber_counter=0;
            for (int y = 0; y < set.size(); y++) {
                if (set.get(y) == Faces.SABER) {
                    temp.add(set.get(y));
                    set.remove(y);
                }
            }
            for (int y = 0; y < set.size(); y++) {
                if (set.get(y) == Faces.SABER) {
                    temp.add(set.get(y));
                    set.remove(y);
                }
            }
            int size_set = set.size();
            set.clear();
            if (tracings.equals("trace")){logger.trace("Current sabers: "+temp);}

            for (int i = 0; i < size_set; i++) {
                set.add(myDice.roll());
            }
            if (tracings.equals("trace")){logger.trace("New rolls: "+set);}

            for (int y = 0; y < set.size(); y++) {
                if (set.get(y) == Faces.SKULL) {
                    skull_counter = skull_counter + 1;
                    set.remove(y);
                }
            }
            for (int y = 0; y < set.size(); y++) {
                if (set.get(y) == Faces.SKULL) {
                    skull_counter = skull_counter + 1;
                    set.remove(y);
                }
            }

            for (int y = 0; y < temp.size(); y++) {
                set.add(temp.get(y));
            }
            temp.clear();

            for (int i=0;i<set.size();i++){
                if (set.get(i)==Faces.SABER){
                    saber_counter++;
                }
            }
            if (skull_counter >= 3) {
                set.clear();
                break;
            }
        }


        if (skull_counter >= 3) {
            set.clear();
        }
        return set;
    }


}
