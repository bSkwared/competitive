// Problem statement: https://www.codechef.com/problems/XENRANK

import java.util.Scanner;

public class XenRank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Number of test cases
        int T = scan.nextInt();
        
        for (int i = 0; i < T; ++i) {
            // Size of set to output
            int m = scan.nextInt();
            int n = scan.nextInt();
            
            long ans = m+n;
            ans = (ans*(ans+1))/2;
            
            
            
            System.out.println(ans + m + 1);
        }
    }
}
