// Problem statement: https://www.codechef.com/problems/PROTEPOI/


import java.util.*;
 
 
public class ProtePoi {
    
    private static class Pair implements Comparable {
        int s;
        int e;
        public Pair(int S, int E) {
            if (S > E) {
                s = E;
                e = S;
            } else {
                s = S;
                e = E;
            }
        }
        @Override
        public int compareTo(Object o) {
            int os = ((Pair)o).s;
            int oe = ((Pair)o).e;
            
            if (os == s) {
                return Integer.compare(oe, e);
            }
            
            return Integer.compare(s, os);
        }
    }
    
    private static Pair[] pArr;
    
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int BBB = 0; BBB < T; ++BBB) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int m = scan.nextInt();
            
            Pair[] px = new Pair[m];
            Pair[] py = new Pair[m];
            
            for (int i = 0; i < m; i++) {
                int x1 = scan.nextInt();
                int y1 = scan.nextInt();
                int x2 = scan.nextInt();
                int y2 = scan.nextInt();
                
                px[i] = new Pair(x1, x2);
                py[i] = new Pair(y1, y2);
            }
            Arrays.sort(px);
            Arrays.sort(py);
            
            int s = (n - k)/2 + 1;
            int e = s + k-1;
            
            pArr = px;
            int rx = getMinCover(0, s, e);
            
            pArr = py;
            int ry = getMinCover(0, s, e);
            
            if (rx == -1 || ry == -1) {
                System.out.println("-1");
            } else {
                System.out.println(ry+rx);
            }
        }
        
    }
    
    
    private static int getMinCover(int n, int s, int e) {
        
 
        int maxUnder = 0;
        int ctr = 0;
        
        for (int i = n; i < pArr.length; ++i) {
            Pair p = pArr[i];
            int ps = p.s;
            int pe = p.e;
            
            if (ps > e) break;
            
            
            if (ps <= s) {
                if (pe > maxUnder) {
                    maxUnder = pe;
                }
                
            } else {
                if (maxUnder < s) {
                    ctr = -1;
                    break;
                }
                
                s = maxUnder+1;
                ++ctr;
                --i;
                if (s > e) break;
            }
        }
        
        if (s < e && maxUnder < e) ctr = -1;
        if (maxUnder >= e && s <= e) ++ctr;
        
        return ctr;
    }
    
    private static int max(int a, int b) {
        int ret = b;
        if (a > b) {
            ret = a;
        }
        return ret;
    }
    
    
    private static int min(int a, int b) {
        int ret = b;
        if (a < b) {
            ret = a;
        }
        return ret;
    }
}