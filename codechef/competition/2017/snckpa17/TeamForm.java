// Problem statement: https://www.codechef.com/problems/TEAMFORM/

import java.util.*;
 
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int i = 0; i < T; ++i) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            
            for (int k = 0; k < m; ++k) {
                scan.nextInt();
                scan.nextInt();
            }
            
            if (n%2 == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        
    }
}
 