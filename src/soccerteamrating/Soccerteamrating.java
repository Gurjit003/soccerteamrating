/*
 * Gurjit Singh
 * Friday November 8th - 2019
 * This program displays the calculator for a soccer team's rating
 */

package soccerteamrating;
import java.util.Scanner;

/**
 *
 * @author sangha
 */
public class Soccerteamrating {
    
// Global variables declaration
static double dAverage, mAverage, fAverage, totalAverage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner declaration
        Scanner input = new Scanner (System.in);
        Scanner input2 = new Scanner (System.in);
        Scanner input3 = new Scanner (System.in);
        
        // Variables declaration
        int gRating = 0; 
        int dNum = 0;
        int dTotal = 0;
        int mNum = 0;
        int mTotal = 0;
        int fNum = 0;
        int fTotal = 0;
        int tNum = 0;
        tNum = dNum + mNum + fNum + 1;
        final String enter2;
        final String enter3;
        
        do {
            final String enter; // Input "enter" final String
            System.out.println("Soccer Team Rating Calculator Steps:"); // Menu/Steps from line 42 to 52
            System.out.println("");
            System.out.println((char)27 + "[31m1. Calculate the goalkeeper's rating." + (char)27);
            System.out.println((char)27 + "[34m2. Calculate the defenders' ratings." + (char)27);
            System.out.println((char)27 + "[35m3. Calculate the midfielders' ratings." + (char)27);
            System.out.println((char)27 + "[36m4. Calculate the forwards' ratings." + (char)27);
            System.out.println("REMEMBER NOT TO EXCEED 11 PLAYERS.");
            System.out.println("");
            System.out.println("TYPE ENTER TO CONTINUE (CAPS)");
            enter = input.nextLine();
            System.out.println("");

            // Goalkeepers' section
            System.out.println((char)27 + "[31m1. Enter the goalkeeper's rating:" + (char)27);
            gRating = input.nextInt();
            System.out.println("");

            // Defenders' section
            System.out.println((char)27 + "[34m2. Enter the number of defenders(3-4):" + (char)27);
            dNum = input.nextInt();
            int [] dRatings = new int [dNum];
            System.out.println("");

            if ((dNum >= 3) && (dNum <= 4)) {
                System.out.println((char)27 + "[34m - Enter the ratings of the " + dNum + " defenders:" + (char)27);
                for (int i = 0; i <= dNum - 1; i = i + 1) {
                    dRatings[i] = input.nextInt();
                    dTotal = dTotal + dRatings[i];
                    System.out.println("");
                }
            }
            else {
                System.out.println((char)27 + "[34mWRONG NUMBER OF DEFENDERS." + (char)27);
                System.out.println("");
            }

            // Midfielders' section
            System.out.println((char)27 + "[35m3. Enter the number of midfielders(3-5):" + (char)27);
            mNum = input.nextInt();
            int [] mRatings = new int [mNum];
            System.out.println("");

            if ((mNum >= 3) && (mNum <= 5)) {
                System.out.println((char)27 + "[35m - Enter the ratings of the " + mNum + " midfielders:" + (char)27);
                for (int i = 0; i <= mNum - 1; i = i + 1) {
                    mRatings[i] = input.nextInt();
                    mTotal = mTotal + mRatings[i];
                    System.out.println("");
                }
            }
            else {
                System.out.println((char)27 + "[35mWRONG NUMBER OF MIDFIELDERS." + (char)27);
                System.out.println("");
            }

            // Forwards' section
            System.out.println((char)27 + "[36m4. Enter the number of forwards(1-4):" + (char)27);
            fNum = input.nextInt();
            int [] fRatings = new int [fNum];
            System.out.println("");

            if ((fNum >= 1) && (fNum <= 4)) {
                System.out.println((char)27 + "[36m - Enter the ratings of the " + fNum + " forwards:" + (char)27);
                for (int i = 0; i <= fNum - 1; i = i + 1) {
                    fRatings[i] = input.nextInt();
                    fTotal = fTotal + fRatings[i];
                    System.out.println("");
                }
            }
            else {
                System.out.println((char)27 + "[36mWRONG NUMBER OF FORWARDS." + (char)27);
                System.out.println("");
            }
            
            // Total number of players decision
            tNum = dNum + mNum + fNum + 1; 
            if ((tNum < 11) || (tNum > 11)) {
                System.out.println("NOT ENOUGH OR TOO MANY PLAYERS!!!");
                System.out.println("YOU HAVE TO RENTER THE INFORMATION!!!");
                System.out.println("-------------------------------------");
                System.out.println("");
            }
            
        } while (tNum != 11);
            // Averages for each position
            System.out.println("Calculating the averages for each position...");
            System.out.println("");
            System.out.println("TYPE ENTER TO SEE THE AVERAGE RATINGS OF EACH POSITION (CAPS)");
            enter2 = input2.nextLine();
            System.out.println("");
            System.out.println((char)27 + "[31mThe rating of the goalkeeper is: " + gRating + (char)27);
            System.out.println("");
            System.out.println((char)27 + "[34mThe average rating of the defenders is: " + dAverageAndOut(dTotal, dNum) + (char)27);
            System.out.println((char)27 + "[34mThe rounded average rating of the defenders is: " + Math.round(dAverage) + (char)27);
            System.out.println("");
            System.out.println((char)27 + "[35mThe average rating of the midfielders is: " + mAverageAndOut(mTotal, mNum) + (char)27);
            System.out.println((char)27 + "[35mThe rounded average rating of the midfielders is: " + Math.round(mAverage) + (char)27);
            System.out.println("");
            System.out.println((char)27 + "[36mThe average rating of the forwards is: " + fAverageAndOut(fTotal, fNum) + (char)27);
            System.out.println((char)27 + "[36mThe rounded average rating of the forwards is: " + Math.round(fAverage) + (char)27);
            System.out.println("");
            // Average for the team
            System.out.println("Calculating the average of the team...");
            System.out.println("");
            System.out.println("TYPE ENTER TO SEE THE AVERAGE RATING OF THE TEAM (CAPS)");
            enter3 = input3.nextLine();
            System.out.println("");
            System.out.println("The average rating of the team is: " + totalAverageAndOut(dAverage, mAverage, fAverage, gRating));
            System.out.println("The average rounded rating of the team is: " + Math.round(totalAverage));
            System.out.println("");
    }
    /**
     * Outputs the average of the defenders
     * @param n1
     * @param n2
     * @return 
     */
    public static double dAverageAndOut (double n1, double n2){ 
        dAverage = n1 / n2;
        
        return dAverage;
    }
    /**
     * Outputs the average of the midfielders
     * @param n1
     * @param n2
     * @return 
     */
    public static double mAverageAndOut (double n1, double n2){ 
        mAverage = n1 / n2;
        
        return mAverage;
    }
    /**
     * Outputs the average of the forwards
     * @param n1
     * @param n2
     * @return 
     */
    public static double fAverageAndOut (double n1, double n2){ 
        fAverage = n1 / n2;
        
        return fAverage;
    }
    /**
     * Outputs the average of the team
     * @param n1
     * @param n2
     * @param n3
     * @param n4
     * @return 
     */
    public static double totalAverageAndOut (double n1, double n2, double n3, double n4){ 
        totalAverage = (n1 + n2 + n3 + n4) / 4;
        
        return totalAverage;
    }
}
