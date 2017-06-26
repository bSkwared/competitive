// Problem statement: https://www.codechef.com/problems/UNIONSET/

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;


public class BS {
    
    private static class St implements Comparable {
        BitSet bs = new BitSet();
        int numElements;

        
        
        @Override
        public int compareTo(Object o) {
            return Integer.compare(numElements, ((St)o).numElements);
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int OUTER = 0; OUTER < T; OUTER++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            
            St[] sets = new St[n];
            for (int i = 0; i < n; i++) {
                sets[i] = new St();
                int NUM = scan.nextInt();
                for (int j = 0; j < NUM; j++) {
                    int next = scan.nextInt();
                    sets[i].bs.set(next-1);
                    ++sets[i].numElements;
                }
            }
            
            Arrays.sort(sets);
            
            int endPtr = sets.length-1;
            int numFull = 0;
            
            while (endPtr >= 0 && sets[endPtr].numElements == k) {
                --endPtr;
                ++numFull;
            }
            
            int startPtr = 0;
            
            int numCtr = 0;
            while (startPtr < endPtr) {
                if (sets[startPtr].numElements + sets[endPtr].numElements < k) {
                    ++startPtr;
                    continue;
                }
                
                for (int i = startPtr; i < endPtr; i++) {
                    if (isFullUnion(sets[i].bs, sets[endPtr].bs, k)) {
                        ++numCtr;
                    }
                }
                
                
                --endPtr;
            }
            
            
            long fullCombs = 0;
            
            for (int i = 1; i <= numFull; i++) {
                fullCombs += sets.length - i;
            }
            
            System.out.println(numCtr + fullCombs);
        }
    }
    
    private static boolean isFullUnion(BitSet s1, BitSet s2, int k) {

        
        BitSet clone = (BitSet) s1.clone();
        clone.or(s2);
        clone.flip(0, k);
        int count = clone.length();
        if (count == 0) {
            return true;
        }
        return false;
    }
}
