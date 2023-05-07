import pk.Faces;
import pk.test;



import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class PiratenKarpen {

    public static void main(String[] args) {



        System.out.println("______________________________________");
        System.out.println(" Welcome to Piraten Karpen Simulator! ");
        System.out.println("--------------------------------------");


        System.out.println("These are the possible faces: " + Arrays.toString(Faces.values()));
        System.out.println("May the best player win!");
        System.out.println();
        String p1=args[0];
        String p2=args[1];
        //String p1="random";
        //String p2="combo";
        String tracings="hold";
        Scanner reader =new Scanner(System.in);

        if (args.length<3){
            tracings="n/a";
        }
        else{
            tracings=args[2];
        }

        /*Scanner reader =new Scanner(System.in);
        System.out.println("To enable tracing please type 'trace' with no capitals and no spaces");
        tracings = reader.next();*/

        test new_sim= new test();
        new_sim.main(p1,p2,tracings);

    }

}

