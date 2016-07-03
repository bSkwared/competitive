import java.util.*;
import java.lang.*;
import java.io.*;

class JollyJumpers
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int length = scan.nextInt();

            boolean[] diffFound = new boolean[length];
            int[] input = new int[length];

            for (int i = 0; i < length; ++i) {
                input[i] = scan.nextInt();
            }


            for (int i = 0; i < length - 1; ++i) {
                int diff = input[i] - input [i+1];

                if (diff < 0) {
                    diff = -diff;
                }

                if (diff < length) {
                    diffFound[diff] = true;
                }
            }


            boolean allFound = true;
            for (int i = 1; i < length; ++i) {
                if (!diffFound[i]) {
                    allFound = false;
                    break;
                }
            }

            if (allFound) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}