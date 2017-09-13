// Problem statement: https://www.codechef.com/problems/MATPAN

import java.util.Scanner;

public class MatPan {
    
    private static int[] stringToInts(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            ints[i] = (int) str.charAt(i) - (int) 'a';
        }
        
        return ints;
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        int[] prices = new int[26];
        for (int OUTER = 0; OUTER < T; OUTER++) {
            
            // Get prices
            for (int i = 0; i < 26; i++) {
                prices[i] = scan.nextInt();
            }
            
            // Convert chars to ints
            String input = scan.next();
            int[] letters = stringToInts(input);
            
            // Check which letters are missing
            boolean[] containsLetter = new boolean[26];
            for (int letter : letters) {
                containsLetter[letter] = true;
            }
            
            // Total of buying missing letters
            int total = 0;
            for (int i = 0; i < 26; i++) {
                if (!containsLetter[i]) {
                    total += prices[i];
                    containsLetter[i] = true;
                }
            }
            
            System.out.println(total);
        }
    }
}
