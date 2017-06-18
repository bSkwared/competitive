// Problem statement: https://www.codechef.com/problems/AND

import java.util.Scanner;

public class And {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        // Get size of input
        int T = scan.nextInt();
        int[] arr = new int[T];
        
        // Read input
        for (int i = 0; i < T; i++) {
            arr[i] = scan.nextInt();
        }
        
        
        long result = 0;
        int[] bitCount = new int[32];
        
        // Calculate sum of ands
        for (int i = T-1; i >= 0; i--) {
            int cur = arr[i];
            result += andSum(cur, bitCount);
            addToCount(arr[i], bitCount);
        }
        
        System.out.println(result);
    }
    
    private static long andSum(int num, int[] bitCount) {
        long sum = 0;
        
        long pow2 = 1;
        for (int i = 0; i < 32; ++i) {
            
            int numBits = bitCount[i];
            
            long singleAnd = pow2 & num;
            long sumOfAnds = singleAnd * numBits;
            
            sum += sumOfAnds;
            
            pow2 <<= 1;
        }
        
        
        return sum;
    }
    
    private static void addToCount(int num, int[] bitCount) {
        
        int pow2 = 1;
        for (int i = 0; i < 32; ++i) {
            
            if ((pow2 & num) != 0) {
                bitCount[i]++;
            }
            
            pow2 <<= 1;
        }
        
    }
}
