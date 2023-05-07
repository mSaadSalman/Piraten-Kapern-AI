package pk;

import java.util.ArrayList;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class winings {

    private static final Logger logger = LogManager.getLogger(test.class);

    public static void total_win(double win1, double win2, int games, double draw){
        double total_win1=((win1/(games-draw)))*100;
        double total_win2=((win2/(games-draw)))*100;
        System.out.println("Player 1's percentage of winning: %"+ total_win1);
        System.out.println("Player 2's percentage of winning: %"+ total_win2);
    }
}
