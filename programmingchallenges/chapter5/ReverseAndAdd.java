import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class ReverseAndAdd {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        for (int ctr = 0; ctr < cases; ++ctr) {
            long n = scan.nextLong();

            int i = 0;
            while (!isPal(n)) {
                n += reverseLong(n);
                ++i;
            }

            System.out.println(i + " " + Long.toString(n));

        }

    }

    public static long reverseLong(long n) {
        long rev = 0;
        long t = n;

        while (t > 0) {
            rev *= 10;
            rev += t % 10;
            t /= 10;
        }

        return rev;
    }

    public static boolean isPal(long n) {
        String str = Long.toString(n);

        int len = str.length();

        for (int i = 0; i < len / 2; ++i) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
