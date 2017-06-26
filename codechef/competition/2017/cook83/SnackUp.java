// Problem statement: https://www.codechef.com/problems/SNACKUP

import java.util.HashMap;
import java.util.Scanner;


public class SnackUp  {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int n = scan.nextInt();
            
            System.out.println(n);
            
            int ctr = 0;
            for (int i = 0; i < n; i++) {
                System.out.println(n);
                
                for (int j = 0; j < n; j++) {
                    System.out.print((int)(j+1) + " ");
                    int toEat = ((j + i) % n) + 1;
                    int toEat2 = ((j + i + 1) % n) + 1;
                    
                    
                    System.out.println(toEat + " " + toEat2);
                }
            }
        }
    }

}
