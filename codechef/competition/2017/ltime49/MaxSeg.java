// Problem statement: https://www.codechef.com/problems/MAXSEGM

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class MaxSeg {
    public static void main(String[] args) {
        int T = readInt();
            HashSet<Integer> set = new HashSet<>();
            int[] C = new int[1000001];
            int[] W = new int[1000001];
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int n = readInt();
            
            
            for (int i = 0; i < n; i++) {
                C[i] = readInt();
            }
            for (int i = 0; i < n; i++) {
                W[i] = readInt();
            }
            
            long sum = 0;
            long maxSum = 0;
            int maxBack = 0;
            set.clear();
            
            for (int i = 0; i < n; i++) {
                
                    
                while (set.contains(C[i])) {
                    set.remove(C[maxBack]);
                    sum -= W[maxBack];
                    ++maxBack;
                }
                
                sum += W[i];
                set.add(C[i]);
                
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            
            System.out.println(maxSum);
        }
    }
    
    
    static BufferedInputStream in = new BufferedInputStream(System.in);
    static int readInt() {
        int no = 0;
        boolean minus = false;
        try {
            int a = in.read();
            while (a == 32 || a == 10|| a == 13) //10 is newline & 32 is ASCII for space
                a = in.read();
            if (a == '-') {
                minus = true;
                a = in.read();
            }
            while (a != 10 && a != 32 && a != -1 && a != 13) {
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
