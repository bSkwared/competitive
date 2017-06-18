// Problem statement: https://www.codechef.com/problems/COINS

import java.util.HashMap;
import java.util.Scanner;


public class Coins {
    
    static HashMap<Long, Long> dp;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         dp = new HashMap<>();
        
        while (scan.hasNextInt()) {
            System.out.println(maxCoins(scan.nextLong()));
        }
    }
    
    private static long maxCoins(long cur) {
        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }
        
        // base case, definitely not a good deal
        if (cur < 12) {
            return cur;
        }
        
        // get max return from n/2
        long result = maxCoins(cur/2);

        // get max return from n/3
        result += maxCoins(cur/3);

        // get max return from n/4
        result += maxCoins(cur/4);
        
        
        // Check if this may be a bad deal
        if (result < cur) {
            result = cur;
        }
        
        dp.put(cur, result);
        return result;
    }
}
