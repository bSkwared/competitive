// Problem statement: https://www.codechef.com/problems/ADACRA

import java.util.Scanner;


public class AdaCra  {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            String str = scan.next();
            
            char cur = str.charAt(0);
            int numChanges = 1;
            
            for (int i = 1; i < str.length(); ++i) {
                char t = str.charAt(i);
                if (t != cur) {
                    cur = t;
                    ++numChanges;
                }
            }
            
            System.out.println(numChanges/2);
            
        }
    }

}
