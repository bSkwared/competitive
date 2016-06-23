import java.util.*;
import java.lang.*;
import java.io.*;
 
class PayingUp {
 
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
 
        int t = scan.nextInt();
 
        for (int i = 0; i < t; ++i) {
            int[] temp = new int[scan.nextInt()];
            int m = scan.nextInt();
            
            int length = 0;
            for(int k = 0; k < temp.length; ++k) {
                int val = scan.nextInt();
                if (val <= m) {
                    temp[length] = val;
                    ++length;
                }
            }
            
            int[] wallet = new int[length];
            for(int k = 0; k < length; ++k) {
                wallet[k] = temp[k];
            }
            
 
            int ctr = 0;
 
            double top = Math.pow(2.0, (double) wallet.length);
 
            boolean rightAmount = false;
 
            for (int k = 0; k < top; ++k) {
                int sum = 0;
 
                for (int it = 0; it < wallet.length; ++it) {
                    if (((k >> it) & 0x1) == 0x1) {
                        sum += wallet[it];
                    }
                }
 
                if (sum == m) {
                    rightAmount = true;
                    break;
                }
            }
 
            System.out.println(rightAmount ? "Yes" : "No");
 
        }
    }
}