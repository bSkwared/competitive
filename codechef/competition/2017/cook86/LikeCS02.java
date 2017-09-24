// Problem statement: https://www.codechef.com/problems/LIKECS02

import java.util.HashSet;
import java.util.Scanner;

public class LikeCS02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int N = scan.nextInt();
            
            boolean isFirst = true;
            for (int i = 0; i < N; i++) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    System.out.print(" ");
                }
                
                System.out.print(i+1+(N/2));
            }
            System.out.println("");
        }
    }
}
