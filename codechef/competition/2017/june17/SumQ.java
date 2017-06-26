// Problem statement: https://www.codechef.com/problems/SUMQ

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SumQ {
    
    private static final long MOD = 1000000007;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = readInt();
        
        final int MAX_SIZE = 100000;
        
        Long[] X = new Long[MAX_SIZE];
        Long[] Y = new Long[MAX_SIZE];
        Long[] Z = new Long[MAX_SIZE];

        long[] xSum  = new long[MAX_SIZE];
        long[] ySum  = new long[MAX_SIZE];
        long[] zSum  = new long[MAX_SIZE];
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int p = readInt();
            int q = readInt();
            int r = readInt();
            
            for (int i = 0; i < p; i++) {
                X[i] = (long) readInt();
            }
            for (int i = 0; i < q; i++) {
                Y[i] = (long) readInt();
            }
            for (int i = 0; i < r; i++) {
                Z[i] = (long) readInt();
            }
            
            Arrays.sort(X, 0, p, Collections.reverseOrder());
            Arrays.sort(Y, 0, q, Collections.reverseOrder());
            Arrays.sort(Z, 0, r, Collections.reverseOrder());
            
            // Y must be bigger/equal than X and Z
            
            
            
            xSum[p-1]  = X[p-1];
            ySum[q-1]  = Y[q-1];
            zSum[r-1]  = Z[r-1];
            
            for (int i = p-2; i >= 0; i--) {
                long curX = X[i];
                xSum[i]   = (xSum[i+1] + curX) % MOD;
            }
            
            for (int i = q-2; i >= 0; i--) {
                long curY = Y[i];
                ySum[i]   = (ySum[i+1] + curY) % MOD;
            }
            
            for (int i = r-2; i >= 0; i--) {
                long curZ = Z[i];
                zSum[i]   = (zSum[i+1] + curZ) % MOD;
            }
            
            int xPtr = 0;
            int zPtr = 0;
            
            long answer = 0;
            
            for (int yPtr = 0; yPtr < q; yPtr++) {
                while (xPtr < p && X[xPtr] > Y[yPtr]) {
                    ++xPtr;
                }
                if (xPtr >= p) {
                    break;
                }
                
                while (zPtr < r && Z[zPtr] > Y[yPtr]) {
                    ++zPtr;
                }
                if (zPtr >= r) {
                    break;
                }
                
                long curY = Y[yPtr];
                long xLeft = p - xPtr;
                long zLeft = r - zPtr;
                
                answer = (answer + ((curY*curY) % MOD) * ((xLeft * zLeft) % MOD)) % MOD;
                answer = (answer + ((curY * zSum[zPtr]) % MOD) * xLeft) % MOD;
                answer = (answer + ((curY * xSum[xPtr]) % MOD) * zLeft) % MOD;
                answer = (answer + ((xSum[xPtr] * zSum[zPtr]) % MOD)) % MOD;
                
            }
            
            System.out.println(answer);
        }
    }
    
    
    static BufferedInputStream in = new BufferedInputStream(System.in);
    static int readInt() {
        int no = 0;
        boolean minus = false;
        try {
            int a = in.read();
            while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                a = in.read();
            if (a == '-') {
                minus = true;
                a = in.read();
            }
            while (a != 10 && a != 32 && a != -1) {
                no = no * 10 + (a - '0');
                a = in.read();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return minus ? -no: no;
    }
    static String read() {
        StringBuilder str = new StringBuilder();
        try {
            int a = in.read();
            while (a == 32)
                a = in.read();
            while (a != 10 && a != 32 && a != -1) {
                str.append((char)a);
                a = in.read();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }
    
}
