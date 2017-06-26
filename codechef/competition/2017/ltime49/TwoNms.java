// Problem statement: https://www.codechef.com/problems/TWONMS
import java.util.Scanner;

public class TwoNms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();
            
            if (n % 2 == 1) {
                a *= 2;
            }
            
            if (a < b) {
                System.out.println(b / a);
            } else {
                System.out.println(a / b);
            }
        }
    }
}
