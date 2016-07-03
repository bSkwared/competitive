import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


class VitoFamily {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        for (int ctr = 0; ctr < cases; ++ctr) {
            int r = scan.nextInt();

            int[] location = new int[r];
            for (int i = 0; i < r; ++i) {
                location[i] = scan.nextInt();
            }

            Arrays.sort(location);

            int median = (r%2 == 0) ? location[r/2] : (location[r/2] + location[r/2 + 1])/2;


        }
    }
}
