// Problem statement: https://www.codechef.com/problems/LIKECS03

import java.util.HashSet;
import java.util.Scanner;

public class LikeCS03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            
            boolean[] containsPower = new boolean[K];
            for (int i = 0; i < N; i++) {
                int cur = scan.nextInt();
                
                int ctr = 0;
                int index = 0;
                for (int j = 0; j < K; j++) {
                    if (((1 << j) & cur) != 0) {
                        ++ctr;
                        index = j;
                    }
                }
                
                if (ctr == 1) {
                    containsPower[index] = true;
                }
            }
            
            int ctr = 0;
            for (int i = 0; i < K; i++) {
                if (!containsPower[i]) {
                    ++ctr;
                }
            }
            
            System.out.println(ctr);
        }
    }
}
