import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int[] deck = new int[52];



        int t = scan.nextInt();

        for (int cases = 0; cases < t; ++cases) {
            for (int i = 0; i < 52; ++i) {
                deck[i] = i;
            }

            int n = scan.nextInt();
            int[][] shuffles = new int[n][52];

            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < 52; ++k) {
                    shuffles[i][k] = scan.nextInt()-1;
                }
            }
            scan.nextLine();
            String line = scan.nextLine();
            while (!line.isEmpty()) {
                deck = applyShuffle(deck, shuffles[Integer.parseInt(line)-1]);
                if (scan.hasNextLine()) {
                    line = scan.nextLine();
                } else {
                    line = "";
                }
            }
            printDeck(deck);
            if (cases < t-1) {
                System.out.print('\n');
            }


        }

    }

    public static int[] applyShuffle(int[] deck, int[] shuffle) {
        int[] t = new int[52];

        for (int i = 0; i < 52; ++i) {
            t[i] = deck[shuffle[i]];
        }

        return t;
    }

    public static void printDeck(int[] deck) {
        final String[] suit  = {"Clubs", "Diamonds", "Hearts", "Spades"};
        final String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < 52; ++i) {
            System.out.println(value[deck[i]%13] + " of " +suit[deck[i]/13]);
        }
    }
}