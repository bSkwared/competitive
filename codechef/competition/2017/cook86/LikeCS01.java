// Problem statement: https://www.codechef.com/problems/LIKECS01

import java.util.HashSet;
import java.util.Scanner;

public class LikeCS01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int i = 0; i < T; i++) {
            String str = scan.next();
            HashSet<String> map = new HashSet<>();
            
            boolean isFound = false;
            for (int j = 0; j < str.length(); j++) {
                for (int k = j+1; k <= str.length(); k++) {
                    String subStr = str.substring(j, k);
                    if (!map.contains(subStr)) {
                        map.add(subStr);
                    } else {
                        isFound = true;
                        break;
                    }
                }
            }
            
            if (isFound) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
