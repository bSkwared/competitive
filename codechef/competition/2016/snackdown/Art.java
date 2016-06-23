import java.util.*;
import java.lang.*;
import java.io.*;

class Art
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();

        for (int cases = 0; cases < t; ++cases) {
            int n = scan.nextInt();
            
            int[] start = new int[3];
            int[] end = new int[3];

            boolean found = false;
            for (int i = 0; i < n; ++i) {
                start[i%3] = scan.nextInt();

                if (start[0] == start[1] && start[1] == start[2]) {
                    found = true;
                } 
            }

            String answer = found ? "Yes" : "No";
            System.out.println(answer);


        }

    }
}