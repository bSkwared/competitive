import java.util.*;
import java.lang.*;
import java.io.*;

class NDiffPalin
{
    public static String[] solved = new String[10002];

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();

        solved[1] = "a";
        solved[2] = "ab";
        solved[3] = "abz";
        solved[4] = "aba";

        for (int i = 5; i < 10000; ++i) {
            genPal(i);
        }

        for (int cases = 0; cases < t; ++cases) {
            int n = scan.nextInt();
            String pal;

            System.out.println(genPal(n));



        }

    }

    public static String genPal(int n) {
        if (solved[n] != null) {
            return solved[n];
        }

        StringBuilder pal = new StringBuilder(genPal(n-1));

        switch (n % 3) {
            case 0:
                pal.deleteCharAt(pal.length()-1);
                int index = pal.length() / 2;
                pal.insert(index, pal.charAt(index));
                break;
            case 1:
                char c = (char) (((pal.charAt(pal.length()/2) - 'a' + 1) % 26) + 'a'); 
                pal.insert(pal.length()/2, c);
                break;
            case 2:
                pal.append("z");
                break;
        }

        solved[n] = pal.toString();
        return solved[n];
    }
}