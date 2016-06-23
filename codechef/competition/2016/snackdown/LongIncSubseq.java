import java.util.*;
import java.lang.*;
import java.io.*;

class LongIncSubseq
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();

        for (int cases = 0; cases < t; ++cases) {
            int n = scan.nextInt();

            System.out.println("100");

            System.out.println(genString(n));
        }
    }

    public static String genString(int n) {
        int max = (100 - n) * n;
        return "";
    }

}