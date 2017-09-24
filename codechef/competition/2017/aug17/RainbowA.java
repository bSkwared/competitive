// Problem statement: https://www.codechef.com/problems/RAINBOWA

import java.util.Scanner;

public class RainbowA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int N = scan.nextInt();

            int[] array = new int[N+1];

            array[0] = 1;
            for (int i = 1; i < N+1; i++) {
                array[i] = scan.nextInt();
            }
            
            boolean isValid = true;
            
            int front = 1;
            int end   = N;
            
            while (front < end) {
                
                if (array[front] != array[front-1] 
                        && array[front] != array[front-1] + 1) {
                    isValid = false;
                }
                
                if (array[front] < 1 || 7 < array[front]) {
                    isValid = false;
                }
                
                if (array[front] == array[end]) {
                    front++;
                    end--;
                } else {
                    isValid = false;
                    break;
                }
            }
            
            if (array[front] != 7) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
