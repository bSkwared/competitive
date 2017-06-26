// Problem statement: https://www.codechef.com/problems/GOODSET

import java.util.Scanner;

public class GoodSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Number of test cases
        int T = scan.nextInt();
        
        for (int i = 0; i < T; ++i) {
            // Size of set to output
            int n = scan.nextInt();
            
            // since max n is 100, the biggest number out would be 400
            // which is less than 301 + 302
            int num = 300;
            boolean first = true;
            
            for (int j = 0; j < n; j++) {
                // only print space after first element in set
                if (first) {
                    first = false;
                } else {
                    System.out.print(" ");
                }
                
                System.out.print(++num);
            }
            System.out.println("");
        }
    }
}
