// Problem statement: https://www.codechef.com/problems/SNTEMPLE/
 
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int BBB = 0; BBB < T; ++BBB) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            int[] bef = new int[n];
            int[] aft = new int[n];
            
            for (int j = 0; j < n; ++j) {
                arr[j] = scan.nextInt();
            }
            
            int ctr = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > ctr) {
                    bef[i] = ++ctr;
                } else {
                    bef[i] = arr[i];
                    ctr = arr[i];
                }
            }
            
            ctr = 0;
            for (int i = n-1; i >= 0; i--) {
                if (arr[i] > ctr) {
                    aft[i] = ++ctr;
                } else {
                    aft[i] = arr[i];
                    ctr = arr[i];
                }
            }
            
            int max = 0;
            int maxi = 0;
            
            for (int i = 0; i < n; i++) {
                int min = aft[i];
                if (min > bef[i]) {
                    min = bef[i];
                }
                
                if (min > max) {
                    max = min;
                    maxi = i;
                }
            }
            
            int[] temple = new int[n];
            
            ctr = max;
            for (int i = maxi; i < maxi+max; i++) {
                temple[i] = ctr--;
            }
            
            ctr = max;
            for (int i = maxi; i > maxi-max; i--) {
                temple[i] = ctr--;
            }
            
            long dig = 0;
            
            for (int i = 0; i < n; ++i) {
                dig += arr[i]-temple[i];
            }
            
            System.out.println(dig);
        }
        
    }
}