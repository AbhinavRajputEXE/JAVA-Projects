package JAVA.miniProjects;

/**
 * This calculator only calculates the gross typing speed in word per minute
 * This program won't consider the wrong words penalty.
 *
 */

import java.io.IOException;
import java.util.Scanner;

public class typingSpeed {
    private static void pressAnyKeyToContinue() {
        System.out.print("Press Enter(only) key to continue...");
        try
        {
            System.in.read();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void infoForUser(){
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("|   • Welcome!!!!!                                                                                            |");
        System.out.println("|   • Here you can calculate your typing speed.                                                               |");
        System.out.println("|   • You just have to type a short sentence of at least 40 letters after the timer (3..2..1..go!.).          |");
        System.out.println("|   • It is advised to type \"The quick brown fox jumps over the lazy dog\" as it contains all the letters.     |");
        System.out.println("|   • After completing the typing press enter to finish.                                                      |");
        System.out.println("---------------------------------------------------------------------------------------------------------------\n");
    }

    public static void ifLessWords(){
        System.out.println("You need to enter at least 40 characters to get accurate results");
    }

    public static void finalSpeed(long stopTime, long startTime,int length){
        long reaction = (stopTime - startTime)/1000;
        float reactionInMinutes = reaction/60F;
        int speed =(int)((length/5)/reactionInMinutes);
        System.out.println("\nYour typing speed was "+speed+" WPM");
    }

    public static void main() throws InterruptedException{
        infoForUser();
        pressAnyKeyToContinue();

        /////////////////////////////////////////
        System.out.println("1");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("GO!!!!!!");
        ////////////////////////////////////////

        Scanner scan = new Scanner(System.in);

        long startTime = System.currentTimeMillis();
        System.out.println("Start typing!!");
        String phrase = scan.nextLine();
        long stopTime = System.currentTimeMillis();
        int length = phrase.length();
        if(length<40){
            ifLessWords();
            System.out.println("Enter \"y/Y\" to continue or \"n/N\" to exit");
            String yN = scan.next();
            if(yN.equals("y") || yN.equals("Y")){
                main();
            }
            else if(yN.equals("n") || yN.equals("N")) {
                System.out.println("Exiting.......");
                System.exit(0);
            }
        }

        else {
            finalSpeed(stopTime, startTime, length);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        main();
    }
}
